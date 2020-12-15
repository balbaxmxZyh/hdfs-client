package kubernetes;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.util.NmspsUtil;
import com.balbaxmx.kubernetes.client.util.PodUtil;
import com.google.gson.Gson;
import io.kubernetes.client.openapi.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: PodUtilTest
 * @Date: 2020/8/24 15:16
 * @Operation:
 * @Description: ${description}
 */
public class PodUtilTest {
    @Before
    public void before() {
        K8sRequestCode.init();
    }

    @Test
    public void list() {
        V1PodList list = PodUtil.list("default");
        System.out.println(list.toString());
    }

    @Test
    public void readNamespace() {
        V1Pod v1Pod = PodUtil.readPod("default","tomcat8");
        System.out.println(v1Pod.toString());
    }

    @Test
    public void create() {
        V1Pod v1Pod = new V1Pod();
        v1Pod.setKind("Pod");
        v1Pod.setApiVersion("v1");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("my-tomcat");
        v1Pod.setMetadata(meta);
        Map<String,String> labels = new HashMap<>();
        labels.put("name","my-tomcat");
        meta.setLabels(labels);
        v1Pod.setMetadata(meta);

        V1PodSpec podSpec = new V1PodSpec();
        List<V1Container> containers = new ArrayList<>();
        V1Container container1 = new V1Container();
        container1.setName("my-tomcat");
        container1.setImage("10.1.8.144:5000/tomcat8");
        List<V1ContainerPort> ports = new ArrayList<>();
        V1ContainerPort port = new V1ContainerPort().containerPort(8081);
        ports.add(port);
        container1.setPorts(ports);
        List<V1EnvVar> envVars = new ArrayList<>();
        V1EnvVar envVar1 = new V1EnvVar();
        envVar1.setName("author");
        envVar1.setValue("zhangyaohui");
        envVars.add(envVar1);
        container1.setEnv(envVars);
        containers.add(container1);
        podSpec.setContainers(containers);
        v1Pod.setSpec(podSpec);
        V1Pod result = PodUtil.create("default",v1Pod);
        System.out.println(result.toString());
    }

    @Test
    public void delete() {
        V1DeleteOptions options = new V1DeleteOptions();
        /*options.setKind("Pod");
        options.setApiVersion("v1");*/
        V1Status status = PodUtil.delete("default","my-tomcat", options);
        System.out.println(status != null?status.toString():1);
    }


}
