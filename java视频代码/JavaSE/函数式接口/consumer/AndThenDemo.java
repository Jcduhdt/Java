package consumer;

import java.util.function.Consumer;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
/*
 * Consumer接口默认方法andThen
 * 作用:需要两个Consumer接口，可以把两个Consumer接口组合到一起，再对数据进行消费
 *
 * 例如：
 * Consumer<String> con1
 * Consumer<String> con2
 * String s = "hello"
 * con1.accept(s);
 * con2.accept(s);
 *
 * 连接两个Consumer接口，再进行消费
 * con1.andThen(con2).accept(s);谁在前边谁先消费
 */
public class AndThenDemo {
    public static void method(String s, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(s);
//        con2.accept(s);
        //使用andthen
        con2.andThen(con1).accept(s);
    }

    public static void main(String[] args) {
        method("FsBKa",(t)->{
            System.out.println(t.toUpperCase());
        },
        (t)->{
            System.out.println(t.toLowerCase());
        });
    }
}
