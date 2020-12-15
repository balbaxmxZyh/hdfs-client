package com.balbaxmx.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * @Author: zhangyh
 * @ClassName: FileUtil
 * @Date: 2020/8/18 16:10
 * @Operation:
 * @Description: 通过文件工具类
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void close(Closeable... closeables){
        for (Closeable closeable : closeables){
            if(closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    logger.error("closr error [{}]", e);
                }
            }
        }
    }

}
