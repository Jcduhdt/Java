import java.util.Scanner;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-05
 */

/**
 * 牛客网
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 */

/**
 * 题目分析：
 * 先举几个例子，可以看出规律来。
 * 4 ： 2*2
 * 5 ： 2*3
 * 6 ： 3*3
 * 7 ： 2*2*3 或者4*3
 * 8 ： 2*3*3
 * 9 ： 3*3*3
 * 10：2*2*3*3 或者4*3*3
 * 11：2*3*3*3
 * 12：3*3*3*3
 * 13：2*2*3*3*3 或者4*3*3*3
 *
 * 下面是分析：
 * 首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
 * 当然也可能有4，但是4=2*2，我们就简单些不考虑了。
 * 5<2*3,6<3*3,比6更大的数字我们就更不用考虑了，肯定要继续分。
 * 其次看2和3的数量，2的数量肯定小于3个，为什么呢？因为2*2*2<3*3，那么题目就简单了。
 * 直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
 * 由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
 *
 * 乘方运算的复杂度为：O(log n)，用动态规划来做会耗时比较多。
 */
public class CutRope {
    public int cutRope(int n) {

        int max = 0;
        if (n <= 3) {
            return n - 1;
        }

        for (int i = 2; i <= Math.ceil(n / 2.0); i++) {//到一半  i就是几段
            int devid = n / i;
            int reminder = n % i;//取余
            int result;
            if (reminder == 0) { //余数为0，就分了i段
                result = (int) Math.pow(i, devid);//pow 求幂
            } else {//余数不为0就分了i+1段，其中有i段的长度为devid,剩下一段的长度就是余数
                result = (int) (Math.pow(i, devid) * (reminder));
            }//太真实了吧，不会做啊，想都想不出来，找规律？
            if (max < result) {
                max = result;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        Scanner s = new Scanner(System.in);
        int max = cutRope.cutRope(s.nextInt());
        System.out.println(max);
    }

}
