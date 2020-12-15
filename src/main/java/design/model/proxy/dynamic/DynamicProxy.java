package design.model.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

/**
 * @Author: zhangyh
 * @ClassName: DynamicProxy
 * @Date: 2020/12/15 15:51
 * @Operation:
 * @Description:
 *
 *  JDK提供的动态代理，代理类需要实现InvocationHandler接口。
 *  抽取一个底层抽象类
 */
public abstract class DynamicProxy implements InvocationHandler {

    protected Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
