package com.gaizka.test02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

// 客户端
public class TcpClientDemo01 {

    static String host = "127.0.0.1";
    static int port = 9999;
    static Socket socket = null;
    static OutputStream os = null;

    public static void main(String[] args) {
        try {
            // 1. 知道服务器的地址，端口号
            InetAddress inetAddress = InetAddress.getByName(host);
            // 2. 创建一个socket连接
            socket = new Socket(inetAddress, port);
            // 3. 发送消息IO流
            os = socket.getOutputStream();
            os.write("你好， 欢迎来到我的世界".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
