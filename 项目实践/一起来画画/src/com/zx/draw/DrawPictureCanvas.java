package com.zx.draw;

import java.awt.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-28
 */
/*
 * 简笔画展示窗体
 */
public class DrawPictureCanvas extends Canvas {
    private Image image = null;//创建花瓣中展示的图片对象

    public void setImage(Image image){
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,null);//在画布上绘制图像
    }

    /**
     * 重写update方法解决屏幕闪烁问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
