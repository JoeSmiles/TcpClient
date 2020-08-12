package com.gaizka.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress localhost1 = InetAddress.getByName("127.0.0.1");
            System.out.println(localhost1);
            InetAddress localhost2 = InetAddress.getByName("localhost");
            System.out.println(localhost2);
            InetAddress localhost3 = InetAddress.getLocalHost();
            System.out.println(localhost3);

            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu);

            // 常用方法
            // System.out.println(baidu.getAddress());
            System.out.println(baidu.getCanonicalHostName());   // 规范的名字
            System.out.println(baidu.getHostAddress());
            System.out.println(baidu.getHostName());    // 获取域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
