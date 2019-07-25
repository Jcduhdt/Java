package cn.itcast.p12.io.objectstream;

import cn.itcast.p12.io.bean.Person;

import java.io.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeObj();
        readObj();
    }

    public static void readObj() throws IOException, ClassNotFoundException {

        //ObjectInputStream 对以前使用 ObjectOutputStream 写入的基本数据和对象进行反序列化。
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
        //对象的反序列化。

        Person p = (Person)ois.readObject();//将读出来的对象强转

        System.out.println(p.getName()+":"+p.getAge());

        ois.close();


    }

    public static void writeObj() throws IOException {
        //.object是保存的对象的规范后缀
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
        //对象序列化，被序列化的对象必须实现Serializable接口
        //对象的默认序列化机制写入的内容是：对象的类，类签名，以及非瞬态和非静态字段的值。


        /*
         * Serializable
         * 通过id号来判别对象匹不匹配
         * 序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联，
         * 该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。
         */
        oos.writeObject(new Person("小强",30));
        //将指定的对象写入 ObjectOutputStream。对象的类、类的签名，以及类及其所有超类型的非瞬态和非静态字段的值都将被写入。
        //java.io.NotSerializableException: cn.itcast.p12.io.bean.Person
        //类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
        // 可序列化类的所有子类型本身都是可序列化的。序列化接口没有方法或字段，仅用于标识可序列化的语义。

        oos.close();
    }
}
