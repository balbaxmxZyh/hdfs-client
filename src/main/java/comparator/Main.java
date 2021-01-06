package comparator;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Main
 * @Date: 2020/12/21 22:05
 * @Operation:
 * @Description: ${description}
 */
public class Main {


    public static void main(String[] args) {
        Model[] models = new Model[]{new Model(1,"zhangsan"),
        new Model(2,"lisi"),new Model(3,"wangwu")};
        Arrays.sort(models,new comparatorModel());

        for (Model model :models){
            System.out.println(model.toString());
        }


        User[] users = new User[]{
                new User(1,"zhangsan"),
                new User(2,"lisi"),
                new User(3,"wangwu")
        };

        Arrays.sort(users);
        for (User user :users){
            System.out.println(user.toString());
        }
    }


    static class comparatorModel implements Comparator<Model>{

        @Override
        public int compare(Model o1, Model o2) {
            return o2.getCode() - o1.getCode();
        }
    }

}
