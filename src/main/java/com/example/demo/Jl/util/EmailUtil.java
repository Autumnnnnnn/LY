package com.example.demo.Jl.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {
    private static final String USER="dzlspacebar@163.com" ;//发件人邮箱
    private static final String PASSWORD="QCYYMATWVTPXEUUE";

    public static boolean sendMail(String to,String text,String title){
        try {
            //设置SSL 连接环境
            final Properties properties = new Properties();
            properties.setProperty("mail.smtp.auth","true");
            properties.setProperty("mail.smtp.port","465");
            properties.setProperty("mail.smtp.host","smtp.163.com");
            properties.setProperty("mail.smtp.ssl.enable", "true");
            properties.setProperty("mail.user",USER);
            properties.setProperty("mail.password",PASSWORD);
            /**
             * 建立邮箱会话，
             * getDefaultInstance() 方法无法获取默认会话，改成了getInstance 创建新的会话
             */
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER,PASSWORD);
                }
            });
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 发件人
            InternetAddress from_address = new InternetAddress(USER);
            message.setFrom(from_address);
            // Set To: 收件人
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: 标题
            message.setSubject(title);
            // 设置消息体
            message.setText(text,"UTF-8","html");
            // 发送消息
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//        String user = "dzlspacebar@qq.com";
//        String content = "<a href='http://localhost:8082/activeUser?code=fc2e66526c08364c306b5e663eb7acc263e9'>点击激活【个人记录网】</a>";
//        String title = "记录网邮箱激活";
//        sendMail(user,content,title);
//        System.out.println("发送成功！");
//    }
}
