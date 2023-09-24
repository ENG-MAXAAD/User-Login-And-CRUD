package com.example.shop;

import java.util.Date;

public class Customers {
    private int id;
    private String cusname ;
    private String cudgender ;
    private int mobile ;
    private String address ;
    private Date date ;

  public   Customers( int id , String cusname, String cudgender,  String address,Date date,  int mobile){
        this.id=id;
        this.cusname=cusname;
        this.cudgender=cudgender;
        this.address=address;
        this.date=date;
       this.mobile=mobile;
    }

    public Date getDate() {
        return date;
    }

    public int getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getCusname() {
        return cusname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public void setCudgender(String cudgender) {
        this.cudgender = cudgender;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCudgender() {
        return cudgender;
    }
}
