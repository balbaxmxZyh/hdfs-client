package design.model.proxy.state;

/**
 * @Author: zhangyh
 * @ClassName: ZhangSan
 * @Date: 2020/12/15 14:08
 * @Operation:
 * @Description:
 *
 * 实际操作类
 *
 */
public class ZhangSan implements People {
    @Override
    public void say() {
        System.out.println("我的名字叫张三");
    }

    @Override
    public void run() {
        System.out.println("张三跑步了");
    }
}
