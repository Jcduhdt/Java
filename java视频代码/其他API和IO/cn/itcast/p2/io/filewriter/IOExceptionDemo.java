package cn.itcast.p2.io.filewriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class IOExceptionDemo {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {

        FileWriter fw = null;//对有异常发生的东西进行外边创建引用变量，try里面进行初始化
        try {
            fw = new FileWriter("k:\\demo.txt");

            fw.write("abcde"+LINE_SEPARATOR+"hahahaha");

        } catch (IOException e) {
            System.out.println(e.toString());
        }finally {
            if (fw!=null)//就是如果系统找不到指定路径，fw就为空指针，空指针不能进行close 所以需要判断
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
        }
    }
}
