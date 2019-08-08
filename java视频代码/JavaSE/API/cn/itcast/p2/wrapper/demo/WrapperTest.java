package cn.itcast.p2.wrapper.demo;

import java.util.Arrays;

/**
 * @version V12.0.1 2019-7-9
 * @author Zhang Xiong
 */


/*
 * 对一个字符串中的数值进行从小到大的排序
 *
 * "20 78 9 -7 88 36 29"
 *
 * 思路：
 * 1.排序，我很熟，可是我只熟int
 * 2.如何获取到这个字符串中的这些需要排序的数值？
 * 发现这个字符串中其实都是空格来对数值进行分隔的
 * 所以就想到用字符串对象的切割方法将大串变成多个小串
 * 3.数值最终变成小串，怎么变成一个int数呢？
 * 字符串-->基本类型可以使用包装类
 */
public class WrapperTest
{
    private static final String SPACE_SEPARATOR = " ";//ctrl+shift+u切换大小写
    public static void main(String[] args)
    {
        String numStr = "20 78 9 -7 88 36 29";

        System.out.println(numStr);
        numStr = sortStringNumber(numStr);
        System.out.println(numStr);
    }

    public static String sortStringNumber(String numStr)
    {
        // 1.将字符串变成字符串数组
        String[] str_arr = stringToArray(numStr);
        // 2.将字符串数组变成int数组
        int[] num_arr = toIntArray(str_arr);
        // 3.对int数组进行排序
        mySortArray(num_arr);
        // 4.将排序后的int数组变成字符串
        String temp = arrayToString(num_arr);
        return temp;
    }

    public static String arrayToString(int[] num_arr)
    {
        StringBuilder sb = new StringBuilder();
        for (int x=0;x<num_arr.length;x++)
        {
            if (x!=num_arr.length)
                sb.append(num_arr[x] + SPACE_SEPARATOR);
            else
                sb.append(num_arr[x]);
        }
        return sb.toString();
    }

    public static void mySortArray(int[] num_arr)
    {
        Arrays.sort(num_arr);
    }

    public static int[] toIntArray(String[] str_arr)
    {
        int[] arr = new int[str_arr.length];
        for (int i = 0;i<arr.length;i++)
        {
            arr[i] = Integer.parseInt(str_arr[i]);
        }
        return arr;
    }

    public static String[] stringToArray(String numStr)
    {
        String[] str_arr = numStr.split(SPACE_SEPARATOR);
        return str_arr;
    }
}
