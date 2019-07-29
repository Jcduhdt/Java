package predicate;

import java.util.function.Predicate;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 取反操作  negate
 */
public class PredicateDemo3 {
    public static boolean checkString(String s, Predicate<String> pre){
//        return !pre.test(s);
        return pre.negate().test(s);
    }

    public static void main(String[] args) {
        String s = "abcdef";

        boolean b = checkString(s,(String str)->{
            return str.length()>5;
        });
        System.out.println("b = " + b);
    }
}
