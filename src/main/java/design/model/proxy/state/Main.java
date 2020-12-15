package design.model.proxy.state;

/**
 * @Author: zhangyh
 * @ClassName: Main
 * @Date: 2020/12/15 14:14
 * @Operation:
 * @Description: ${description}
 */
public class Main {


    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        PeopleProxy proxy = new PeopleProxy(zhangSan);
        proxy.run();
        proxy.say();
    }
}
