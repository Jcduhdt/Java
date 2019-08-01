package junit.test;

import junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */
public class CalculatorTest {

    /**
     * 初始化方法：
     * 用于资源的申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源方法:
     * 在所有的测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试方法
     */
    @Test
    public void testAdd(){
//        System.out.println("我被执行了");

        System.out.println("testAdd...");
        Calculator c = new Calculator();

        int result = c.add(1,2);
//        System.out.println(result);

        //3.断言  我断言这个结果是3
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(1,2);
        System.out.println("testsub...");
        Assert.assertEquals(-1,result);
    }
}
