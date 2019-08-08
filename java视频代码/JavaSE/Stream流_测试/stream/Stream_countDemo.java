package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * long count();
 * 用于统计Stream流中的个数
 * count方法是一个终结方法，返回值是一个long类型的整数
 * 所以不能继续调用Stream流中的其他方法了
 */
public class Stream_countDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println("count = " + count);
    }
}
