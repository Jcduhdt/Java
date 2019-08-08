package stream;

import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 截取流中的前n个元素，参数是long型，如果集合当前长度大于参数则进行截取，否则不进行操作
 */
public class Stream_limitDemo {
    public static void main(String[] args) {
        String[] arr = {"喜羊羊","美羊羊","懒羊羊","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream2 = stream.limit(3);
        stream2.forEach(name-> System.out.println(name));

    }
}
