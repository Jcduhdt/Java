public class Variable
{
    public static void main(String[] args)
    {
        //数据类型  变量名  =  初始化值;

        byte b = 5;//-128~127
        short a = 4000;
        int x = 12;
        x = x + b;
        b = (byte)(b + 200);//强制类型转换 要注意的是转换会有精度减少的风险 比如int-byte
        long l = 12124l; //最后那个是小写的L，用于声明数据为long型，同下面的f
        float f = 2.34f;
        double d = 3.45;
        char ch = 'a';
        boolean  bl = true;
        bl = false; //定义变量是有byte int 这些东西，但是定义一次后再用这个数据就是直接赋值，不能加前面的数据类型

        {
            int z = 23;
            System.out.println(z);
        } //花括号表示一个作用域，比如这个z只能在这个花括号内打印，但是这个花括号外就打印不了

        System.out.println(b);
        System.out.println(f);
        System.out.println('a'+1);//'a'的ascii数字是97
        System.out.println((char)('a'+1));//强制类型转换
        System.out.println('你'+0);//unicode国际标准码表


        //面试问题
        byte b1 = 4;
        // b1 = 3 + 7;//值是固定的，就能判断在不在范围内
        byte b2 = 3;
        byte b3 = 7;
        //b1 = b2 + b3;//这有问题，b1,b2是变量，一变换就出事，不确定不知道在不在范围之内，编译时就会提示丢失精度
        int x1;
        x1 = b2 + b3;//这就行，因为无论b2,b3怎么变换都在int范围之内
        int x2 = Integer.MAX_VALUE;//int型的最大值
        int x3 = 2;//加了2, x1肯定超了
        x1 = x2 + x3;//这就没上面的b1的问题，因为int是默认类型，超过后会强制转换 只保留32位，高位舍弃，一舍弃就开头就是1就是负数

        System.out.println(b1);
        System.out.println(x1);

    }
}
