package consumer;

import java.util.function.Consumer;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
public class ConsumerTest {
    public static void printInfo(String[] arr, Consumer<String> con1,Consumer<String> con2){
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女","古力娜扎,女","周杰伦,男"};

        printInfo(arr,(message)->{
            String name = message.split(",")[0];
            System.out.print("姓名: "+name);
        },(message)->{
            String age = message.split(",")[1];
            System.out.println("   年龄: "+age);
        });
    }
}
