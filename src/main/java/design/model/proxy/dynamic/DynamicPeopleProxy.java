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
 *  人增强类，需要自己去增强前置、后置
 */
public class DynamicPeopleProxy extends DynamicProxy {


    public DynamicPeopleProxy(Object target) {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("wash hand");
        Object result =  method.invoke(target);
        System.out.println("wipe mouth");
        return result;
    }


}
