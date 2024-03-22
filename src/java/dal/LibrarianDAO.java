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
import model.Librarian;

/**
 *
 * @author User
 */
public class LibrarianDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    List<Librarian> list = new ArrayList<>();

    //get all Librarian  // ok
    public List<Librarian> getAllLibrarian() {
        List<Librarian> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Librarian";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Librarian(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get bookInventory by an ID  //ok
    public Librarian getLibrarianByID(int librarianId) {
        try {
            String queryStatment = "SELECT * FROM Librarian WHERE librarianId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, librarianId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new Librarian(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        LibrarianDAO dao = new LibrarianDAO();
//        List<Librarian> list = dao.getAllLibrarian();
//        for (Librarian obj : list) {
//            System.out.println(obj); ///                 ok
//        }
//
//          Librarian librarian5 = dao.getLibrarianByID(5);
//            System.out.println(librarian5); ///                 ok
        
    }
}
