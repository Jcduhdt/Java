package web.utils;

//import sun.misc.BASE64Encoder;这个方法不行了  报错  使用Base64代替
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
//            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + Base64.getEncoder().encodeToString(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
