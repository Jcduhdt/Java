package stream;

import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
//<R> Stream<R> map(Function<? super T, ? extends R> mapper);
public class Stream_mapDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        /*Stream<Integer> stream2 = stream.map((String s)->{
            return Integer.parseInt(s);
        });*/
        Stream<Integer> stream2 = stream.map(s->Integer.parseInt(s));

        stream2.forEach(name-> System.out.println(name));
    }
}
