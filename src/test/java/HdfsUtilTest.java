import com.balbaxmx.hdfs.client.util.HdfsUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hbase.client.ClusterConnection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.Before;

import java.io.IOException;

/**
 * @Author: zhangyh
 * @ClassName: HdfsUtilTest
 * @Date: 2020/8/1 20:50
 * @Operation:
 * @Description: ${description}
 */
public class HdfsUtilTest {

    @Before
    public void init() throws Exception {
        FileSystem system = HdfsUtil.getFs();
    }
}
