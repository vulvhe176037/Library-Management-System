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
public class BookPurchases {
//    CREATE TABLE BookPurchases (
//    [PurchasesId] INT PRIMARY KEY,
//    [BookName] VARCHAR(255),
//    [TotalQuantity] INT,
//    [TotalCost] FLOAT,
//    [PurchaseDate] DATE,
//    [LibrarianId] INT,
//    FOREIGN KEY ([LibrarianId]) REFERENCES Librarian([LibrarianId])
//);
    private int purchasesId;
    private String bookName;
    private int totalQuantity;
    private float totalCost;
    private Date purchaseDate;
    private int librarianId;

    public BookPurchases() {
    }

    public BookPurchases(int purchasesId, String bookName, int totalQuantity, float totalCost, Date purchaseDate, int librarianId) {
        this.purchasesId = purchasesId;
        this.bookName = bookName;
        this.totalQuantity = totalQuantity;
        this.totalCost = totalCost;
        this.purchaseDate = purchaseDate;
        this.librarianId = librarianId;
    }

    public int getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(int purchasesId) {
        this.purchasesId = purchasesId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    @Override
    public String toString() {
        return "BookPurchases{" + "purchasesId=" + purchasesId + ", bookName=" + bookName + ", totalQuantity=" + totalQuantity + ", totalCost=" + totalCost + ", purchaseDate=" + purchaseDate + ", librarianId=" + librarianId + '}';
    }

    
}