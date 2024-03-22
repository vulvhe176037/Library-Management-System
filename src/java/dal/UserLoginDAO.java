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
import model.UserLogin;
//import model.UserLogin;

/**
 *
 * @author User
 */
public class UserLoginDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<UserLogin> list = new ArrayList<>();

    public UserLogin login(String accountName, String password) {
        try {
            String queryStatment = "SELECT * FROM UserLogin where UserLogin.AccountName = ? and UserLogin.Password = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, accountName);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while(rs.next()){
                return new UserLogin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getString(9));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //OK
    public List<UserLogin> getAllUserLogin() {
        List<UserLogin> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM UserLogin";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new UserLogin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //OK
    public UserLogin getUserLoginByID(String idUserLogin) {
        try {
            String queryStatment = "SELECT * FROM UserLogin WHERE UserID = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, idUserLogin);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new UserLogin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getString(9));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    //
    public UserLogin getUserLoginByAccountName(String accountName) {
        try {
            String queryStatment = "SELECT * FROM UserLogin WHERE accountName = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, accountName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new UserLogin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getString(9));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //OK
    //Just for a member of library management system
    public void addUserLogin(String accountName, String password, String fullName, String email, String phoneNumber, String dateOfBirth, String createdDate, String accessLevel) {
        String addStatement = "INSERT INTO UserLogin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stm = connect.prepareStatement(addStatement);
            List<UserLogin> userList = getAllUserLogin(); // 5 nguoi : id -> 1 2 3 4 5 (length: 5)
            int length = userList.size();
            UserLogin lastUser = userList.get(length);
            stm.setInt(1, lastUser.getUserId() + 1);//thang tiep theo se co id la 5 + 1 = 6
            stm.setString(2, accountName);
            stm.setString(3, password);
            stm.setString(4, fullName);
            stm.setString(5, email);
            stm.setString(6, phoneNumber);
            stm.setString(7, dateOfBirth);
            stm.setString(8, createdDate);
            stm.setString(9, accessLevel);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    //OK
    public void changePasswordById(String UserID, String Password) {
        String updateStatement = "UPDATE UserLogin SET Password = ? WHERE UserID = ?";
        try {
            stm = connect.prepareStatement(updateStatement);
            stm.setString(1, Password);
            stm.setString(2, UserID);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void changePasswordByAccountAndOldPassword(String account, String pass) {
        String updateStatement = "update UserLogin set Password = ? where AccountName = ?";
        try {
            stm = connect.prepareStatement(updateStatement);
            stm.setString(1, pass);
            stm.setString(2, account);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteUserLogin(String UserID) {
        String deleteStatement = "DELETE FROM UserLogin WHERE UserID = ?";
        try {
            stm = connect.prepareStatement(deleteStatement);
            stm.setString(1, UserID);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    public static void main(String[] args) {
        UserLoginDAO t = new UserLoginDAO();
        List<UserLogin> l = t.getAllUserLogin();
        for (UserLogin obj : l) {
            System.out.println(obj);
        }
    }
}
