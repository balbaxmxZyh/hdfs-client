package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.apis.CustomObjectsApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangyh
 * @ClassName: CRDUtil
 * @Date: 2020/8/19 15:18
 * @Operation:
 * @Description: CRD资源增删改查
 *
 * 通过 CRD 我们可以向 Kubernetes API 中增加新资源类型，而不需要修改 Kubernetes 源码来创建自定义的 API server，
 * 该功能大大提高了 Kubernetes 的扩展能力。
 * 当你创建一个新的CustomResourceDefinition (CRD)时，Kubernetes API服务器将为你指定的每个版本创建一
 * 个新的RESTful资源路径，我们可以根据该api路径来创建一些我们自己定义的类型资源。CRD可以是命名空间的，
 * 也可以是集群范围的，由CRD的作用域(scpoe)字段中所指定的，与现有的内置对象一样，
 * 删除名称空间将删除该名称空间中的所有自定义对象。customresourcedefinition本身没有名称空间，所有名称空间都可以使用。
 *
 */
public class CRDUtil {

    private static Logger logger = LoggerFactory.getLogger(CRDUtil.class);

    private static CustomObjectsApi api;

    /**
     * 获取CRD资源操作对象
     * @return
     */
    public static CustomObjectsApi before(){
        if(api == null) {
            api = new CustomObjectsApi();
        }
        return api;
    }


    /**
     * 获取集群范围CRD资源对象-scale
     * @param name
     * @return
     */
    public static JsonObject query(String name){
        JsonObject result = null;
        try {
            Object o = before().getClusterCustomObjectScale(K8sRequestCode.GROUP,
                    K8sRequestCode.VERSION,
                    K8sRequestCode.PLURAL,
                    name);
            result = GsonUtil.toJson(o);
        } catch (Exception e) {
            logger.info("查询 CRD资源 失败[{}]",e);
        }
        return result;
    }


    /**
     * 获取集群范围CRD资源对象-状态
     * @param name
     * @return
     */
    public static JsonObject queryStatus(String name){
        JsonObject result = null;
        try {
            Object o = before().getClusterCustomObjectStatus(K8sRequestCode.GROUP,
                    K8sRequestCode.VERSION,
                    K8sRequestCode.PLURAL,
                    name);
            result = GsonUtil.toJson(o);
        } catch (Exception e) {
            logger.info("查询 CRD资源对象状态 失败[{}]",e);
        }
        return result;
    }

    public static Boolean delete(String name){
        JsonObject result = null;
        try {
            Object o = before().deleteClusterCustomObject(K8sRequestCode.GROUP,
                    K8sRequestCode.VERSION,
                    K8sRequestCode.PLURAL,
                    name,null,null,null,null,null);
            result = GsonUtil.toJson(o);
        } catch (Exception e) {
            logger.info("查询 CRD资源对象状态 失败[{}]",e);
            return false;
        }
        return true;
    }

    public static Boolean create(Object body){
        JsonObject result = null;
        try {
            Object o = before().createClusterCustomObject(K8sRequestCode.GROUP,
                    K8sRequestCode.VERSION,
                    K8sRequestCode.PLURAL,
                    body,K8sRequestCode.PRETTY,
                    null,null);
            result = GsonUtil.toJson(o);
        } catch (Exception e) {
            logger.info("查询 CRD资源对象状态 失败[{}]",e);
            return false;
        }
        return true;
    }

    public static Boolean update(String name,Object body){
        JsonObject result = null;
        try {
            Object o = before().patchClusterCustomObject(K8sRequestCode.GROUP,
                    K8sRequestCode.VERSION,
                    K8sRequestCode.PLURAL,
                    name,
                    body,
                    null,null,null);
            result = GsonUtil.toJson(o);
        } catch (Exception e) {
            logger.info("查询 CRD资源对象状态 失败[{}]",e);
            return false;
        }
        return true;
    }
}
