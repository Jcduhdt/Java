package com.zx.snake;

import javax.swing.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-07
 */
public class StartGames {
    public static void main(String[] args) {
        //1.绘制一个静态窗口  JFrame
        JFrame frame = new JFrame("贪吃蛇小游戏");
        frame.setBounds(10,10,900,720);//设置界面大小
        frame.setResizable(false);//窗口大小不可以改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件，游戏可以关闭了

        //2.面板 Jpanel
        frame.add(new GamePanel());
        frame.setVisible(true);//窗口可视化

    }
}
