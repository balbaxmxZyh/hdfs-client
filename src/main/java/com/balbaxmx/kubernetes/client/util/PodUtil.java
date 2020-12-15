package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.openapi.models.V1Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangyh
 * @ClassName: PodUtil
 * @Date: 2020/8/19 15:19
 * @Operation:
 * @Description: Pod增删改查
 */
public class PodUtil {

    private static Logger logger = LoggerFactory.getLogger(PodUtil.class);

    private static CoreV1Api api;

    /**
     * 获取Namespaces操作对象
     * @return
     */
    public static CoreV1Api before(){
        if(api == null) {
            api = new CoreV1Api();
        }
        return api;
    }


    /**
     * 	namespace的pod列表
     * @param namespace
     * @return
     */
    public static V1PodList list(String namespace){
        V1PodList result = null;
        try {
            result= before().listNamespacedPod(namespace,
                    K8sRequestCode.PRETTY,
                    true,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("查询 pod列表 失败[{}]",e);
        }
        return result;
    }


    /**
     * 查询pod信息
     * @param namespace
     * @param pod
     * @return
     */
    public static V1Pod readPod(String namespace ,String pod) {
        V1Pod result = null;
        try {
            result= before().readNamespacedPod(pod,
                    namespace,
                    K8sRequestCode.PRETTY,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("查询 pod信息 失败[{}]",e);
        }
        return result;
    }

    /**
     * 删除pod
     * @param namespace
     * @param name
     * @param body
     * @return
     */
    public static V1Status delete(String namespace, String name, V1DeleteOptions body){
        V1Status result = null;
        try {
            result = before().deleteNamespacedPod(name,
                    namespace,
                    null,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("删除[{}]pod 失败[{}]",name,e);
        }
        return result;
    }

    /**
     * 创建pod
     * @param namespace
     * @param node
     * @return
     */
    public static V1Pod create(String namespace,V1Pod node){
        V1Pod result = null;
        try {
            result = before().createNamespacedPod(namespace,
                    node,
                    null,
                    K8sRequestCode.PRETTY,
                    null);
        } catch (Exception e) {
            logger.info("创建pod 失败[{}]",e);
        }
        return result;
    }


}
