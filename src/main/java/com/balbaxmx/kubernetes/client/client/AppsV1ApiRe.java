package com.balbaxmx.kubernetes.client.client;

import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.*;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: AppsV1ApiRe
 * @Date: 2020/8/26 11:29
 * @Operation:
 * @Description: 对AppsV1Api部分方法重写
 *
 */
public class AppsV1ApiRe extends AppsV1Api {

    private String contentType;

    private String accept;


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    @Override
    public Call patchNamespacedDeploymentCall(String name, String namespace, V1Patch body, String pretty, String dryRun, String fieldManager, Boolean force, ApiCallback _callback) throws ApiException {
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/deployments/{name}".replaceAll("\\{name\\}", getApiClient().escapeString(name.toString())).replaceAll("\\{namespace\\}", getApiClient().escapeString(namespace.toString()));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();
        if (pretty != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("pretty", pretty));
        }

        if (dryRun != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("dryRun", dryRun));
        }

        if (fieldManager != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("fieldManager", fieldManager));
        }

        if (force != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("force", force));
        }

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        String[] localVarAccepts = new String[]{"*/*","application/json", "application/yaml", "application/vnd.kubernetes.protobuf"};
        String localVarAccept = getApiClient().selectHeaderAccept(screen(localVarAccepts,contentType));
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        String[] localVarContentTypes = new String[]{"application/json-patch+json", "application/merge-patch+json", "application/strategic-merge-patch+json", "application/apply-patch+yaml"};
        String localVarContentType = getApiClient().selectHeaderContentType(screen(localVarContentTypes,contentType));
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[]{"BearerToken"};
        return getApiClient().buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, body, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    /**
     * 重写patch请求
     * @param name
     * @param namespace
     * @param body
     * @param pretty
     * @param dryRun
     * @param fieldManager
     * @param force
     * @param _callback
     * @return
     * @throws ApiException
     */
    @Override
    public Call patchNamespacedDeploymentScaleCall(String name, String namespace, V1Patch body, String pretty, String dryRun, String fieldManager, Boolean force, ApiCallback _callback) throws ApiException {
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/deployments/{name}".replaceAll("\\{name\\}", getApiClient().escapeString(name.toString())).replaceAll("\\{namespace\\}", getApiClient().escapeString(namespace.toString()));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();
        if (pretty != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("pretty", pretty));
        }

        if (dryRun != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("dryRun", dryRun));
        }

        if (fieldManager != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("fieldManager", fieldManager));
        }

        if (force != null) {
            localVarQueryParams.addAll(getApiClient().parameterToPair("force", force));
        }

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        String[] localVarAccepts = new String[]{"*/*","application/json", "application/yaml", "application/vnd.kubernetes.protobuf"};
        String localVarAccept = getApiClient().selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        String[] localVarContentTypes = new String[]{"application/json","application/json-patch+json", "application/merge-patch+json", "application/strategic-merge-patch+json", "application/apply-patch+yaml"};
        String localVarContentType = getApiClient().selectHeaderContentType(screen(localVarContentTypes,contentType));
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[]{"BearerToken"};

        RequestBody reqBody = RequestBody.create(MediaType.parse("application/strategic-merge-patch+json"),
                body.getValue());

        getApiClient().updateParamsForAuth(localVarAuthNames, localVarQueryParams, localVarHeaderParams, localVarCookieParams);
        String url = getApiClient().buildUrl(localVarPath, localVarQueryParams, localVarCollectionQueryParams);
        okhttp3.Request.Builder reqBuilder = (new okhttp3.Request.Builder()).url(url);
        getApiClient().processHeaderParams(localVarHeaderParams, reqBuilder);
        getApiClient().processCookieParams(localVarCookieParams, reqBuilder);
        reqBuilder.tag(null);
        Request request = reqBuilder.method("PATCH", reqBody).build();
        return  getApiClient().getHttpClient().newCall(request);
    }


    /**
     * 从local筛选出target，并返回
     * 如果没有设置则不作处理
     * @param local
     * @param target
     * @return
     */
    public static String[] screen(String[] local,String target){
        if(!StringUtils.isEmpty(target)){
            for (String str : local){
                if(target.equals(str)){
                    String[] result = {target};
                    return result;
                }
            }
        }
        return local;
    }

}
