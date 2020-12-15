package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1NamespaceList;
import io.kubernetes.client.openapi.models.V1Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangyh
 * @ClassName: NmspsUtil
 * @Date: 2020/8/19 15:19
 * @Operation:
 * @Description: Namespaces增删改查
 */
public class NmspsUtil {

    private static Logger logger = LoggerFactory.getLogger(NmspsUtil.class);

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
     * 分区列表
     * @return
     */
    public static V1NamespaceList list(){
        V1NamespaceList result = null;
        try {
            result = before().listNamespace(K8sRequestCode.PRETTY,
                    true,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("查询 分区列表 失败[{}]",e);
        }
        return result;
    }

    /**
     * 分区信息
     * @return
     */
    public static V1Namespace readNamespace(String name){
        V1Namespace result = null;
        try {
            result = before().readNamespace(name,
                    K8sRequestCode.PRETTY,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("查询 分区列表 失败[{}]",e);
        }
        return result;
    }


    /**
     * 删除name分区
     * @param name
     * @return
     */
    public static V1Status delete(String name,V1DeleteOptions options){
        V1Status result = null;
        try {
            result = before().deleteNamespace(name,
                    K8sRequestCode.PRETTY,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    options);
        } catch (Exception e) {
            logger.info("删除[{}]分区 失败[{}]",name,e);
        }
        return result;
    }

    /**
     * 创建分区
     * @param namespace
     * @return
     */
    public static V1Namespace create(V1Namespace namespace){
        V1Namespace result = null;
        try {
            result = before().createNamespace(namespace,
                    null,
                    K8sRequestCode.PRETTY,
                    null);
        } catch (Exception e) {
            logger.info("创建分区 失败[{}]",e);
        }
        return result;
    }

}
