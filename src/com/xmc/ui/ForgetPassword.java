package com.xmc.ui;



import com.mysql.cj.util.StringUtils;
import com.xmc.dao.UserDao;
import com.xmc.utils.qqMailsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 登陆界面视图
 */
public class ForgetPassword extends JFrame{


    public static String code;

    public ForgetPassword(){

        Font font=new Font("黑体",Font.BOLD,25);
        setResizable(false);
        setTitle("忘记密码");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(540, 270, 700, 600);
        setLayout(new BorderLayout(50,50));


        JLabel titelLabel=new JLabel("找回密码",JLabel.CENTER);
        titelLabel.setFont(font);

        JLabel jLabel1=new JLabel("绑定邮箱：",JLabel.CENTER);
        JTextField jTextField1=new JTextField();
        jLabel1.setFont(font);
        jTextField1.setFont(font);

        JLabel jLabel2=new JLabel("新密码：",JLabel.CENTER);
        JPasswordField jPasswordField =new JPasswordField();
        jLabel2.setFont(font);
        jPasswordField.setFont(font);

        JLabel jLabel3=new JLabel("确认新密码：",JLabel.CENTER);
        JPasswordField jPasswordField2 =new JPasswordField();
        jLabel3.setFont(font);
        jPasswordField2.setFont(font);

        JTextField jTextField3=new JTextField();
        jTextField3.setFont(font);


        JButton jButton1=new JButton("确认更改");
        JButton jButton2=new JButton("返回");
        JButton jButton3=new JButton("获取验证码");


        jButton1.setFont(font);
        jButton2.setFont(font);
        jButton1.setForeground(Color.CYAN);
        jButton2.setForeground(Color.CYAN);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userEmail = jTextField1.getText();
                String userPassWord = String.valueOf(jPasswordField.getPassword());
                String reUserPassWord = String.valueOf(jPasswordField2.getPassword());
                String valueCode = jTextField3.getText();
                if (valueCode.equals(code) && code != null){
                    if (StringUtils.isNullOrEmpty(userPassWord) || StringUtils.isNullOrEmpty(reUserPassWord)
                            || StringUtils.isNullOrEmpty(valueCode)){
                        jTextField1.setText("");
                        jPasswordField.setText("");
                        jPasswordField2.setText("");
                        JOptionPane.showMessageDialog(null, "请输入完整信息!");

                    }else if (!userPassWord.equals(reUserPassWord)){
                        JOptionPane.showMessageDialog(null, "两次输入密码不一致!");
                    }
                    else {
                        //TODO
                        new UserDao().updateUser(userEmail,reUserPassWord);
                        JOptionPane.showMessageDialog(null, "更新成功!!");
                        setVisible(false);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "请输入有效验证码!!");

                }

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField1.getText();
                if (text.length() > 8 && text.contains("@qq.com")) {
                    code = qqMailsUtils.sendMimeMail("2174369772@qq.com",text);
                    JOptionPane.showMessageDialog(null, "验证码发送成功!");
                }else {
                    JOptionPane.showMessageDialog(null, "邮箱格式错误!目前只支持qq邮箱注册!");
                }
            }
        });


        JPanel jPanel1=new JPanel();
        JPanel jPanel2=new JPanel();
        JPanel jPanel3=new JPanel();
        JPanel jPanel4=new JPanel();


        //上面


        //中间
        jPanel1.setLayout(new GridLayout(4,2,1,20));
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jPasswordField);
        jPanel1.add(jLabel3);
        jPanel1.add(jPasswordField2);
        jPanel1.add(jButton3);
        jPanel1.add(jTextField3);



        //下面按钮
        jPanel2.setLayout(new GridLayout(1,2,100,5));
        jPanel2.add(jButton1);
        jPanel2.add(jButton2);

        jPanel3.setLayout(new BorderLayout(50,45));
        jPanel3.add(new JPanel(),BorderLayout.SOUTH);
        jPanel3.add(new JPanel(),BorderLayout.EAST);
        jPanel3.add(new JPanel(),BorderLayout.WEST);
        jPanel3.add(new JPanel(),BorderLayout.NORTH);
        jPanel3.add(jPanel2);

        //标题
        jPanel4.setLayout(new GridLayout(3,2));
        jPanel4.add(new JPanel());
        jPanel4.add(titelLabel);

        add(jPanel4,BorderLayout.NORTH);
        add(jPanel3,BorderLayout.SOUTH);
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
        add(jPanel1,BorderLayout.CENTER);


    }


}

