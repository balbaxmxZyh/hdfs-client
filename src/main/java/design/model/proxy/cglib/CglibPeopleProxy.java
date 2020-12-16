package design.model.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhangyh
 * @ClassName: CglibAnimalProxy
 * @Date: 2020/12/16 15:05
 * @Operation:
 * @Description:
 *
 * 基于cglib的人代理类
 */
public class CglibPeopleProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {

        System.out.println("people pre");
        Object result = methodProxy.invokeSuper(object,args);
        System.out.println("people next");
        return result;
    }
}
