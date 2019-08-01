package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 使用Stream流的方式，遍历集合，对集合中的数据进行过滤
 * Stream流是JDK1.8之后出现的
 * 与IO流不太一样
 * 关注的是做什么，而不是怎么做
 *
 * 拼接流式,工厂的生产流水线
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("金毛");
        list.add("灭绝师太");
        list.add("肖明");
        list.add("张强");
        list.add("张三丰");

        //1.过滤张开头的
        //2.过滤三个字的
        //3，遍历打印

        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));

    }
}
