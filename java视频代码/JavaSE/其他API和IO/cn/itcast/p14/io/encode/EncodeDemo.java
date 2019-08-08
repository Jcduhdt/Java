package cn.itcast.p14.io.encode;

import java.io.UnsupportedEncodingException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
         * 字符串-->字节数组：编码
         * 字符数组-->字符串：解码
         *
         * "你好"：utf-8:-28 -67 -96 -27 -91 -67 本机默认编码
         * GBK:-60 -29 -70 -61
         *
         * 如果你编码编错了。解不出来
         * 如果编对了，解错了，有可能有救
         *
         * iso8859-1是单字节编码，utf-8是3字节编码。所以导致结果不同
         */

        String str = "你好";

        byte[] buf = str.getBytes("gbk");

        String s1 = new String(buf,"utf-8");

        System.out.println(s1);

        byte[] buf2 = s1.getBytes("utf-8");//获取源字节
        printBytes(buf2);//你好-17 -65 -67 -17 -65 -67 -17 -65 -67转换失败 锟斤拷锟
        //谢谢-48 -69 48 69转换成功
        String s2 = new String(buf2,"gbk");

        System.out.println("s2 = " + s2);


//        encodeDemo();

    }

    public static void encodeDemo() throws UnsupportedEncodingException {
        String str = "你好";

        //编码
        byte[] buf = str.getBytes("GBK");

        printBytes(buf);

        //解码
        String s1 = new String(buf,"GBK");
        System.out.println("s1 = " + s1);
    }

    public static void printBytes(byte[] buf) {
        for (byte b : buf) {
            System.out.println(b);
        }
    }
}
