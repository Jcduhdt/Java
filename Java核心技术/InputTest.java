import java.util.*;
/**
 * time:2019-5-5
 * author: Zhang Xiong
 * This program demonstrates console input
 */

public class InputTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);//构造Scanner对象与System.in关联 获得输入的方法
        //还有种Console进行读密码，就是用*代替输入的那种

        //get first input
        System.out.print("What is your name?");
        String name = in.nextLine();

        //get second input
        System.out.print("How old are you?");
        int age = in.nextInt();

        //display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age+1));
    }
}
