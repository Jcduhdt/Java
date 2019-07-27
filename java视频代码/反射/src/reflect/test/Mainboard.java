package reflect.test;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class Mainboard {
    public void run(){
        System.out.println("main board run...");
    }

    public void usePCI(PCI p){
        if (p != null) {
            p.open();
            p.close();
        }
    }
}
