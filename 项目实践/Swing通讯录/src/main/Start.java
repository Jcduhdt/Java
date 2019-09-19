package main;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-02
 */

import frame.LoginFrame;

/**
 * 程序运行入口
 */
public class Start {
    public static void main(String[] args) {
//        这段代码添加后,美化不成，反而页面显示出现问题不知道什么原因
        /*try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();//启用BeautyEye主题
        }catch (Exception e){
            e.printStackTrace();
        }*/
        LoginFrame frame = new LoginFrame();//登录窗体
        frame.setVisible(true);//窗体可见
    }
}
