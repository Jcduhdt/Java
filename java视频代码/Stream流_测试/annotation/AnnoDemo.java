package annotation;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */

/*
JDK中预定义的一些注解
@Override:检测被该注解标注的方法是否是继承自父类（接口）的
@Deprecated：该注解标注的内容，表示已过时
@SuppressWarnings：压制警告
*/
@SuppressWarnings("all")//使用了这个，就把右边那些黄色的警告线消除了
public class AnnoDemo {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }


    @MyAnno//自己定义的注解
    public void show2(){
        //替代show1方法
    }

    public void demo(){
        show1();
    }
}
