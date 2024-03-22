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
public class Employee {
    private int id;
    private String name;
    private Date from;
    private Date to;
    private int status;

    public Employee() {
    }

    public Employee(int id, String name, Date from, Date to, int status) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", status=" + status + '}';
    }
    
    
}
