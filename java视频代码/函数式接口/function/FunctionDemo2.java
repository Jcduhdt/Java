package function;

import java.util.function.Function;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * Function方法中的andThen:用来进行组合操作
 * 需求：
 *      把String类型的“123”转换为Integer类型，把转换后的结果加10
 *      把增加之后的Integer类型的数据，转换为String类型
 */
public class FunctionDemo2 {
    public static void change(String s, Function<String,Integer> fun1,Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println("ss = " + ss);
    }

    public static void main(String[] args) {
        String s = "123";
        /*change(s,(String str)->{
            return Integer.parseInt(str)+10;
        },(Integer i)->{
            return i+"";
        });*/


        //优化
        change(s,(str)->Integer.parseInt(str)+10,(i)->i+"");

    }
}
