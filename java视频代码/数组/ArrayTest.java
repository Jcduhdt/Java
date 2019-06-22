/**
 * time:2019-05-05
 * author:Zhang Xiong
 * 十进制的转换，查表法
 */
public class ArrayTest
{
    public static void main(String[] args)
    {
        toHex(60);
        toHex_1(60);
        toOctal(26);
        toBinary(-6);
        System.out.println(Integer.toBinaryString(-6));
        String week = getWeek(7);
        System.out.println(week);
    }


    /*
    什么时候使用数组
    如果数据出现了对应关系，而且对应关系的一方是有序的数字编号，并作为角标使用
    这时就必须想到数组的使用
    0,1,2,3,4,5,6,7,8,9, A, B, C, D, E, F
    0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
    将数据存到数组中
    根据运算结果作为角标直接去查数组中对应的元素即可
    即查表法
     */


    /*
    获取整数的十六进制表现形式
     */
    public static void toHex(int num)
    {
        for (int x=0;x<8;x++)
        {
            int temp = num & 15;//保留有效位数
            if (temp>9)
                System.out.print((char) (temp-10+'A'));
            else
                System.out.print(temp);
            num = num >>> 4;//无符号右移取下一个字节
        }
        System.out.println();
        //打印反了，而且很多0没必要
        /*
        int n1 = num & 15;
        System.out.println("n1="+n1);

        num = num >>> 4;
        int n2 = num & 15;
        System.out.println("n2="+n2);
         */
    }

    public static void trans(int num,int base,int offset)
    {
        if (num==0)
        {
            System.out.println("0");
            return ;
        }


        char[] chs={'0','1','2','3','4','5','6',
                '7','8','9','A','B','C','D','E','F'};
        /*
        一会查表会查到比较的数据
        数据一多，就会先存储起来，再进行操作
        所以定义一个数组，临时容器
         */
        char[] arr = new char[32];
        int pos = arr.length;

        while(num!=0)
        {
            int temp = num & base;
            arr[--pos] = chs[temp];
            num = num >>> offset;
        }

        for (int x=pos;x<arr.length;x++)
        {
            System.out.print(arr[x]);
        }
        System.out.println();
    }

    //十进制转十六进制
    public static void toHex_1(int num)
    {
        trans(num,15,4);
    }
    //十进制转八进制
    public static void toOctal(int num)
    {
        trans(num,7,3);
    }
    //十进制转二进制
    public static void toBinary(int num)
    {
        trans(num,1,1);
    }

    /*
    查表法
    星期
    String s = "abc";
    int x = 4;
     */
    public static String getWeek(int num)
    {
        if (num>7 || num<1)
        {
            return "错误的星期";
        }
        String[] weeks = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};

        return weeks[num];
    }
}
