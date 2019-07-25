package cn.itcast.p10.io.properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {

        /*
         * Map
         *  |--Hashtable
         *      |--Properties:
         *
         * Properties集合：
         * 特点：
         * 1.该集合中的键和值都是字符串类型
         * 2.集合中的数据可以保存到流中，或者从流获取
         *
         * 通常该集合用于操作以键值对形式存在的配置文件
         */
//        propertiesDemo();
//        methodDemo_1();
//        methodDemo_2();
//        methodDemo_3();
//        myLoad();
        test();
    }

    //对已有的文件配置中的信息进行修改
    /*
     * 读取这个文件
     * 并将这个文件中的键值数据存储到集合中
     * 再通过集合对数据进行修改
     * 再通过流将修改后的数据存储到文件中
     */
    public static void test() throws IOException {
        //读取这个文件
        File file = new File("info.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fr = new FileReader("info.txt");

        //创建集合存储配置信息
        Properties prop = new Properties();

        //将流中的信息存储到集合中
        prop.load(fr);
        prop.setProperty("wangwu","16");

        FileWriter fw = new FileWriter(file);//不能提前创建，因为这个是创建一个新文件，会覆盖，数据都没取出来就有问题

        prop.store(fw,"");
        prop.list(System.out);

        fw.close();
        fr.close();

    }


    //模拟一下load方法
    public static void myLoad() throws IOException {
        Properties prop = new Properties();

        BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));

        String line = null;

        while ((line = bufr.readLine()) != null) {
            if (line.startsWith("#"))
                continue;
            String[] arr = line.split("=");
            System.out.println(arr[0] + "::" + arr[1]);

            prop.setProperty(arr[0], arr[1]);
        }
        prop.list(System.out);
        bufr.close();
    }

    public static void methodDemo_3() throws IOException {

        Properties prop = new Properties();

        //集合中的数据来自一个文件
        //注意：必须保证该文件中的数据是键值对
        //需要使用到读取流
        FileInputStream fis = new FileInputStream("info.txt");

        //使用load方法
        prop.load(fis);

        prop.list(System.out);//prop.list()调试用的
    }

    public static void methodDemo_2() throws IOException {
        Properties prop = new Properties();

        //存储元素
        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "31");
        prop.setProperty("wangwu", "36");
        prop.setProperty("zhaoliu", "20");


        //想要将这些集合中的字符串键值信息持久化存储到文件中
        //需要关联输出流
        FileOutputStream fos = new FileOutputStream("info.txt");

        //将集合中数据存储到文件中，使用store方法
        prop.store(fos, "name+age");
        // 文件中#开头都是注释信息
        //还自带时间信息
        //comments不能用中文，具体看api，会乱码

        fos.close();
    }

    /*
     * 演示Properties集合和流对象相结合的功能
     */
    public static void methodDemo_1() {
        Properties prop = new Properties();

        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "31");
        prop.setProperty("wangwu", "36");
        prop.setProperty("zhaoliu", "20");
        prop.list(System.out);

//        prop = System.getProperties();//打印系统信息
    }

    /*
     * Properties集合的存和取
     */
    public static void propertiesDemo() {
        //创建一个Properties集合

        Properties prop = new Properties();

        //存储元素
        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "31");
        prop.setProperty("wangwu", "36");
        prop.setProperty("zhaoliu", "20");

        //修改元素
        //键相同，值覆盖
        prop.setProperty("wangwu", "26");

        //取出所有元素
        Set<String> names = prop.stringPropertyNames();

        for (String name : names) {
            String value = prop.getProperty(name);//可以用getKey，但没必要，还要强转
            System.out.println(name + ":" + value);
        }
    }
}
