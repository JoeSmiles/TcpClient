package test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void service() {
        while(true) {
            Socket socket = null;
            try {
                // 等待客户连接
                socket = serverSocket.accept();
                System.out.println("New connection accepted "
                + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader br = getReader(socket);
                PrintWriter pw = getWriter(socket);

                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                    pw.println(echo(msg));
                    // 如果客户发送的消息为 bye 就通讯结束
                    if ("bye".equals(msg)) return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) socket.close();  // 断开连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}
