package com.gaizka.test03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class TcpServerFileDemo {

    public static void main(String[] args) throws IOException {
        // 1. 创建服务
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2. 监听客户端的连接
        Socket socket = serverSocket.accept();
        // 3. 获取输入流
        InputStream is = socket.getInputStream();

        // 4. 文件输出
        FileOutputStream fos = new FileOutputStream("receive.txt");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 通知客户端我接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());

        // 5. 关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
