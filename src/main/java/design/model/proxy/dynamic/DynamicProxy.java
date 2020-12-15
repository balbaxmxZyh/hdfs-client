package design.model.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

/**
 * @Author: zhangyh
 * @ClassName: DynamicProxy
 * @Date: 2020/12/15 15:51
 * @Operation:
 * @Description:
 *
 *
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
