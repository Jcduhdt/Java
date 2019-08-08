package cn.itcast.p4.generic.define.demo;

import cn.itcast.p2.bean.Student;

/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */

public class GenericDefineDemo4 {
    public static void main(String[] args) {
       Tool<Student> tool =  new Tool<Student>();

       //tool.setObject(new Worker());//Error:(15, 23) java: 不兼容的类型: cn.itcast.p2.bean.Worker无法转换为cn.itcast.p2.bean.Student
        tool.setObject(new Student());
       Student stu = tool.getObject();
        /* Tool tool = new Tool();

        tool.setObject(new Student());

        Student stu = (Student)tool.getObject();*/
    }
}
