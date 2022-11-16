package com.xmc.ui.employeeAdmin;



import com.eltima.components.ui.DatePicker;
import com.mysql.cj.util.StringUtils;
import com.xmc.dao.EmployeeDao;
import com.xmc.dao.UserDao;
import com.xmc.pojo.AdminSginIn;
import com.xmc.pojo.Employee;
import com.xmc.pojo.User;
import com.xmc.ui.ForgetPassword;
import com.xmc.ui.SignUp;
import com.xmc.ui.employee.EmployeeHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

/*
 * 登陆界面视图
 */
public class BeginSginUp extends JFrame{



    public BeginSginUp(int adminId){

        final DatePicker datepick;
        final DatePicker datepick2;

        datepick = getDatePicker();
        datepick2 = getDatePicker();

        Font font=new Font("黑体",Font.BOLD,25);
        Font font2=new Font("华文楷体",Font.BOLD,24);
        setResizable(false);
        setTitle("发起签到");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(475, 200, 936, 762);
        setLayout(new BorderLayout(50,50));


        JLabel titelLabel=new JLabel("发起签到",JLabel.CENTER);
        titelLabel.setFont(font);

        JLabel jLabel1=new JLabel("活动名称：",JLabel.RIGHT);
        JTextArea jTextArea=new JTextArea(100,100);
        jLabel1.setFont(font);
        jTextArea.setFont(font2);

        JLabel jLabel2=new JLabel("开始时间：",JLabel.RIGHT);
        jLabel2.setFont(font);

        JLabel jLabel3=new JLabel("结束时间：",JLabel.RIGHT);
        jLabel3.setFont(font);





        JButton jButton1=new JButton("确认发起");
        JButton jButton2=new JButton("返回");


        jButton1.setFont(font);
        jButton2.setFont(font);
        jButton1.setForeground(Color.CYAN);
        jButton2.setForeground(Color.CYAN);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String signInName = jTextArea.getText();
                String beginTime = datepick.getText();
                String endTime = datepick2.getText();
                AdminSginIn adminSginIn = new AdminSginIn(adminId, 0, signInName, 0, beginTime, endTime);
                new UserDao().createSignIn(adminSginIn);
                JOptionPane.showMessageDialog(null, "创建活动成功!!");
                setVisible(false);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        JPanel jPanel1=new JPanel();
        JPanel jPanel2=new JPanel();
        JPanel jPanel3=new JPanel();
        JPanel jPanel4=new JPanel();





        //中间
        jPanel1.setLayout(new GridLayout(6,2,1,20));
        jPanel1.add(new JPanel());
        jPanel1.add(new JPanel());

        jPanel1.add(jLabel1);
        jPanel1.add(jTextArea);
        jPanel1.add(jLabel2);
        jPanel1.add(datepick);
        jPanel1.add(jLabel3);
        jPanel1.add(datepick2);



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

    private static DatePicker getDatePicker() {

        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(400, 300
        );

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);



//        datepick.setLocation(137, 83);//设置起始位置
        /*
        //也可用setBounds()直接设置大小与位置
//        datepick.setBounds(137, 83, 177, 24);
        */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CANADA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }


}

