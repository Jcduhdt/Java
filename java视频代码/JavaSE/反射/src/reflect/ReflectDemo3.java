package reflect;

import java.lang.reflect.Field;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        getFieldDemo();
    }


    /*
     * 获取字节码文件中的字段
     */
    public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("reflect.bean.Person");

//        Field field = clazz.getField("age");//只能获取共有的
        Field field = clazz.getDeclaredField("age");//只能获取本类，但包含私有
        System.out.println(field);

        //对私有字段的访问，取消权限检查  暴力访问
        field.setAccessible(true);

        Object obj = clazz.newInstance();

        field.set(obj,89);
        Object o = field.get(obj);
        System.out.println(o);
    }
}
