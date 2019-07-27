package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        createNewObject();
//        createNewObject_2();
    }

    public static void createNewObject_2() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        reflect.bean.Person P = new reflect.bean.Person("小强",30);

        /*
         * 当获取指定名称对应类中的锁体现的对象时
         * 而该对象初始化不使用空参数构造该怎么办呢？
         * 既然是通过指定的构造函数进行对象的初始化
         * 所以应该先获取到该构造函数。通过字节码文件对象即可完成
         * 该方法是：getConstructor(ParamterTypes);
         *
         */
        String name = "reflect.bean.Person";
        //找寻该名称类文件，并加载进内存，并产生Class对象
        Class clazz = Class.forName(name);
        //获取到了指定的构造函数对象
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        //通过该构造器对象的newInstance方法进行对象的初始化
        Object obj = constructor.newInstance("小明",38);
    }

    public static void createNewObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //早期：new时候，先根据被new的类的名称找寻该类的字节码文件，并加载进内存，并创建该字节码文件对象
        //并接着创建该字节文件的对象的Person对象
//        reflect.bean.Person P = new reflect.bean.Person();

        //现在
        String name = "reflect.bean.Person";
        //找寻该名称类文件，并加载进内存，并产生Class对象
        Class clazz = Class.forName(name);
        //如何产生该类的对象呢
        Object obj = clazz.newInstance();//该方法只能调用类的无参构造函数进行初始化
    }
}
