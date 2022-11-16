package com.xmc.ui.employeeAdmin;

import com.xmc.dao.EmployeeDao;
import com.xmc.dao.UserDao;
import com.xmc.pojo.Employee;
import com.xmc.pojo.vo.SignInResult;
import com.xmc.utils.JTableUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 谢孟呈
 */
public class SignInList extends JFrame {


    JTable table;

    JScrollPane sp=new JScrollPane();



   public SignInList(int adminId){


        setVisible(true);
        System.out.println(adminId);
        search(adminId);
        setBounds(474, 99, 1136,770);
        JPanel jp=new JPanel();
        setResizable(false);
       jp.setLayout(new GridLayout(1,1,10,10));

        Font font=new Font("黑体",Font.BOLD,20);



        jp.add(new JPanel());

        add(jp,BorderLayout.NORTH);
        add(new JPanel(),BorderLayout.SOUTH);
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
    }

    public  void search(int adminId) {
        DefaultTableModel model;

        remove(sp);
        List<SignInResult> all = new UserDao().employeeSignInList(adminId);
        String[] columeName= {"员工名称","签到时间","活动名称"};
        if(all.size()==0) {
            model=new DefaultTableModel(columeName,1);
            table=new JTable(model);
            table.setBackground(Color.CYAN);
            sp=new JScrollPane(table);
            add(sp);
            validate();
            return ;
        }
        String[][] values= new String[all.size()][3];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] =all.get(i).getEmployeeName();
            values[i][1] = all.get(i).getSignInTime();
            values[i][2] =  all.get(i).getSignInName();
        }
        model=new DefaultTableModel(values,columeName);
        table=new JTable(model);
        Font font = new Font("黑体", Font.BOLD, 20);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        JTableUtils.setTableStyle(table);
        table.setBackground(Color.CYAN);
        sp=new JScrollPane(table);
        add(sp);
        validate();

    }
}
