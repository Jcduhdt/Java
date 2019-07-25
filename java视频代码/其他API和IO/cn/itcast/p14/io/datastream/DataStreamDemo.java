package cn.itcast.p14.io.datastream;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-25
 */
public class DataStreamDemo {

    public static void main(String[] args) throws IOException {
//        writeData();
        readData();

    }

    public static void readData() throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        String str =  dis.readUTF();

        System.out.println("str = " + str);
    }

    public static void writeData() throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("你好");//写进去带有utf-8修改版的标志头

        dos.close();
    }
}
