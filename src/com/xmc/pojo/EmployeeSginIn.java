package com.xmc.pojo;

public class EmployeeSginIn {

    private int employeeNum;

    private int adminId;

    private int signInId;

    private String signInTime;

    public EmployeeSginIn(int employeeNum, int adminId, int signInId, String signInTime) {
        this.employeeNum = employeeNum;
        this.adminId = adminId;
        this.signInId = signInId;
        this.signInTime = signInTime;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getSignInTime() {
        return signInTime;
    }


    public void setSignInTime(String signInTime) {
        this.signInTime = signInTime;
    }

    public int getSignInId() {
        return signInId;
    }

    public void setSignInId(int signInId) {
        this.signInId = signInId;
    }
}
