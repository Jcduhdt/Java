package reflect.test;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class SoundCard implements PCI{
    public void open(){
        System.out.println("sound open");
    }

    public void close(){
        System.out.println("sound close");
    }
}
