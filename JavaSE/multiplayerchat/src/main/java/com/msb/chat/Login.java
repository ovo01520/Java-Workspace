package com.msb.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/8-20:58
 * @Description: MultiplayerChat.ChatClient
 * @Version: 1.0
 */
public class Login extends JFrame {
    private JLabel unameJLabel;
    private JLabel pwdJLabel;
    private JTextField unameJTextField;
    private JTextField pwdJTextField;
    private JButton loginJButton;
    private JButton cacelJButton;

    public Login(){
        super("IT全明星聊天室");
        this.unameJLabel = new JLabel("用户名");
        this.pwdJLabel = new JLabel("密码");
        this.unameJTextField = new JTextField();
        this.pwdJTextField = new JTextField();
        this.loginJButton = new JButton("登录");
        this.cacelJButton = new JButton("取消");

        this.setSize(300,200);
        this.setLayout(new GridLayout(3,2));
        this.add(unameJLabel);
        this.add(unameJTextField);
        this.add(pwdJLabel);
        this.add(pwdJTextField);
        this.add(loginJButton);
        this.add(cacelJButton);

        //给按钮做监听事件
        MyEvent myEvent = new MyEvent();
        this.loginJButton.addActionListener(myEvent);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //监听单击事件
    class MyEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            //1.获得用户名
            String loginUname = unameJLabel.getText();
            try {
                //2.创建socket连接服务器端
                Socket socket = new Socket("127.0.0.1",9999);
                //3.跳转到聊天室界面
                new Client(socket,loginUname);
                //4.当前窗口可以关闭
                dispose();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null,"找不到服务器");
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
