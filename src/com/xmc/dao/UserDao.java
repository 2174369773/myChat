package com.xmc.dao;

import com.xmc.pojo.*;
import com.xmc.pojo.vo.SignInResult;
import com.xmc.utils.DBManager;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    DBManager dbManager = new DBManager();


    public User login(String userEmail, String userPassword){
        boolean res = false;
        StringBuilder sql = new StringBuilder("select * from tb_user where userEmail = '"
                +userEmail+"' and userPassword ='"+userPassword+"'" );
        System.out.println("select : "+ sql);
        ResultSet set = null;
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()) {
                User user = new User(set.getInt("id"),set.getString("userName"),
                       set.getString("userPassword"),set.getString("userEmail"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean checkIsValue(String userEmail){
        boolean res = false;
        StringBuilder sql = new StringBuilder(
                "select count(*) from tb_user where userEmail = '" +userEmail+"'"
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

    public boolean createUser(User user){
        StringBuilder sql = new StringBuilder("insert into tb_user values(");
        sql.append("null,"+
                "'"+user.getUserName()+"',"+
                "'"+user.getUserPassword()+"',"+
                "'"+user.getUserEmail()+"')"
        );
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public void updateUser(String userEmail, String reUserPassWord) {

        StringBuilder sql = new StringBuilder("update tb_user");
        sql.append(" set userPassword = '"+reUserPassWord+"'"+
                "where userEmail = '"+userEmail+"'");
        System.out.println("insert sql:"+sql.toString());
        try {
            dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean createSignIn(AdminSginIn adminSginIn){
        StringBuilder sql = new StringBuilder("insert into tb_signin values(");
        sql.append(adminSginIn.getAdminId()+","+"null,"+
                "'"+adminSginIn.getSignInName()+"',"+
                ""+adminSginIn.getCount()+","+
                "'"+adminSginIn.getCreatTime()+"',"+
                "'"+adminSginIn.getEndTime()+"')"
        );
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean createTakeUp(TakeOff takeOff){
        StringBuilder sql = new StringBuilder("insert into tb_take_off values(");
        sql.append(takeOff.getEmployeeNum()+","+ "null,"+
                ""+takeOff.getAdminId()+","+
                "'"+takeOff.getReason()+"',"+
                "'"+takeOff.getStatus()+"',"+
                "null,"+
                "'"+takeOff.getCreateTime()+"',"+
                "'"+takeOff.getEndTime()+"')"
        );
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public List<TakeOff> selectAllTakeOff(int adminId,int employeeNum, int takeOffId){

        List<TakeOff> takeOffList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from tb_take_off where 1=1 and adminId = " + adminId);
        if(employeeNum > 0){
            sql.append(" and `employeeNum` = "+employeeNum);
        }
        if(takeOffId > 0){
            sql.append(" and `takeOffId` = "+takeOffId);
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                TakeOff takeOff = new TakeOff(
                        set.getInt("employeeNum"),
                        set.getInt("takeOffId"),
                        set.getInt("adminId"),
                        set.getString("reason"),
                        set.getString("status"),
                        set.getString("remark"),
                        set.getString("createTime"),
                        set.getString("endTime")
                        );

                takeOffList.add(takeOff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return takeOffList;

    }



    public List<AdminSginIn> selectAllSignIn(int adminId,String text){

        List<AdminSginIn> adminSginInList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from tb_signin where 1=1 and adminId = " + adminId);
        if(text != null && !"".equals(text)){
            sql.append(" and `signInName` like '%"+text+"%'");
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                AdminSginIn adminSginIn = new AdminSginIn(
                        set.getInt("adminId"),
                        set.getInt("signInId"),
                        set.getString("signInName"),
                        set.getInt("count"),
                       set.getString("createTime"),
                        set.getString("endTime")
                     );

                adminSginInList.add(adminSginIn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminSginInList;

    }

    public List<SignInResult> employeeSignInList(int adminId){

        List<SignInResult> signInResults = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT te.employeeName,tes.signInTime,ts.signInName  FROM tb_employee te,tb_employee_signin tes ,tb_signin ts WHERE te.employeeNum = tes.employeeNum AND " +
                "tes.signInId = ts.signInId AND tes.adminId = "+ adminId);
        sql.append(" ORDER BY  ts.signInName");
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                SignInResult signInResult = new SignInResult(
                        set.getString("employeeName"),
                        set.getString("signInTime"),
                        set.getString("signInName")
                        );

                signInResults.add(signInResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signInResults;

    }


    public boolean createEmployeeSignIn(EmployeeSginIn employeeSginIn){
        StringBuilder sql = new StringBuilder("insert into tb_employee_signin values(");
        sql.append(employeeSginIn.getEmployeeNum()+","+ employeeSginIn.getAdminId()+","+employeeSginIn.getSignInId()+","+
                "'"+employeeSginIn.getSignInTime()+"')"
        );
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("主键不能重复");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public void updateSignUpCount(int adminId, int count,int signInId) {

        StringBuilder sql = new StringBuilder("update tb_signin");
        sql.append(" set count = "+count+
                " where adminId = "+adminId+" and signInId = "+signInId);
        System.out.println("insert sql:"+sql.toString());
        try {
            dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
