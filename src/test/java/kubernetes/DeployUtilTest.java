package kubernetes;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.deploy.YamlInfo;
import com.balbaxmx.kubernetes.client.model.Deployment;
import com.balbaxmx.kubernetes.client.model.DeploymentList;
import com.balbaxmx.kubernetes.client.patch.JsonPathInfo;
import com.balbaxmx.kubernetes.client.patch.PatchEnum;
import com.balbaxmx.kubernetes.client.util.DeployUtil;
import com.balbaxmx.kubernetes.client.util.GsonUtil;
import com.balbaxmx.kubernetes.client.util.PodUtil;
import com.balbaxmx.kubernetes.client.util.YamlUtil;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.models.*;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: PodUtilTest
 * @Date: 2020/8/24 15:16
 * @Operation:
 * @Description: ${description}
 */
public class DeployUtilTest {
    @Before
    public void before() {
        K8sRequestCode.init();
    }

    @Test
    public void list() {
        DeploymentList list = DeployUtil.list("default");
        System.out.println(list.toString());
    }

    @Test
    public void readNamespace() {
        Deployment deployment = DeployUtil.readDeploy("default","my-tomcat");
        System.out.println(deployment.toString());
    }

    @Test
    public void create() {
        V1ContainerPort port = new V1ContainerPort();
        port.setContainerPort(80);
        V1Container container = YamlUtil.createV1Container("my-tomcat","10.1.8.144:5000/tomcat8",
                "",null,null,null,
                Arrays.asList(port));
        V1Deployment deployment = YamlInfo.builder().setAppVersion("apps/v1")
                .setKind("Deployment")
                .setReplicas(1)
                .setMeta("default","my-tomcat")
                .setSelectorMatchLabels("app","my-tomcat")
                .setTempMetaLabel("app","my-tomcat")
                .setContainer(container)
                .build();

        Deployment result = DeployUtil.create("default",deployment);
//        System.out.println(result.toString());
    }

    @Test
    public void delete() {
        V1DeleteOptions options = new V1DeleteOptions();
        V1Status status = DeployUtil.delete("default","my-tomcat", options);
        System.out.println(status != null?status.toString():1);
    }


    @Test
    public void updateReplicas() {
        Deployment status = DeployUtil.updateReplicas("default","my-tomcat", 2);
        System.out.println(status != null?status.toString():1);

    }

    @Test
    public void update() {
        String body ="{\"spec\":{\"template\":{\"metadata\":{\"labels\":{\"data_tomcat\":\"yyyytomcat\"}}}}}";
        V1Deployment status = DeployUtil.update("default","my-tomcat", body);
        System.out.println(status != null?status.toString():1);

    }


    @Test
    public void jsonPathTest() {
        JsonPathInfo replace = new JsonPathInfo("/spec/replicas", 1, PatchEnum.REPLACE);
        JsonPathInfo add = new JsonPathInfo("/hello", Arrays.asList("world"), PatchEnum.ADD);
        JsonPathInfo remove = new JsonPathInfo("/foo", null, PatchEnum.REMOVE);
        JsonPathInfo copy = new JsonPathInfo("/biscuits/0", "/best_biscuit", PatchEnum.COPY);
        JsonPathInfo move = new JsonPathInfo("/biscuits", "/cookies", PatchEnum.MOVE);

        System.out.println("[" + replace.toJsonPath() + "]");
        System.out.println("[" + add.toJsonPath() + "]");
        System.out.println("[" + remove.toJsonPath() + "]");
        System.out.println("[" + copy.toJsonPath() + "]");
        System.out.println("[" + move.toJsonPath() + "]");
    }



}
