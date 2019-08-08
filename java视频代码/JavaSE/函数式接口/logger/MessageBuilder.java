package logger;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法，返回被拼接的消息
    public abstract String builderMessage();
}
