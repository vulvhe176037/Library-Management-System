/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BookPurchases;

/**
 *
 * @author User
 */
public class BookPurchasesDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    List<BookPurchases> list = new ArrayList<>();

    //get all BookPurchases  // ok
    public List<BookPurchases> getAllBookPurchases() {
        List<BookPurchases> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM BookPurchases";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new BookPurchases(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get bookInventory by an ID  //ok
    public BookPurchases getBookPurchasesByID(int purchasesId) {
        try {
            String queryStatment = "SELECT * FROM BookPurchases WHERE purchasesId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, purchasesId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new BookPurchases(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        BookPurchasesDAO dao = new BookPurchasesDAO();
        List<BookPurchases> list = dao.getAllBookPurchases();
        for (BookPurchases obj : list) {
            System.out.println(obj); ///                 ok
        }
//
//          BookPurchases purchases17 = dao.getBookPurchasesByID(17);
//            System.out.println(purchases17); ///                 ok
        
    }
}
