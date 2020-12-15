package com.balbaxmx.hdfs.client.constant;

import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhangyh
 * @ClassName: HdfsConfig
 * @Date: 2020/7/26 15:32
 * @Operation:
 * @Description: ${description}
 */
public class HdfsConfig {

    private static Logger logger = LoggerFactory.getLogger(HdfsConfig.class);

    private static Configuration conf = null;

    private static final String URL = "hdfs://namenode:9000";

    private static final String DEFAULT_FS_TYPE = "fs.defaultFS";

    private static final String HDFS_REPLICATION = "2";
    private static final String REPLICATION_TYPE = "dfs.replication";

    private static final String BLOCK_SIZE = "128m";
    private static final String BLOCK_TYPE = "dfs.blocksize";



    public static Configuration getConf() {
        if(conf != null){
            return conf;
        }
        conf = new Configuration();
        conf.set(REPLICATION_TYPE, HDFS_REPLICATION);
        conf.set(BLOCK_TYPE, BLOCK_SIZE);
        conf.set(DEFAULT_FS_TYPE,URL);
        return conf;
    }
}
