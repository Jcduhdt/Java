package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        getMethodDemo();
        getMethodDemo_2();
        getMethodDemo_3();
    }

    public static void getMethodDemo_3() throws Exception {
        Class clazz = Class.forName("reflect.bean.Person");
        //写方法名，和方法传入的参数（方法没有参数，就传null）来获取指定方法
        Method method = clazz.getMethod("paramMethod", String.class, int.class);

        Object obj = clazz.newInstance();
        method.invoke(obj,"小强",29);//方法用invoke调用
    }

    public static void getMethodDemo_2() throws Exception {
        Class clazz = Class.forName("reflect.bean.Person");
        //写方法名，和方法传入的参数（方法没有参数，就传null）来获取指定方法
        Method method = clazz.getMethod("show",null);

//        Object obj = clazz.newInstance();
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Object obj = constructor.newInstance("小明",36);
        method.invoke(obj,null);
    }


    /*
     * 获取指定Class中的所有公共函数
     */
    public static void getMethodDemo() throws ClassNotFoundException {
        Class clazz = Class.forName("reflect.bean.Person");

        Method[] methods = clazz.getMethods();//获取的都是共有的方法
        methods = clazz.getDeclaredMethods();//只获取本类中所有方法，包含私有
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
