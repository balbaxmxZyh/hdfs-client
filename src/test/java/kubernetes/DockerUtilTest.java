package kubernetes;

import com.balbaxmx.kubernetes.client.client.DockerAppV2Client;
import com.balbaxmx.kubernetes.client.config.K8sRequestCode;
import com.balbaxmx.kubernetes.client.docker.model.Repositories;
import com.balbaxmx.kubernetes.client.model.DeploymentList;
import com.balbaxmx.kubernetes.client.util.DeployUtil;
import com.balbaxmx.kubernetes.client.util.DockerUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangyh
 * @ClassName: kubernetes.DockerUtilTest
 * @Date: 2020/9/7 14:33
 * @Operation:
 * @Description: ${description}
 */
public class DockerUtilTest {


    @Test
    public void list() {
        Repositories o = DockerUtil.selectImageList();
        System.out.println(o.toString());
    }

    @Test
    public void image() {
        Object o = DockerUtil.selectImageTags("fmcp-sink");
        System.out.println(o.toString());
    }

    @Test
    public void imageMan() {
        Object o = DockerUtil.selectImageManifests("fmcp-sink","3.003");
        System.out.println(o.toString());
    }

    @Test
    public void digest() {
        Object o = DockerUtil.selectImageDigest("nginx","latest");
        System.out.println(o.toString());
    }
}
