package org.example.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private String branch;
    private String mobile;
    private double totalFee;
    private double paidFee;
    private double dueFee;
    private String feeStatus;

    public Student(int id, String name, int age, String course, String email, String branch, String mobile,double totalFee,
                   double paidFee,
                   double dueFee,
                   String feeStatus) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.branch= branch;
        this.mobile= mobile;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.dueFee = dueFee;
        this.feeStatus = feeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBranch(){
        return branch;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }

    public String getMobile(){
        return  mobile;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(double paidFee) {
        this.paidFee = paidFee;
    }

    public double getDueFee() {
        return dueFee;
    }

    public void setDueFee(double dueFee) {
        this.dueFee = dueFee;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", mobile='" + mobile + '\'' +
                ", totalFee=" + totalFee +
                ", paidFee=" + paidFee +
                ", dueFee=" + dueFee +
                ", feeStatus='" + feeStatus + '\'' +
                '}';
    }
}
