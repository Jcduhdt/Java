package cn.itcast.p4.generic.define.demo;


/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */

/*
public class Tool {
    private Object object;

    public Object getobject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
*/

//再jck1.5以后，使用泛型来接收类中要操作的引用数据类型
//泛型类。什么时候用？当类中的操作的引用
public class Tool<QQ>{
    private QQ q;

    public QQ getObject() {
        return q;
    }

    public void setObject(QQ q) {
        this.q = q;
    }

    /**
     * 将泛型定义在泛型上
     * @param str
     * @param <W>
     */
    public <W> void show(W str){
        System.out.println("show: " + str.toString());
    }

    public void print(QQ str){
        System.out.println("print:" + str);
    }

    /**
     * 当方法静态时不能访问类上定义的泛型。如果静态方法使用泛型
     * 只能 将泛型定义在方法上 定义在返回类型前
     * @param obj
     */
    public static <Y> void method(Y obj){
        System.out.println("method: "+obj);
    }
}