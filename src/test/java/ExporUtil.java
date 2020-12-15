/**
 * @Author: zhangyh
 * @ClassName: ExporUtil
 * @Date: 2020/8/13 10:41
 * @Operation:
 * @Description:
 */
public class ExporUtil {

    /**
     * 模拟导入文件操作
     * @param robotDemo
     * @param path
     */
    public static void operate(AwtRobot robotDemo,String path){
        robotDemo.delay(1000);
        robotDemo.enter();
        robotDemo.delay(1000);
        robotDemo.setAndctrlVClipboardData(path);
        robotDemo.delay(1000);
        robotDemo.enter();
    }
}
