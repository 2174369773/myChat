package com.xmc.pojo;


public class Employee {

    private int adminId;

    private int employeeNum;

    private String positions;

    private String employeeName;

    private String gender;

    private int age;

    private String education;

    private String salary;

    private String workPhone;

    private String familyPhone;

    private String phone;

    private Long qqNumber;

    private String qqEmail;

    private String password;

    private String address;

    public Employee(int adminId,int employeeNum, String positions, String employeeName, String gender, int age, String education, String salary, String workPhone, String familyPhone, String phone, Long qqNumber, String qqEmail, String password, String address) {

        this.adminId = adminId;
        this.employeeNum = employeeNum;
        this.positions = positions;
        this.employeeName = employeeName;
        this.gender = gender;
        this.age = age;
        this.education = education;
        this.salary = salary;
        this.workPhone = workPhone;
        this.familyPhone = familyPhone;
        this.phone = phone;
        this.qqNumber = qqNumber;
        this.qqEmail = qqEmail;
        this.password = password;
        this.address = address;
    }


    public String getQqEmail() {
        return qqEmail;
    }

    public void setQqEmail(String qqEmail) {
        this.qqEmail = qqEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Long qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "adminId=" + adminId +
                ", employeeNum=" + employeeNum +
                ", positions='" + positions + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", salary='" + salary + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", familyPhone='" + familyPhone + '\'' +
                ", phone='" + phone + '\'' +
                ", qqNumber=" + qqNumber +
                ", qqEmail='" + qqEmail + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
