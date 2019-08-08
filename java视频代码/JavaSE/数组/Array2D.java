/**
 * time:2019-05-06
 * author:Zhang Xiong
 * 二维数组定义格式
 */
public class Array2D
{
    public static void main(String[] args)
    {
        int[][] arr = new int[3][2];

        System.out.println(arr);//直接打印二维数组 抛出异常[[I@5f184fc6
        System.out.println(arr[0]);//直接打印二维数组中的角标0的一维数组
        System.out.println(arr[0][0]);//直接打印二维数组中的角标0的一维数组中角标为0的数据
        System.out.println(arr.length);//打印二位数组长度，即一维数组个数
        System.out.println(arr[1].length);

        int[][] arr1 = {{3,1,5,9},{4,5,6},{3,8},{6}};
        int sum = 0;
        for (int i=0;i<arr1.length;i++)
        {
            for (int j=0;j<arr1[i].length;j++)
            {
                System.out.print(arr1[i][j] + " ");
                sum += arr1[i][j];
            }
            System.out.println();
        }
        System.out.println("sum = " + sum);
    }
}
