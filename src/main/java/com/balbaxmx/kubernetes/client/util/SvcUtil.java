package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.client.CoreV1ApiRe;
import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.model.DeploymentList;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.ApiResponse;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.openapi.models.V1ServiceList;
import io.kubernetes.client.openapi.models.V1Status;
import okhttp3.Call;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangyh
 * @ClassName: SvcUtil
 * @Date: 2020/8/19 15:20
 * @Operation:
 * @Description: Services增删改查
 */
public class SvcUtil {
    private static Logger logger = LoggerFactory.getLogger(SvcUtil.class);

    private static CoreV1Api api;

    /**
     * 获取Services操作对象
     * @return
     */
    public static CoreV1Api before(){
        if(api == null) {
            api = new CoreV1Api();
        }
        return api;
    }


    /**
     * 	namespace的service列表
     * @param namespace
     * @return
     */
    public static JsonObject list(String namespace){
        JsonObject result = null;
        try {
            Call call = before().listNamespacedServiceCall(namespace,
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
            result = GsonUtil.toObject(resultStr,JsonObject.class);
        } catch (Exception e) {
            logger.info("查询 service列表 失败[{}]",e);
        }
        return result;
    }

    /**
     * 获取service信息
     * @param namespace
     * @param svcName
     * @return
     */
    public static JsonObject readSvc(String namespace, String svcName) {
        JsonObject result = null;
        try {
            Call call = before().readNamespacedServiceCall(svcName,
                    namespace,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,JsonObject.class);
        } catch (Exception e) {
            logger.info("查询 service 信息 失败[{}]",e);
        }
        return result;
    }

    /**
     * 删除service
     * @param name
     * @param namespace
     * @param body
     * @return
     */
    public static V1Status delete(String name, String namespace, V1DeleteOptions body){
        V1Status result = null;
        try {
             result = before().deleteNamespacedService(name,
                    namespace,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    null,
                     body);
        } catch (Exception e) {
            logger.info("删除[{}]pod service[{}]",name,e);
        }
        return result;
    }

    /**
     * 创建service
     * @param namespace
     * @param service
     * @return
     */
    public static JsonObject create(String namespace,V1Service service){
        JsonObject result = null;
        try {
            CoreV1ApiRe coreV1ApiRe = new CoreV1ApiRe();
            coreV1ApiRe.setContentType("application/json");
            coreV1ApiRe.setAccept("*/*");
            Call call = coreV1ApiRe.createNamespacedServiceCall(namespace,
                    service,
                    K8sRequestCode.PRETTY,
                    null,
                    null,null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,JsonObject.class);
        } catch (Exception e) {
            logger.info("创建service 失败[{}]",e);
        }
        return result;
    }


}
