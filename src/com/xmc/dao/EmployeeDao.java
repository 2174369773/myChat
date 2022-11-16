package com.xmc.dao;

import com.xmc.pojo.Employee;
import com.xmc.pojo.User;
import com.xmc.utils.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    //数据库驱动对象
    DBManager dbManager = new DBManager();

    //登录成功后，对全部员工信息就行回显
    public List<Employee> findAllEmployee(String text,int adminId) {
        List<Employee> employeeList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from tb_employee where 1=1 and adminId = " + adminId);
        if(text != null && !"".equals(text)){
            sql.append(" and employeeName like '%"+text+"%'");
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Employee employee = new Employee(
                        set.getInt("adminId"),
                        set.getInt("employeeNum"),
                        set.getString("positions"),
                        set.getString("employeeName"),
                        set.getString("gender"),
                        set.getInt("age"),
                        set.getString("education"),
                        set.getString("salary"),
                        set.getString("workPhone"),
                        set.getString("familyPhone"),
                        set.getString("phone"),
                        set.getLong("qqNumber"),
                        set.getString("qqEmail"),
                        set.getString("passWord"),
                        set.getString("address"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    //添加员工信息
    public boolean createEmpolyee(Employee employee,int adminId) {

        StringBuilder sql = new StringBuilder("insert into tb_employee values(");
        sql.append(employee.getEmployeeNum()+",'"+employee.getPositions()+"',"+
                "'"+employee.getEmployeeName()+"',"+
                "'"+employee.getGender()+"',"+employee.getAge()+
                ",'"+employee.getEducation()+"','"+employee.getSalary()+
                 "','"+employee.getWorkPhone()+"',"+
                 "'"+employee.getFamilyPhone()+"',"+
                 "'"+employee.getPhone()+"',"+employee.getQqNumber()+
                 ",'"+employee.getPassword()+"',"+
                "'"+employee.getQqEmail()+"',"+
                "'"+employee.getAddress()+"'," +adminId+")");

        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除员工信息
    public boolean delEmployee(String valueAt,int adminId) {

        StringBuilder sql = new StringBuilder("delete from tb_employee where adminId ="+adminId+" and employeeNum = "+ valueAt);

        System.out.println("delete sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //通过员工id就行查询员工id，达到更新回显效果
    public Employee findByEmployeeNumber(String valueAt,int adminId) {

        StringBuilder sql = new StringBuilder("select * from tb_employee where 1=1 and adminId ="+adminId);
        if(valueAt != null && !"".equals(valueAt)){
            sql.append(" and employeeNum = "+valueAt);
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Employee employee = new Employee(
                        set.getInt("adminId"),
                        set.getInt("employeeNum"),
                        set.getString("positions"),
                        set.getString("employeeName"),
                        set.getString("gender"),
                        set.getInt("age"),
                        set.getString("education"),
                        set.getString("salary"),
                        set.getString("workPhone"),
                        set.getString("familyPhone"),
                        set.getString("phone"),
                        set.getLong("qqNumber"),
                        set.getString("qqEmail"),
                        set.getString("passWord"),
                        set.getString("address"));

                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee empolyeeLogin(String userEmail,String userPassWord) {

        StringBuilder sql = new StringBuilder("select * from tb_employee where 1=1 and qqEmail ='"+userEmail);
        sql.append("' and passWord = '"+userPassWord+"'");
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Employee employee = new Employee(
                        set.getInt("adminId"),
                        set.getInt("employeeNum"),
                        set.getString("positions"),
                        set.getString("employeeName"),
                        set.getString("gender"),
                        set.getInt("age"),
                        set.getString("education"),
                        set.getString("salary"),
                        set.getString("workPhone"),
                        set.getString("familyPhone"),
                        set.getString("phone"),
                        set.getLong("qqNumber"),
                        set.getString("qqEmail"),
                        set.getString("passWord"),
                        set.getString("address")
                );

                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查看邮箱是否重复注册
    public boolean checkIsValue(String employeeEmail){
        boolean res = false;
        StringBuilder sql = new StringBuilder(
                "select count(*) from tb_employee where qqEmail = '" +employeeEmail+"@qq.com"+"'"
        );
        System.out.println("select : "+ sql);
        ResultSet set = null;
        try {
            set = dbManager.executeQuery(sql.toString());
            set.next();
            if(set.getInt(1)>0){
                System.out.println(set.getInt(1));
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
}
