package cn.itcast.p1.string.demo;

/**
 * @version V12.0.1 2019-7-5
 * @author Zhang Xiong
 */

/*
 * 按照面向对象的思想对字符串进行功能分类
 * "abcd"
 * 看API文档
 * 1.获取：
 *  1.1 获取字符串中字符的个数（长度）
 *      int length();
 *  1.2 根据位置获取字符
 *      char charAt(int index);
 *  1.3 根据字符获取在字符串中的第一次出现的位置
 *      int indexOf(int ch);ch就是char  int就是可能输入的是数字，ascii码
 *      int indexOf(int ch,int fromIndex);从指定位置进行ch的查找第一次出现的位置
 *      int indexOf(String str);
 *      int indexOf(String str,int fromIndex);
 *
 *      从后往前读根据字符串获取在字符串中的第一次出现的位置
 *      int lastIndexOf(int ch);ch就是char  int就是可能输入的是数字，ascii码
 *      int lastIndexOf(int ch,int fromIndex);从指定位置进行ch的查找第一次出现的位置
 *      int lastIndexOf(String str);
 *      int lastIndexOf(String str,int fromIndex);
 *  1.4 获取字符串中的一部分字符串，也叫字串  为什么substring的第二个s不大写,因为是一个单词
 *      String substring(int beginIndex, int endIndex); //该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符。
 *      //因此，该子字符串的长度为 endIndex-beginIndex。 不包含end
 *      String substring(int beginIndex);
 * 2.转换
 *  2.1 将字符串变成字符串数组（字符串的切割）
 *      String[] split(String regex);//涉及到正则表达式
 *  2.2 将字符串变成字符数组
 *      char[] toCharArray();
 *  2.3 将字符串转为字节数组
 *      byte[] getBytes();
 *  2.4 将字符串中的字母转成大小写
 *      String toUpperCase();大写
 *      String toLowerCase();小写
 *  2.5 将字符串中的指定内容进行替换
 *      String replace(char oldch,char newch);
 *      String replace(String s1,String s2);
 *  2.6 将字符串两端的空格去除
 *      String trim();
 *  2.7 将字符串进行连接
 *      String concat();
 * 3.判断
 *  3.1 两个字符串内容是否相同
 *      boolean equals(Object obj);
 *      boolean equalsIgnoreCase(string str);忽略大写比较字符串内容
 *  3.2 字符串中是否包含指定字符串
 *      boolean contains(String str);
 *  3.3 字符串是否以指定字符串开头，是否以指定字符串结尾
 *      boolean startsWith(string);
 *      boolean endsWith(string);
 * 4.比较
 *  4.1 比较两个字符串再字典中的大小
 */
public class StringMethodDemo
{
    public static void main(String[] args)
    {
        //stringMethodDemo_1();
        //stringMethodDemo_2();
        //stringMethodDemo_3();
        stringMethodDemo_4();
    }

    public static void stringMethodDemo_4()
    {
        System.out.println("abc".compareTo("aqz"));//对象比较是用的compareTo()方法
    }

    public static void stringMethodDemo_3()
    {
        String s = "abc";
        System.out.println(s.equals("ABC".toLowerCase()));//true
        System.out.println(s.equalsIgnoreCase("ABC"));//true

        System.out.println(s.contains("bc"));

        String str = "ArrayDemo.java";
        System.out.println(str.startsWith("Array"));
        System.out.println(str.endsWith(".java"));//找所有java文件
        System.out.println(str.contains("Demo"));
    }

    public static void stringMethodDemo_2()
    {
        String s = "张三，李四，王五";
        String[] arr = s.split("，");//如果是以.区分，则需要转义 \\. 才行
        //还要注意中英文字符

        for (int i=0; i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        char[] chs = s.toCharArray();
        for (int i=0;i<chs.length;i++)
        {
            System.out.println(chs[i]);
        }

        s = "ab你";
        byte[] bytes = s.getBytes();
        for (int i=0;i<bytes.length;i++)
        {
            System.out.println(bytes[i]);
        }

        System.out.println("Abc".toUpperCase());

        String s1 = "java";
        String s2 = s1.replace('q','z');//没找到就不替换
        System.out.println(s1==s2);//true

        System.out.println("-"+"    ab   c    ".trim()+"-");

        System.out.println("abc".concat("kk"));//比str+str专业

        System.out.println(String.valueOf(4)+1);//将基本数据类型转换成字符串
    }

    public static void stringMethodDemo_1()
    {
        String s = "abcdae";

        System.out.println("length: " + s.length());//6
        System.out.println("char: " + s.charAt(2));//c //String index out of range: 20
        System.out.println("index: " + s.indexOf('k'));//0 //-1 我们可以根据-1，来判断该字符或者字符串是否存在
        System.out.println("index: " + s.lastIndexOf('a'));//4

        System.out.println("substring: " + s.substring(2,s.length()));
    }
}
