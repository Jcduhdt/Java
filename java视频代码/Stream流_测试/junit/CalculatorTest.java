package junit;


/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.add(3,4);
        System.out.println(result);

        int result1 = c.sub(5,2);
        System.out.println(result1);
    }
}
