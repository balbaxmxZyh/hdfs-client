package com.balbaxmx.kubernetes.client.client;

import com.balbaxmx.kubernetes.client.util.GsonUtil;
import io.kubernetes.client.openapi.ApiCallback;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Pair;
import io.kubernetes.client.openapi.ProgressRequestBody;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: DockerV2Api
 * @Date: 2020/9/7 13:55
 * @Operation:
 * @Description: docker 客户端
 */
public class DockerV2Api {

    private String  basePath = "http://10.1.8.144:5000";

    private OkHttpClient httpClient;


    public DockerV2Api() {
        initHttpClient();
    }

    private void initHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.httpClient = builder.build();
    }


    public Request buildRequest(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, String> cookieParams, Map<String, Object> formParams, String[] authNames) throws Exception {
        String url = this.buildUrl(path, queryParams, collectionQueryParams);

        okhttp3.Request.Builder reqBuilder = (new okhttp3.Request.Builder()).url(url);
        this.processHeaderParams(headerParams, reqBuilder);
        this.processCookieParams(cookieParams, reqBuilder);
        String contentType = (String) headerParams.get("Content-Type");
        if (contentType == null) {
            contentType = "application/json";
        }

        RequestBody reqBody;
        if (!HttpMethod.permitsRequestBody(method)) {
            reqBody = null;
        } else if ("application/x-www-form-urlencoded".equals(contentType)) {
            reqBody = this.buildRequestBodyFormEncoding(formParams);
        } else if (body == null) {
            if ("DELETE".equals(method)) {
                reqBody = null;
            } else {
                reqBody = RequestBody.create(MediaType.parse(contentType), "");
            }
        } else {
            reqBody = this.serialize(body, contentType);
        }

        reqBuilder.tag(null);
        Request request = reqBuilder.method(method, reqBody).build();
        return request;
    }

    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, String> cookieParams, Map<String, Object> formParams) throws Exception {
        Request request = this.buildRequest(path, method, queryParams, collectionQueryParams, body, headerParams, cookieParams, formParams);
        return this.httpClient.newCall(request);
    }

    public String buildUrl(String path, List<Pair> queryParams, List<Pair> collectionQueryParams) {
        StringBuilder url = new StringBuilder();
        url.append(this.basePath).append(path);
        String prefix;
        Iterator var6;
        Pair param;
        String value;
        if (queryParams != null && !queryParams.isEmpty()) {
            prefix = path.contains("?") ? "&" : "?";
            var6 = queryParams.iterator();

            while(var6.hasNext()) {
                param = (Pair)var6.next();
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }

                    value = this.parameterToString(param.getValue());
                    url.append(this.escapeString(param.getName())).append("=").append(this.escapeString(value));
                }
            }
        }

        if (collectionQueryParams != null && !collectionQueryParams.isEmpty()) {
            prefix = url.toString().contains("?") ? "&" : "?";
            var6 = collectionQueryParams.iterator();

            while(var6.hasNext()) {
                param = (Pair)var6.next();
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }

                    value = this.parameterToString(param.getValue());
                    url.append(this.escapeString(param.getName())).append("=").append(value);
                }
            }
        }

        return url.toString();
    }
    public Request buildRequest(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, String> cookieParams, Map<String, Object> formParams) throws ApiException {
        String url = this.buildUrl(path, queryParams, collectionQueryParams);
        okhttp3.Request.Builder reqBuilder = (new okhttp3.Request.Builder()).url(url);
        this.processHeaderParams(headerParams, reqBuilder);
        this.processCookieParams(cookieParams, reqBuilder);
        String contentType = (String)headerParams.get("Content-Type");
        if (contentType == null) {
            contentType = "application/json";
        }

        RequestBody reqBody;
        if (!HttpMethod.permitsRequestBody(method)) {
            reqBody = null;
        } else if ("application/x-www-form-urlencoded".equals(contentType)) {
            reqBody = this.buildRequestBodyFormEncoding(formParams);
        }else if (body == null) {
            if ("DELETE".equals(method)) {
                reqBody = null;
            } else {
                reqBody = RequestBody.create(MediaType.parse(contentType), "");
            }
        } else {
            reqBody = this.serialize(body, contentType);
        }

        reqBuilder.tag(null);
        Request request  = reqBuilder.method(method, reqBody).build();
        return request;
    }

    public String escapeString(String str) {
        try {
            return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException var3) {
            return str;
        }
    }


    public String parameterToString(Object param) {
        if (param == null) {
            return "";
        } else if (!(param instanceof Date) && !(param instanceof DateTime) && !(param instanceof LocalDate)) {
            if (param instanceof Collection) {
                StringBuilder b = new StringBuilder();

                Object o;
                for(Iterator var3 = ((Collection)param).iterator(); var3.hasNext(); b.append(String.valueOf(o))) {
                    o = var3.next();
                    if (b.length() > 0) {
                        b.append(",");
                    }
                }

                return b.toString();
            } else {
                return String.valueOf(param);
            }
        } else {
            String jsonStr = GsonUtil.toJsonStirng(param);
            return jsonStr.substring(1, jsonStr.length() - 1);
        }
    }

    public RequestBody serialize(Object obj, String contentType) throws ApiException {
        if (obj instanceof byte[]) {
            return RequestBody.create(MediaType.parse(contentType), (byte[])((byte[])obj));
        } else if (obj instanceof File) {
            return RequestBody.create(MediaType.parse(contentType), (File)obj);
        } else if (this.isJsonMime(contentType)) {
            String content;
            if (obj != null) {
                content = GsonUtil.toJsonStirng(obj);
            } else {
                content = null;
            }

            return RequestBody.create(MediaType.parse(contentType), content);
        } else {
            throw new ApiException("Content type \"" + contentType + "\" is not supported");
        }
    }

    public void processHeaderParams(Map<String, String> headerParams, okhttp3.Request.Builder reqBuilder) {
        Iterator var3 = headerParams.entrySet().iterator();

        Map.Entry header;
        while(var3.hasNext()) {
            header = (Map.Entry)var3.next();
            reqBuilder.header((String)header.getKey(), this.parameterToString(header.getValue()));
        }

    }

    public void processCookieParams(Map<String, String> cookieParams, okhttp3.Request.Builder reqBuilder) {
        Iterator var3 = cookieParams.entrySet().iterator();

        Map.Entry param;
        while(var3.hasNext()) {
            param = (Map.Entry)var3.next();
            reqBuilder.addHeader("Cookie", String.format("%s=%s", param.getKey(), param.getValue()));
        }

    } public RequestBody buildRequestBodyFormEncoding(Map<String, Object> formParams) {
        okhttp3.FormBody.Builder formBuilder = new okhttp3.FormBody.Builder();
        Iterator var3 = formParams.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, Object> param = (Map.Entry)var3.next();
            formBuilder.add((String)param.getKey(), this.parameterToString(param.getValue()));
        }

        return formBuilder.build();
    }

    public boolean isJsonMime(String mime) {
        String jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
        return mime != null && (mime.matches(jsonMime) || mime.equals("*/*"));
    }
}
