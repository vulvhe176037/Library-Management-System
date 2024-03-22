/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import model.Book;
import model.BorrowedBook;
import model.Reader;
/**
 *
 * @author User
 */
public class Book_Reader_Borrowed_Collapse {
//            SELECT Reader.readerId, Reader.fullName, Book.BookID, Book.BookName, BorrowedBook.BorrowDate, BorrowedBook.ReturnStatus, BorrowedBook.ReturnDate
//            FROM Book
//            JOIN Borrowing ON Book.BookID = Borrowing.BookID
//            JOIN Reader ON Borrowing.ReaderID = Reader.ReaderID
//            WHERE Reader.ReaderName LIKE 'Emma%'  
    private int readerId;
    private String fullNameReader;
    private int bookId;
    private String bookName;
    private Date BorrowDate;
    private String ReturnStatus;
    private Date ReturnDate;
    private Book bookObj;
    private BorrowedBook borBookObj;
    private Reader readerObj;

    public Book_Reader_Borrowed_Collapse() {
    }

    public Book_Reader_Borrowed_Collapse(int readerId, String fullNameReader, int bookId, String bookName, Date BorrowDate, String ReturnStatus, Date ReturnDate) {
        this.readerId = readerId;
        this.fullNameReader = fullNameReader;
        this.bookId = bookId;
        this.bookName = bookName;
        this.BorrowDate = BorrowDate;
        this.ReturnStatus = ReturnStatus;
        this.ReturnDate = ReturnDate;
    }

    public Book_Reader_Borrowed_Collapse(String fullName) {
        this.readerId = readerObj.getReaderId();
        this.fullNameReader = readerObj.getFullNameReader();
        this.bookId = bookObj.getBookId();
        this.bookName = bookObj.getBookName();
        this.BorrowDate = borBookObj.getBorrowDate();
        this.ReturnStatus = borBookObj.getReturnStatus();
        this.ReturnDate = borBookObj.getReturnDate();
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

    public Book getBookObj() {
        return bookObj;
    }

    public void setBookObj(Book bookObj) {
        this.bookObj = bookObj;
    }

    public BorrowedBook getBorBookObj() {
        return borBookObj;
    }

    public void setBorBookObj(BorrowedBook borBookObj) {
        this.borBookObj = borBookObj;
    }

    public Reader getReaderObj() {
        return readerObj;
    }

    public void setReaderObj(Reader readerObj) {
        this.readerObj = readerObj;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(Date BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public String getReturnStatus() {
        return ReturnStatus;
    }

    public void setReturnStatus(String ReturnStatus) {
        this.ReturnStatus = ReturnStatus;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    @Override
    public String toString() {
        return "Book_Reader_Borrowed_Collapse{" + "readerId=" + readerId + ", fullNameReader=" + fullNameReader + ", bookId=" + bookId + ", bookName=" + bookName + ", BorrowDate=" + BorrowDate + ", ReturnStatus=" + ReturnStatus + ", ReturnDate=" + ReturnDate + ", bookObj=" + bookObj + ", borBookObj=" + borBookObj + ", readerObj=" + readerObj + '}';
    }

}
