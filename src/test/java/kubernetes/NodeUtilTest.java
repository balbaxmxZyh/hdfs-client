package kubernetes;

import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.util.NodeUtil;
import com.google.gson.JsonObject;
import io.kubernetes.client.openapi.models.V1Node;
import io.kubernetes.client.openapi.models.V1Status;
import io.kubernetes.client.openapi.models.V1StatusDetails;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangyh
 * @ClassName: NodeUtilTest
 * @Date: 2020/8/24 9:39
 * @Operation:
 * @Description: ${description}
 */
public class NodeUtilTest {

    @Before
    public void before(){
        K8sRequestCode.init();
    }

    @Test
    public void list(){
        JsonObject object = NodeUtil.list();
        System.out.println(object.toString());
    }

    @Test
    public void read(){
        JsonObject object = NodeUtil.readNode("fmcp-01");
        System.out.println(object.toString());
    }

    @Test
    public void delete(){
//        V1Status object = NodeUtil.delete("fmcp-03");
//        System.out.println(object.toString());
    }

    @Test
    public void create(){
        //todo 研究
    }
}
