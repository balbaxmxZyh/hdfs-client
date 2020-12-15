package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.client.AppsV1ApiRe;
import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.model.Deployment;
import com.balbaxmx.kubernetes.client.model.DeploymentList;
import com.balbaxmx.kubernetes.client.patch.JsonPathInfo;
import com.balbaxmx.kubernetes.client.patch.PatchEnum;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.*;
import okhttp3.ResponseBody;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import okhttp3.Call;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: DeployUtil
 * @Date: 2020/8/19 16:42
 * @Operation:
 * @Description: Deployment增删改查
 */
public class DeployUtil {

    private static Logger logger = LoggerFactory.getLogger(DeployUtil.class);

    private static AppsV1Api api;

    private static AppsV1ApiRe appsV1ApiRe;

    /**
     * 获取Deployment操作对象
     * @return
     */
    public static AppsV1Api before(){
        if(api == null) {
            api = new AppsV1Api();
        }
        return api;
    }

    /**
     * AppsV1ApiRe
     */
    public static AppsV1ApiRe getPatchClient(){
        if(appsV1ApiRe == null) {
            appsV1ApiRe= new AppsV1ApiRe();
            appsV1ApiRe.setContentType(V1Patch.PATCH_FORMAT_STRATEGIC_MERGE_PATCH);
            appsV1ApiRe.setAccept("*/*");
        }
        return appsV1ApiRe;
    }

    /**
     * 	namespace的Deployment列表
     * @param namespace
     * @return
     */
    public static DeploymentList list(String namespace){
        DeploymentList result = null;
        try {
           Call call = before().listNamespacedDeploymentCall(namespace,
                   K8sRequestCode.PRETTY,
                   true,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                   null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,DeploymentList.class);
        } catch (Exception e) {
            logger.info("查询 Deployment列表 失败[{}]",e);
        }
        return result;
    }


    /**
     * 查看Deployment信息
     * @param namespace
     * @param deployName
     * @return
     */
    public static Deployment readDeploy(String namespace, String deployName) {
        Deployment result = null;
        try {
            Call call = before().readNamespacedDeploymentCall(deployName,
                    namespace,
                    K8sRequestCode.PRETTY,
                    null,null,null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,Deployment.class);
        } catch (Exception e) {
            logger.info("查询 Deployment列表 失败[{}]",e);
        }
        return result;
    }

    /**
     * 删除Deployment
     * @param namespace
     * @param name
     * @param body
     * @return
     */
    public static V1Status delete(String namespace,String name, V1DeleteOptions body){
        V1Status result = null;
        try {
            result = before().deleteNamespacedDeployment(name,
                    namespace,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    null,
                    body);
        } catch (Exception e) {
            logger.info("删除[{}]Deployment 失败[{}]",name,e);
        }
        return result;
    }

    /**
     * 创建Deployment
     * @param namespace
     * @param deployment
     * @return
     */
    public static Deployment create(String namespace,V1Deployment deployment){
        Deployment result = null;
        try {
            Call call = before().createNamespacedDeploymentCall(namespace,
                    deployment,
                    null,
                    K8sRequestCode.PRETTY,
                    null,
                    null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,Deployment.class);
        } catch (Exception e) {
            logger.info("创建Deployment 失败[{}]",e);
        }
        return result;
    }


    /**
     * 修改副本数
     * @param namespace
     * @param name
     * @param replicas 副本数
     * @return
     *
     * 添加可以
     */
    public static Deployment updateReplicas(String namespace,String name,int replicas){
        Deployment result = null;
        try {
            V1Patch patch = new V1Patch("{\"spec\":{\"replicas\": "+replicas+" }}");
            Call call = getPatchClient().patchNamespacedDeploymentScaleCall(name,
                    namespace,
                    patch,
                    K8sRequestCode.PRETTY,
                    null,
                    null,null,null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,Deployment.class);
        } catch (Exception e) {
            logger.info("更新Deployment 失败[{}]",e);
        }
        return result;
    }


    /**
     *
     * 更新Deployment
     * @param namespace
     * @param name
     * @param requestBody 需要JSON语法格式
     *
     *   {"spec":{"selector":{"matchLabels":{"test_tomcat":"yyyytomcat"}}}}
     *
     * @return
     */
    public static V1Deployment update(String namespace,String name,String requestBody){
        V1Deployment result = null;
        try {
            if(StringUtils.isEmpty(requestBody)){
                return null;
            }
            V1Patch patch = new V1Patch(requestBody);
            Call call = getPatchClient().patchNamespacedDeploymentScaleCall(name,
                    namespace,
                    patch,
                    K8sRequestCode.PRETTY,
                    null,null,null,null);
            ResponseBody body = call.execute().body();
            System.out.println(body.string());
        } catch (Exception e) {
            logger.info("更新Deployment 失败[{}]",e);
        }
        return result;
    }


}
