package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class Send implements Runnable {
    private DatagramSocket ds;

    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try{
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while ((line = bufr.readLine())!=null){

                byte[] buf = line.getBytes();

                //使用DatagramPacket将数据封装到该对象包中
                DatagramPacket dp =
                        new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.31.255"),10001);
                //192.168.31.255最后的那个255是广播。可以1：244实现群聊
                //通过udp的socket服务将数据包发送出去，使用send方法
                ds.send(dp);

                if ("886".equals(line))
                    break;
            }


            //关闭资源
            ds.close();
        }catch (Exception e){

        }
    }
}
