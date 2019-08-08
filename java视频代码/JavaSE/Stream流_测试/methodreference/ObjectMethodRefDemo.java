package methodreference;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
/*
 * 通过对象名引用成员方法
 * 使用前提是对象名已经存在的，成员方法已经存在
 * 就可以使用对象名来引用成员方法
 */
public class ObjectMethodRefDemo {
    public static void printString(Printable p){
        p.print("Hello");
    }

    public static void main(String[] args) {
        printString((s)->{
            MethodRefObject obj = new MethodRefObject();
            obj.printUpperCaseString(s);
        });

        //使用方法引用优化Lambda
        MethodRefObject obj = new MethodRefObject();
        printString(obj::printUpperCaseString);
    }
}
