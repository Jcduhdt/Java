/**
 * time:2019-04-29
 * author:Zhang Xiong
 * 数组排序
 */
public class Sort
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{23,416,748,3584,2,48};
        for (int i = 0; i<arr.length; i++)
        {
            if (i != arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]);
        }

        System.out.println("-------------------------");
        selectSort_1(arr);
        for (int i = 0; i<arr.length; i++)
        {
            if (i != arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]);
        }

        System.out.println("-------------------------");
        int[] arr1 = {1,353,496,35,48,68,100};
        bubbleSort(arr1);
        for (int i = 0; i<arr1.length; i++)
        {
            if (i != arr1.length-1)
                System.out.print(arr1[i]+",");
            else
                System.out.println(arr1[i]);
        }


    }

    //选择排序，依次找出最小值
    public static void selectSort(int[] arr)//不需要返回值，因为是同一数组
    {
        for (int x=0; x<arr.length; x++)
        {
            for (int y=x+1; y<arr.length; y++)
            {
                if (arr[x]>arr[y])
                {
                    swap(arr,x,y);
                }
            }
        }
    }

    //冒泡排序，从开始两两相邻的比较,这样大的就排后面去了
    public static void bubbleSort(int[] arr)
    {
        for (int x=0; x<arr.length; x++)
        {
            for (int y=0; y<arr.length-1-x; y++)
            {   //内循环-1：为了避免角标越界
                //-x：为了让外循环增加一次，内循环参数与比较的元素个数递减
                if (arr[y]>arr[y+1])
                {
                    swap(arr,y,y+1);
                }
            }
        }
    }

    //为了减少冗余
    public static void swap(int[] arr, int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //为了提高性能,一轮中记录最小值及其角标，只换一次
    public static void selectSort_1(int[] arr)
    {
        for (int x=0; x<arr.length; x++)
        {
            int num = arr[x];
            int index = x;
            for (int y=x+1; y<arr.length; y++)
            {
                if (num>arr[y])
                {
                    num = arr[y];
                    index = y;
                }
            }
            if (index!=x)
                swap(arr,x,index);
        }
    }
}
