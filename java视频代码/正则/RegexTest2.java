import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */

/*
 * 网页爬虫:其实是一个程序用于互联网中获取符合指定规则数据
 *
 * 爬取邮箱地址
 */
public class RegexTest2 {
    public static void main(String[] args) throws Exception {
        List<String> list = getMails();
        for (String mail : list) {
            System.out.println(mail);
        }
    }

    public static List getMails() throws Exception {

        //1.读取源文件
//        BufferedReader bufr = new BufferedReader(new FileReader("mail.html"));

        URL url = new URL("http://bing.com");
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(url.openStream()));
        //2.对读取的数据进行规则的匹配，从中获取符合规则的数据
        String mail_regex = "\\w+@\\w+(\\.\\w+)+";

        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(mail_regex);

        String line = null;
        while ((line = bufIn.readLine())!=null){
            System.out.println(line);

            Matcher m = p.matcher(line);
            while (m.find()){
                //3.将符合规则的数据存储到集合中
                list.add(m.group());
            }
        }
        return list;
    }
}
