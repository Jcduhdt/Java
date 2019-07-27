package uploadpic;

import java.io.*;
import java.net.Socket;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-27
 */
public class UploadTask implements Runnable {

    private Socket s;

    public UploadTask(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        int count = 0;
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connected");

        try {
            //读取客户端发来的数据
            InputStream in = s.getInputStream();

            //将读取到的数据存储到文件当中
            File dir = new File("E:\\pic");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, ip + ".jpg");
            //如果文件已经存在于服务器端
            while (file.exists()){
                file = new File(dir,ip+"("+(++count)+").jpg");
            }

            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];

            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            //获取socket输出流，将上传成功字样发给客户端
            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());

            fos.close();
            s.close();
        }catch (IOException e){

        }
    }
}
