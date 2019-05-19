/**
 * time:2019-05-19
 * author：Zhang Xiong
 *
 * 写方法时，写void是因为懒，不然就要指定格式，要写return
 */
public class StaticDemo2
{
    public static void main(String[] args) throws Exception//后面这东西没讲过
    {
        Thread.sleep(5000);//当时也没讲
        Person_4.method();
        Person_4 p = new Person_4("java",20);
        p.show();
    }
}

class Person_4
{
    private String name;
    private int age;
    static String country = "CN";
    public Person_4(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    public void show()
    {
        System.out.println(Person_4.country+":"+this.name+":"+this.age);
    }

    public static void method()
    {
        System.out.println(Person_4.country);
    }
}