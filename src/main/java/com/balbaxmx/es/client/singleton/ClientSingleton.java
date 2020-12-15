package com.balbaxmx.es.client.singleton;

import com.balbaxmx.es.client.config.ElasticsearchConfig;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author: zhangyh
 * @ClassName: ClientSingleton
 * @Date: 2020/8/19 20:49
 * @Operation:
 * @Description:
 *
 * 种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。
 * 想象一下，如果实例化instance很消耗资源，我想让他延迟加载，
 * 另外一方面，我不希望在Singleton类加载时就实例化，
 * 因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化instance显然是不合适的
 */
public class ClientSingleton {
    /**
     * 内部类
     */
    private static class SingletonHolder {
        private static final ClientSingleton INSTANCE = new ClientSingleton();
    }

    /**
     * 构造方法私有化
     */
    private ClientSingleton(){}

    /**
     * 单例模式
     * @return
     */
    public static final ClientSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RestHighLevelClient highLevelClient = null;

    public RestHighLevelClient getClient(){
        if(highLevelClient == null){
            String[] hosts = ElasticsearchConfig.HOSTS;
            String scheme = ElasticsearchConfig.SCHEME;
            HttpHost[] httpHosts = new HttpHost[hosts.length];
            for (int i = 0 ;i < hosts.length ;i++){
                String host = hosts[i];
                String[] hs = host.split(":");
                httpHosts[i] = new HttpHost(hs[0],Integer.parseInt(hs[1]),scheme);

            }
            highLevelClient = new RestHighLevelClient(
                    RestClient.builder(httpHosts));
        }
        return highLevelClient;
    }
}
