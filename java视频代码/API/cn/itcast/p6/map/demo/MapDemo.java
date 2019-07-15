package cn.itcast.p6.map.demo;

import java.util.*;

/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */

public class MapDemo
{
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
//        method(map);
        method_2(map);
    }

    public static void method_2(Map<Integer,String> map)
    {
        map.put(8,"wangwu");
        map.put(2,"zhaoliu");
        map.put(7,"xiaoqiang");
        map.put(6,"wangcai");
        map.put(4,"wangcai");

        Collection<String> values = map.values();

        Iterator<String> it_1 = values.iterator();
        while (it_1.hasNext())
        {
            System.out.println(it_1.next());
        }

        /*
         * 通过map转成set就可以迭代
         * 找到了另一个方法，entrySet
         * 该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型（结婚证）
         * <>泛型
         */

        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();//应该是创建一个Set集合，存的是Map.Entry类型

        Iterator<Map.Entry<Integer,String>> it_2 = entrySet.iterator();
        while(it_2.hasNext())
        {
            Map.Entry<Integer,String> me = it_2.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key+":::"+value);
        }
        //取出map中所有元素
        //原理，通过keySet方法获取map中所有的键所在的set集合，再通过set的迭代器获取到每一个键
        //再对每一个键通过map集合的get方法获取其对应的值即可
       /* Set<Integer> keySet = map.keySet();
        Iterator<Integer> it = keySet.iterator();

        while(it.hasNext())
        {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key+":"+value);
        }*/
    }

    public static void method(Map<Integer,String> map)//学号，姓名
    {
        // 添加元素
        System.out.println(map.put(8,"wangcai"));//null
        System.out.println(map.put(8,"xiaoqiang"));//wangcai 存相同键，值会覆盖
        map.put(2,"zhangsan");
        map.put(7,"zhaoliu");

        // 删除
        System.out.println("remove: " + map.remove(2));

        // 判断
        System.out.println("Containskey: "+ map.containsKey(7));

        //获取
        System.out.println("get: "+ map.get(6));
        System.out.println(map);//{8=xiaoqiang}

        Outer.Inner.show();
    }
}

interface MyMap{
    public static interface MyEntey{//内部接口
        void get();
    }
}

class MyDemo implements MyMap.MyEntey{
    public void get(){}
}

class Outer{
    static class Inner{
        static void show(){}
    }
}
