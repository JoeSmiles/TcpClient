package com.gaizka.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class UdpSenderDemo01 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        // 准备数据： 控制台读取 System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)  {
            String data = reader.readLine();
            if ("bye".equals(data)) {
                break;
            }
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            socket.send(packet);
        }

        socket.close();
    }
}
