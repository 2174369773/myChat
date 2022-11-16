package com.xmc.ui;



import com.mysql.cj.util.StringUtils;
import com.xmc.dao.EmployeeDao;
import com.xmc.dao.UserDao;
import com.xmc.pojo.Employee;
import com.xmc.pojo.User;
import com.xmc.ui.employee.EmployeeHome;
import com.xmc.ui.employeeAdmin.AdminHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 登陆界面视图
 */
public class Login extends JFrame{

    public Login(){

        Font font=new Font("黑体",Font.BOLD,25);
        setResizable(false);
        setTitle("登录页面");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(540, 270, 700, 600);
        setLayout(new BorderLayout(50,50));


        JLabel titelLabel=new JLabel("欢迎来到企业员工管理系统",JLabel.CENTER);
        titelLabel.setFont(font);

        JLabel jLabel1=new JLabel("用户邮箱：",JLabel.CENTER);
        JTextField jTextField1=new JTextField(30);
        jLabel1.setFont(font);
        jTextField1.setFont(font);


        JLabel jLabel2=new JLabel("用户密码：",JLabel.CENTER);
        JTextField jTextField2=new JTextField(30);
        jLabel2.setFont(font);
        jTextField2.setFont(font);


        JLabel jLabel3=new JLabel("选择角色：",JLabel.CENTER);
        JComboBox jComboBox = new JComboBox();
        jComboBox.addItem("---请选择---");
        jComboBox.addItem("员工");
        jComboBox.addItem("管理员");
        jLabel3.setFont(font);
        jComboBox.setFont(font);



        JButton jButton1=new JButton("登录");
        JButton jButton2=new JButton("注册");
        JButton jButton3=new JButton("忘记密码?");


        jButton1.setFont(font);
        jButton2.setFont(font);
        jButton1.setForeground(Color.CYAN);
        jButton2.setForeground(Color.CYAN);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userEmail = jTextField1.getText();
                String passWord = jTextField2.getText();
                int selectedIndex = jComboBox.getSelectedIndex();
                //管理员
                if (selectedIndex == 2) {
                    System.out.println(selectedIndex);
                    if (!(StringUtils.isNullOrEmpty(userEmail) && StringUtils.isNullOrEmpty(passWord))) {
                        User user = new UserDao().login(userEmail, passWord);
                        if (user == null) {
                            JOptionPane.showMessageDialog(null, "账号或密码错误!!");
                            jTextField1.setText("");
                            jTextField2.setText("");
                            return;
                        }
                        JOptionPane.showMessageDialog(null, "登录成功!!");
                        setVisible(false);
                        new AdminHome(user.getId()).setVisible(true);
//
                    } else {
                        JOptionPane.showMessageDialog(null, "请输入完整信息!!");
                    }
                }else {
                    //员工登录
                    if (!(StringUtils.isNullOrEmpty(userEmail) && StringUtils.isNullOrEmpty(passWord))){
                        Employee employee = new EmployeeDao().empolyeeLogin(userEmail,passWord);
                        if (employee != null){
                            System.out.println(employee);
                            new EmployeeHome(employee).setVisible(true);
                        }
                    }
                }

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp().setVisible(true);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ForgetPassword().setVisible(true);
            }
        });


        JPanel jPanel1=new JPanel();
        JPanel jPanel2=new JPanel();
        JPanel jPanel3=new JPanel();
        JPanel jPanel4=new JPanel();





        //中间
        jPanel1.setLayout(new GridLayout(4,2,1,20));
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);
        jPanel1.add(jLabel3);
        jPanel1.add(jComboBox);
        jPanel1.add(jButton3);



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
        setVisible(true);


    }

}

