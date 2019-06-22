import java.util.Scanner;

/**
 * time:2019-05-15
 * author：Zhang Xiong
 * 封装：指隐藏对象的属性和实现细节，仅对外提供访问方式
 * 好处：将变化隔离、便于使用、提高重用性、提高安全性
 *封装原则：
 * 把不需要对外提供的内容都隐藏
 * 把属性隐藏，提供方法
 *
 * private：私有，是一个权限修饰符，用于修饰成员
 *          私有的内容只在本类中有效
 * 注意：私有仅仅是封装的一种体现
 */
public class PersonDemo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入年龄：");
        int a = in.nextInt();
        Person p = new Person();
        p.lock(a);
        p.speak();
    }
}

class Person
{
    /*
     * 人：
     * 属性：年龄
     * 行为：说话
     */
    //public<-->private权限修饰符
    private int age;//私有化，外面不能访问
    // 即使创建了一个Person类，也没有age这个属性

    //规范了
    public void setAge(int a)
    {
        age = a;
    }
    public int getAge()
    {
        return age;
    }

    public void lock(int a)//上锁判断age是否符合常规
    {
        if (a>0 && a<130)
            age = a;
        else
            System.out.println("错误的数据");
    }
    void speak()
    {
        System.out.println("age="+age);
    }
}
