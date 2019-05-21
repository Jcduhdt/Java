import java.util.*;
import java.math.*;

/**
 * time:2019-5-5
 * author: Zhang Xiong
 * This program uses big numbers to compute the odds of winning the grand prize in a lottery.
 * 在基本的整数和浮点数精度不能够满足需求时可使用BigInteger实现任意精度运算
 * 使用大数值计算，静态的valueOf方法将普通数值转换为大数值
 * 不过这样只能用add multiply divide来代替+ * /
 * 计算中奖概率
 * 比如1-490之间取60个数字抽奖 即那个数学公式C(上60,下490)
 */
public class BigIntegerTest
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

        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i=1;i<=k;i++)
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1).divide(BigInteger.valueOf(i)));

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
