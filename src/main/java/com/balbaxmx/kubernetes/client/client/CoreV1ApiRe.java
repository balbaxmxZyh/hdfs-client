package com.balbaxmx.kubernetes.client.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.kubernetes.client.custom.IntOrString;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiCallback;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Pair;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Service;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: CoreV1ApiRe
 * @Date: 2020/8/27 10:50
 * @Operation:
 * @Description: CoreV1Api部分方法重写
 */
public class CoreV1ApiRe extends CoreV1Api {

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
    public Call createNamespacedServiceCall(String namespace, V1Service body, String pretty, String dryRun, String fieldManager, ApiCallback _callback) throws ApiException {
        String localVarPath = "/api/v1/namespaces/{namespace}/services".replaceAll("\\{namespace\\}", getApiClient().escapeString(namespace.toString()));
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

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        String[] localVarAccepts = new String[]{"*/*","application/json", "application/yaml", "application/vnd.kubernetes.protobuf"};
        String localVarAccept = getApiClient().selectHeaderAccept(AppsV1ApiRe.screen(localVarAccepts,accept));
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        String[] localVarContentTypes = new String[]{"*/*","application/json", "application/yaml"};
        String localVarContentType = getApiClient().selectHeaderContentType(AppsV1ApiRe.screen(localVarContentTypes,contentType));
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[]{"BearerToken"};

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IntOrString.class,new IntOrString.IntOrStringAdapter())
                .create();
        byte[] bodyStr = new byte[0];
        try {
            bodyStr = gson.toJson(body).getBytes("utf8");
        } catch (UnsupportedEncodingException e) {
        }
        return getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, bodyStr, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }
    

}
