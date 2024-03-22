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
public class Book_BookInventory_BookPurchases_Collapse {
    private String bookName;
    private int originalQuantity;
    private int takenQuantity;
    private int remainQuantity;
    private Date refreshDate;
    private int purchasesId;
    private Date purchaseDate;
    private BookInventory inventory;
    private BookPurchases purchase;

    public Book_BookInventory_BookPurchases_Collapse() {
    }

    public Book_BookInventory_BookPurchases_Collapse(String bookName, int originalQuantity, int takenQuantity, int remainQuantity, Date refreshDate, int purchasesId, Date purchaseDate, BookInventory inventory, BookPurchases purchase) {
        this.bookName = bookName;
        this.originalQuantity = originalQuantity;
        this.takenQuantity = takenQuantity;
        this.remainQuantity = remainQuantity;
        this.refreshDate = refreshDate;
        this.purchasesId = purchasesId;
        this.purchaseDate = purchaseDate;
        this.inventory = inventory;
        this.purchase = purchase;
    }
    public Book_BookInventory_BookPurchases_Collapse(String bookName, int originalQuantity, int takenQuantity, int remainQuantity, Date refreshDate, int purchasesId, Date purchaseDate) {
        this.bookName = bookName;
        this.originalQuantity = originalQuantity;
        this.takenQuantity = takenQuantity;
        this.remainQuantity = remainQuantity;
        this.refreshDate = refreshDate;
        this.purchasesId = purchasesId;
        this.purchaseDate = purchaseDate;
    }

//    public Book_BookInventory_BookPurchases_Collapse(String bookName) {
//        this.bookName = purchase.getBookName();
//        this.originalQuantity = inventory.getOriginalQuantity();
//        this.takenQuantity = inventory.getTakenQuantity();
//        this.remainQuantity = inventory.getRemainQuantity();
//        this.refreshDate = inventory.getRefreshDate();
//        this.purchasesId = purchase.getPurchasesId();
//        this.purchaseDate = purchase.getPurchaseDate();
//    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public int getTakenQuantity() {
        return takenQuantity;
    }

    public void setTakenQuantity(int takenQuantity) {
        this.takenQuantity = takenQuantity;
    }

    public int getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(int remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public int getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(int purchasesId) {
        this.purchasesId = purchasesId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    
    public BookInventory getInventory() {
        return inventory;
    }

    public void setInventory(BookInventory inventory) {
        this.inventory = inventory;
    }

    public BookPurchases getPurchase() {
        return purchase;
    }

    public void setPurchase(BookPurchases purchase) {
        this.purchase = purchase;
    }

    public Date getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(Date refreshDate) {
        this.refreshDate = refreshDate;
    }

    @Override
    public String toString() {
        return "Book_BookInventory_BookPurchases_Collapse{" + "bookName=" + bookName + ", originalQuantity=" + originalQuantity + ", takenQuantity=" + takenQuantity + ", remainQuantity=" + remainQuantity + ", refreshDate=" + refreshDate + ", purchasesId=" + purchasesId + ", purchaseDate=" + purchaseDate + '}';
    }

}
