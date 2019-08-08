package chat;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-26
 */
public class ChatDemo {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send = new DatagramSocket();

        DatagramSocket rece = new DatagramSocket(10001);
        new Thread(new Send(send)).start();
        new Thread(new Rece(rece)).start();
    }
}
