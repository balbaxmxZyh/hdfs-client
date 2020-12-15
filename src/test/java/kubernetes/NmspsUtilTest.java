package kubernetes;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.util.NmspsUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: NodeUtilTest
 * @Date: 2020/8/24 9:39
 * @Operation:
 * @Description: ${description}
 */
public class NmspsUtilTest {

    @Before
    public void before(){
        K8sRequestCode.init();
    }

    @Test
    public void list(){
        V1NamespaceList list = NmspsUtil.list();
        System.out.println(list.toString());
    }

    @Test
    public void readNamespace(){
        V1Namespace namespace = NmspsUtil.readNamespace("zyh-test2");
        System.out.println(namespace.toString());
    }

    /**
     *  "metadata": {
     *                 "name": "kube-public",
     *                 "selfLink": "/api/v1/namespaces/kube-public",
     *                 "uid": "bd604344-1188-45be-8e73-756c6abecb5b",
     *                 "resourceVersion": "13",
     *                 "creationTimestamp": "2020-06-22T02:16:19Z"
     *             },
     */
    @Test
    public void create(){
        V1Namespace namespace = new V1Namespace();
        namespace.setApiVersion("v1");
        namespace.setKind("Namespace");
        V1NamespaceSpec spec = new V1NamespaceSpec();
        spec.addFinalizersItem("kubernetes");
        namespace.setSpec(spec);
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("zyh-test2");
        namespace.setMetadata(meta);
        V1Namespace result = NmspsUtil.create(namespace);
        System.out.println(result.toString());
    }

    @Test
    public void delete(){
        V1Namespace namespace = NmspsUtil.readNamespace("zyh-test2");
        V1DeleteOptions options = new V1DeleteOptions();
        options.setPreconditions(new V1Preconditions().uid(namespace.getMetadata().getUid()));
        NmspsUtil.delete("zyh-test2",options);
    }

}
