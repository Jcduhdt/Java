/**
 * time:2019-05-19
 * author：Zhang Xiong
 *
 * public static void main(String[] args)
 * 主函数特殊之处：
 * 1.格式是固定的 整个句子固定
 * 2.被jvm所识别和调用
 *
 * public：因为权限必须最大
 * static：不需要对象的，直接使用主函数所属类名调用即可
 * void：主函数没有具体返回值
 * main：函数名，不是关键字，只是一个jvm识别的固定名字
 * String[] args：这是主函数的参数列表，是一个数组类型的参数，而且元素都是字符串类型
 */
public class MainDemo
{
    public static void main(String[] args)//new String[0]
    {
        System.out.println(args);//报错[Ljava.lang.String;@5f184fc6 长的字符串数组实体
        System.out.println(args.length);//0
        //使用cmd java MainDemo haha hehe xixi  即向main函数传值
        //System.out.println(args[0]);//报错，超出索引范围 因为没传值
    }

    //这个可以写，当作是自己写的函数  不过与main名重复了而已
    public static void main(int x)
    { }
}
