package FunctionInterface;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */

//函数式接口的使用：一般可以作为方法的参数和返回值类型
public class Demo {
    //定义一个方法，参数使用函数式接口MyFunInterfaceDemo
    public static void show(MyFunInterfaceDemo myInter){
        myInter.method();
    }

    public static void main(String[] args) {
        //调用show方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        show(new MyFunInterfaceImpl());

        //调用show方法，方法的参数是一个接口，所以我们可以传递接口的匿名内部类
        show(new MyFunInterfaceDemo() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        //调用show方法，方法的参数是一个函数式接口，所以我们可以使用Lambda表达式
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        //简化Lambda表达式
        show(()->System.out.println("简化Lambda表达式重写接口中的抽象方法"));
    }
}
