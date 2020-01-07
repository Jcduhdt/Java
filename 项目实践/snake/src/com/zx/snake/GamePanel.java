package com.zx.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-07
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener{
    int length;//蛇的长度
    int[] snakeX = new int[600];//蛇的坐标X
    int[] snakeY = new int[500];//蛇的坐标Y
    String fx;//上下左右 U D L R
    boolean isStart = false;//游戏是否开始

    Timer timer = new Timer(100,this);//定时器，0.1秒执行一次，计算帧率，蛇的快慢，监听当前窗口

    //定义一个食物
    int foodX;
    int foodY;
    Random random = new Random();

    //死亡判断
    boolean isFail = false;

    //积分系统
    int score;

    //构造器
    public GamePanel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);//让键盘的焦点聚集在游戏上
        this.addKeyListener(this);//添加一个监听
        timer.start();//让时间动起来
    }

    //初始化
    public void init(){
        length = 3;
        snakeX[0] = 100;snakeY[0] = 100;//头部坐标
        snakeX[1] = 75;snakeY[1] = 100;//第一个身体坐标
        snakeX[2] = 50;snakeY[2] = 100;//第二个身体坐标
        fx = "R";
        foodX = 25+25*random.nextInt(34); //25是每个格子的大小
        foodY = 75+25*random.nextInt(24);//要自己算范围
        score = 0;
    }

    //画板：画界面 画蛇
    //Graphics: 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);//设置背景颜色

        //绘制头部广告栏
        Data.header.paintIcon(this,g,25,11);
        //绘制游戏区域
        g.fillRect(25,75,850,600);
        //画一条静态的小蛇
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for (int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);//蛇的身体长度通过length来控制
        }

        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度："+length,750,35);
        g.drawString("分数："+score,750,50);
        //画食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //游戏提示：是否开始
        if (isStart==false){
            //画一个文字，String
            g.setColor(Color.WHITE);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏",300,300);
        }
        //失败提醒
        if (isFail){
            //画一个文字，String
            g.setColor(Color.RED);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("游戏失败，按下空格重新开始",200,300);
        }
    }
    //接收键盘的输入：监听
    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下，未释放
        //获取键盘按下的是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode==KeyEvent.VK_SPACE){//如果按下的键是空格
            if (isFail){//失败，重新再来一遍
                isFail = false;
                init();//重新初始化游戏
            }else {
                isStart = !isStart;
            }
            repaint();//刷新界面
        }
        //键盘控制走向
        if (keyCode==KeyEvent.VK_LEFT){
            fx="L";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            fx="R";
        }else if(keyCode==KeyEvent.VK_UP){
            fx="U";
        }else if(keyCode==KeyEvent.VK_DOWN){
            fx="D";
        }
    }

    //定时器：监听事件 帧：执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态
        if (isStart && !isFail){
            //右移
            for (int i = length-1; i > 0; i--) {//除了脑袋，圣体都向前移动
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //通过控制方向让头部移动
            if (fx.equals("R")){
                snakeX[0] = snakeX[0] + 25;//头部移动
                if (snakeX[0]>850){        //边界判断
                    snakeX[0] = 25;
                }
            }else if (fx.equals("L")){
                snakeX[0] = snakeX[0] - 25;//头部移动
                if (snakeX[0]<25){        //边界判断
                    snakeX[0] = 850;
                }
            }else if (fx.equals("U")){
                snakeY[0] = snakeY[0] - 25;//头部移动
                if (snakeY[0]<75){        //边界判断
                    snakeY[0] = 650;
                }
            }else if (fx.equals("D")){
                snakeY[0] = snakeY[0] + 25;//头部移动
                if (snakeY[0]>650){        //边界判断
                    snakeY[0] = 75;
                }
            }
            //如果小蛇的头部和食物坐标重合
            if (snakeX[0]==foodX && snakeY[0]==foodY){
                //长度+1
                length++;
                score += 10;
                //重新生成食物
                foodX = 25+25*random.nextInt(34); //25是每个格子的大小
                foodY = 75+25*random.nextInt(24);//要自己算范围
            }
            //结束判断
            for (int i = 1; i < length; i++) {
                if (snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFail = true;
                }
            }
            //刷新界面 才会动
            repaint();
        }
        timer.start();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }


}
