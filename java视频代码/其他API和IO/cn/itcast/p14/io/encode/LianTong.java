package cn.itcast.p14.io.encode;

import java.io.UnsupportedEncodingException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class LianTong {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "联通";

        /*
        11000001
        10101010
        11001101
        10101000
        utf-8规范 就是有些东西有问题 看视频吧
        */


        byte[] buf = str.getBytes("gbk");

        for (byte b : buf) {
//            System.out.println(b);
            System.out.println(Integer.toBinaryString(b&255));
        }

    }
}
