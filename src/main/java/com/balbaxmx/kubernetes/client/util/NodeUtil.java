package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Node;
import io.kubernetes.client.openapi.models.V1Status;
import okhttp3.Call;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * @Author: zhangyh
 * @ClassName: NodeUtil
 * @Date: 2020/8/19 15:19
 * @Operation:
 * @Description: Node增删改查
 */
public class NodeUtil {
    private static Logger logger = LoggerFactory.getLogger(NodeUtil.class);

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
     * 对应 V1NodeList 对象
     * 	节点列表
     * @return
     */
    public static JsonObject list(){
        JsonObject result = null;
        try {
            Call call = before().listNodeCall(K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                   null);
            ResponseBody body =  call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,JsonObject.class);
        } catch (Exception e) {
            logger.info("查询 节点列表 失败[{}]",e);
        }
        return result;
    }

    /** 对应 V1Node 对象
     * 	节点列表
     * @return
     */
    public static JsonObject readNode(String name){
        JsonObject result = null;
        try {
            Call call = before().readNodeCall(name,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null);
            ResponseBody body =  call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,JsonObject.class);
        } catch (Exception e) {
            logger.info("查询 节点列表 失败[{}]",e);
        }
        return result;
    }

    /**
     * 删除节点
     * @param name
     * @return
     */
    public static V1Status delete(String name){
        V1Status result = null;
        try {
            result = before().deleteNode(name,
                    K8sRequestCode.PRETTY,
                    null,
                    null,
                    null,
                    null,
                    null);
        } catch (Exception e) {
            logger.info("删除[{}]节点 失败[{}]",name,e);
        }
        return result;
    }

    /**
     * 创建节点
     * @param node
     * @return

    public static V1Node create(V1Node node){
        V1Node result = null;
        try {
            result = before().createNode(node,
                    null,
                    K8sRequestCode.PRETTY,
                    null);
        } catch (Exception e) {
            logger.info("创建节点 失败[{}]",e);
        }
        return result;
    }
     */

}
