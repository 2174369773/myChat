package com.xmc.ui.employee;

import com.xmc.dao.EmployeeDao;
import com.xmc.pojo.Employee;
import com.xmc.ui.employeeAdmin.EmployeeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 谢孟呈
 */
public class ToSignUp extends JFrame {


    JButton jb1=new JButton("确认注册");
    JButton jb2=new JButton("关闭");

    JPanel jp1=new JPanel();
    JPanel jp2=new JPanel();
    JPanel jp3=new JPanel();
    JPanel jp4=new JPanel();
    JComboBox cmb=new JComboBox();



    JTextField jt=new JTextField();
    JTextField jt1=new JTextField();
    JTextField jt2=new JTextField();
    JTextField jt3=new JTextField();
    JTextField jt5=new JTextField();
    JTextField jt6=new JTextField();
    JTextField jt7=new JTextField();
    JTextField jt8=new JTextField();
    JTextField jt9=new JTextField();
    JTextField jt10=new JTextField();
    JTextField jt11=new JTextField();
    JTextField jt12=new JTextField();


    public ToSignUp() {

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    String gender = cmb.getSelectedIndex() == 1 ? "女" : "男";
                    Employee employee = new Employee(
                            Integer.parseInt(jt.getText()),
                            Integer.parseInt(jt1.getText()),
                            jt2.getText(),
                            jt3.getText(),
                            gender,
                            Integer.parseInt(jt5.getText()),
                            jt6.getText(),
                            jt7.getText(),
                            jt8.getText(),
                            jt9.getText(),
                            jt10.getText(),
                            Long.parseLong(jt11.getText()),
                            jt11.getText()+"@qq.com",
                            "abc123",
                            jt12.getText()
                    );
                    if (!new EmployeeDao().checkIsValue(jt11.getText())) {
                        boolean isSuccess = new EmployeeDao().createEmpolyee(employee, Integer.parseInt(jt.getText()));
                        if (isSuccess) {
                            JOptionPane.showMessageDialog(null, "注册成功!!");
                            setVisible(false);
                            return;
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "该邮箱已经注册过了!!");
                        jt11.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请输入完整信息!!");
                }
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                return;

            }
        });

        setResizable(false);
        setTitle("员工注册");
        Font font=new Font("黑体",Font.BOLD,25);
        setLayout(new BorderLayout(50,50));
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
        add(new JPanel(),BorderLayout.NORTH);
        setBounds(489, 108, 1136,770);

        JLabel titelLabel=new JLabel("员工注册",JLabel.CENTER);
        titelLabel.setFont(font);

        jp1.setLayout(new GridLayout(7,2,5,10));
        JLabel jl=new JLabel("管理员编号：",JLabel.RIGHT);
        jt.setFont(font);
        jl.setFont(font);
        JLabel jl1=new JLabel("编号：",JLabel.RIGHT);
        jl1.setFont(font);
        JLabel jl2=new JLabel("职务：",JLabel.RIGHT);
        jl2.setFont(font);
        JLabel jl3=new JLabel("姓名：",JLabel.RIGHT);
        jl3.setFont(font);
        JLabel jl4=new JLabel("性别：",JLabel.RIGHT);
        jl4.setFont(font);
        JLabel jl5=new JLabel("年龄：",JLabel.RIGHT);
        jl5.setFont(font);
        JLabel jl6=new JLabel("教育经历：",JLabel.RIGHT);
        jl6.setFont(font);
        JLabel jl7=new JLabel("工资：",JLabel.RIGHT);
        jl7.setFont(font);
        JLabel jl8=new JLabel("工作电话：",JLabel.RIGHT);
        jl8.setFont(font);
        JLabel jl9=new JLabel("家庭电话：",JLabel.RIGHT);
        jl9.setFont(font);
        JLabel jl10=new JLabel("电话：",JLabel.RIGHT);
        jl10.setFont(font);
        JLabel jl11=new JLabel("QQ：",JLabel.RIGHT);
        jl11.setFont(font);
        JLabel jl12=new JLabel("住址：",JLabel.RIGHT);
        jl12.setFont(font);
        cmb.addItem("---请选择---");    //向下拉列表中添加一项
        cmb.addItem("女");
        cmb.addItem("男");
        cmb.setFont(font);



        jp1.add(jl);
        jp1.add(jt);
        jp1.setFont(font);

        jp1.add(jl1);
        jp1.add(jt1);
        jt1.setFont(font);


        jp1.add(jl2);
        jp1.add(jt2);
        jt2.setFont(font);

        jp1.add(jl3);
        jp1.add(jt3);
        jt3.setFont(font);

        jp1.add(jl4);
        jp1.add(cmb);

        jp1.add(jl5);
        jp1.add(jt5);
        jt5.setFont(font);

        jp1.add(jl6);
        jp1.add(jt6);
        jt6.setFont(font);

        jp1.add(jl7);
        jp1.add(jt7);
        jt7.setFont(font);

        jp1.add(jl8);
        jp1.add(jt8);
        jt8.setFont(font);

        jp1.add(jl9);
        jp1.add(jt9);
        jt9.setFont(font);

        jp1.add(jl10);
        jp1.add(jt10);
        jt10.setFont(font);

        jp1.add(jl11);
        jp1.add(jt11);
        jt11.setFont(font);

        jp1.add(jl12);
        jp1.add(jt12);
        jt12.setFont(font);


        jp3.setLayout(new BorderLayout(50,50));
        jp2.setLayout(new GridLayout(1,1,50,5));
        jb1.setForeground(Color.CYAN);
        jb1.setFont(font);

        jb2.setForeground(Color.CYAN);
        jb2.setFont(font);


        //标题
        jp4.setLayout(new GridLayout(3,2));
        jp4.add(new JPanel());
        jp4.add(titelLabel);

        jp3.add(new JPanel(),BorderLayout.SOUTH);
        jp3.add(new JPanel(),BorderLayout.EAST);
        jp3.add(new JPanel(),BorderLayout.WEST);
        jp3.add(new JPanel(),BorderLayout.NORTH);
        jp3.add(jp2);

        jp2.add(jb1);
        jp2.add(jb2);

        add(jp4,BorderLayout.NORTH);
        add(jp1);
        add(jp3,BorderLayout.SOUTH);
        setVisible(true);


    }

    public boolean check(){
        if(
                "".equals(jt.getText().trim()) ||
                 "".equals(jt1.getText().trim()) ||
                "".equals(jt2.getText().trim()) ||
                "".equals(jt3.getText().trim()) ||
                "".equals(jt5.getText().trim()) ||
                "".equals(jt6.getText().trim()) ||
                "".equals(jt7.getText().trim()) ||
                "".equals(jt8.getText().trim()) ||
                "".equals(jt9.getText().trim()) ||
                "".equals(jt10.getText().trim()) ||
                "".equals(jt11.getText().trim()) ||
                "".equals(jt12.getText().trim()) ||
                (cmb.getSelectedIndex()==0)){
            return false;
        }
        return true;
    }
}
