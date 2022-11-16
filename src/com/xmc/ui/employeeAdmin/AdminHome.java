package com.xmc.ui.employeeAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame{
    static JMenuItem jm1=new JMenuItem("员工列表");
    static JMenuItem jm2=new JMenuItem("发起签到");
    static JMenuItem jm3=new JMenuItem("签到列表");
    static JMenuItem jm5=new JMenuItem("请假审批");
    static JMenuItem jm4=new JMenuItem("退出系统");


    public AdminHome( int adminId) {

        jm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeList employeeList = new EmployeeList(adminId);
                employeeList.setEmployeeList(employeeList);
                employeeList.setVisible(true);
            }
        });
        jm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new   BeginSginUp(adminId).setVisible(true);

            }
        });
        jm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignInList(adminId).setVisible(true);
            }
        });
        jm4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jm5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setTitle("企业员工管理系统1.0版本----管理员首页");
        setBounds(100, 100, 1500,800);
        JMenuBar a = new JMenuBar();
        JMenu ch=new JMenu("操作");

        Font font=new Font("黑体",Font.BOLD,20);
        ch.setFont(font);
        a.add(ch);

        jm1.setFont(font);
        jm1.setForeground(Color.BLUE);

        jm2.setFont(font);
        jm2.setForeground(Color.BLUE);

        jm3.setFont(font);
        jm3.setForeground(Color.BLUE);
        jm4.setFont(font);
        jm4.setForeground(Color.BLUE);

        ch.add(jm1);
        ch.add(jm2);
        ch.add(jm3);
        ch.add(jm4);
        add(a,BorderLayout.NORTH);
        JLabel jLabel= new JLabel();

        add(jLabel);
        setVisible(true);
    }
}
