package com.example.demo.Jl.util.utilDao;

public class EmailDao {
    private String toUser;//用户邮箱
    private String type; //发送邮件的目的
    private String title;//标题
    private String content;//内容

    @Override
    public String toString() {
        return "EmailDao{" +
                "toUser='" + toUser + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
