package design.model.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @Author: zhangyh
 * @ClassName: DynamicProxyFactor
 * @Date: 2020/12/15 14:34
 * @Operation:
 * @Description:
 *
 * 动态代理工厂
 */
public class DynamicProxyFactor {


    /**
     * 获取一个动态代理类
     * @param
     * @return
     */
    public static Object creatProxy(DynamicProxy proxy){
        Object target = proxy.getTarget();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxy);
    }
}
