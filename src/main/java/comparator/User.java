package comparator;

import java.util.Comparator;

/**
 * @Author: zhangyh
 * @ClassName: User
 * @Date: 2020/12/21 22:01
 * @Operation:
 * @Description: ${description}
 */
public class User implements Comparable<User> {

    private Integer code;
    private String name;

    public User(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {

        return o.code - this.code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
