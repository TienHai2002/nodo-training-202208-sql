package edu.hanoi.service.model;

public class User {
    private String username;
    private String password;
    private String email;
    private int age;
    private int groupId;

    public User() {
    }

    public User(String username, String password, String email, int age, int groupId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
