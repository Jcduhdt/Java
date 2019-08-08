package p1.swing;

import javax.swing.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class MySwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MySwing");
        frame.setContentPane(new MySwing().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton button1;
    private JPanel panel1;
    private JButton button2;
}
