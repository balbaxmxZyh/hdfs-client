package design.model.proxy.dynamic;

/**
 * @Author: zhangyh
 * @ClassName: Dog
 * @Date: 2020/12/15 15:22
 * @Operation:
 * @Description: ${description}
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("bone");
    }
}
