package com.xmc.pojo;

public class AdminSginIn {

    private int adminId;

    private int signInId;

    private String signInName;

    public int count;

    private String creatTime;

    private String endTime;

    public AdminSginIn(int adminId, int signInId, String signInName, int count, String creatTime, String endTime) {
        this.adminId = adminId;
        this.signInId = signInId;
        this.signInName = signInName;
        this.count = count;
        this.creatTime = creatTime;
        this.endTime = endTime;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getSignInId() {
        return signInId;
    }

    public void setSignInId(int signInId) {
        this.signInId = signInId;
    }

    public String getSignInName() {
        return signInName;
    }

    public void setSignInName(String signInName) {
        this.signInName = signInName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AdminSginIn{" +
                "adminId=" + adminId +
                ", signInId=" + signInId +
                ", signInName='" + signInName + '\'' +
                ", count=" + count +
                ", creatTime='" + creatTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
