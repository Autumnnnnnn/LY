package com.example.demo.Jl.personDao;

import java.util.Date;

public class collectionDao {
    private int id;
    private  String userId;
    private int scenicSpots;
    private int store;
    private Date createTime;

    @Override
    public String toString() {
        return "collectionDao{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", scenicSpots=" + scenicSpots +
                ", store=" + store +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getScenicSpots() {
        return scenicSpots;
    }

    public void setScenicSpots(int scenicSpots) {
        this.scenicSpots = scenicSpots;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
}
