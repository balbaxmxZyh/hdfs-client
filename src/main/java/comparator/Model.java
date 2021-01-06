package comparator;

/**
 * @Author: zhangyh
 * @ClassName: Model
 * @Date: 2020/12/21 22:06
 * @Operation:
 * @Description: ${description}
 */
public class Model {

    private Integer code;
    private String name;

    public Model(Integer code,String name){
        this.code = code;
        this.name = name;
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
        return "Model{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
