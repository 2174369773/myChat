package com.xmc.ui;


import com.mysql.cj.util.StringUtils;
import com.xmc.dao.UserDao;
import com.xmc.pojo.User;
import com.xmc.ui.employee.ToSignUp;
import com.xmc.utils.qqMailsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUp extends JFrame {


    public static  String code;

    public SignUp() {

        Font font=new Font("黑体",Font.BOLD,25);//统一字体样式
        Font  font2  = new Font("方正舒体",Font.BOLD ,30);

        setTitle("注册页面");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300,125,700,600);
        setLayout(new BorderLayout(100,100));
        setResizable(false);

        JLabel titelLabel = new JLabel("欢迎光临注册页面!");
        titelLabel.setFont(font);


        JLabel label2 = new JLabel("请输入邮箱:",JLabel.CENTER);
        label2.setFont(new Font("黑体",Font.BOLD,20));
        JTextField t2=new JTextField();
        t2.setFont(font);

        JLabel label3 = new JLabel("请输入密码:",JLabel.CENTER);
        label3.setFont(new Font("黑体",Font.BOLD,20));
        JTextField t3=new JTextField();
        t3.setFont(font);

        JLabel label4 = new JLabel("昵称:",JLabel.CENTER);
        label4.setFont(new Font("黑体",Font.BOLD,20));
        JTextField t4=new JTextField();
        t4.setFont(font);

        JLabel label5 = new JLabel("请输验证码:",JLabel.CENTER);
        label5.setFont(new Font("黑体",Font.BOLD,20));
        JTextField t5=new JTextField();
        t5.setFont(font);


        JButton jButton1=new JButton("确认注册");
        JButton jButton2=new JButton("返回");
        JButton jButton3=new JButton("获取验证码");
        JButton jButton4=new JButton("我是员工");
        jButton4.setBackground(Color.CYAN);
        jButton4.setFont(font2);

        jButton1.setFont(font);
        jButton2.setFont(font);
        jButton1.setForeground(Color.CYAN);
        jButton2.setForeground(Color.CYAN);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userEmail = t2.getText();
                String userPassWord = t3.getText();
                String userName = t4.getText();
                String valueCode = t5.getText();
                if (valueCode.equals(code) && code != null){
                    if (StringUtils.isNullOrEmpty(userPassWord)
                       || StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(valueCode)){
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        JOptionPane.showMessageDialog(null, "请输入完整信息!");

                    }else {
                        if(!new UserDao().checkIsValue(userEmail)){
                            new UserDao().createUser(new User(null,userName,userPassWord,userEmail));
                            JOptionPane.showMessageDialog(null, "注册成功!!");
                            setVisible(false);

                        }else {
                            JOptionPane.showMessageDialog(null, "该邮箱已经注册过了!!");
                        }
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
                String text = t2.getText();
                if (text.length() > 8 && text.contains("@qq.com")) {
                        code = qqMailsUtils.sendMimeMail("2174369772@qq.com",text);
                        JOptionPane.showMessageDialog(null, "验证码发送成功!");
                }else {
                    JOptionPane.showMessageDialog(null, "邮箱格式错误!目前只支持qq邮箱注册!");
                }
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ToSignUp().setVisible(true);
                setVisible(false);
            }
        });



        //根据布局分析，需要用到三个面板
        JPanel jpanel = new JPanel();
        JPanel jpanel2 = new JPanel();
        JPanel jpanel3 = new JPanel();
        JPanel jpanel4 = new JPanel();





        //网格布局,上面
        jpanel.setLayout(new GridLayout(2,3));
        jpanel.add(new JPanel());
        jpanel.add(new JPanel());
        jpanel.add(new JPanel());
        jpanel.add(new JPanel());
        jpanel.add(titelLabel);

        //下面
        jpanel2.setLayout(new GridLayout(1,2,100,5));
        jpanel2.add(jButton1);
        jpanel2.add(jButton2);

        jpanel4.setLayout(new BorderLayout(30,15));
        jpanel4.add(new JPanel(),BorderLayout.SOUTH);
        jpanel4.add(new JPanel(),BorderLayout.EAST);
        jpanel4.add(new JPanel(),BorderLayout.WEST);
        jpanel4.add(new JPanel(),BorderLayout.NORTH);
        jpanel4.add(jpanel2);


        //中间
        jpanel3.setLayout(new GridLayout(5,2,5,5));
        jpanel3.add(label4);
        jpanel3.add(t4);
        jpanel3.add(label2);
        jpanel3.add(t2);
        jpanel3.add(jButton3);
        jpanel3.add(t5);
        jpanel3.add(label3);
        jpanel3.add(t3);
        jpanel3.add(jButton4);




        this.add(jpanel,BorderLayout.NORTH);
        this.add(jpanel4,BorderLayout.SOUTH);
        this.add(new JPanel(),BorderLayout.EAST);
        this.add(new JPanel(),BorderLayout.WEST);
        this.add(jpanel3,BorderLayout.CENTER);
    }
}
