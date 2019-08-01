package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class StreamTest2 {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋元");
        one.add("徐星合");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        one.add("李逍遥");
        one.add("哪吒");

        Stream<String> stream1 = one.stream().filter(name->name.length()==3)
                                            .limit(3);

        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张天爱");
        two.add("尼古拉斯");
        two.add("赵丽颖");
        two.add("唐柔");
        two.add("张三丰");
        two.add("张飞");
        two.add("柳烟");
        Stream<String> stream2 = two.stream().filter(name->name.startsWith("张"))
                                             .skip(2);

        Stream.concat(stream1,stream2).map(name->new Person(name)).forEach(p-> System.out.println(p));
    }
}
