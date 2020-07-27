package com.example.demo.Jl.personDao;

import java.util.Date;

public class shopDao {
    private int id;
    private String name;
    private String photogreph;
    private int type;
    private String address;
    private String introduce;
    private double price;
    private String grade;
    private Date checkintime;
    private Date departuretime;

    @Override
    public String toString() {
        return "shopDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photogreph='" + photogreph + '\'' +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", introduce='" + introduce + '\'' +
                ", price=" + price +
                ", grade='" + grade + '\'' +
                ", checkintime=" + checkintime +
                ", departuretime=" + departuretime +
                '}';
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

    public String getPhotogreph() {
        return photogreph;
    }

    public void setPhotogreph(String photogreph) {
        this.photogreph = photogreph;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }
}
