package com.zx.draw;

import com.mr.util.DrawImageUtil;
import com.mr.util.FrameGetShape;
import com.mr.util.ShapeWindow;
import com.mr.util.Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-28
 */

/*
 * 画图主窗体
 */
public class DrawPictureFrame extends JFrame implements FrameGetShape {
    //创建一个8位BGR颜色分量的图像
    BufferedImage image = new BufferedImage(570,390,BufferedImage.TYPE_INT_BGR);
    Graphics gs = image.getGraphics();//获得图像的绘图对象
    Graphics2D g = (Graphics2D) gs;//将绘图对象转换成Graphics2D类型
    DrawPictureCanvas canvas = new DrawPictureCanvas();//创建画布对象
    Color foreColor = Color.BLACK;  //定义前景色
    Color backgroundColor = Color.WHITE;//定义背景色
    int x = -1;//上一次鼠标绘制点的横坐标
    int y = -1;//上一次鼠标绘制点的纵坐标
    boolean rubber = false;//橡皮标识变量
    private JToolBar toolBar;//工具栏
    private JButton eraserButton;//橡皮按钮
    private JToggleButton strokeButton1;//细线按钮
    private JToggleButton strokeButton2;//粗线按钮
    private JToggleButton strokeButton3;//较粗按钮
    private JButton backgroundButton;//背景色按钮
    private JButton foregroundButton;//前景色按钮
    private JButton clearButton;//清除按钮
    private JButton saveButton;//保存按钮
    private JButton shapeButton;//图形按钮
    boolean drawShape = false;//画图形标识变量
    Shapes shape;//绘画的图形
    //应该是将前面的按钮变成菜单
    private JMenuItem strokeMenuItem1;
    private JMenuItem strokeMenuItem2;
    private JMenuItem strokeMenuItem3;
    private JMenuItem clearMenuItem;
    private JMenuItem foregroundMenuItem;
    private JMenuItem backgroundMenuItem;
    private JMenuItem eraserMenuItem;
    private JMenuItem exitMenuItem;//退出菜单
    private JMenuItem saveMenuItem;

    private JMenuItem shuiyinMenuItem;//水印菜单
    private String shuiyin = "";//水印字符内容

    private PictureWindow picWindow;//简笔画展示窗体
    private JButton showPicButton;//展开简笔画按钮


    public DrawPictureFrame() {
        setResizable(false);//窗体不能改变大小
        setTitle("画图程序(水印内容:["+shuiyin+"])");//设置标题 添加水印内容提示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭则停止运行
        setBounds(500, 100, 574, 460);//设置窗口位置和宽度
        init();//组件初始化
        addListener();//添加组件监听
    }

