package cn.itcast.p14.io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */

//操纵内存的读
    //不用关流，因为没调用底层资源
public class ByteArrayStreamDemo {
    public static void main(String[] args) {

        ByteArrayInputStream bis = new ByteArrayInputStream("abcdefg".getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int ch = 0;

        while ((ch=bis.read())!=-1){
            bos.write(ch);
        }

        System.out.println(bos.toString());
    }
}
