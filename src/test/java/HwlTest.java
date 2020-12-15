import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangyh
 * @ClassName: HwlTest
 * @Date: 2020/10/20 14:47
 * @Operation:
 * @Description: ${description}
 */
public class HwlTest {

    public static void main(String[] args) {
        String index  = "10.210.65.1";
        index  = index.substring(index.length()-5, index.length());
        String[] indexs = index.split("\\.");

        if(indexs[0].equals("1")&&indexs[2].equals("1")){//public类型的ipv4
            /*if(e.getColumns()[0]!=null){
                value   = e.getColumns()[0].getVariable().toString();
                snmpPortData.setPort(Integer.parseInt(value));
                snmpPortData.setPortIp(indexs[1]);
            }*/
        }
    }
}
