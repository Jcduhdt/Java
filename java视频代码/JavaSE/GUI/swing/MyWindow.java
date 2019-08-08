package p1.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class MyWindow {
    private static final String LINE_SEPARATOR = System.getProperty("line_separator");
    private JTextField textField1;
    private JPanel panel1;
    private JButton 转到Button;
    private JTextArea textArea1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyWindow");
        frame.setContentPane(new MyWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MyWindow() {
        转到Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * 通过点击按钮获取文本框中目录
                 * 将目录中的内容显示在文本区域中
                 */

                String dir_str = textField1.getText();
                File dir = new File(dir_str);

                if (dir.exists() && dir.isDirectory()){
                    String[] names = dir.list();

                    for (String name : names) {
                        textArea1.append(name+LINE_SEPARATOR);
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
