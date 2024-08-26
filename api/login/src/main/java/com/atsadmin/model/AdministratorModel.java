package com.atsadmin.model;

import java.time.LocalDateTime;

public class AdministratorModel {
        private Long id;
        private String emailId;
        private String password;
        private String phoneNumber;
        private int failedAttempts;
        private LocalDateTime lastAttemptTime;
        private boolean locked;

        public AdministratorModel(){

        }
        public AdministratorModel(Long id, String emailId, String password, String phoneNumber,int failedAttempts, LocalDateTime lastAttemptTime, boolean locked){
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
