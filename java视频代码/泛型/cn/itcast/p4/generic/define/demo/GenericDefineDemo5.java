package cn.itcast.p4.generic.define.demo;


/**
 * @version V12.0.1 2019-7-17
 * @author Zhang Xiong
 */

public class GenericDefineDemo5 {
    public static void main(String[] args) {
        InterImpl in = new InterImpl();
        in.show("abx");

        InterImpl2<Integer> in2 = new InterImpl2<Integer>();
        in2.show(5);
    }
}

//泛型接口，将泛型定义在接口上
//两种泛型接口实现方式，就看在哪里明确
interface Inter<T>{
    public void show(T t);
}

class InterImpl implements Inter<String>{
    public void show(String str){
        System.out.println("show: " + str);
    }
}

class InterImpl2<Q> implements Inter<Q>{
    public void show(Q q){
        System.out.println("show: " + q);
    }
}
