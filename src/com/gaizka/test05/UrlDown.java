package com.gaizka.test05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {

    public static void main(String[] args) throws IOException {

        // 1. 下载地址
//        URL url = new URL("http://localhost:8080/gaizka/test.txt");
        URL url = new URL("https://m10.music.126.net/20200812102754/c2764175aa54c59d251cad65a628ad17/yyaac/obj/wonDkMOGw6XDiTHCmMOi/3490911606/e2d4/96a5/737a/e3b65fe63672b290c7290f36d19a87c3.m4a");

        // 2. 连接到这个资源 HTTP
        URLConnection urlConnection = url.openConnection();

        InputStream is = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("世界上不存在的歌.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);  // 写出这个数据
        }

        fos.close();
        is.close();
        urlConnection.connect();
    }
}
