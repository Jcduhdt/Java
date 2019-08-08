package predicate;

import java.util.function.Predicate;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * Predicate的and  or
 *
 * 连接两个判断条件
 */
public class PredicateDemo2 {
    public static boolean checkString(String s, Predicate<String> pre1,Predicate<String> pre2){
//        return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);
//        return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        String s = "abcdef";

        boolean b = checkString(s,(String str)->{
            return str.length()>5;
        },(String str)->{
            return str.contains("k");
        });
        System.out.println("b = " + b);
    }
}
