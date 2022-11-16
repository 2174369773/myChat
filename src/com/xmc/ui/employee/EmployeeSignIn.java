package com.xmc.ui.employee;

import com.eltima.components.ui.DatePicker;
import com.xmc.dao.EmployeeDao;
import com.xmc.dao.UserDao;
import com.xmc.pojo.AdminSginIn;
import com.xmc.pojo.Employee;
import com.xmc.pojo.EmployeeSginIn;
import com.xmc.ui.employeeAdmin.AddEmployee;
import com.xmc.ui.employeeAdmin.EmployeeList;
import com.xmc.utils.DateUtil;
import com.xmc.utils.JTableUtils;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author 谢孟呈
 */
public class EmployeeSignIn extends JFrame {


    String valueAt = null;
    String endTime = null;
    String count = null;
    JButton jb=new JButton("查询");
    JButton jb1=new JButton("确认签到");
    JLabel jLabel = new JLabel("活动名称:",JLabel.RIGHT);
    JTable table;
    JTextField jt=new JTextField(50);
    JScrollPane sp=new JScrollPane();


    public EmployeeSignIn(Employee employee){

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(employee.getAdminId());
                jt.setText("");
                return;

            }
        });
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(endTime);
                System.out.println(DateUtil.getCurrentTime());
                if (DateUtil.dateSubtraction(DateUtil.getCurrentTime(),String.valueOf(endTime)) < 0 ){
                    JOptionPane.showMessageDialog(null, "签到时间已经过了!!!");
                    return;
                }
                boolean isSuccess = new UserDao().createEmployeeSignIn(new EmployeeSginIn(
                            employee.getEmployeeNum(),
                            employee.getAdminId(),
                            Integer.parseInt(valueAt),
                            DateUtil.getCurrentTime()));
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, "活动签到成功!!");
                    new UserDao().updateSignUpCount(employee.getAdminId(),Integer.parseInt(count)+1,Integer.parseInt(valueAt));
                    search(employee.getAdminId());
                }else {
                    JOptionPane.showMessageDialog(null, "不可重复签到!!");

                }

            }
        });


        setVisible(true);
        search(employee.getAdminId());
        setBounds(474, 99, 1136,770);
        JPanel jp=new JPanel();
        setResizable(false);
        jp.setLayout(new GridLayout(1,100,10,10));

        Font font=new Font("黑体",Font.BOLD,20);

        jb.setFont(font);
        jb1.setFont(font);

        jp.add(jLabel);
        jLabel.setFont(font);
        jp.add(jt);
        jp.add(jb);
        jp.add(jb1);
        jp.add(new JPanel());

        add(jp,BorderLayout.NORTH);
        add(new JPanel(),BorderLayout.SOUTH);
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
    }

    public  void search(int adminId) {
        DefaultTableModel model;
        remove(sp);
        List<AdminSginIn> all = new UserDao().selectAllSignIn(adminId, jt.getText());
        System.out.println(all);
        String[] columeName = {"活动id","活动名称", "活动开始时间", "活动结束时间","目前签到人数"};
        if (all.size() == 0) {
            model = new DefaultTableModel(columeName, 1);
            table = new JTable(model);
            table.setBackground(Color.CYAN);
            sp = new JScrollPane(table);
            add(sp);
            validate();
            return;
        }
        String[][] values = new String[all.size()][5];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] = String.valueOf(all.get(i).getSignInId());
            values[i][1] = all.get(i).getSignInName();
            values[i][2] = all.get(i).getCreatTime();
            values[i][3] = all.get(i).getEndTime();
            values[i][4] = String.valueOf(all.get(i).getCount());

        }
        model = new DefaultTableModel(values, columeName);
        table = new JTable(model);
        Font font = new Font("黑体", Font.BOLD, 20);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        JTableUtils.setTableStyle(table);
        table.setBackground(Color.CYAN);
        sp = new JScrollPane(table);
        add(sp);
        validate();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                endTime = null;
                valueAt =null;
                count = null;
                valueAt = (String) table.getValueAt(e.getFirstIndex(), 0);
                endTime = (String) table.getValueAt(e.getFirstIndex(), 3);
                count = (String) table.getValueAt(e.getFirstIndex(), 4);


                System.out.println(valueAt);
                return;

            }
        });
        //监听表格
    }


}