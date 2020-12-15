package com.balbaxmx.kubernetes.client.client;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Pair;
import okhttp3.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: DockerAppV2Client
 * @Date: 2020/9/7 14:07
 * @Operation:
 * @Description: ${description}
 */
public class DockerAppV2Client {

    private DockerV2Api api;

    public DockerAppV2Client() {
        api = new DockerV2Api();
    }

    public Call patchNamespacedDeploymentCall(String name, String namespace,Object body) throws Exception {
        String localVarPath = "/apis/apps/v1/namespaces/{namespace}/deployments/{name}".replaceAll("\\{name\\}", api.escapeString(name.toString())).replaceAll("\\{namespace\\}", api.escapeString(namespace.toString()));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();


        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, body, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }


    public Call selectImageList() throws Exception {
        String localVarPath = "/v2/_catalog";
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }


    /**
     * 获取镜像版本集合
     * @param name 镜像名
     * @return
     * @throws Exception
     */
    public Call selectImage(String name) throws Exception {
        String localVarPath = "/v2/{name}/tags/list".replaceAll("\\{name\\}", api.escapeString(name));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }

    /**
     * 获取镜像版本集合
     * @param name 镜像名
     * @param tag 版本
     * @param accept 参数  application/vnd.docker.distribution.manifest.v2+json 或者 application/json
     * @return
     * @throws Exception
     */
    public Call selectImageManifests(String name,String tag,String accept) throws Exception {
        String localVarPath = "/v2/{name}/manifests/{tag}".replaceAll("\\{name\\}", api.escapeString(name)).replaceAll("\\{tag\\}", api.escapeString(tag));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        //"application/vnd.docker.distribution.manifest.v2+json"
        if(accept == null || "".equals(accept)){
            localVarHeaderParams.put("Accept", "application/json");
        }else {
            localVarHeaderParams.put("Accept", accept);
        }
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }

    /**
     * 删除镜像
     * @param name
     * @param digest
     * @return
     * @throws Exception
     */
    public Call deleteImage(String name,String digest) throws Exception {
        String localVarPath = "/v2/{name}/manifests/{digest}".replaceAll("\\{name\\}", api.escapeString(name)).replaceAll("\\{digest\\}", api.escapeString(digest));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }


    /**
     * 获取镜像上传需要的Uuid
     * @param name
     * @return
     * @throws Exception
     */
    public Call getUploadUuid(String name) throws Exception {
        String localVarPath = ("/v2/{name}/blobs/uploads/").replaceAll("\\{name\\}", api.escapeString(name));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }

    /**
     * 上传镜像
     * @param name
     * @return
     * @throws Exception
     */
    public Call uploadUuid(String name,String uuid,byte[] body) throws Exception {
        String localVarPath = ("/v2/{name}/blobs/uploads/{uuid}").replaceAll("\\{name\\}", api.escapeString(name)).replaceAll("\\{uuid\\}", api.escapeString(uuid));
        List<Pair> localVarQueryParams = new ArrayList();
        List<Pair> localVarCollectionQueryParams = new ArrayList();

        Map<String, String> localVarHeaderParams = new HashMap();
        Map<String, String> localVarCookieParams = new HashMap();
        Map<String, Object> localVarFormParams = new HashMap();
        localVarHeaderParams.put("Accept", "application/json");
        localVarHeaderParams.put("Content-Type", "application/json");
        return api.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, body, localVarHeaderParams, localVarCookieParams, localVarFormParams);
    }
}
