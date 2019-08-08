package function;

import java.util.function.Function;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * Function中抽象方法：R apply(T t),根据类型T的参数获取类型R的结果
 * eg：String to Integer
 */
public class FunctionDemo {
    public static void change(String s, Function<String,Integer> fun){
        Integer in = fun.apply(s);
        System.out.println("in = " + in);
    }

    public static void main(String[] args) {
        String s = "1234";
        change(s,(str)->Integer.parseInt(str));
    }
}
