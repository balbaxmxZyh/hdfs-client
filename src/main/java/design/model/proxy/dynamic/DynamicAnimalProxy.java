package design.model.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zhangyh
 * @ClassName: DynamicAnimalProxy
 * @Date: 2020/12/15 14:24
 * @Operation:
 * @Description:
 *
 * 动物增强类，需要自己去增强前置、后置
 */
public class DynamicAnimalProxy extends DynamicProxy {


    public DynamicAnimalProxy(Object target) {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre operation");
        Object result =  method.invoke(target);
        System.out.println("next operation");
        return result;
    }


}
