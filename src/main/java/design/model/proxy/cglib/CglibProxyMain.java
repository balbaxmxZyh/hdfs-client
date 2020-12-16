package design.model.proxy.cglib;

import design.model.proxy.dynamic.Monkey;
import design.model.proxy.state.People;
import design.model.proxy.state.ZhangSan;

/**
 * @Author: zhangyh
 * @ClassName: CglibProxyMain
 * @Date: 2020/12/16 15:13
 * @Operation:
 * @Description: ${description}
 */
public class CglibProxyMain {

    public static void main(String[] args) {
        CglibAnimalProxy animalProxy = new CglibAnimalProxy();
        Elephant elephant = (Elephant) CglibProxyFactory.createCglibProxyFactory(animalProxy,Elephant.class);
        elephant.eat();


        Monkey monkey = (Monkey) CglibProxyFactory.createCglibProxyFactory(animalProxy,Monkey.class);
        monkey.eat();

        CglibPeopleProxy peopleProxy = new CglibPeopleProxy();
        ZhangSan zhangSan = (ZhangSan) CglibProxyFactory.createCglibProxyFactory(peopleProxy,ZhangSan.class);
        zhangSan.run();
    }
}
