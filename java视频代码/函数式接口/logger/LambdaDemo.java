package logger;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

/*
 * 使用Lambda优化日志案例
 * Lambda的特点：延迟加载
 * Lambda的使用前提，必须存在函数式接口
 */
public class LambdaDemo {
    //定义一个显示日志信息的方法，方法的参数传递日志的等级和messageBuilder接口
    public static void showLog(int level,MessageBuilder mb){
        //对日志的等级进行判断，如果是1级别，那么输出日志信息
        if (level==1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        //调用showLog方法，传递日志级别和日志信息
        showLog(2,()->{
            //返回一个拼接好的字符串
            System.out.println("不满足条件不执行");
            return msg1+msg2+msg3;
        });

        /*
         * 使用Lambda表达式作为参数传递，仅仅是把参数传递到showLog方法中
         * 只有满足条件，日志的等级是1级
         *      才会调用接口MessageBuilder中的方法builderMessage
         *      才会进行字符串拼接
         *  所以条件不满足，日志等级不是1级
         *      那么MessageBuilder接口中的方法builderMessage也不会执行
         *      所以拼接字符串的代码也不会执行
         *  所以不存在性能浪费
         */
    }
}
