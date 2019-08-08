package packa;

/**
 * @version V12.0.1 2019-06-22
 * @author Zhang Xiong
 */
public class DemoA extends packb.DemoB//不同包之间的继承
{
    public void show()//被别人调用，必须要是public
    {
        method();
        System.out.println("demoa show run");
    }
}
