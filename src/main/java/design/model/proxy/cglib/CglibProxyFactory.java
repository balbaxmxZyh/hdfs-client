package design.model.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author: zhangyh
 * @ClassName: CglibProxyFactory
 * @Date: 2020/12/16 15:02
 * @Operation:
 * @Description:
 *
 * 基于CGLIB动态代理
 * 通过继承类，进行前后置增强
 */
public class CglibProxyFactory {


    /**
     *  通过工厂获取clazz的代理类
     * @param proxy
     * @param clazz
     * @return
     */
    public static Object createCglibProxyFactory(MethodInterceptor proxy, Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(proxy);
        return enhancer.create();
    }
}
