package stream;

import java.util.ArrayList;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class StreamTest {
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
        //只要名字为3个字的成员
        ArrayList<String> one1 = new ArrayList<>();
        for (String name : one) {
            if (name.length()==3){
                one1.add(name);
            }
        }
        //第一个队伍筛选后只要三个人
        ArrayList<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i));
        }


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

        //只要姓张的
        ArrayList<String> two1 = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith("张")){
                two1.add(name);
            }
        }

        //不要前两人
        ArrayList<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add(two1.get(i));
        }

        //合并两个队伍
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one2);
        all.addAll(two2);

        //根据姓名创建Person对象，存到集合中
        ArrayList<Person> list = new ArrayList<>();
        for (String name : all) {
            list.add(new Person(name));
        }

        //打印队伍Person信息
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
