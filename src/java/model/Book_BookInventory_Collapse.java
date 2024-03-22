/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Book;
import model.BookInventory;

/**
 *
 * @author User
 */
public class Book_BookInventory_Collapse {
    private int inventoryId;
    private String bookName;
    private int originalQuantity;
    private int takenQuantity;
    private int remainQuantity;
    private Book book;
    private BookInventory bookIvtr;

    public Book_BookInventory_Collapse() {
    }

    public Book_BookInventory_Collapse(int inventoryId, String bookName, int originalQuantity, int takenQuantity, int remainQuantity) {
        this.inventoryId = inventoryId;
        this.bookName = bookName;
        this.originalQuantity = originalQuantity;
        this.takenQuantity = takenQuantity;
        this.remainQuantity = remainQuantity;
    }
    
//    public Book_BookInventory_Collapse(String bookName) {
//        this.inventoryId = bookIvtr.getInventoryId();
//        this.bookName = book.getBookName();
//        this.originalQuantity = bookIvtr.getOriginalQuantity();
//        this.takenQuantity = bookIvtr.getTakenQuantity();
//        this.remainQuantity = bookIvtr.getRemainQuantity();
//    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

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

    @Override
    public String toString() {
        return "Book_BookInventory_Collapse{" + "inventoryId=" + inventoryId + ", bookName=" + bookName + ", originalQuantity=" + originalQuantity + ", takenQuantity=" + takenQuantity + ", remainQuantity=" + remainQuantity + '}';
    }
}
