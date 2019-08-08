package cn.itcast.p14.io.encode;

import java.io.UnsupportedEncodingException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */

/*
 * 在java中，字符串"abcd"与字符串"ab你好"的长度是一样的，都是四个字符
 * 但对应的字节数不同，一个汉字占两个字节
 * 定义一个方法，按照最大的字节数来取子串
 * 如：对于"ab你好"，如果取三个字节，那么字串就是ab与"你"字的半个
 * 那么半个就要舍弃，如果取四个字节就是"ab你"，取五个字节还是"ab你"
 */

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "ab你好cd谢谢";

        int len = str.getBytes("gbk").length;

        for (int x = 0; x < len; x++) {
            System.out.println("截取"+(x+1)+"个字节的结果是"+cutStringByByte(str,x+1));
        }

        /*String str2 = "琲";
        byte[] buf = str2.getBytes();
        for (byte b : buf) {
            System.out.println("b = " + b);
        }*/

    }

    public static String cutStringByByte(String str,int len) throws UnsupportedEncodingException {

        byte[] buf = str.getBytes("gbk");

        int count = 0;
        for (int x = len-1; x >=0 ; x--) {
            if (buf[x]<0)
                count++;
            else
                break;
        }

        if (count%2==0)//utf-8就要%3
            return new String(buf,0,len,"gbk");
        else
            return new String(buf,0,len-1,"gbk");
    }


}
