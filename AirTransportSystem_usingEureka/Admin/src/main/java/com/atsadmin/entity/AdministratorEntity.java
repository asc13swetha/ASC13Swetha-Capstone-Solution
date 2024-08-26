package com.atsadmin.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Login")
public class AdministratorEntity {
    @Id
    @Column (name = "id")
    private Long id;
    @Column (name = "email_Id",nullable = false)
    private String emailId;
    @Column (name = "password",nullable = false)
    private String password;
    @Column (name = "phone_Number",nullable = false)
    private String phoneNumber;
    @Column (name = "failed_Attempts",nullable = false)
    private int failedAttempts;
    @Column (name = "last_Attempt_Time")
    private  LocalDateTime lastAttemptTime;
    @Column (name = "locked",nullable = false)
    private boolean locked=false;

    public AdministratorEntity(){

    }
    public AdministratorEntity(Long id, String emailId, String password, String phoneNumber, int failedAttempts, LocalDateTime lastAttemptTime, boolean locked){
        this.id=id;
        this.emailId=emailId;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.failedAttempts=failedAttempts;
        this.lastAttemptTime=lastAttemptTime;
        this.locked=locked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public LocalDateTime getLastAttemptTime() {
        return lastAttemptTime;
    }

    public void setLastAttemptTime(LocalDateTime lastAttemptTime) {
        this.lastAttemptTime = lastAttemptTime;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", failedAttempts=" + failedAttempts +
                ", lastAttemptTime=" + lastAttemptTime +
                ", locked=" + locked +
                '}';
    }
}

