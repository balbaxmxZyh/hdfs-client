package design.model.proxy.dynamic;

import design.model.proxy.state.People;
import design.model.proxy.state.ZhangSan;

/**
 * @Author: zhangyh
 * @ClassName: DynamicMain
 * @Date: 2020/12/15 14:38
 * @Operation:
 * @Description: ${description}
 */
public class DynamicMain {

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        DynamicAnimalProxy monkeyProxy = new DynamicAnimalProxy(monkey);
        Object proxy = DynamicProxyFactor.creatProxy(monkeyProxy);
        ((Animal)proxy).eat();
        System.out.println("-----------------");

        Dog dog = new Dog();
        DynamicAnimalProxy dogProxy = new DynamicAnimalProxy(dog);
        Object dogProxyObjec = DynamicProxyFactor.creatProxy(dogProxy);
        ((Animal)dogProxyObjec).eat();
        System.out.println("-----------------");

        ZhangSan zhangSan = new ZhangSan();
        DynamicPeopleProxy zhangsanProxy = new DynamicPeopleProxy(zhangSan);
        Object zhangsanProxyObject = DynamicProxyFactor.creatProxy(zhangsanProxy);
        ((People)zhangsanProxyObject).say();
        System.out.println("-----------------");


    }
}
