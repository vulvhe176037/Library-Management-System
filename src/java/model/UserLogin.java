/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author User
 */
public class UserLogin {
//    CREATE TABLE UserLogin (
//    [UserID] INT PRIMARY KEY NOT NULL,
//    [AccountName] VARCHAR(50) NOT NULL,
//    [Password] VARCHAR(100) NOT NULL,
//    [FullName] VARCHAR(255),
//    [Email] VARCHAR(100) NOT NULL,
//    [PhoneNumber] VARCHAR(20) NOT NULL,
//    [CreatedDate] DATE NOT NULL,
//    [DateOfBirth] DATE, 
//    [AccessLevel] VARCHAR(20)
//);
    private int userId;
    private String accountName;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Date createdDate;
    private String accessLevel;

    public UserLogin() {
    }

    public UserLogin(int userId, String accountName, String password, String fullName, String email, String phoneNumber, Date dateOfBirth, Date createdDate, String accessLevel) {
        this.userId = userId;
        this.accountName = accountName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = createdDate;
        this.accessLevel = accessLevel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    
    
    @Override
    public String toString() {
        return "UserLogin{" + "userId=" + userId + ", accountName=" + accountName + ", password=" + password + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate + ", dateOfBirth=" + dateOfBirth + ", accessLevel=" + accessLevel + '}';
    }

    
}
