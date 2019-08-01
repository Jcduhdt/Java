package annotation;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public @interface MyAnno {
    int age() default 6;
    /*String show2();

    MyAnno2 anno2();

    String[] strs();*/
}
