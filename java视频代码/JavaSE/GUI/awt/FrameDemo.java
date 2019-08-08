package p1.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class FrameDemo {
    public static void main(String[] args) {

        Frame f = new Frame("my frame");

//        f.setSize(500,400);//设置窗口大小，宽高
//        f.setLocation(400,200);//设置窗口位置，距左边，距上边

        f.setBounds(400,200,500,400);//合并上面两句

        f.setLayout(new FlowLayout());//设置流式布局

        Button but = new Button("Button流");//为啥我的按钮名字如果是中文就是四个正方形，，解析错误？
        //没有设置布局就会使用默认布局，导致这个按钮占满了整个框
        f.add(but);//将按钮添加到窗体中

        f.addWindowListener(new WindowAdapter() {
            @Override
            //点击关闭按钮的事件
            public void windowClosing(WindowEvent e) {

                System.out.println("biubiubiu"+e);
//                super.windowClosing(e);
                System.exit(0);//点了关闭就退出,推出虚拟机
            }
        });//添加窗体监视器


        //在按钮上加上一个监听
        but.addActionListener(new ActionListener() {//括号内是适配器
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button run....");
            }
        });


        f.setVisible(true);//显示窗口 没有设置窗口大小的时候太小了，，搞笑
        System.out.println("over");
    }
}
