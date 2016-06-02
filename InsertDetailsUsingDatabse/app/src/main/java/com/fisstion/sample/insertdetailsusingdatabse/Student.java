package com.fisstion.sample.insertdetailsusingdatabse;

/**
 * Created by alekhya on 31/5/16.
 */
public class Student {
    String stuName;
    String stuPhoneNumber;
    String stuBranch;

    //creating the constructor
    public Student(String stuName,String stuBranch,String stuPhoneNumber){

      this.stuName=stuName;
      this.stuPhoneNumber=stuPhoneNumber;
      this.stuBranch=stuBranch;
    }


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPhoneNumber() {
        return stuPhoneNumber;
    }

    public void setStuPhoneNumber(String stuPhoneNumber) {
        this.stuPhoneNumber = stuPhoneNumber;
    }

    public String getStuBranch() {
        return stuBranch;
    }

    public void setStuBranch(String stuBranch) {
        this.stuBranch = stuBranch;
    }







}
