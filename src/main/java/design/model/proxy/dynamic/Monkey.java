package design.model.proxy.dynamic;

/**
 * @Author: zhangyh
 * @ClassName: Monkey
 * @Date: 2020/12/15 14:21
 * @Operation:
 * @Description:
 *
 * 实际需要被代理的类
 * 猴子
 */
public class Monkey implements Animal {

    @Override
    public void eat() {
        System.out.println("banana");
    }
}
