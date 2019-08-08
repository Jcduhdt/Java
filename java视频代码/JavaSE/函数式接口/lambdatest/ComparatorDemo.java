package lambdatest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 如果一个方法的返回值类型是一个函数式接口，那么就可以直接放回一个Lambda表达式
 * 当需要通过一个方法来获取一个java.util.Comparator接口类型的对象作为排序器时，就可以调该方法获取
 */
public class ComparatorDemo {
    //定义一个方法，方法的返回值类型使用函数式接口Comparator
    public static Comparator<String> getComparator(){
        //方法的返回值类型是一个接口，那么我们可以返回这个接口的匿名内部类
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照字符串的降序排序
                return o2.length()-o1.length();
            }
        };*/

        //方法的返回值类型是一个接口，那么我们可以返回一个Lambda表达式
        /*return (String o1,String o2)->{
            //按照字符串的降序排序
            return o2.length()-o1.length();
        };*/

        //优化  方法的返回值类型是一个接口，那么我们可以返回一个Lambda表达式
        return (o1,o2)-> o2.length()-o1.length();
    }


    public static void main(String[] args) {
        String[] arr = {"aaa","b","cccccc","dddddddddddddddddd"};
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