    public void init(){
        g.setColor(backgroundColor);//用背景色设置绘图对象的颜色
        g.fillRect(0, 0, 570, 390);//用背景色填充整个画布
        g.setColor(foreColor);//用前景色设置绘图对象的颜色
        canvas.setImage(image);//设置画布图像
        getContentPane().add(canvas);//将画布添加到窗体容器默认布局的中部位置

        toolBar = new JToolBar();//初始化工具栏
        getContentPane().add(toolBar,BorderLayout.NORTH);//工具栏添加到窗体最北位置

//        showPicButton = new JButton("展开简笔画");下面是对该代码的优化  变好看
        showPicButton = new JButton();
        showPicButton.setToolTipText("展开简笔画");//设置按钮鼠标悬停提示
        showPicButton.setIcon(new ImageIcon("src/img/icon/展开.png"));//设置按钮图标

        toolBar.add(showPicButton);
//        saveButton = new JButton("保存");//初始化按钮对象，并添加文本内容  优化
        saveButton = new JButton();
        saveButton.setToolTipText("保存");
        saveButton.setIcon(new ImageIcon("src/img/icon/保存.png"));

        toolBar.add(saveButton);//工具栏添加按钮
        toolBar.addSeparator();//添加分割条
        //初始化按钮对象，并添加文本内容
//        strokeButton1 = new JToggleButton("细线");
        strokeButton1 = new JToggleButton();//初始化有选中状态的按钮对象
        strokeButton1.setToolTipText("细线");
        strokeButton1.setIcon(new ImageIcon("src/img/icon/1像素线条.png"));

        strokeButton1.setSelected(true);//细线按钮处于被选中状态
        toolBar.add(strokeButton1);//工具栏添加按钮
        //初始化按钮对象，并添加文本内容
//        strokeButton2 = new JToggleButton("粗线");
        strokeButton2 = new JToggleButton();
        strokeButton2.setToolTipText("粗线");
        strokeButton2.setIcon(new ImageIcon("src/img/icon/2像素线条.png"));

        toolBar.add(strokeButton2);//工具栏添加按钮
        //初始化有选中状态的按钮对象，并添加文本内容
//        strokeButton3 = new JToggleButton("较粗");
        strokeButton3 = new JToggleButton();
        strokeButton3.setToolTipText("细线");
        strokeButton3.setIcon(new ImageIcon("src/img/icon/4像素线条.png"));

        //画笔粗细按钮组，保证同时只有一个按钮被选中
        ButtonGroup strokeGroup = new ButtonGroup();
        strokeGroup.add(strokeButton1);//按钮组添加按钮
        strokeGroup.add(strokeButton2);//按钮组添加按钮
        strokeGroup.add(strokeButton3);//按钮组添加按钮
        toolBar.add(strokeButton3);//工具栏添加按钮
        toolBar.addSeparator();//分割
//        backgroundButton = new JButton("背景颜色");
        backgroundButton = new JButton();
        backgroundButton.setToolTipText("背景颜色");
        backgroundButton.setIcon(new ImageIcon("src/img/icon/背景色.png"));

        toolBar.add(backgroundButton);
//        foregroundButton = new JButton("前景颜色");
        foregroundButton = new JButton();
        foregroundButton.setToolTipText("前景颜色");
        foregroundButton.setIcon(new ImageIcon("src/img/icon/前景色.png"));

        toolBar.add(foregroundButton);
        toolBar.addSeparator();

//        shapeButton = new JButton("图形");
        shapeButton = new JButton();
        shapeButton.setToolTipText("图形");
        shapeButton.setIcon(new ImageIcon("src/img/icon/形状.png"));

        toolBar.add(shapeButton);
//        clearButton = new JButton("清除");
        clearButton = new JButton();
        clearButton.setToolTipText("清除");
        clearButton.setIcon(new ImageIcon("src/img/icon/清除.png"));

        toolBar.add(clearButton);
//        eraserButton = new JButton("橡皮");
        eraserButton = new JButton();
        eraserButton.setToolTipText("橡皮");
        eraserButton.setIcon(new ImageIcon("src/img/icon/橡皮.png"));

        toolBar.add(eraserButton);
        toolBar.setFloatable(true);//设置工具栏可随意拖动，默认false

        JMenuBar menuBar = new JMenuBar();//创建菜单栏
        setJMenuBar(menuBar);//窗体载入菜单栏

        JMenu systemMenu = new JMenu("系统");//初始化菜单栏对象，并添加文本内容
        menuBar.add(systemMenu);//菜单栏添加菜单对象
        shuiyinMenuItem = new JMenuItem("设置水印");
        systemMenu.add(shuiyinMenuItem);
        saveMenuItem = new JMenuItem("保存");
        systemMenu.add(saveMenuItem);
        systemMenu.addSeparator();//添加分割条
        exitMenuItem = new JMenuItem("退出");
        systemMenu.add(exitMenuItem);

        JMenu strokeMenu = new JMenu("线型");
        menuBar.add(strokeMenu);
        strokeMenuItem1 = new JMenuItem("细线");
        strokeMenu.add(strokeMenuItem1);
        strokeMenuItem2 = new JMenuItem("粗线");
        strokeMenu.add(strokeMenuItem2);
        strokeMenuItem3 = new JMenuItem("较粗");
        strokeMenu.add(strokeMenuItem3);

        JMenu colorMenu = new JMenu("颜色");
        menuBar.add(colorMenu);
        foregroundMenuItem = new JMenuItem("前景颜色");
        colorMenu.add(foregroundMenuItem);
        backgroundMenuItem = new JMenuItem("背景颜色");
        colorMenu.add(backgroundMenuItem);

        JMenu editMenu = new JMenu("编辑");
        menuBar.add(editMenu);
        clearMenuItem = new JMenuItem("清除");
        editMenu.add(clearMenuItem);
        eraserMenuItem = new JMenuItem("橡皮");
        editMenu.add(eraserMenuItem);

        //创建简体画展示面板，并将本类当作它的父窗体
        picWindow = new PictureWindow(DrawPictureFrame.this);
    }

