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
import model.Reader;
import model.Book_Reader_Borrowed_Collapse;

/**
 *
 * @author User
 */
public class ReaderDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Reader> list = new ArrayList<>();

    //get all Reader             // ok
    public List<Reader> getAllReader() {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader By 4 fields: FullName, DOB, PhoneNumber, Email    //ok
    public List<Reader> searchAllReaderBy4Fields(String fullName, String DOB, String PhoneNumber, String email) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where FullName = ? and DateOfBirth = ? and PhoneNumber = ? and Email = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, fullName);
            stm.setString(2, DOB);
            stm.setString(3, PhoneNumber);
            stm.setString(4, email);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader by FullName  //ok
    public List<Reader> getAllReaderByFullName(String fullName) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where FullName LIKE ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, '%'+fullName+'%');
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader by DateOfBirh  //ok
    public List<Reader> getAllReaderByDOB(String dateOfBirth) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where DateOfBirth = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, dateOfBirth);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader by SĐT  //ok
    public List<Reader> getAllReaderByPhoneNumber(String SDT) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where PhoneNumber = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, SDT);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader by Email  //ok
    public List<Reader> getAllReaderByEmail(String email) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where Email = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, email);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all reader by Email  //ok
    public List<Reader> getReadersByPhoneNumberAndEmail(String phoneNumber, String email) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader where PhoneNumber = ? and Email = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, phoneNumber);
            stm.setString(2, email);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get a reader by an ID        //ok
    public Reader getReaderByID(int readerId) {
        try {
            String queryStatment = "SELECT * FROM Reader WHERE readerId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, readerId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //get all reader by part of name         // ok
    public List<Reader> getReaderByPartName(String partName) {
        List<Reader> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Reader WHERE Reader.FullName LIKE ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, "%" + partName + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    List<Reader> l = getAllReader();
    int size = l.size();
     int readerId = size + 1;
    //add a reader to Reader table  ///     ok
    public void addReader(String fullName, String dateOfBirth, String phoneNumber, String email, int numberOfBorrowedBook, int numberOfReturnBook) {
        try {
            String queryStatment = "insert into Reader values (?, ?, ?, ?, ?, ?, ?)";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, readerId);
            stm.setString(2, fullName);
            stm.setString(3, dateOfBirth);
            stm.setString(4, phoneNumber);
            stm.setString(5, email);
            stm.setInt(6, numberOfBorrowedBook);
            stm.setInt(7, numberOfReturnBook);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    //update information of a reader  //ok
    public void updateReaderInformation(int readerId, String fullName, String dateOfBirth, String phoneNumber, String email) {
        try {
            String queryStatment = "update Reader set FullName = ?, DateOfBirth = ?, PhoneNumber = ?, Email = ? where ReaderId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, fullName);
            stm.setString(2, dateOfBirth);
            stm.setString(3, phoneNumber);
            stm.setString(4, email);
            stm.setInt(5, readerId);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    //Lấy ra lịch sử mượn sách của 1 độc giả cụ thể (by fullName of Reader)
    //get history that a reader borrowed books from library by his/her fullName  // ok
    public List<Book_Reader_Borrowed_Collapse> getHistoryBorrowedOfAReader(String fullName) {
        List<Book_Reader_Borrowed_Collapse> list = new ArrayList<>();
        String queryStatment = "SELECT Reader.readerId, Reader.fullName, Book.BookID, Book.BookName, BorrowedBook.BorrowDate, BorrowedBook.ReturnStatus, BorrowedBook.ReturnDate\n"
                + "            FROM Book\n"
                + "            JOIN BorrowedBook ON Book.BookID = BorrowedBook.BookID\n"
                + "            JOIN Reader ON BorrowedBook.ReaderID = Reader.ReaderID\n"
                + "            WHERE Reader.FullName = ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, fullName);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book_Reader_Borrowed_Collapse(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getDate(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //check if Reader's PhoneNumber is exist or not.
    public boolean checkPhoneNumberExist(String phoneNumber) {
        String queryStatment = "SELECT * FROM Reader WHERE PhoneNumber LIKE ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, phoneNumber);
            rs = stm.executeQuery();
            while (rs.next()) {//trong bảng Reader đã tồn tại phoneNumber đó
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    //check if Reader's Email is exist or not.
    public boolean checkEmailExist(String email) {
        String queryStatment = "SELECT * FROM Reader WHERE Email LIKE ?";
        try {
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, email);
            rs = stm.executeQuery();
            while (rs.next()) {//trong bảng Reader đã tồn tại email đó
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        ReaderDAO dao = new ReaderDAO();
//        List<Reader> list = dao.getAllReader();
//        for (Reader obj : list) {
//            System.out.println(obj); ///                 ok
//        }
//
//          Reader reader2 = dao.getReaderByID(2);
//            System.out.println(reader2); ///                 ok
//        
//        insert into Reader values ('Đỗ Quốc T', '2003-11-14', '0981234590', 'doquoct@gmail.com')
//        dao.addReader("Đỗ Quốc T", "2003-11-14", "0981234590", "doquoct@gmail.com"); //ok

//update Reader set FullName = 'Quak quak quak', DateOfBirth = '2003-07-23', PhoneNumber = '0123456789', Email = 'taolaai@gmail.com' where ReaderId = 4
//        dao.updateReaderInformation(4, "quak", "2003-07-23", "0123456789", "taolaai@gmail.com");   ///ok
//
//            List<Reader> l = dao.getReaderByPartName("Nguyễn");
//            for (Reader r : l) {                                      //ok
//                System.out.println(r);
//        }
//        List<Book_Reader_Borrowed_Collapse> l = dao.getHistoryBorrowedOfAReader("Nguyễn Văn A");
//        for (Book_Reader_Borrowed_Collapse o : l) {               //ok
//            System.out.println(o);
//        }
//List<Reader> l = dao.getAllReaderByDOB("2000-01-15");
//        for (Reader reader : l) {                             //ok
//            System.out.println(reader);
//        }
//List<Reader> l = dao.getAllReaderByEmail("nguyenvana@gmail.com");
//        for (Reader reader : l) {                             //ok
//            System.out.println(reader);
//        }
//List<Reader> l = dao.getAllReaderByFullName("Nguyễn Thị B");
//        for (Reader reader : l) {                             //ok
//            System.out.println(reader);
//        }
//List<Reader> l = dao.getAllReaderByPhoneNumber("5554443333");
//        for (Reader reader : l) {                             //ok
//            System.out.println(reader);
//        }
//        List<Reader> l = dao.searchAllReaderBy4Fields("Nguyễn Văn A", "2000-01-15", "1234567890", "nguyenvana@gmail.com");
//        for (Reader reader : l) {                             //ok
//            System.out.println(reader);
//        }
//        boolean isExistPhone = dao.checkPhoneNumberExist("1234567890");
//            System.out.println(isExistPhone);                 //ok
//        boolean isExistEmail = dao.checkEmailExist("nguyenvana@gmail.com");
//            System.out.println(isExistEmail);                 //ok
    }
}
