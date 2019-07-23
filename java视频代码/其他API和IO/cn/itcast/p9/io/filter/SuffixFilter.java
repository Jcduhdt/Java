package cn.itcast.p9.io.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */

//后缀名过滤器
public class SuffixFilter implements FilenameFilter {

    private String suffix;
    public SuffixFilter(String suffix){
        super();
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
