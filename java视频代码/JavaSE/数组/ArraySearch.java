/**
 * time:2019-04-29
 * author: Zhang Xiong
 */
import java.util.*;
public class ArraySearch
{
    public static void main(String[] args)
    {
        int[] arr={5,16,21,35,46,55,68,78,84,96};
        int index = getIndex(arr,35);
        System.out.println("index="+index);
        int index_1 = halfSearch(arr,46);
        System.out.println("index="+index_1);
        int index_2 = halfSearch_1(arr,84);
        System.out.println("index="+index_2);
        int index_3 = halfSearch_2(arr,50);
        System.out.println("index="+index_3);
        int index_4 = Arrays.binarySearch(arr,50);//如果存在返回具体角标位置，若不存在，返回 -插入点-1
        System.out.println("index="+index_4);

    }

    /*
    数组常见功能：查找
     */
    public static int getIndex(int[] arr,int key)
    {
        for (int x=0; x<arr.length; x++)
        {
            if (arr[x] == key)
                return x;
        }
        return -1;//因为返回的是角标，数组中没有-1这个脚标，这就是返回错误的意思
    }

    /*
    二分查找法
    必须要是对排好序的数组进行处理
     */
    public static int halfSearch(int[] arr,int key)
    {
        int max,min,mid;
        min = 0;
        max = arr.length-1;
        mid = (min+max)/2;

        while(arr[mid]!=key)
        {
            if(key>arr[mid])
                min = mid+1;
            else if(key<arr[mid])
                max = mid-1;

            if(max<min)
                return -1;

            mid = (max+min)/2;
        }
        return mid;
    }


    public static int halfSearch_1(int[] arr,int key)
    {
        int max,min,mid;
        min = 0;
        max = arr.length-1;

        while(min<max)
        {
            mid = (max+min)>>1;

            if(key>arr[mid])
                min = mid+1;
            else if(key<arr[mid])
                max = mid-1;
            else
                return mid;
        }
        return -1;
    }


    /*
    面试题
    给定一个有序数组，如果往该数组添加一个元素，要保证数组有序，如何获取放取位置
     */
    public static int halfSearch_2(int[] arr,int key)
    {
        int max,min,mid;
        min = 0;
        max = arr.length-1;

        while(min<max)
        {
            mid = (max+min)>>1;

            if(key>arr[mid])
                min = mid+1;
            else if(key<arr[mid])
                max = mid-1;
            else
                return mid;
        }
        return min;
    }
}
