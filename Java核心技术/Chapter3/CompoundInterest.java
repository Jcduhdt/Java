/**
 * time:2019-5-6
 * author: Zhang Xiong
 * This program shows how to store tabular data in a 2D array.
 * 计算不同利率下的收益
 * 打印二维数组的数据元素列表
 * 也可使用System.out.println(Arrays.deepToString(a));
 */
public class CompoundInterest
{
    public static void main(String[] args)
    {
        //final 是定义一个不可更改的常量
        final double STARTRATE = 10;
        final  int NRATES = 6;
        final  int NYEARS = 10;

        //set interest rates to 10 ... 15%
        //建一个数组保存10-15%的不同利率
        double[] interestRate = new double[NRATES];
        for (int j=0;j<interestRate.length;j++)
            interestRate[j] = (STARTRATE + j) / 100.0;

        //建一个balances二维数组，行数为年数，列数为不同利率数
        double[][] balances = new double[NYEARS][NRATES];

        //set initial balance to 10000
        //设置第一年的余额为10000，不同利率都是初始10000
        for (int j=0;j<balances[0].length;j++)
            balances[0][j] = 10000;

        //compute interest for future years

        for (int i=1;i<balances.length;i++)
        {
            for (int j=0;j<balances[i].length;j++)
            {
                //get last year's balances from previous row
                //创建临时变量保存去年的余额，即对应上一行的数据
                double oldBalance = balances[i - 1][j];

                //compute interest
                double interest = oldBalance * interestRate[j];

                //compute this year's balance
                balances[i][j] = oldBalance + interest;
            }
        }

        //print one row of interest rates
        for (int j=0;j<interestRate.length;j++)
            System.out.printf("%9.0f%%", 100 * interestRate[j]);//9.0是为了显示美观吧

        System.out.println();

        //print balance table
        for (double[] row : balances)
        {
            //print table row
            for (double b : row)
                System.out.printf("%10.2f",b);

            System.out.println();
        }
    }
}
