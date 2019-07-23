package cn.itcast.p9.io.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-23
 */
public class FilterByHidden implements FileFilter {
    public boolean accept(File pathname){
        return !pathname.isHidden();
    }
}
