import java.util.ArrayList;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-18
 */

/*
 * 1.IDEA中代码模板所处位置：setting.Editor.Live_Templates/Postfix_Completion
 * 2.在setting.Editor.Live_Templates里面自定义添加，我创建了一个包Custom
 */
public class TemplateTest {
    //模板六：prsf:可生成private static final
    private static final int CU = 6;

    //变形：psf  public static final
    public static final  int NUM = 1;
    //变形：psfi
    public static final int NUM2 = 13;
    //变形：psfs
    public static final String STR = "sada";





    //模板一：psvm/main
    public static void main(String[] args) {
        //模板二:sop 我把sout改成sop了,变形也是
        System.out.println();
        //变形：sopp/sopm/sopv/xxx.sout
        System.out.println("args = [" + args + "]");//sopp
        System.out.println("TemplateTest.main");//sopm
        int num1 = 10;
        System.out.println(num1);//xxx.sop
        int num2 = 20;
        System.out.println("num2 = " + num2);//sopv


        //模版三：fori
        //这个还要再for循环的条件上写条件，itar方便得多
        String[] arr = new String[]{"Tom","Jerry","Hanmeimei","Lilei"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//arr[i].sout
        }

        //变形：iter 增强for循环
        //应该是对就近元素进行
        for (String s : arr) {
            System.out.println(s);//s.sout
        }

        //变形itar
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);//a.sout
        }


        //模板四：list.for 增强型
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(334);
        list.add(468);
        list.add(95);
        for (Object o : list) {

        }

        //变形list.fori
        for (int i = 0; i < list.size(); i++) {

        }

        //变形：list.forr  倒序遍历
        for (int i = list.size() - 1; i >= 0; i--) {

        }
    }


    public void Method(){
        System.out.println("TemplateTest.Method");//sopm

        //模板五：ifn
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(334);
        list.add(468);
        list.add(95);

        if (list == null) {

        }

        //变形:inn  判断not null
        if (list != null) {

        }

        //变形：xxx.nn/xxx.null
        if (list != null) {
            //list.nn
        }
        if (list == null) {
            //list.null
        }
    }
}