    /**
     * 为组件添加动作监听
     */
    private void addListener(){
        //画板添加鼠标移动监听事件
        canvas.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(final MouseEvent e){ //当鼠标拖拽时
                if (x>0 && y>0){                //如果x和y存在鼠标记录
                    if (rubber){                //如果橡皮标识为true，表示使用橡皮
                        g.setColor(backgroundColor);//绘图工具使用背景色
                        g.fillRect(x,y,10, 10);//在鼠标滑过的位置填充正方形
                    }else{                      //如果橡皮标识为false，表示用画笔画图
                        g.drawLine(x,y, e.getX(),e.getY()); //在鼠标滑过的位置画直线
                    }
                }
                x = e.getX();//上一次鼠标绘制点的横坐标
                y = e.getY();//上一次鼠标绘制点的纵坐标
                canvas.repaint();//更新画布
            }
            public void mouseMoved(final MouseEvent arg0){//当鼠标移动时
                if (rubber){//如果使用橡皮
                    //设置鼠标指针的形状为图片
                    Toolkit kit = Toolkit.getDefaultToolkit();//获得系统默认的组件工具包
                    //利用工具包获取图片
                    Image img = kit.createImage("src/img/icon/鼠标橡皮.png");
                    //利用工具包创建一个自定义的光标对象
                    //参数为图片，光标热点(写成0,0就行)和光标描述字符串
                    Cursor c = kit.createCustomCursor(img, new Point(0, 0), "clear");
                    setCursor(c);//使用自定义光标
                }else{
                    //设置鼠标指针的形状为十字光标
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                }
            }
        });
        toolBar.addMouseMotionListener(new MouseMotionAdapter() {//工具栏添加鼠标移动监听
            @Override
            public void mouseMoved(MouseEvent e) {//当鼠标移动时
                //设置鼠标指针的形状为默认光标
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        //画板  添加鼠标单击事件监听
        canvas.addMouseListener(new MouseAdapter() {
            public void mouseReleased(final MouseEvent arg0){//当按键抬起时
                x = -1;//将记录上一次鼠标绘制点的横坐标恢复成-1
                y = -1;//将记录上一次鼠标绘制点的纵坐标恢复成-1
            }
            public void mousePressed(MouseEvent e){//当按键按下时
                if (drawShape){                     //如果此时鼠标画的是图形
                    switch(shape.getType()){        //判断图形的种类
                        case Shapes.YUAN:           //如果是圆形
                            //计算坐标，让鼠标处于圆形的中心
                            //就是设置圆的外面的方形的左上角位置
                            int yuanX = e.getX()-shape.getWidth()/2;
                            int yuanY = e.getY()-shape.getHeigth()/2;
                            //创建圆形图形，并指定坐标和宽高
                            //描述窗体矩形定义的椭圆
                            Ellipse2D yuan = new Ellipse2D.Double(yuanX,yuanY,
                                    shape.getWidth(),shape.getHeigth());
                            g.draw(yuan);//画图工具画此图形 空心  想画实心的就使用g.fill(yuan);
                            break;//结束switch
                        case Shapes.FANG:           //如果是方形
                            //计算坐标，让鼠标处于图形的中心位置
                            int fangX = e.getX()-shape.getWidth()/2;
                            int fangY = e.getY()-shape.getHeigth()/2;
                            //创建方形图形，并指定坐标和宽高
                            //Rectangle2D描述通过位置和尺寸定义的矩形
                            Rectangle2D fang = new Rectangle2D.Double(fangX, fangY, shape.getWidth(), shape.getHeigth());
                            g.draw(fang);//画图工具画此方形
                            break;
                    }
                    canvas.repaint();//更新画布
                    //画图形标识变量为false，说明现在鼠标画的是图形，而不是线条
                    drawShape = false;
                }
            }
        });


        strokeButton1.addActionListener(new ActionListener() {//细线按钮添加动作监听
            @Override
            public void actionPerformed(final ActionEvent arg0) {//单击时
                //声明画笔的属性，粗细为1像素，线条末端无修饰，折线处呈尖角
                BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_ROUND);
                g.setStroke(bs);//画图工具使用此画笔
            }
        });
        strokeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //声明画笔的属性，粗细为2像素，线条末端无修饰，折线处呈尖角
                BasicStroke bs = new BasicStroke(2, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER);
                g.setStroke(bs);
            }
        });
        strokeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //声明画笔的属性，粗细为4像素，线条末端无修饰，折线处呈尖角
                BasicStroke bs = new BasicStroke(4, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER);
                g.setStroke(bs);
            }
        });

        backgroundButton.addActionListener(new ActionListener() {//背景颜色按钮添加动作监听
            @Override
            public void actionPerformed(final ActionEvent arg0) {//单击时
                //打开选择颜色对话框，参数依次为：父窗体、标题、默认选中颜色(青色)
                Color bgColor = JColorChooser.showDialog(DrawPictureFrame.this,
                        "选择颜色对话框", Color.CYAN);
                if (bgColor != null){
                    backgroundColor = bgColor;//选中的颜色赋给背景色变量
                }
                //背景色按钮也更换为这种背景颜色
                backgroundButton.setBackground(backgroundColor);
                g.setColor(backgroundColor);//绘图工具使用背景色
                g.fillRect(0,0,570,390);//画一个背景颜色的方形填满整个画布
                g.setColor(foreColor);//绘图工具使用前景色
                canvas.repaint();//更新画布
            }
        });

        foregroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //打开选择颜色对话框，参数依次为：父窗体、标题、默认选中颜色(青色)
                Color fColor = JColorChooser.showDialog(DrawPictureFrame.this,
                        "选择颜色对话框", Color.CYAN);
                if (fColor != null){
                    foreColor = fColor;
                }
                //前景色按钮的文字也更换为这种背景颜色
