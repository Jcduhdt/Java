package stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 获取一个流的方式：
 *  -所有Collection集合都可以通过strea默认方法获取流
 *      default Stream<E> stream()
 *  -Stream接口的静态方法of可以获取数组对应的流
 *  static <T> Stream<T> of(T...values)
 *  参数是一个可变参数，那么我们就可以传递一个数组
 *
 * 必须是单列
 * 对于map就要转换
 */
public class GetStreamDemo {
    public static void main(String[] args) {
        //把集合转化成Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();
        //获取键，存储到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        //获取值，存到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //获取键值对(键与值的映射关系，entrySet)
        Set<Map.Entry<String,String>> entries = map.entrySet();
        Stream<Map.Entry<String,String>> stream5 = entries.stream();

        //把数组转换成Stream流
        Stream<Integer> stream6 = Stream.of(1,2,3,4,5);
        //可变参数可以传递数组
        Integer[] arr = {1,2,3,4,5,6};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = {"a","b","c"};
        Stream<String> streamm8 = Stream.of(arr2);
    }
}
