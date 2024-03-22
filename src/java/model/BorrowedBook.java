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
public class BorrowedBook {
//    CREATE TABLE BorrowedBook (
//    [BorrowId] INT PRIMARY KEY,
//    [BorrowDate] DATE,
//    [ReturnStatus] VARCHAR(10),
//    [ReturnDate] DATE,
//    [BookSttBefore] VARCHAR(255),
//    [BookSttAfter] VARCHAR(255),
//    [NumberOfFlag] INT,
//    [TotalFine] FLOAT,
//    [Paid] VARCHAR,
//    [LibrarianId] INT,
//    [ReaderId] INT,
//    [BookId] INT,
//    FOREIGN KEY ([LibrarianId]) REFERENCES Librarian([LibrarianId]),
//    FOREIGN KEY ([ReaderId]) REFERENCES Reader([ReaderId]),
//    FOREIGN KEY ([BookId]) REFERENCES Book([BookId])
//);
    
    private int borrowId;
    private Date borrowDate;
    private String returnStatus;
    private Date returnDate;
    private String bookSttBefore;
    private String bookSttAfter;
    private int numberOfFlag;
    private float totalFine;
//    private String paidFine; ko xét tới nữa
    private int librarianId;
    private int readerId;
    private int bookId;
    
    private String bookName;
    private String versionInLibrary;
    private String readerName;
    private String librarianName;
    
    public BorrowedBook() {
    }

    public BorrowedBook(int bookId, String bookName, String versionInLibrary, String readerName, String librarianName, Date borrowDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.versionInLibrary = versionInLibrary;
        this.readerName = readerName;
        this.librarianName = librarianName;
        this.borrowDate = borrowDate;
    }
    
    public BorrowedBook(int borrowId, Date borrowDate, String returnStatus, Date returnDate, String bookSttBefore, String bookSttAfter, int numberOfFlag, float totalFine, int librarianId, int readerId, int bookId) {
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.returnStatus = returnStatus;
        this.returnDate = returnDate;
        this.bookSttBefore = bookSttBefore;
        this.bookSttAfter = bookSttAfter;
        this.numberOfFlag = numberOfFlag;
        this.totalFine = totalFine;
//        this.paidFine = paidFine;
        this.librarianId = librarianId;
        this.readerId = readerId;
        this.bookId = bookId;
    }

    public BorrowedBook(int bookId, Date borrowDate, Date returnDate, String returnStatus) {
    this.bookId = bookId;
    this.borrowDate = borrowDate;
    this.returnDate = returnDate;
    this.returnStatus = returnStatus;
}
    
    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    

//    public String getPaidFine() {
//        return paidFine;
//    }
//
//    public void setPaidFine(String paidFine) {
//        this.paidFine = paidFine;
//    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookSttBefore() {
        return bookSttBefore;
    }

    public void setBookSttBefore(String bookSttBefore) {
        this.bookSttBefore = bookSttBefore;
    }

    public String getBookSttAfter() {
        return bookSttAfter;
    }

    public void setBookSttAfter(String bookSttAfter) {
        this.bookSttAfter = bookSttAfter;
    }

    public int getNumberOfFlag() {
        return numberOfFlag;
    }

    public void setNumberOfFlag(int numberOfFlag) {
        this.numberOfFlag = numberOfFlag;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public float getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(float totalFine) {
        this.totalFine = totalFine;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getVersionInLibrary() {
        return versionInLibrary;
    }

    public void setVersionInLibrary(String versionInLibrary) {
        this.versionInLibrary = versionInLibrary;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" + "borrowId=" + borrowId + ", borrowDate=" + borrowDate + ", returnStatus=" + returnStatus + ", returnDate=" + returnDate + ", bookSttBefore=" + bookSttBefore + ", bookSttAfter=" + bookSttAfter + ", numberOfFlag=" + numberOfFlag + ", totalFine=" + totalFine + ", librarianId=" + librarianId + ", readerId=" + readerId + ", bookId=" + bookId + ", bookName=" + bookName + ", versionInLibrary=" + versionInLibrary + ", readerName=" + readerName + ", librarianName=" + librarianName + '}';
    }

  

}
