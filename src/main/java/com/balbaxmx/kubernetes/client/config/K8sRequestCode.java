package com.balbaxmx.kubernetes.client.config;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.credentials.AccessTokenAuthentication;

/**
 * @Author: zhangyh
 * @ClassName: K8sRequestCode
 * @Date: 2020/8/19 15:20
 * @Operation:
 * @Description: ${description}
 */
public class K8sRequestCode {

    public static String API_SERVER = "group";

    public static String GROUP = "group";

    public static String VERSION = "v1";

    public static String PLURAL = "clusters";

    public static String PRETTY = "true";

    public static String TOKEN = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkR5MktuR2xBcUlLc0RPUm9JZ0F3V21fQmd0cEYtcmVGaVpib21MaUN5T3MifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImZtY3AtdG9rZW4teGh0cjYiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZm1jcCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6ImZiNTM3OGNlLTI3NTAtNDNkNy05ZWU2LTMyZmY4ODNlYTUyYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmZtY3AifQ.nZINbClUB4NBbMhHF_rOyxT6ld-AWW-O6afe6wEGhwQRrrbFv3HhGBZ0vgT7F1GeLKSpVaTBwzxDTcJdBvI_NWf3E0rwVDVS00tVu8HpJz4I53OJuezrGvE3Tp_CqPtGoJi5INrHfz0BcK_tAjUbpyfDO_Gb5dUf4l0d9jhxhOzSnJCMAeuNFWqtpxiXNHYJ4ZlE3R6qkVWx-Mo9JWuH4_KLWQq9KK7cGwQoLIEsyrP4969W19Luu7GnwB-0nhYrdwV37AgVYVlmd44JLwzTokQhXrgGnZ0GTlS23rsdc1FiPRgot-1fJEZus6LOrlFDPqfUxQL7Nt6mlUaSRar3tA";

    public static void init(){
        ApiClient client = new ClientBuilder().setBasePath("https://10.1.14.10:6443").setVerifyingSsl(false)
                .setAuthentication(new AccessTokenAuthentication(TOKEN)).build();
        Configuration.setDefaultApiClient(client);
    }

}
