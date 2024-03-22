/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class BookLocations {
//    CREATE TABLE BookLocations (
//    [LocationId] INT PRIMARY KEY,
//    [LocationName] VARCHAR(255),
    //[Capacity] INT
//);
    private int locationId;
    private String locationName;
    private int capacity;
    
    public BookLocations() {
    }

    public BookLocations(int locationId, String locationName, int capacity) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "BookLocations{" + "locationId=" + locationId + ", locationName=" + locationName + ", capacity=" + capacity + '}';
    }

}
