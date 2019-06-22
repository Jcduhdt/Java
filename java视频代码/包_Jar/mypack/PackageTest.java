package mypack;

import packa.DemoA;//导入
/*
 * import packa.*;导入所有类，但不导入包
 * 比如有packa\DemoA.class
 * packa\abs\DemoAbc.class
 * 就只能导入DemoA.class 不会导入DemoAbc.class
 * 要想导入就只能写import packa.abs.DemoAbc;
 *
 *
 * 导包原则：用到哪个类，就导入哪个类
 * import 干嘛用的？ 为了简化类名书写
 */

/**
 * @version V12.0.1 2019-06-22
 * @author Zhang Xiong
 */

/*
 * cmd  javac mypack.PackageTest.java
 *      java mypack.PackageTest
 *
 * javac -d 路径 PackageTest.java
 */

/*
 * java文件，若放在包里，那该java文件已有包所属，所以必须明确其包名。
 * 就像导入的是import packa.DemoA;
 *
 * 还要注意权限
 *
 * 包与包之间的类进行访问，被访问的包中的类必须是public，被访问的包中的类的方法也必须是public
 *
 *            public      protected        default         private
 * 同一类中     ok           ok              ok               ok
 * 同一包中     ok           ok              ok
 * 子类中       ok           ok
 * 不同包中     ok
 */
public class PackageTest
{
    public static void main(String[] args)
    {
        System.out.println("Hello package!");

        DemoA d = new DemoA();
        d.show();
    }
}
