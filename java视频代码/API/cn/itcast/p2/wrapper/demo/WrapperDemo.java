package cn.itcast.p2.wrapper.demo;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * @version V12.0.1 2019-7-9
 * @author Zhang Xiong
 */

/*
 * 基本数据类型对象包装类
 * 为了方便操作基本数据类型值，将其封装成了对象，在对象中定义了属性和行为丰富了该数据的操作
 * 用于描述该对象的类就称为基本数据类型对象包装类
 *
 * byte     Byte
 * short    Short
 * int      Integer
 * long     Long
 * float    Float
 * double   Double
 * char     Character
 * boolean  Boolean
 *
 * 该包装对象主要用基本类型和字符串之间的转换
 *
 * 基本类型--->字符串
 *      1.基本类型数值+""
 *      2.用String类中的静态方法valueOf(基本类型数值);
 *      3.用Integer的静态方法valueOf(基本类型数值);
 *
 * 字符串--->基本类型
 *      1.使用包装中的静态方法 xxx parseXxx("xxx类型的字符串");
 *          int parserInt("intstring");
 *          long parserLong("longstring");
 *          boolean parserBoolean("booleanstring");
 *          八种基本类型只有character不需要也没有parser
 *      2.如果字符串被Integer进行对象的封装
 *          可使用另一个非静态方法，intValue();
 *          将一个Integer对象转成基本数据类型值
 *
 * 整数具有不同的进制体现
 *
 * 十进制-->其他进制
 *      toBinaryString
 *      toHexString
 *      toOctalString
 *      toString(60,4)
 * 其他进制-->十进制
 *      parserInt("string",radix);
 */
public class WrapperDemo
{
    public static void main(String[] args)
    {/*
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(-6));

        int num = 4;
        Integer a = new Integer(5);*/

     /*   int x = Integer.parseInt("123");//这个方法是有异常抛出的，不过是运行异常，没有明确让抛但标明了就是想让你处理一下
        System.out.println("123" + 1);
        System.out.println(Integer.parseInt("123")+ 1);

        Integer i = new Integer("45");
        System.out.println(i.intValue());*/

       /* //十进制-->其他进制
        System.out.println(Integer.toBinaryString(60));
        System.out.println(Integer.toHexString(60));
        System.out.println(Integer.toOctalString(60));
        System.out.println(Integer.toString(60,4));//radix就是进制的选择，这里选的是4进制

        //其他进制-->十进制
        System.out.println(Integer.parseInt("3c",16));//对""内的数视为后面数值的进制数，比如这是为16进制的3c*/

        Integer a = new Integer("3");
        Integer b = new Integer(3);
        System.out.println(a==b);//false  因为是两个new 不同空间
        System.out.println(a.equals(b));//true  Integer比较的是数值是否相同
        System.out.println(a.compareTo(b));//按数值比较大小，大返1，等返0，小返-1
    }
}
