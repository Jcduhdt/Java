package com.zx.draw;

import com.mr.util.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-31
 */

/**
 * 简笔画展示窗体
 */
public class PictureWindow extends JWindow {
    private JButton changeButton;//更换图片按钮
    private JButton hiddenButton;//隐藏按钮
    private BackgroundPanel centerPanel;//展示图片的带背景图面板
    File list[];//图片文件数组
    int index;//当前选中的图片索引
    DrawPictureFrame frame;//父窗体

    /**
     * 构造方法
     * @param frame
     */
    public PictureWindow(DrawPictureFrame frame){
        this.frame = frame;//构造参数的值赋给父窗体
        setSize(400,460);//设置窗体高宽
        init();//组件初始化
        addListenner();//组件添加监听器
    }

    private void init() {
        Container c = getContentPane();//获取窗体主容器
        File dir = new File("src/img/picture");//创建简笔画素材文件夹对象
        list = dir.listFiles();//获取文件夹里的所有文件
        //初始化背景面板，使用图片文件夹里第一张简笔画
        centerPanel = new BackgroundPanel(getListImage());
        c.add(centerPanel,BorderLayout.CENTER);//背景面板放到主容器中部
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);//创建右对齐的流布局
        flow.setHgap(20);//水平间隔20px
        JPanel southPanel = new JPanel();//创建南部面板
        southPanel.setLayout(flow);//南部面板使用刚才创建好的流布局
        changeButton  = new JButton("更换图片");//实例化“更换图片”按钮
        southPanel.add(changeButton);//南部面板添加按钮
        hiddenButton = new JButton("隐藏");
        southPanel.add(hiddenButton);
        c.add(southPanel,BorderLayout.SOUTH);//南部面板放到主容器的南部位置
    }

    private void addListenner() {
        hiddenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);//窗体不可见
                frame.initShowPicButton();//父类窗体还原简笔画按钮的文本内容,就是父窗体的关于该面板的按钮变成展开简笔画
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setImage(getListImage());//背景面板重新载入图片
            }
        });
    }

    private Image getListImage() {
        String imgPath = list[index].getAbsolutePath();//获取当前索引下的图片文件路径
        ImageIcon image = new ImageIcon(imgPath);//获取此图片文件的图标对象
        index++;
        if (index >= list.length){//索引循环
            index = 0;
        }
        return image.getImage();//获得图标对象的图片对象
    }
}
