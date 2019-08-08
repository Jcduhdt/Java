package cn.itcast.p9.io.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */

//创建过滤器
public class FilterByJava implements FilenameFilter {
    public boolean accept(File dir,String name){
//        System.out.println(dir + "-------------" + name);
        return name.endsWith(".java");
    }
}
