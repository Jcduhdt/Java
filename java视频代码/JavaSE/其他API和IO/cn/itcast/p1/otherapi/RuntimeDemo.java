package cn.itcast.p1.otherapi;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-20
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        /*
         * Runtime:没有构造方法摘要，说明该类不可以创建对象
         * 又发现还有非静态方法，说明该类应该提供静态的返回该类对象的方法
         * 而且只有一个，说明Runtime类使用了单例设计模式
         */

        Runtime r = Runtime.getRuntime();

//        execute:执行 xxx.exe

        try{

//            r.exec("D:\\Atom\\atom.exe");//""内是执行文件路径 这里就是打开执行atom.exe
            /*r.exec("D:\\Atom\\atom.exe D:\\Java\\JavaProject\\OtherApi\\src\\cn\\itcast\\p1\\otherapi\\system\\RuntimeDemo.java");
            //两个路径 空格分开前一个是打开的进程，后一个是进程打开的文件，这行我就是用atom 打开了这个java程序*/
            Process p = r.exec("D:\\Atom\\atom.exe");//process表示进程
            Thread.sleep(5000);//让p这个进程睡5s
            p.destroy();//杀死该进程，java只能杀死自己产生进程
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
