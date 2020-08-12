package com.gaizka.test02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class TcpServerDemo01 {

    static int port = 9999;
    static ServerSocket serverSocket = null;
    static Socket socket = null;
    static InputStream is = null;
    static ByteArrayOutputStream baos = null;

    public static void main(String[] args) {

        try {

            // 1. 创建一个地址
            serverSocket = new ServerSocket(port);
            while (true) {
                // 2. 等待客户端的了连接
                socket = serverSocket.accept();
                // 3. 读取客户端的消息
                is = socket.getInputStream();

                // 管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
