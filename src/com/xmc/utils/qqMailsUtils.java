package com.xmc.utils;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description: qq邮箱通用发信息类
 * @ClassName: qqMailsUtils
 * @Author: xmc
 * @Date: 2022/10/1 13:03
 * @Version: 1.0
 */
public class qqMailsUtils {

    public static String sendMimeMail(String source,String target) {
        // 收件人电子邮箱
        String to = target;
        // 发件人电子邮箱
        String from = source;
        String code = "";
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("2174369772@qq.com", "ykyxavvbbvosdjai"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("验证码邮件:");

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            ArrayList random = RandomUtil.getRandom(list, 6);
            for (int i = 0; i < random.size(); i++) {
                code+=random.get(i);
            }
            // 设置消息体
            message.setText("您的登录验证码是："+code);

            // 发送消息
            Transport.send(message);
            System.out.println("发送成功");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return code;
    }

}
