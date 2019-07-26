package p1.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class MouseAndKeyDemo {

    private Frame f;
    private TextField tf;//文本框
    private Button but;

    public MouseAndKeyDemo() {
        init();//初始化
    }

    private void init() {

        f = new Frame("演示鼠标和键盘监听");
        f.setBounds(400, 200, 500, 400);
        f.setLayout(new FlowLayout());

        tf = new TextField(15);//就是文本框的长度
        f.add(tf);

        but = new Button("Button");
        f.add(but);

        myEvent();

        f.setVisible(true);
    }

    private void myEvent() {

        //给文本框添加键盘监听
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println("key run..."+e.getKeyChar()+"..."+e.getKeyCode()+"..."+KeyEvent.getKeyText(e.getKeyCode()));
                /*int code = e.getKeyCode();
                if (!(code >= KeyEvent.VK_0 && code<=KeyEvent.VK_9)){//为什么必须是&&
                    System.out.println("必须是数字");
                    e.consume();
                    //感觉这段代码有bug  用上了shift键切换中英文就会出现bug
                }*/
                if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER){
                    System.out.println("enter run..");
                }
            }
        });



        //给窗口添加退出监听器
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        //在按钮上添加一个鼠标监听事件
        but.addMouseListener(new MouseAdapter() {

            private int count = 1;

            @Override
            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//                System.out.println("Mouse Enter"+count++);
//                tf.setText("mouse enter..." + count++);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                System.out.println("Mouse Enter"+count++);
//                System.out.println(e);

                if (e.getClickCount() == 2) {
                    tf.setText("mouse double click..." + count++);
                }
            }
        });
    }

    public static void main(String[] args) {
        new MouseAndKeyDemo();
    }
}
