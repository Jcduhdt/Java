import java.util.Arrays;
import java.util.Scanner;

/**
 * time:2019-5-6
 * author: Zhang Xiong
 * This program demonstrates array manipulation.
 * 以数组进行操作，使用了随机数，数组排序，for each循环
 * 在1-n个随机数中抽取k个数，把这k个数排序打印出来，即你购买的彩票
 */
public class LotteryDrawing
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        //fill an array with number 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i=0;i<numbers.length;i++)
            numbers[i] = i + 1;

        //draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i=0;i<result.length;i++)
        {
            //make a random index between 0 and n-1
            int r = (int)(Math.random() * n);//Math.random()返回[0,1)之间的随机浮点数 使用（int）进行强转

            //pick the element at the random location
            result[i] = numbers[r];

            //move the last element into the random location
            //为避免重复抽取一个数
            //让抽取到的那个数变成数组中最后位的那个数，再把搜索改庶族的范围缩小一次
            numbers[r] = numbers[n - 1];
            n--;
        }

        //print the sorted array
        //每次抽取的都是下标而不是具体的值，下标指向包含尚未抽取过的数组，抽取K个后就可对result进行排序
        Arrays.sort(result);
        System.out.println("Best the following combination. It'll make you rich!");
        //for each循环 r 为result中的成员 对每个成员进行遍历
        //与python中的for each in url_list:效果一样
        for (int r : result)
            System.out.println(r);
    }
}
