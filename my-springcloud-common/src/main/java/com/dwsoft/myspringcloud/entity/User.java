package com.dwsoft.myspringcloud.entity;

/**
 * @author tlk
 * @date 2020/7/13-13:43
 */
public class User {
    private Integer userId;
    private String  userName;
    private String  email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(Integer userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
