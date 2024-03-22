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
import model.BookInventory;
import model.Book_BookInventory_Collapse;

/**
 *
 * @author User
 */
public class BookInventoryDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<BookInventory> list = new ArrayList<>();

    //get all BookInventory  // ok
    public List<BookInventory> getAllBookInventory() {
        List<BookInventory> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM BookInventory";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new BookInventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get bookInventory by an ID  //ok
    public BookInventory getBookInventoryByID(int inventoryId) {
        try {
            String queryStatment = "SELECT * FROM BookInventory WHERE inventoryId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, inventoryId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new BookInventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //get information of a book in BookInventory
    //Kiểm tra xem (RemainQuantity) kho còn hay không để thông báo rằng: 
    //"Không thể add thêm sách bởi số lượng của cuốn sách này trong kho đã hết"
    public boolean checkRemainQuantityOfABook_MoreThanZero(String bookName) {
        try {
            String queryStatment
                    = "Select distinct BookInventory.InventoryId, Book.BookName, BookInventory.OriginalQuantity , BookInventory.TakenQuantity , BookInventory.RemainQuantity\n"
                    + "from Book join BookInventory on Book.InventoryId = BookInventory.InventoryId\n"
                    + "where Book.BookName = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            Book_BookInventory_Collapse bookCollap = new Book_BookInventory_Collapse();
            while (rs.next()) {
                bookCollap = new Book_BookInventory_Collapse(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
            int getRemainQuantity = bookCollap.getRemainQuantity();
            if (getRemainQuantity == 0) { // Xác nhận còn sách trong kho 
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }
    

    public static void main(String[] args) {
        BookInventoryDAO dao = new BookInventoryDAO();
//        List<BookInventory> list = dao.getAllBookInventory();
//        for (BookInventory obj : list) {
//            System.out.println(obj); ///                 ok
//        }

//          BookInventory inventory17 = dao.getBookInventoryByID(17);
//            System.out.println(inventory17); ///                 ok
        boolean ok = dao.checkRemainQuantityOfABook_MoreThanZero("Carrie");   // ok
        if (ok) {
            System.out.println("còn sách");
        } else {
            System.out.println("hết sách");
        }
    }
}
