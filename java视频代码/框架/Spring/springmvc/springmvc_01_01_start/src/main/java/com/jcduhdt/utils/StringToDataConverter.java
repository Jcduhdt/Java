package com.jcduhdt.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-09
 * 把字符串转换日期
 */
public class StringToDataConverter implements Converter<String,Date> {

    /**
     * String source  传入进来字符串
     * @param source
     * @return
     */
    public Date convert(String source) {
        //判断
        if (source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换日期
        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
