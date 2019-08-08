package cn.itcast.p4.generic.define.demo;

/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */
public class GenericDemo4
{
    public static void main(String[] args) {
        Tool<String> tool = new Tool<String>();

        tool.show(new Integer(8));
        tool.show("sdsa");
        tool.print("hahag");
//        tool.print(new Integer(8));

        Tool.method(new Integer(4));
        Tool.method("gfas");
    }
}
