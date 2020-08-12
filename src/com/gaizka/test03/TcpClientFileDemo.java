package com.gaizka.test03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

// 客户端
public class TcpClientFileDemo {

    public static void main(String[] args) throws Exception {
        // 1. 创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        // 2. 创建一个输出流
        OutputStream os = socket.getOutputStream();

        // 3. 读取文件
        FileInputStream fis = new FileInputStream(new File("北斗物联网接口.txt"));
        // 4. 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        // 通知服务器，我已经结束了
        socket.shutdownOutput();

        // 确定服务器接收完毕才能断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }

        System.out.println(baos.toString());

        // 5. 关闭资源
        fis.close();
        os.close();
        socket.close();

    }
}
