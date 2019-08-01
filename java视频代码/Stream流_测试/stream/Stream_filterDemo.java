package stream;

import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
//Stream<T> filter(Predicate<? super T> predicate);
//filter 方法参数Predicate是一个函数是接口，所以可以传递Lambda表达式，对数据进行过滤
public class Stream_filterDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰","张翠山","张无忌","赵敏","周芷若");
//        Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("张");});
        Stream<String> stream2 = stream.filter(name->name.startsWith("张"));//filter就是过滤器反回true就收到数组/集合里吧
        stream2.forEach(name-> System.out.println(name));

        /*
         * Stream流属于管道流，只能被消费（使用）一次
         * 第一个Stream流调用完毕方法，数据就会流转到下一个Stream上
         * 而这时第一个Stream流已经使用完毕，就会关闭了
         * 所以第一个Stream流就不能再调用了
         */
    }
}
