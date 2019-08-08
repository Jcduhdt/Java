package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class Rece implements Runnable {
    private DatagramSocket ds;

    public Rece(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try{
            while (true) {
                //2.创建数据包
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);

                //3.使用接收方法将数据存储到数据包中
                ds.receive(dp);//阻塞式的，等待数据

                //4.通过数据包对象，解析其中的数据，比如地址，端口，数据内容
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());

                System.out.println(ip + ":" + port + ":" + text);

                if (text.equals("886")){
                    System.out.println(ip+"退出聊天室");
                }
            }
        }catch (Exception e){

        }
    }
}
