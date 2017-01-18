package com.tz.online.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_USER")
public class User {
    private Long userId; // ID标识

    @NotNull
    @Size(min=6,max=12,message="{user.username.invalid}")
    private String username;
    @NotNull
    @Size(min=6,max=12,message="{user.password.invalid}")
    private String password;
    @NotNull
    @Size(min=11,max=11,message="{user.tel.invalid}")
    private String tel;
    @NotNull
    @Size(min=6,max=20,message="{user.email.invalid}")
    private String email;
    @NotNull
    @Size(min=1,max=100,message="{user.address.invalid}")
    private String address;
    @NotNull
    @Size(min=1,max=100,message="{user.comparate.invalid}")
    private String comparate;

    public User() {
    }

    public User(String username, String password, String tel, String email, String address, String comparate) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.comparate = comparate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id")
    @SequenceGenerator(name = "user_id", sequenceName = "online_user_id", initialValue = 0, allocationSize = 1)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(length = 30, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 20, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 200, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(length = 100, nullable = false)
    public String getComparate() {
        return comparate;
    }

    public void setComparate(String comparate) {
        this.comparate = comparate;
    }

    @Column(length = 150, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 12, nullable = false)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", comparate='" + comparate + '\'' +
                '}';
    }
}
