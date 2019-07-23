package cn.itcast.p1.otherapi;

import java.util.Random;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-20
 */
public class MathDemo {
    public static void main(String[] args) {
        /*
         * Math:提供了操作数学运算的方法。都是静态的
         *
         * 常用的方法
         * ceil():返回大于参数的最小整数
         * floor():返回小于参数的最大整数
         * round():返回四舍五入的整数
         * pow(a,b):a的b次方
         * random():返回带正号的[0,1)的均匀分布的伪随机数
         */

        /*double d1 = Math.ceil(12.56);
        System.out.println("d1 = " + d1);

        double d2 = Math.floor(12.56);
        System.out.println("d2 = " + d2);

        double d3 = Math.round(12.56);
        System.out.println("d3 = " + d3);

        double d4 = Math.pow(10,2);
        System.out.println("d4 = " + d4);*/

        /*for (int i = 0; i < 10; i++) {
//            double d = Math.random();//[0,1)之间的均匀分布随机数
//            double d = Math.floor(Math.random()*10);//[0,9)之间均匀分布随机数
//            double d = Math.ceil(Math.random()*10);//[1,10)之间均匀分布随机数
            double d = (int)(Math.random()*6+1);//骰子，随机置位
            System.out.println(d);
        }*/

        Random r = new Random();//封装成了对象
        for (int i = 0; i <10 ; i++) {
//            double d = (int)(r.nextDouble()*6+1);
            double d = r.nextInt(6)+1;
            System.out.println(d);
        }
    }
}
