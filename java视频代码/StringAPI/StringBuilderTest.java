package cn.itcast.p2.stringBuffer.test;

/**
 * @version V12.0.1 2019-7-8
 * @author Zhang Xiong
 */

public class StringBuilderTest
{
    public static void main(String[] args)
    {
        int[] arr = {3,1,5,3,8};
        String s = arrayToString(arr);
        String s1 = arrayToString_2(arr);

        System.out.println(s);
        System.out.println(s1);
    }

    public static String arrayToString_2(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;i<arr.length;i++)
        {
            if (i!=arr.length-1)
                sb.append(arr[i]+", ");
            else
                sb.append(arr[i]+"]");
        }
        return sb.toString();
    }

    public static String arrayToString(int[] arr)
    {
        String str = "[";
        for (int i = 0;i<arr.length;i++)
        {
            if (i!=arr.length-1)
                str+=arr[i]+", ";
            else
                str+=arr[i]+"]";
        }
        return str;
    }
}
