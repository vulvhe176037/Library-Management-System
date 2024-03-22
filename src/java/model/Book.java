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
public class Book {
//    CREATE TABLE Book (
//    [BookId] INT PRIMARY KEY,
//    [BookName] VARCHAR(255),
//    [ISBN] VARCHAR(13),
//    [Author] VARCHAR(255),
//    [Genre] VARCHAR(255),
//    [Publisher] VARCHAR(255),
//    [PublishYear] VARCHAR(4),
//    [VersionInLibrary] VARCHAR(255),
//    [Price] FLOAT,
//    [IsRemaining] VARCHAR(10),
//    [LocationId] INT,
//    [InventoryId] INT,
    //[ImageData] VARBINARY(MAX), 
//    FOREIGN KEY ([LocationId]) REFERENCES BookLocations([LocationId]),
//    FOREIGN KEY ([InventoryId]) REFERENCES BookInventory([InventoryId])
//);

    private int bookId;
    private String bookName;
    private String ISBN;
    private String author;
    private String genre;
    private String publisher;
    private String publishYear;
    private String versionInLibrary;
    private float price;
    private String isRemaining;
    private int locationId;
    private int inventoryId;
    private String imagePath;

    //bonus Collapse
    private String returnStatus;
    private Date maxReturnDate;
    private int borrowId;
    private Date borrowDate;
    private Date returnDate;
    

    public Book() {
    }

    public Book(int bookId, String bookName, String ISBN, String author, String genre, String publisher, String publishYear, String versionInLibrary, float price, String isRemaining, int locationId, int inventoryId, String imagePath) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.versionInLibrary = versionInLibrary;
        this.price = price;
        this.isRemaining = isRemaining;
        this.locationId = locationId;
        this.inventoryId = inventoryId;
        this.imagePath = imagePath;
    }
    
    public Book(int bookId, String bookName, String ISBN, String author, String genre, String publisher, String publishYear, String versionInLibrary, float price, String isRemaining, int locationId, int inventoryId, String imagePath, int borrowId, Date borrowDate, String returnStatus, Date returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.versionInLibrary = versionInLibrary;
        this.price = price;
        this.isRemaining = isRemaining;
        this.locationId = locationId;
        this.inventoryId = inventoryId;
        this.imagePath = imagePath;
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.returnStatus = returnStatus;
        this.returnDate = returnDate;
    }

                    
    public Book(int bookId, String bookName, String ISBN, String author, String genre, String publisher, String publishYear, String versionInLibrary, float price, String isRemaining, int locationId, int inventoryId, String imagePath, String returnStatus, Date maxReturnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.versionInLibrary = versionInLibrary;
        this.price = price;
        this.isRemaining = isRemaining;
        this.locationId = locationId;
        this.inventoryId = inventoryId;
        this.imagePath = imagePath;
        this.returnStatus = returnStatus;
        this.maxReturnDate = maxReturnDate;
    }

//    public Book(int bookId, String bookName, String versionInLibrary, String isRemaining, String returnStatus) {
//        this.bookId = bookId;
//        this.bookName = bookName;
//        this.versionInLibrary = versionInLibrary;
//        this.isRemaining = isRemaining;
//        this.returnStatus = returnStatus;
//    }
    public Book(String bookName) {
        this.bookName = bookName;
    }
//

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

//    public Book(String bookName) {
//        this.bookName = bookName;
//    }
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getVersionInLibrary() {
        return versionInLibrary;
    }

    public void setVersionInLibrary(String versionInLibrary) {
        this.versionInLibrary = versionInLibrary;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIsRemaining() {
        return isRemaining;
    }

    public void setIsRemaining(String isRemaining) {
        this.isRemaining = isRemaining;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    @Override
//    public String toString() {
//        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", ISBN=" + ISBN + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher + ", publishYear=" + publishYear + ", versionInLibrary=" + versionInLibrary + ", price=" + price + ", isRemaining=" + isRemaining + ", locationId=" + locationId + ", inventoryId=" + inventoryId + ", imagePath=" + imagePath +  '}';
//    }
//       @Override
//    public String toString() {
//        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", ISBN=" + ISBN + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher + ", publishYear=" + publishYear + ", versionInLibrary=" + versionInLibrary + ", price=" + price + ", isRemaining=" + isRemaining + ", locationId=" + locationId + ", inventoryId=" + inventoryId + ", imagePath=" + imagePath + ", returnStatus=" + returnStatus + '}';
//    }
//    
    public Date getMaxReturnDate() {
        return maxReturnDate;
    }

    public void setMaxReturnDate(Date maxReturnDate) {
        this.maxReturnDate = maxReturnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", ISBN=" + ISBN + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher + ", publishYear=" + publishYear + ", versionInLibrary=" + versionInLibrary + ", price=" + price + ", isRemaining=" + isRemaining + ", locationId=" + locationId + ", inventoryId=" + inventoryId + ", imagePath=" + imagePath + ", returnStatus=" + returnStatus + ", maxReturnDate=" + maxReturnDate + ", borrowId=" + borrowId + '}';
    }

    

}
