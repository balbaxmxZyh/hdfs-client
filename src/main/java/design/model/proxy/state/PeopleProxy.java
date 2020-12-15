package design.model.proxy.state;

/**
 * @Author: zhangyh
 * @ClassName: PeopleProxy
 * @Date: 2020/12/15 14:12
 * @Operation:
 * @Description: ${description}
 *
 *
 * 人的代理类
 */
public class PeopleProxy implements People{

    private People people;

    public PeopleProxy(People people) {
        this.people = people;
    }

    @Override
    public void say() {
        System.out.println("say 的前置增强");
        this.people.say();
        System.out.println("say 的后置增强");
    }

    @Override
    public void run() {
        System.out.println("run 的前置增强");
        this.people.run();
        System.out.println("run 的后置增强");
    }
}
