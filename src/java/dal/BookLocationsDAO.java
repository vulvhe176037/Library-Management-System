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
import model.BookLocations;

/**
 *
 * @author User
 */
public class BookLocationsDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    List<BookLocations> list = new ArrayList<>();

    //get all BookLocations  // ok
    public List<BookLocations> getAllBookLocations() {
        List<BookLocations> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM BookLocations";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new BookLocations(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get bookInventory by an ID  //ok
    public BookLocations getBookLocationsByID(int locationId) {
        try {
            String queryStatment = "SELECT * FROM BookLocations WHERE locationId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, locationId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
                return new BookLocations(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        BookLocationsDAO dao = new BookLocationsDAO();
//        List<BookLocations> list = dao.getAllBookLocations();
//        for (BookLocations obj : list) {
//            System.out.println(obj); ///                 ok
//        }
////
          BookLocations location2 = dao.getBookLocationsByID(2);
            System.out.println(location2); ///                 ok
        
    }
}
