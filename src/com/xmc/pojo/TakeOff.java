package com.xmc.pojo;

/**
 * @author 谢孟呈
 */
public class TakeOff {

    private int employeeNum;

    private int takeOffId;

    private int adminId;

    private String reason;

    private String status;

    private String remark;

    private String createTime;

    private String endTime;


    public TakeOff(int employeeNum, int takeOffId, int adminId, String reason, String status, String remark, String createTime, String endTime) {
        this.employeeNum = employeeNum;
        this.takeOffId = takeOffId;
        this.adminId = adminId;
        this.reason = reason;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public int getTakeOffId() {
        return takeOffId;
    }

    public void setTakeOffId(int takeOffId) {
        this.takeOffId = takeOffId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
