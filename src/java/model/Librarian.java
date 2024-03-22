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
public class Librarian {
//    CREATE TABLE Librarian (
//    [LibrarianId] INT PRIMARY KEY,
//    [FullName] VARCHAR(255),
//    [DateOfBirth] DATE,
//    [PhoneNumber] VARCHAR(20),
//    [Email] VARCHAR(255)
//);
    private int librarianId;
    private String fullNameLibrarian;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;

    public Librarian() {
    }

    public Librarian(int librarianId, String fullNameLibrarian, Date dateOfBirth, String phoneNumber, String email) {
        this.librarianId = librarianId;
        this.fullNameLibrarian = fullNameLibrarian;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
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

    public String getFullNameLibrarian() {
        return fullNameLibrarian;
    }

    public void setFullNameLibrarian(String fullNameLibrarian) {
        this.fullNameLibrarian = fullNameLibrarian;
    }

    @Override
    public String toString() {
        return "Librarian{" + "librarianId=" + librarianId + ", fullNameLibrarian=" + fullNameLibrarian + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }

    
}
