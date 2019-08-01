package stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{"+
                "name="+name+"}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
