package com.example.demo.Jl.personDao;

import java.util.Date;

public class scheduleDao {
    private int id;
    private String userId;
    private String time;
    private String content;
    private Date createTime;

    @Override
    public String toString() {
        return "scheduleDao{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
