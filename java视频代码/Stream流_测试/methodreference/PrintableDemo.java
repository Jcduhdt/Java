package methodreference;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class PrintableDemo {
    public static void printString(Printable p){
        p.print("HelloWorld");
    }

    public static void main(String[] args) {
        printString((s)->{
            System.out.println(s);
        });

        printString(System.out::println);//::为引用运算符
        //其所在表达式被称为方法引用，如果Lambda要表达的函数已经存在于某个方法的实现中，
        // 那么可以通过双冒号来引用该方法作为Lambda的代替
    }
}
