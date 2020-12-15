package com.balbaxmx.common.util;

import com.balbaxmx.common.info.BatchInfo;
import com.balbaxmx.common.info.BatchLine;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: BigFileReadUtil
 * @Date: 2020/8/18 15:54
 * @Operation:
 * @Description:
 *
 * 分批次读取大文件
 * 1、预分配[0,100000][100001,200000]...
 * 2、根据预分配信息，最后的position查找最近的换行符位置并替换这次的end position 和下一次的start postion
 *      比如:从100000查到最近一次换行符位于100030
 *      [0,100030][100031,200000]
 *      以此类推，最后按行分配
 *
 * 3、多线程同事读取文件
 * 4、合并结果
 *
 *
 */
public class BigFileReadUtil extends FileUtil{

    private static Logger logger = LoggerFactory.getLogger(BigFileReadUtil.class);

    /**
     * 获取文件的有行
     * @param path 文件路径
     * @return
     */
    public static List<String> getLineAll(String path){
        List<String> lines = Lists.newArrayList();
        try {
            List<BatchInfo> list = getBatchInfo(path,2);
        }catch (Exception e){

        }

        return lines;
    }


    /**
     * 把文件分割batch批次
     * 返回每个批次信息
     *
     * @param path 文件路径
     * @param batch 批次
     * @return
     */
    public static List<BatchInfo> getBatchInfo(String path,int batch)throws IOException{
        List<BatchInfo> list = Lists.newArrayList();
        FileInputStream inputStream = new FileInputStream(new File(path));

        Long count = inputStream.getChannel().size();
        Long s = count / batch;
        BatchInfo info ;
        Long start = 0L;
        Long end = s;
        for (int i = 1;i <= batch ;i++){
            if(end < count){
                end = findLine(inputStream, end);
            }
            info = new BatchInfo(start,end);
            list.add(info);
            start = end + 1;
            end = ( i+1 ) * s;
        }
        return list;
    }


    /**
     * 从position开启查找最近的一次换行符位置
     * @param inputStream
     * @param position
     * @return
     */
    public static Long findLine(FileInputStream inputStream, Long position) throws IOException {
        FileChannel fileChannel = inputStream.getChannel();
        fileChannel.position(position);
        int bufferSize = 1024;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        byte b;
        Long lineNumber = position ;
        boolean is = true;
        while (fileChannel.read(buffer) > 0 || is){
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++)
            {
                b = buffer.get();
                // 如果遇到换行
                if(b == 10){
                    lineNumber++;
                    is = false;
                    break;
                }
                lineNumber++;

            }
            buffer.clear(); // 清空buffer
        }
        return lineNumber;
    }



    public static BatchLine readLine(FileInputStream inputStream,Integer batchNum, Long start, Long end) throws Exception{
        List<String> lines = new ArrayList<>();
        FileChannel fileChannel = inputStream.getChannel();
        fileChannel.position(start);
        int bufferSize = 1024*1024;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        byte b;
        byte[] bytes = new byte[bufferSize];
        Long finish = end;
        boolean flag = true;
        while (fileChannel.read(buffer) > 0 && flag){
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++){
                finish++;
                if(finish > end){
                    flag = false;
                    break;
                }
                b = buffer.get();
                // 如果遇到换行
                if(b == 10){
                    break;
                }else {

                }
            }
            buffer.clear(); // 清空buffer
        }
        return new BatchLine(batchNum,lines);
    }

}
