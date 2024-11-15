package com.hrk.entity;

public class Student {
    private String stuName;
    private Integer stuId;
    private Integer stuClass;
    private Integer stuGrade;
    private String stuMajor;

    public Student() {

    }

    public Integer getStuGrade() {
        return stuGrade;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public void setStuGrade(Integer stuGrade) {
        this.stuGrade = stuGrade;
    }

    public Integer getStuClass() {
        return stuClass;
    }

    public void setStuClass(Integer stuClass) {
        this.stuClass = stuClass;
    }



    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuId=" + stuId +
                ", stuClass=" + stuClass +
                ", stuGrade=" + stuGrade +
                ", stuMajor='" + stuMajor + '\'' +
                '}';
    }
}
