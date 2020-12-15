import com.balbaxmx.common.util.BigFileReadUtil;
import org.junit.Test;

/**
 * @Author: zhangyh
 * @ClassName: BigFileReadUtilTest
 * @Date: 2020/9/2 14:30
 * @Operation:
 * @Description: ${description}
 */
public class BigFileReadUtilTest {

    @Test
    public void test(){
        BigFileReadUtil.getLineAll("E:\\newland\\MML\\jna data\\result1\\20200701_000.MML");
    }
}
