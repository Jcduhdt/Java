/**
 * time:2019-04-29
 * author:Zhang Xiong
 */
public class ArrayOperation
{
    public static void main(String[] args)
    {
        //元素类型[] 数组名 = new 元素类型[]{元素,元素,...};
        int[] arr = new int []{89,34,270,17};//明确元素内容及个数
        int[] arr1 = {89,32,546,351};//静态初始化方式

        for (int i=0; i<arr.length ;i++)//居然这样获取数组长度
        {
            System.out.println("arr["+i+"] = "+arr[i]+";");
        }

        System.out.println("------------------------");
        for (int i=arr.length-1; i>=0 ;i--)//反向遍历
        {
            System.out.println("arr["+i+"] = "+arr[i]+";");
        }

        System.out.println(getMax(arr));
        System.out.println(getMax_1(arr));
    }
    /*
    获取数组最大值
     */
    public static int getMax(int[] arr)
    {
        int max = arr[0];
        for (int i = 1;i<arr.length ;i++)
        {
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public static int getMax_1(int[] arr)//利用角标
    {
        int maxIndex = 0;
        for (int i = 1;i<arr.length ;i++)
        {
            if (arr[i]>arr[maxIndex])
                maxIndex = i;
        }
        return arr[maxIndex];
    }
}
