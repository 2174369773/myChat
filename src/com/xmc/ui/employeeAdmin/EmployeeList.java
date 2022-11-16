package com.xmc.ui.employeeAdmin;

import com.xmc.dao.EmployeeDao;
import com.xmc.pojo.Employee;
import com.xmc.utils.JTableUtils;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 谢孟呈
 */
public class EmployeeList extends JFrame {

    String valueAt = null;
    JButton jb=new JButton("查询");
    JButton jb1=new JButton("添加");
    JButton jb2=new JButton("编辑");
    JButton jb3=new JButton("删除");


    JLabel jLabel = new JLabel("员工姓名:",JLabel.RIGHT);
    JTable table;
    JTextField jt=new JTextField(50);
    JScrollPane sp=new JScrollPane();
    private EmployeeList employeeList;


    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

   public EmployeeList(int adminId){

       jb2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if (valueAt == null){
                   JOptionPane.showMessageDialog(null, "您还未选择员工!!");
                   return;
               }else {
                   Employee employee = new EmployeeDao().findByEmployeeNumber(valueAt,adminId);
                   new AddEmployee(employeeList, employee, adminId).setVisible(true);
                   return;
               }
           }
       });
       jb3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               if (valueAt == null){
                   JOptionPane.showMessageDialog(null, "您还未选择员工!!");
                   return;
               }
               int n = JOptionPane.showConfirmDialog(null, "确认删除该员工?", "确认删除",JOptionPane.YES_NO_OPTION); //返回值为0或1
               if (n == 0 ){
                   new EmployeeDao().delEmployee(valueAt,adminId);
                   JOptionPane.showMessageDialog(null, "删除成功!!");
                   search(adminId);
                   return;
               }
           }
       });
       jb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               search(adminId);
               jt.setText("");
               return;

           }
       });
       jb1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("进去选择!");
               System.out.println(employeeList);
               new AddEmployee(employeeList,null,adminId).setVisible(true);
               search(adminId);
               return;
           }
       });


        setVisible(true);
        System.out.println(adminId);
        search(adminId);
        setBounds(474, 99, 1136,770);
        JPanel jp=new JPanel();
        setResizable(false);
       jp.setLayout(new GridLayout(1,100,10,10));

        Font font=new Font("黑体",Font.BOLD,20);
        jt.setFont(font);
        jLabel.setFont(font);
        jb.setFont(font);
        jb1.setFont(font);
        jb2.setFont(font);
        jb3.setFont(font);
       jb3.setBackground(Color.RED);



        jp.add(jLabel);
        jp.add(jt);
        jp.add(jb);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(new JPanel());

        add(jp,BorderLayout.NORTH);
        add(new JPanel(),BorderLayout.SOUTH);
        add(new JPanel(),BorderLayout.EAST);
        add(new JPanel(),BorderLayout.WEST);
    }

    public  void search(int adminId) {
        DefaultTableModel model;
        remove(sp);
        List<Employee> all = new EmployeeDao().findAllEmployee(jt.getText(),adminId);
        String[] columeName= {"编号","职务","姓名","性别","年龄","教育经历","工资","工作电话","家庭电话","电话","qq号","住址"};
        if(all.size()==0) {
            model=new DefaultTableModel(columeName,1);
            table=new JTable(model);
            table.setBackground(Color.CYAN);
            sp=new JScrollPane(table);
            add(sp);
            validate();
            return ;
        }
        String[][] values= new String[all.size()][12];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] = String.valueOf(all.get(i).getEmployeeNum());
            values[i][1] = all.get(i).getPositions();
            values[i][2] =  all.get(i).getEmployeeName();
            values[i][3] =  all.get(i).getGender();
            values[i][4] =  String.valueOf(all.get(i).getAge());
            values[i][5] = all.get(i).getEducation();
            values[i][6] = String.valueOf(all.get(i).getSalary());
            values[i][7] = all.get(i).getWorkPhone();
            values[i][8] = all.get(i).getFamilyPhone();
            values[i][9] = all.get(i).getPhone();
            values[i][10] =String.valueOf(all.get(i).getQqNumber());
            values[i][11] = all.get(i).getAddress();


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

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                valueAt = (String) table.getValueAt(e.getFirstIndex(), 0);
                System.out.println(valueAt);
                return;

            }
        });
        //监听表格



    }
}