//                foregroundButton.setForeground(foreColor);
                foregroundButton.setBackground(foreColor);//背景也更换为这种颜色

                g.setColor(foreColor);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                g.setColor(backgroundColor);
                g.fillRect(0,0,570,390);
                g.setColor(foreColor);
                canvas.repaint();
            }
        });
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //单击工具栏的橡皮按钮，使用橡皮
                /*if (eraserButton.getText().equals("橡皮")){
                    rubber = true;
                    eraserButton.setText("画图");
                }else{
                    rubber = false;
                    eraserButton.setText("橡皮");
                    g.setColor(foreColor);
                }*/
                if (rubber){
                    eraserButton.setToolTipText("橡皮");
                    //设置按钮图标
                    eraserButton.setIcon(new ImageIcon("src/img/icon/橡皮.png"));
                    eraserMenuItem.setText("橡皮");
                    g.setColor(foreColor);
                    rubber = false;
                }else{
                    eraserMenuItem.setText("画图");
                    eraserButton.setToolTipText("画图");
                    //设置按钮图标
                    eraserButton.setIcon(new ImageIcon("src/img/icon/画笔.png"));
                    g.setColor(backgroundColor);
                    rubber = true;
                }
            }
        });
        shapeButton.addActionListener(new ActionListener() {//图形按钮添加动作监听
            //这部分代码就是设置图形选择界面的出现位置，以及可见性
            //只是开头new了一个别人写好的图形选择器的对象
            @Override
            public void actionPerformed(ActionEvent e) {//单击时
                //创建图形选择组件
                //这个公司自己创建的图形选择组件
                ShapeWindow shapeWindow = new ShapeWindow(DrawPictureFrame.this);//就是图形的选择界面
                int shapeButtonWidth = shapeButton.getWidth();//获取图像按钮宽度  36
                int shapeWindowWidth = shapeWindow.getWidth();//获取图形按钮宽度  249
                int shapeButtonX = shapeButton.getX();//获取相对于程序界面的图形按钮横坐标  310
                int shapeButtonY = shapeButton.getY();//获取相对于程序界面的图形按钮纵坐标
                //getX() 当前绘图程序界面所在的横坐标(左上角)
                //计算图形组件横坐标，让组件与"图形"按钮居中对齐
                //就是按钮当前横坐标减去(图形选择界面宽度-按钮宽度)的一半
                int shapeWindowX = getX()+shapeButtonX-(shapeWindowWidth-shapeButtonWidth)/2;
                //计算图形组件纵坐标，让组件显示在"图形"按钮下方
                //纵轴距离是据顶部的距离
                int shapeWindowY = getY()+shapeButtonY+80;
                //设置图形组件坐标位置
                shapeWindow.setLocation(shapeWindowX,shapeWindowY);
                shapeWindow.setVisible(true);//图形组件可见
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {//单击时
                /*
                saveImage()方法的参数说明
                    JFrame frame:保存图片时会弹出一个文件选择对话框，此参数决定文件选择对话框在哪个窗体中间显示
                    BufferedImage saveImage:需要板寸成图片文件的图片对象，此对象必须是BufferedImage类或其子类对象
                */
                addWatermark();//添加水印
                DrawImageUtil.saveImage(DrawPictureFrame.this,image);//打印图片
            }
        });
        shuiyinMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出输入对话框
                shuiyin = JOptionPane.showInputDialog(DrawPictureFrame.this,
                        "你想添加什么水印?");
                if (null == shuiyin){
                    shuiyin = "";
                }else {
                    setTitle("画图程序(水印内容:["+shuiyin+"])");
                }
            }
        });
        showPicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isVisible = picWindow.isVisible();
                if (isVisible){
//                    showPicButton.setText("展开简笔画");
                    showPicButton.setToolTipText("展开简笔画");
                    showPicButton.setIcon(new ImageIcon("src/img/icon/展开.png"));
                    picWindow.setVisible(false);
                }else{
//                    showPicButton.setText("隐藏简笔画");
                    showPicButton.setToolTipText("隐藏简笔画");
                    showPicButton.setIcon(new ImageIcon("src/img/icon/隐藏.png"));

                    //重新指定简笔画展示窗体的显示位置
                    //横坐标 = 主窗体横坐标-简笔画窗体宽度-5
                    //纵坐标 = 主窗体纵坐标
                    picWindow.setLocation(getX()-picWindow.getWidth()-5,getY());
                    picWindow.setVisible(true);
                }
            }
        });
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e) {
                System.exit(0);//程序关闭
            }
        });
        eraserMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //两个功能,画图与橡皮在单机时转换
                /*if (eraserMenuItem.getText().equals("橡皮")){
                    rubber = true;
                    eraserMenuItem.setText("画图");
                    eraserButton.setText("画图");
                }else{
                    rubber = false;
                    eraserMenuItem.setText("橡皮");
                    eraserButton.setText("橡皮");
                    g.setColor(foreColor);
                }*/
                if (rubber){
                    eraserButton.setToolTipText("橡皮");
                    //设置按钮图标
                    eraserButton.setIcon(new ImageIcon("src/img/icon/橡皮.png"));
                    eraserMenuItem.setText("橡皮");
                    g.setColor(foreColor);
                    rubber = false;
                }else{
                    eraserMenuItem.setText("画图");
                    eraserButton.setToolTipText("画图");
                    //设置按钮图标
                    eraserButton.setIcon(new ImageIcon("src/img/icon/画笔.png"));
                    g.setColor(backgroundColor);
                    rubber = true;
                }
            }
        });
        clearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                g.setColor(backgroundColor);
                g.fillRect(0,0,570,390);
                g.setColor(foreColor);
                canvas.repaint();
            }
        });
        strokeMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                BasicStroke bs = new BasicStroke(1,BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_ROUND);
                g.setStroke(bs);
                strokeButton1.setSelected(true);
            }
        });
        strokeMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                BasicStroke bs = new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                g.setStroke(bs);
                strokeButton1.setSelected(true);
            }
        });
        strokeMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke bs = new BasicStroke(4,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                g.setStroke(bs);
                strokeButton1.setSelected(true);
            }
        });
        foregroundMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //打开选择颜色对话框，参数依次为：父窗体、标题、默认选中颜色(青色)
                Color fColor = JColorChooser.showDialog(DrawPictureFrame.this,
                        "选择颜色对话框", Color.CYAN);
                if (fColor != null){
                    foreColor = fColor;
                }
                //前景色按钮的文字也更换为这种背景颜色
