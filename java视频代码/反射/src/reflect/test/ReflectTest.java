package reflect.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */

/*
 * 电脑运行
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Mainboard mb = new Mainboard();
        mb.run();
        //每次添加一个设备都需要修改代码传递一个新创建的对象
//        mb.usePCI(new SoundCard());//电脑使用接口的时候就要修改程序，创建添加的设备的对象
        //能不能不修改代码就可以完成这个动作
        //不用new来完成，而是只获取其class文件，在内部实现创建对象的动作

        File configFile = new File("pci.properties");
        Properties prop = new Properties();//键值对，配置文件
        FileInputStream fis = new FileInputStream(configFile);

        prop.load(fis);

        for (int i = 0; i < prop.size(); i++) {
            String pciName = prop.getProperty("pci"+(i+1));
            Class clazz = Class.forName(pciName);//用Class去加载这个pci类

            PCI p = (PCI)clazz.newInstance();
            mb.usePCI(p);
        }

        fis.close();
    }
}
