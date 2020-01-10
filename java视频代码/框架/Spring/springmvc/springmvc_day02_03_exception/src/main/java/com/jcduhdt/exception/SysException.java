package com.jcduhdt.exception;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-10
 * 自定义异常类
 */
public class SysException extends Exception{
    //存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
