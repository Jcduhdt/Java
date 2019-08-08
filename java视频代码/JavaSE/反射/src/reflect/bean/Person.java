package reflect.bean;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        super();
        System.out.println("Person run");
    }

    public Person(String name,int age) {
        super();
        this.name = name;
        this.age = age;

        System.out.println("Person param run..."+this.name+":"+this.age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(name+"...show run..."+age);
    }

    private void method(){
        System.out.println("method run");
    }

    public void paramMethod(String str,int num){
        System.out.println("parammethod run..."+str+":"+num);
    }
}
