package stream;

import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
/*
 * concat:用于把流组合到一起，静态方法
 */
public class Stream_concatDemo {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("喜羊羊","美羊羊","懒羊羊","灰太狼","红太狼");
        Stream<String> stream2 = Stream.of("张三丰","张翠山","张无忌","赵敏","周芷若");

        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(name-> System.out.println(name));

    }
}
