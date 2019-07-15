package cn.itcast.p1.string.demo;

/**
 * @version V12.0.1 2019-7-5
 * @author Zhang Xiong
 */

/*
 * 给定一个字符串数组。按照字典顺序进行从小到大的排序
 * {"nba","abc","cba","zz","qq","haha"}
 *
 * 思路：
 * 1.对数组排序。可以用选择，冒泡
 * 2.for 嵌套和比较以及换位
 * 3.问题：以前排的是整数，比较用的比较运算符，可是现在是字符串对象
 *   字符串对象怎么比较呢。爽了，对象中提供了用于字符串对象比较的功能
 */
public class StringTest_1
{
    public static void main(String[] args)
    {
        String[] arr = {"nba","abc","cba","zz","qq","haha"};
        printArray(arr);
        sortString(arr);
        printArray(arr);
    }

    public static void sortString(String[] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr.length-1;j++)
            {
                if (arr[i].compareTo(arr[j])<0)//字符串比较用compareTo完成
                    swap(arr,i,j);
            }
        }
    }

    public static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(String[] arr)
    {
        System.out.print("[");
        for (int i=0;i<arr.length;i++)
        {
            if (i!=arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]+"]");
        }
    }
}
