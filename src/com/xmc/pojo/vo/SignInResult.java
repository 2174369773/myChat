package com.xmc.pojo.vo;

public class SignInResult {

    private String employeeName;

    private String signInTime;

    private String signInName;

    public SignInResult(String employeeName, String signInTime, String signInName) {
        this.employeeName = employeeName;
        this.signInTime = signInTime;
        this.signInName = signInName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(String signInTime) {
        this.signInTime = signInTime;
    }

    public String getSignInName() {
        return signInName;
    }

    public void setSignInName(String signInName) {
        this.signInName = signInName;
    }
}
