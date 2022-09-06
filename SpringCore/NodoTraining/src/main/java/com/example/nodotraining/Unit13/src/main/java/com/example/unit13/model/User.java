package com.example.unit13.model;
import javax.persistence.*;

@Entity
@Table(name = "Haint_User",uniqueConstraints = {@UniqueConstraint(columnNames ="username")})
public class User {
    @Id
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private int age;


    public User(String username, String password, String email, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public User() {
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
}