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
public class BookInventory {
//    CREATE TABLE BookInventory (
//    [InventoryId] INT PRIMARY KEY,
//    [OriginalQuantity] INT,
//    [TakenQuantity] INT,
//    [RemainQuantity] INT,
//    [RefreshDate] DATE,
//    [PurchasesId] INT,
//    FOREIGN KEY ([PurchasesId]) REFERENCES BookPurchases([PurchasesId])
//);
    private int inventoryId;
    private int originalQuantity;
    private int takenQuantity;
    private int remainQuantity;
    private Date refreshDate;
    private int purchasesId;

    public BookInventory() {
    }

    public BookInventory(int inventoryId, int originalQuantity, int takenQuantity, int remainQuantity, Date refreshDate, int purchasesId) {
        this.inventoryId = inventoryId;
        this.originalQuantity = originalQuantity;
        this.takenQuantity = takenQuantity;
        this.remainQuantity = remainQuantity;
        this.refreshDate = refreshDate;
        this.purchasesId = purchasesId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
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

    public Date getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(Date refreshDate) {
        this.refreshDate = refreshDate;
    }

    public int getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(int purchasesId) {
        this.purchasesId = purchasesId;
    }

    @Override
    public String toString() {
        return "BookInventory{" + "inventoryId=" + inventoryId + ", originalQuantity=" + originalQuantity + ", takenQuantity=" + takenQuantity + ", remainQuantity=" + remainQuantity + ", refreshDate=" + refreshDate + ", purchasesId=" + purchasesId + '}';
    }
    
}
