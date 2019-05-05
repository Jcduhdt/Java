import java.util.Scanner;

/**
 * time:2019-5-5
 * author: Zhang Xiong
 * This program demonstrates a <code>while</code> loop.
 * 就是输入有多少存款达到好多才退休
 * 输入每年存好多，利率多少
 * 计算要好多年才能达到你的目标
 */

public class Retirement
{
    public static void main(String[] args)
    {
        //read inputs
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interstRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        //updata account balance while goal isn't reached
        while (balance < goal)
        {
            //add this year's payment and interest
            balance += payment;
            double interest = balance * interstRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("You can retire in " + years + "years.");
    }
}
