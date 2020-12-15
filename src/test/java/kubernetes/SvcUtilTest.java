package kubernetes;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.util.GsonUtil;
import com.balbaxmx.kubernetes.client.util.SvcUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.kubernetes.client.custom.IntOrString;
import io.kubernetes.client.openapi.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: PodUtilTest
 * @Date: 2020/8/24 15:16
 * @Operation:
 * @Description: ${description}
 */
public class SvcUtilTest {
    @Before
    public void before() {
        K8sRequestCode.init();
    }

    @Test
    public void list() {
        JsonObject list = SvcUtil.list("default");
        System.out.println(list.toString());
    }

    @Test
    public void readNamespace() {
        JsonObject v1Service = SvcUtil.readSvc("default","tomcat8-8080");
        System.out.println(v1Service.toString());
    }

    @Test
    public void create() {
        V1Service v1Service = new V1Service();
        v1Service.setApiVersion("v1");
        v1Service.setKind("Service");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("my-tomcat-svc");
        v1Service.setMetadata(meta);

        V1ServiceSpec spec = new V1ServiceSpec();
        Map<String,String> map = new HashMap<>();
        //设置代理的pod
        map.put("app","my-tomcat");
        spec.setSelector(map);
        List<V1ServicePort> ports = new ArrayList<>();
        V1ServicePort port = new V1ServicePort();
        port.setPort(80);
        port.setTargetPort(new IntOrString(8080));
        port.setNodePort(30011);
        port.setName("http");
        ports.add(port);
        spec.setPorts(ports);
        //LoadBalancer类型
        spec.setType("NodePort");
        v1Service.setSpec(spec);
        JsonObject result = SvcUtil.create("default",v1Service);
        System.out.println(result.toString());
    }

    @Test
    public void delete() {
        V1DeleteOptions options = new V1DeleteOptions();
        /*options.setKind("Pod");
        options.setApiVersion("v1");*/
        V1Status status = SvcUtil.delete("service-example","default", options);
        System.out.println(status != null?status.toString():1);
    }


}
