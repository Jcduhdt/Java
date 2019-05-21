import java.util.Scanner;

/**
 * time:2019-5-5
 * author: Zhang Xiong
 * This program demonstrates a <code>while</code> loop.
 * 就是输入有多少存款达到好多才退休
 * 输入每年存好多，利率多少
 * 计算要好多年才能达到你的目标
 */

public class Retirement2
{
    public static void main(String[] args)
    {
        //read inputs
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interstRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        //updata account balance while goal isn't reached
        //do while循环
        do
        {
            //add this year's payment and interest
            balance += payment;
            double interest = balance * interstRate / 100;
            balance += interest;
            year++;
            //print current balance
            //类似python中%s %d  其中%,逗号是添加分组分隔符外国的数字表示
            System.out.printf("After year %d, your balance is %,.2f%n", year , balance);

            //ask if ready to retire and get input
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }
        while (input.equals("N"));
    }
}
