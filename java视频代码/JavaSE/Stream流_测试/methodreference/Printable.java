package methodreference;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */

//定义打印函数式接口
@FunctionalInterface
public interface Printable {
    //打印字符串的抽象方法
    void print(String s);
}
