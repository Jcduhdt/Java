package stream;

import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * skip 跳过前n个，若n大于元素个数，返回为空的流
 *  Stream<T> skip(long n);
 */
public class Stream_skipDemo {
    public static void main(String[] args) {
        String[] arr = {"喜羊羊","美羊羊","懒羊羊","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream2 = stream.skip(3);
        stream2.forEach(name-> System.out.println(name));

    }
}
