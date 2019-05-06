/**
 * time:2019-5-6
 * author: Zhang Xiong
 * This program demonstrates a triangular array.
 * 打印不规则数组，数组的每一行有不同长度
 */
public class LotteryArray
{
    public static void main(String[] args)
    {
        final int NMAX = 10;

        //allocate triangular array
        //得到三角形的数组
        //固定了行数的二维数组
        int[][] odds = new int[NMAX + 1][];
        for (int n=0;n<=NMAX;n++)
            //对每行的元素个数进行固定
            odds[n] = new int[n + 1];

        //fill triangular array
        //填元素
        for (int n=0;n<odds.length;n++)
            for (int k=0;k<odds[n].length;k++)
            {
                //compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*...*k)
                int lotteryOdds = 1;
                for (int i=1;i<=k;i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;

                odds[n][k] = lotteryOdds;
            }

        //print triangular array
        for (int[] row : odds)
        {
            for (int odd : row)
                System.out.printf("%4d",odd);
            System.out.println();
        }
    }
}
