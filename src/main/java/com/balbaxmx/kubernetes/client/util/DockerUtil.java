package com.balbaxmx.kubernetes.client.util;

import com.balbaxmx.kubernetes.client.client.DockerAppV2Client;
import com.balbaxmx.kubernetes.client.docker.model.ImageDigest;
import com.balbaxmx.kubernetes.client.docker.model.ImageManifests;
import com.balbaxmx.kubernetes.client.docker.model.ImageTags;
import com.balbaxmx.kubernetes.client.docker.model.Repositories;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.MediaSize;

/**
 * @Author: zhangyh
 * @ClassName: DockerUtil
 * @Date: 2020/9/7 14:33
 * @Operation:
 * @Description: ${description}
 */
public class DockerUtil {

    private static Logger logger = LoggerFactory.getLogger(DockerUtil.class);


    private static DockerAppV2Client api;

    /**
     * 获取Deployment操作对象
     * @return
     */
    public static DockerAppV2Client before(){
        if(api == null) {
            api = new DockerAppV2Client();
        }
        return api;
    }


    /**
     * 	获取docker私服所有的镜像
     * @return
     */
    public static Repositories selectImageList(){
        Repositories result = null;
        try {
            Call call = before().selectImageList();
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,Repositories.class);
        } catch (Exception e) {
            logger.info("查询 docker私服所有的镜像 失败[{}]",e);
        }
        return result;
    }

    /**
     * 	获取docker私服镜像版本集合
     * @return
     */
    public static ImageTags selectImageTags(String name){
        ImageTags result = null;
        try {
            Call call = before().selectImage(name);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,ImageTags.class);
        } catch (Exception e) {
            logger.info("查询 docker私服镜像版本集合[{}] 失败[{}]",name,e);
        }
        return result;
    }

    /**
     * 获取镜像tag 的Digest
     * 的信息
     * @param name
     * @param tag
     * @return
     */
    public static ImageDigest selectImageDigest(String name, String tag){
        ImageDigest result = null;
        try {
            Call call = before().selectImageManifests(name,tag,"application/vnd.docker.distribution.manifest.v2+json");
            Response response = call.execute();
            String digest = response.header("Docker-Content-Digest","");
            ResponseBody body = response.body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,ImageDigest.class);
            if(result != null) {
                result.setDigest(digest);
            }
        } catch (Exception e) {
            logger.info("查询 镜像tag的Digest[{}:{}] 失败[{}]",name,tag,e);
        }
        return result;
    }


    /**
     * 获取镜像tag信息
     * 的信息
     * @param name
     * @param tag
     * @return
     */
    public static ImageManifests selectImageManifests(String name, String tag){
        ImageManifests result = null;
        try {
            Call call = before().selectImageManifests(name,tag,null);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,ImageManifests.class);
        } catch (Exception e) {
            logger.info("查询 镜像tag的信息[{}:{}] 失败[{}]",name,tag,e);
        }
        return result;
    }

    /**
     * 删除镜像
     * @param name
     * @param digest
     * @return
     */
    public static ImageManifests deleteImage(String name, String digest){
        ImageManifests result = null;
        try {
            Call call = before().deleteImage(name,digest);
            ResponseBody body = call.execute().body();
            String resultStr = body.string();
            result = GsonUtil.toObject(resultStr,ImageManifests.class);
        } catch (Exception e) {
            logger.info("删除镜像[{}:{}] 失败[{}]",name,digest,e);
        }
        return result;
    }

}
