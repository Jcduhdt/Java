import java.util.Scanner;

/**
 * time:2019-5-5
 * author: Zhang Xiong
 * This program demonstrates a <code>for</code> loop.
 * 计算中奖概率
 * 比如1-50之间取6个数字抽奖 即那个数学公式C(上6,下50)
 */
public class LotteryOdds
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        /*
        compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*...*k)
         */

        int lotteryOdds = 1;
        for (int i=1;i<=k;i++)
            lotteryOdds = lotteryOdds * (n - i + 1) / i;

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
