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
public class Reader {
//    CREATE TABLE Reader (
//    [ReaderId] INT PRIMARY KEY,
//    [FullName] VARCHAR(255),
//    [DateOfBirth] DATE,
//    [PhoneNumber] VARCHAR(20),
//    [Email] VARCHAR(255)
 //   [numberOfBooksBorrowed] int,
 //   [numberOfBooksReturned] int
//);
    private int readerId;
    private String fullNameReader;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private int numberOfBooksBorrowed;
    private int numberOfBooksReturned;

    public Reader() {
    }

    public Reader(int readerId, String fullNameReader, Date dateOfBirth, String phoneNumber, String email, int numberOfBooksBorrowed, int numberOfBooksReturned) {
        this.readerId = readerId;
        this.fullNameReader = fullNameReader;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
        this.numberOfBooksReturned = numberOfBooksReturned;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getFullNameReader() {
        return fullNameReader;
    }

    public void setFullNameReader(String fullNameReader) {
        this.fullNameReader = fullNameReader;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfBooksBorrowed() {
        return numberOfBooksBorrowed;
    }

    public void setNumberOfBooksBorrowed(int numberOfBooksBorrowed) {
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
    }

    public int getNumberOfBooksReturned() {
        return numberOfBooksReturned;
    }

    public void setNumberOfBooksReturned(int numberOfBooksReturned) {
        this.numberOfBooksReturned = numberOfBooksReturned;
    }

    @Override
    public String toString() {
        return "Reader{" + "readerId=" + readerId + ", fullNameReader=" + fullNameReader + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", email=" + email + ", numberOfBooksBorrowed=" + numberOfBooksBorrowed + ", numberOfBooksReturned=" + numberOfBooksReturned + '}';
    }


}
