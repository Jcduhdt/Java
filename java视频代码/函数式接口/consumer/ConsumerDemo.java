package consumer;

import java.util.function.Consumer;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 *
 * java.util.function.Consumer
 * Consumer接口包含抽象方法void accept(T t) 一位消费一个制定泛型的数据
 * Consumer接口是一个消费型接口，泛型执行什么类，就可以使用accept方法消费什么类型的数据
 * 至于具体怎么消费（使用）需要自定义
 */
public class ConsumerDemo {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("赵丽颖",(String name)->{
            //消费方式
            System.out.println(name);

            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
