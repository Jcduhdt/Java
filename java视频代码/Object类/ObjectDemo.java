/**
 * @version V12.0.1 2019-06-11
 * @author Zhang Xiong
 */

/*
 * Object：所有类的根类
 * Object是不断抽取而来，具备着所有对象的共性内容
 */
class Person
{
    private int age;
    Person(int age)
    {
        this.age = age;
    }
    /*
     * 比较Person的年龄，是否是同龄人
     * 一般都会覆盖此方法，根据对象的特有内容，建立判断对象是否相同的依据
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person))
        {
            //return false;
            throw new ClassCastException("类型错误");
        }
        Person p = (Person) obj;
        return this.age == p.age;
    }

    /*public int hashCode()
    {
        return age;//自己改为以年龄为哈希码
    }*/
    public String toString()
    {
        return "Person :" + age;
    }
}

class Demo{}
public class ObjectDemo
{
    public static void main(String[] args)
    {
        Person p1 = new Person(20);
        Person p2 = new Person(20);
        Person p3 = p1;
        Demo d = new Demo();

        /*
         * equals()方法没被覆盖的时候，作用同==，都是判断两对象地址值是否相同
         */
        System.out.println(p1==p2);
        System.out.println(p1.equals(p3));
        //System.out.println(p1.equals(d));
        System.out.println(p1.equals(p2));
        System.out.println(p2);
        System.out.println(Integer.toHexString(p2.hashCode()));
        Class clazz1 = p1.getClass();
        Class clazz2 = p2.getClass();
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1.getName());
        System.out.println(p1.getClass().getName()+"$"+Integer.toHexString(p1.hashCode()));
    }
}
