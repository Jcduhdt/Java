package predicate;

import java.util.function.Predicate;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 *
 * 作用：对某种数据类型的数据进行判断，结果返回一个boolean值
 *
 * Predicate接口中包含一个抽象方法：
 *      boolean test(T t):用来指定数据类型数据进行判断的方法
 *      结果：
 *          符合条件，返回true
 *          不符合：false
 */
public class PredicateDemo {

    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcde";
        boolean b = checkString(s,(String str)->{
            return str.length()>5;
        });
        System.out.println(b);
    }
}
