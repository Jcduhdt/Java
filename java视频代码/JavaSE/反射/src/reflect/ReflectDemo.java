package reflect;

import reflect.bean.Person;

import java.net.SocketOption;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */

/*
 *Java反射机制是在运行状态中，对于任意一个类（class文件），都能够知道这个类的所有属性和方法
 * 对于任意一个对象，都能够调用它的任意一个方法和属性
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制
 *
 * 动态获取类中信息，就是java反射
 * 可以理解为对类的解剖
 * 提高了程序扩展性
 *
 * 要想对字节码文件进行解剖，必须有字节码文件对象
 * 如何获取字节码文件对象呢
 *
 *
 *
 * 应用程序独立运行，对外提供接口是为了功能扩展
 *
 * 如果想要对指定名称的字节码文件进行加载并获取其中的内容并调用
 * 怎么可以实现呢？
 * 这时就使用到了反射技术
 *
 * Tomcat
 * 提供了处理请求和应答的方式
 * 因为具体的处理动作不同，所以对外提供了接口，由开发者来实现具体请求和应答处理
 */

/*
 * class Class{
 * 提供获取字节码文件中的内容
 * 比如：
 * 名称
 * 字段
 * 构造函数
 * 一般函数
 * }
 * 该类就可以获取字节码文件中的所有内容，那么反射就是依靠该类完成的
 * 想要对一个类文件进行解剖，只要获取到该类的字节码文件对象即可
 */


public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {

//        getClassObject_1();
//        getClassObject_2();
        getClassObject_3();
    }



    /*
     * 方式三：
     * 只要通过给定的类的字符串名称就可以获取该类，更为扩展
     * 可使用Class类中的方法完成
     * 该方法就是forName
     * 这种方式只要有名称即可，更为方便，扩展性更强
     */
    public static void getClassObject_3() throws ClassNotFoundException {
        String className = "reflect.bean.Person";//应该是类所在的名称空间，与该类是否导入没关系
        //感觉就相当于import后面的内容
        Class clazz = Class.forName(className);
        System.out.println(clazz);
    }

    private static void getClassObject_2(){
        /*
         * 方式2
         * 2.任何数据类型都具备一个静态属性，class来获取其对应的Class对象
         * 相对简单，但是还要明确用到类中的静态成员
         * 还是不够扩展
         */
        Class clazz = Person.class;

        Class clazz1 = Person.class;
        System.out.println(clazz==clazz1);

    }

    /*
     * 获取字节码对象的方式
     * 1.Object类中的getClass()方法的
     *  想要用这种方式，必须要明确具体的类，并创建对象
     */
    public static void getClassObject_1(){
        Person p = new Person();
        Class clazz = p.getClass();

        Person p1 = new Person();
        Class clazz1 = p1.getClass();

        System.out.println(clazz==clazz1);
    }
}
