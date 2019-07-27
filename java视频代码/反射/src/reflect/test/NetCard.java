package reflect.test;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class NetCard implements PCI{
    @Override
    public void open() {
        System.out.println("net open");
    }

    @Override
    public void close() {
        System.out.println("net close");
    }
}
