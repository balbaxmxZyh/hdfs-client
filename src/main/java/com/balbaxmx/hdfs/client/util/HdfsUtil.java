package com.balbaxmx.hdfs.client.util;

import com.balbaxmx.hdfs.client.constant.HdfsConfig;
import com.google.common.collect.Lists;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: HdfsUtil
 * @Date: 2020/7/26 15:15
 * @Operation:
 * @Description: ${description}
 */
public class HdfsUtil {

    private static Logger logger = LoggerFactory.getLogger(HdfsUtil.class);

    private static FileSystem fileSystem = null;
    private static Integer BYTE_SIZE = 1024;

    /**
     * 获取FileSystem 初始化必须有
     * @return
     */
    public static FileSystem getFs(){
        try {
            if(fileSystem == null) {
                fileSystem = FileSystem.get(HdfsConfig.getConf());
                logger.info("创建fileSystem成功");
            }
        } catch (IOException e) {
            logger.error("创建fileSystem失败[{}]",e);
        }
        return fileSystem;
    }

    /**
     * 关闭
     */
    public static void close(){
        try {
            if(fileSystem != null) {
                fileSystem.close();
                logger.info("关闭fileSystem成功");
            }
        } catch (IOException e) {
            logger.error("关闭fileSystem失败[{}]",e);
        }
    }

    public static Boolean mkdir(String path){
        Boolean result = false;
        try {
            //要创建的文件夹或多级文件夹
            result = getFs().mkdirs(new Path(path));
            logger.info("hdfs创建文件夹[{},{}]",path,result);
        } catch (IOException e) {
            logger.error("hdfs创建文件夹[{},{}]",path,result);
        }
        return result;
    }

    /**
     * 上传文件
     * @param path hdfs文件
     * @param localPath 本地文件
     * @return
     */
    public static Boolean load(String path, String localPath){
        boolean result = false;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(localPath));
            loadByIOUtils(path,fileInputStream);
            result = true;
        }catch (FileNotFoundException e) {
            logger.error("[{}]",e);
        } catch (Exception e) {
            logger.error("创建本地文件失败[{},{}]",localPath,result);
        }
        return result;
    }

    /**
     * 上传文件
     * @param path hdfs文件
     * @param in 输入文件流
     * @throws Exception
     */
    public static void loadByIOUtils(String path ,InputStream in) throws Exception{
        FSDataOutputStream out = null;
        if(in == null){
            throw new IOException("InputStream is null");
        }
        try {
            //选择上传路径
            out = getFs().create(new Path(path));
            IOUtils.copyBytes(in,out,HdfsConfig.getConf());
            logger.info("上传文件[{}]",path);
        } catch (IOException e) {
            logger.error("上传文件失败[{}]",path);
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("关闭上传流失败[{},{}]",path,e);
                }
            }
        }
    }

    /**
     * 上传文件
     * @param path hdfs文件
     * @param in 输入文件流
     * @throws Exception
     */
    public static void loadByAip(String path ,InputStream in) throws Exception{
        FSDataOutputStream out = null;
        if(in == null){
            throw new IOException("InputStream is null");
        }
        try {
            //选择上传路径
            out = getFs().create(new Path(path));
            byte[] b = new byte[BYTE_SIZE];
            int len = 0;
            while((len = in.read(b))!=-1){
                out.write(b,0,len);
            }
            logger.info("上传文件（AIP）[{}]",path);
        } catch (IOException e) {
            logger.error("上传文件（AIP）失败[{}]",path);
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("关闭上传流（AIP）失败[{},{}]",path,e);
                }
            }
        }
    }

    /**
     * 下载文件
     * @param path
     * @param out
     * @throws Exception
     */
    public static void downloadByAip(String path, OutputStream out) throws Exception{
        Boolean result = false;
        FSDataInputStream in = null;
        if(out == null){
            throw new IOException("OutputStream is null");
        }
        try {
            //选择下载路径
            in = getFs().open(new Path(path));
            byte[] b = new byte[BYTE_SIZE];
            int len = 0;
            while((len = in.read(b))!=-1){
                out.write(b,0,len);
            }
            result = true;
            logger.info("下载文件（AIP）[{},{}]",path,result);
        } catch (IOException e) {
            logger.error("下载文件（AIP）失败[{},{}]",path,result);
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭下载流（AIP）失败[{},{}]",path,e);
                }
            }
        }
    }
    /**
     * 下载文件
     * @param path
     * @param out
     * @throws Exception
     */

    public static void downloadByIOUtils(String path, OutputStream out) throws Exception{
        Boolean result = false;
        FSDataInputStream in = null;
        if(out == null){
            throw new IOException("OutputStream is null");
        }
        try {
            //选择下载路径
            in = getFs().open(new Path(path));
            IOUtils.copyBytes(in,out,HdfsConfig.getConf());
            logger.info("下载文件[{},{}]",path,result);
        } catch (IOException e) {
            logger.error("下载文件失败[{},{}]",path,result);
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭下载流失败[{},{}]",path,e);
                }
            }
        }
    }


    /**
     * 遍历path文件夹所有文件
     * @param path
     * @return
     */
    public static List<String> lsr(String path) {
        List<String> result = Lists.newArrayList();
        try {
            //获取文件列表
            FileStatus[] listStatus = getFs().listStatus(new Path(path));
            for (FileStatus fileStatus : listStatus) {
                //遍历文件列表，判断是文件还是文件夹
                isDir(fileStatus, result);
            }
        } catch (IOException e) {
            logger.error("遍历文件失败[{}]",e);
        }
        logger.info("遍历文件大小[{}]",result.size());
        return result;
    }


    /**
     * 判断是否是文件夹
     * @param fileStatus
     * @param allFiles
     */
    public static void isDir(FileStatus fileStatus, List<String> allFiles) {
        //如果是文件夹，则获取该文件夹下的文件列表，遍历判断 递归调用
        if(fileStatus.isDirectory()) {
            String dirname = fileStatus.getPath().getName();
            logger.info("Directory："+dirname);
            FileStatus[] listStatus;
            try {
                listStatus = getFs().listStatus(new Path("/"+dirname));
                for (FileStatus fileStatus2 : listStatus) {
                    isDir(fileStatus2,allFiles);
                }
            } catch (Exception e) {
                logger.error("[{}]",e);
            }
        }else {
            String dirname = fileStatus.getPath().getName();
            allFiles.add(dirname);
        }
    }


    /**
     * 重命名
     * @param path
     * @param newPath
     * @return
     */
    public static boolean rename(String path,String newPath){
        Boolean result = false;
        try {
            result = getFs().rename(new Path(path), new Path(newPath));
            logger.info("源文件[{}]，修改为[{}]成功",path,newPath);
        } catch (IOException e) {
            logger.error("源文件[{}]，修改为[{}]失败[{}]",path,newPath,e);
        }
        return result;
    }
}
