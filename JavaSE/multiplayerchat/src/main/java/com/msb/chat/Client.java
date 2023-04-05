package com.msb.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/8-21:39
 * @Description: MultiplayerChat.ChatClient
 * @Version: 1.0
 */
public class Client extends JFrame{
    //滚动面板 用来存放消息列表
    private JScrollPane topPanel;
    //发送消息的面板
    private JPanel bottomPanel;
    //存放消息列表
    private  JTextArea msgList;
    //写消息的文本框
    private JTextField msgText;
    //发送按钮
    private JButton sendButton;

    private Socket socket;
    private String uname;

    public Client(Socket socket,String uname) {
        super(uname);

        this.socket = socket;
        this.uname = uname;
        //创建组件对象
        this.topPanel = new JScrollPane();
        this.bottomPanel = new JPanel();
        this.msgList = new JTextArea();
        this.msgText = new JTextField();
        this.sendButton = new JButton();

        //设置属性(绝对布局)
        this.topPanel.setLayout(null);
        this.bottomPanel.setLayout(null);

        this.topPanel.setBounds(0,0,1000,500);
        this.msgList.setBounds(30,30,940,440);
        this.bottomPanel.setBounds(0,500,1000,100);
        this.msgText.setBounds(30,510,700,80);
        this.sendButton.setBounds(750,510,200,80);

        //添加组件到窗口中
        this.topPanel.add(msgList);
        this.bottomPanel.add(msgText);
        this.bottomPanel.add(sendButton);

        this.add(topPanel);
        this.add(bottomPanel);
        //设置窗口属性
        this.setSize(1000,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //开启一个线程 接收服务器端发回的消息
        ReceiveThread receiveThread = new ReceiveThread();
        receiveThread.start();

        //对发送按钮做监听器
        MyEvent myEvent = new MyEvent();
        this.sendButton.addActionListener(myEvent);

    }
    class MyEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //1.获得文本框的消息内容
            String msg = msgText.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = simpleDateFormat.format(new Date());
            msg = time + uname + "说：" + msg;
            //2.发送到服务器端
            try {
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                pw.println(msg);
                //不要关闭输出流 FTP协议中规定 如果关闭当前socket输出流 则意味着对应的socket关闭
                pw.flush();
            } catch (IOException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

        }
    }

    class ReceiveThread extends Thread{
        @Override
        public void run() {
            try {
                //从服务器端读取消息
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = null;
                while ((msg = bufferedReader.readLine())!= null){
                    msgList.append(msg + "\n");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
