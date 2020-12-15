package com.balbaxmx.es.client.util;

import com.balbaxmx.es.client.singleton.ClientSingleton;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Author: zhangyh
 * @ClassName: ElasticsearchUtil
 * @Date: 2020/8/19 20:43
 * @Operation:
 * @Description: Elasticsearch工具类
 */
public class ElasticsearchUtil {

    private static Logger logger = LoggerFactory.getLogger(ElasticsearchUtil.class);

    public static Boolean createIndex(String index){
        RestHighLevelClient levelClient = ClientSingleton.getInstance().getClient();
        GetIndexRequest indexRequest = new GetIndexRequest(index);
        try {
            boolean exist = levelClient.indices().exists(indexRequest, RequestOptions.DEFAULT);
            if(exist){
                return true;
            }else {
                CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
                CreateIndexResponse response = levelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean add(){

        return true;
    }
}
