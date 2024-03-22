/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Employee;

/**
 *
 * @author User
 */
public class EmployeeDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Employee> list = new ArrayList<>();

    public List<Employee> getAllEmployee() {
        try {
            String query = "select * from Employee";
            stm = connect.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void changeStatus(String id, String status) {
        try {
            String query = "update Employee set [status] = ? where id = ?";
            stm = connect.prepareStatement(query);
            stm.setString(1, status);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Date getMinFrom(){
        try{
            String query = "select min([from]) from Employee";
            stm = connect.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()){
                return rs.getDate(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public Date getMaxTo(){
        try{
            String query = "select max([to]) from Employee";
            stm = connect.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()){
                return rs.getDate(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
//        List<Employee> listEmployee = dao.getAllEmployee();
//        for (Employee employee : listEmployee) {
//            System.out.println(employee);
//        }
        System.out.println(dao.getMaxTo());
    }
}
