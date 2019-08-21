package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-21
 */

/*
  选择器查询
*/
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        /*
          div{

          }
         */
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("---------------");

        //查询id值为biu的元素
        Elements elements1 = document.select("#biu");
        System.out.println(elements1);
        System.out.println("---------------");

        //5.获取student标签并且number属性值为heima_0001的age子标签
        //5.1获取student标签并且number属性值为heima_0001
        Elements element2 = document.select("student[number='heima_0001']");
        System.out.println(element2);
        System.out.println("---------------");

        Elements element3 = document.select("student[number='heima_0001']>age");
        System.out.println(element3);
    }
}
