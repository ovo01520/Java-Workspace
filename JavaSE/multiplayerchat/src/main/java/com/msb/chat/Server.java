package com.msb.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/9-7:02
 * @Description: MultiplayerChat.ChatClient
 * @Version: 1.0
 */
//聊天室服务器端
public class Server {
    //存放所有链接上当前服务器的客户端
    private List<Socket> clientSockets = new ArrayList<Socket>();

    public Server() {
        try {
            //1.创建服务器端的socket
            ServerSocket serverSocket = new ServerSocket(9999);
            while(true) {
                //2.接收服务器端的socket
                Socket socket = serverSocket.accept();
                //3.存入集合中
                this.clientSockets.add(socket);
                //4.开一个线程处理客户端发送过来的消息
                ReceiveThread thread = new ReceiveThread(socket);

                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //创建一个线程 接收客户端的socket
    class ReceiveThread extends Thread{
        private Socket currentSocket;

        public ReceiveThread(Socket socket) {
            this.currentSocket = socket;
        }

        public void run(){
            try {
                //获得当前线程中拿到的消息
                InputStream is = this.currentSocket.getInputStream();
                //群发给所有的线程对象
                //获得输入流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String msg = null;
                while ((msg = bufferedReader.readLine())!=null){
                    //群发给所有客户端
                    for (Socket socket:clientSockets){
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                        pw.println(msg);
                        //发送到客户端
                        //不要关闭输出流 FTP协议中规定 如果关闭当前socket输出流 则意味着对应的socket关闭
                        pw.flush();
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