//                foregroundButton.setForeground(foreColor);
                foregroundButton.setBackground(foreColor);
                g.setColor(foreColor);
            }
        });

        backgroundMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //打开选择颜色对话框，参数依次为：父窗体、标题、默认选中颜色(青色)
                Color bgColor = JColorChooser.showDialog(DrawPictureFrame.this,
                        "选择颜色对话框", Color.CYAN);
                if (bgColor != null){
                    backgroundColor = bgColor;//选中的颜色赋给背景色变量
                }
                //背景色按钮也更换为这种背景颜色
                backgroundButton.setBackground(backgroundColor);
                g.setColor(backgroundColor);//绘图工具使用背景色
                g.fillRect(0,0,570,390);//画一个背景颜色的方形填满整个画布
                g.setColor(foreColor);//绘图工具使用前景色
                canvas.repaint();//更新画布
            }
        });
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                addWatermark();//添加水印
                DrawImageUtil.saveImage(DrawPictureFrame.this,image);//打印图片
            }
        });
    }

    /**
     * 回复展开简笔画按钮的文本内容，此方法供简笔画面板的“隐藏”按钮调用
     */
    public void initShowPicButton(){
//        showPicButton.setText("展开简笔画");
        showPicButton.setToolTipText("展开简笔画");
        showPicButton.setIcon(new ImageIcon("src/img/icon/展开.png"));
    }

    public void addWatermark(){
        if (!"".equals(shuiyin.trim())){//如果水印字段不是空字符串
            /*
            Java绘图工具类Graphics2D提供的一些方法
                rotate(double theta):设置绘图的旋转弧度，让图片倾斜  theta:旋转的弧度
                setFont(Font font):设置字体， font:字体对象
                setComposite(Composite comp):设置图片绘制像素方式，本节用来设置透明度
                    comp：绘图合成接口，利用来实现类AlphaComposite来实现透明效果
                drawString(String str,int x,int y):绘制文字,文字，横纵坐标
             */
            g.rotate(Math.toRadians(-30));//将图片旋转-30弧度
            Font font = new Font("楷体",Font.BOLD,72);//设置字体
            g.setFont(font);//载入字体
            g.setColor(Color.GRAY);//水印的使用颜色
            AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.4f);//设置透明效果
            g.setComposite(alpha);//使用透明效果
            g.drawString(shuiyin,150,500);//绘制文字
            canvas.repaint();//面板重绘
            g.rotate(Math.toRadians(30));//将图片再旋转回来
            alpha = AlphaComposite.SrcOver.derive(1f);//不透明效果
            g.setComposite(alpha);//使用不透明效果
            g.setColor(foreColor);//画笔恢复之前的颜色
        }
    }

    /**
     * FrameGetShape接口实现类，用于获得图形空间返回的被选中的图形
     * 应该是图形选择界面确认图形的形状后会调用这个吧
     * @param shape
     */
    @Override
    public void getShape(Shapes shape) {
        this.shape = shape;//将返回的图形对象赋给类的全局变量
        drawShape = true;//画图形标识变量为true，说明现在鼠标画的是图形，而不是线条
    }

    public static void main(String[] args) {
        DrawPictureFrame frame = new DrawPictureFrame();//创建窗体对象
        frame.setVisible(true);//窗体可见
    }
}
