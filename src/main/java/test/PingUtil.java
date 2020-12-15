package test;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zhangyh
 * @ClassName: PingUtil
 * @Date: 2020/7/20 11:01
 * @Operation:
 * @Description: ${description}
 */
public class PingUtil {
    private static Logger logger = LogManager.getLogger(PingUtil.class);

    private static String PRE_MS = "MS";
    private static String PRE_TTL = "TTL";

    /**
     *
     * @param ipAddress 地址
     * @param timeOut 超时时间
     * @return
     */
    public static boolean ping(String ipAddress) {
        BufferedReader in = null;
        boolean result = false;
        // 将要执行的ping命令,此命令是windows格式的命令
        Runtime r = Runtime.getRuntime();
        //获取操作系统类型
        String osName = System.getProperty("os.name");
        String pingCommand;
        if(osName.toLowerCase().contains("linux")){
            pingCommand = "ping -c 3 -W 1 "+ipAddress;
        }else {
            pingCommand = "ping " + ipAddress + " -n 3 -w 1000";
        }
        try {   // 执行命令并获取输出
            Process p = r.exec(pingCommand);
            if (p == null) {
                return result;
            }
            // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int connectedCount = 0;
            String line = null;
            while ((line = in.readLine()) != null) {
                connectedCount += getCheckResult(line);
            }
            // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
            result = connectedCount > 0;
            return result;
        } catch (Exception ex) {
            logger.error("指令异常[{}]",ex);
            return result;
        } finally {
            logger.info("执行命令[{},{}]",pingCommand,result);
            try {
                in.close();
            } catch (IOException e) {
                logger.error("指令流关闭异常[{}]",e);
            }
        }
    }

    /**
     * 若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
     * @param line
     * @return
     */
    private static int getCheckResult(String line) {
        System.out.println(line);
        if(StringUtils.isEmpty(line)){
            return 0;
        }
        if(line.toUpperCase().indexOf(PRE_MS) != -1 && line.toUpperCase().indexOf(PRE_TTL) != -1){
            return 1;
        }
        return 0;
    }
}
