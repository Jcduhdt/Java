package supplier;

import java.util.function.Supplier;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 常用函数式接口
 * java.util.function.Supplier<T>接口仅包含一个无参的方法：T get() 用来获取一个泛型参数指定类型的对象数据
 * Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据
 *
 * 感觉好没用
 */
public class SupplierDemo {
    //定义一个方法，方法参数传递Supplier<T>接口，反省之死那个String，get方法就会返回一个String
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        String s = getString(()->"胡歌");
        System.out.println(s);
    }
}
