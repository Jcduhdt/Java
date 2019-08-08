package FunctionInterface;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 函数式接口：有且只有一个去抽象方法的接口，称之为函数式接口
 * 当然接口中可以包含其他的方法（默认，静态，私有)
 */

/**
 * @FunctionalInterface注解
 * 作用：可以检测接口是否是一个函数式接口
 *      是:编译成功
 *      否：编译失败（接口中没有抽象方法，抽象方法的个数多于1个）
 *
 * 就是，下面那个黄色的内容，如果报错就是有红色下划线
 * 也有个提醒类型的作用吧
 */

@FunctionalInterface
public interface MyFunInterfaceDemo {
    //定义一个抽象方法
    public abstract void method();

//    void method2();
}
