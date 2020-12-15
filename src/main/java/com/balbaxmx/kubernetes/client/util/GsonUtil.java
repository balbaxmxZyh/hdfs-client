package com.balbaxmx.kubernetes.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: zhangyh
 * @ClassName: GsonUtil
 * @Date: 2020/8/19 15:50
 * @Operation:
 * @Description: ${description}
 */
public class GsonUtil {


    /**
     * 将object对象转成json格式字符串
     * @param object
     * @return
     */
    public static String toJsonStirng(Object object) {
        if(object == null){
            return null;
        }
        Gson gson = getGson();
        return gson.toJson(object);
    }


    /**
     * 将object对象转成JsonObject
     * @param object
     * @return
     */
    public static JsonObject toJson(Object object) {
        if(object == null){
            return null;
        }
        Gson gson = getGson();
        return gson.fromJson(gson.toJson(object),JsonObject.class);
    }

    /**
     * 将String转成clazz对象
     * @param source
     * @return
     */
    public static <T> T toObject(String source,Class<T> clazz) {
        if(StringUtils.isEmpty(source)){
            return null;
        }
        Gson gson = getGson();
        return  gson.fromJson(source,clazz);
    }


    /**
     * 获取gson对象
     * @return
     */
    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        return gsonBuilder.create();
    }



    /**
     * 将object对象转成json格式字符串
     * @param object
     * @return
     */
    public static String toJsonStirng(Object object,Gson gson) {
        if(object == null){
            return null;
        }
        return gson.toJson(object);
    }


    /**
     * 将String转成clazz对象
     * @param source
     * @return
     */
    public static <T> T toObject(String source, Class<T> clazz, Gson gson) {
        if(StringUtils.isEmpty(source)){
            return null;
        }
        return  gson.fromJson(source,clazz);
    }
}
