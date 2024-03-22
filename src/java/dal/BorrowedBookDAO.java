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
import model.Book;
import model.BorrowedBook;
import model.Librarian;
import model.Reader;

/**
 *
 * @author User
 */
public class BorrowedBookDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<BorrowedBook> list = new ArrayList<>();

    //get all BorrowedBook  // ok
    public List<BorrowedBook> getAllBorrowedBook() {
        List<BorrowedBook> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM BorrowedBook";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get borrowedBook by an ID  //ok
    public List<BorrowedBook> getBorrowedBookByID(int borrowId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT * FROM BorrowedBook WHERE borrowId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, borrowId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get borrowedBook by bookName  //ok
    public List<BorrowedBook> searchBorrowedBookByBookName(String bookName) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT Book.BookId, Book.BookName, Book.VersionInLibrary, Reader.FullName AS N'Độc giả', Librarian.FullName AS N'Thủ thư', BorrowedBook.BorrowDate\n"
                    + "FROM     Book INNER JOIN\n"
                    + "                  BorrowedBook ON Book.BookId = BorrowedBook.BookId INNER JOIN\n"
                    + "                  Librarian ON BorrowedBook.LibrarianId = Librarian.LibrarianId INNER JOIN\n"
                    + "                  Reader ON BorrowedBook.ReaderId = Reader.ReaderId\n"
                    + "				  WHERE Book.BookName LIKE ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get borrowedBook by readerName  //ok
    public List<BorrowedBook> searchBorrowedBookByReaderName(String readerName) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT Book.BookId, Book.BookName, Book.VersionInLibrary, Reader.FullName AS N'Độc giả', Librarian.FullName AS N'Thủ thư', BorrowedBook.BorrowDate\n"
                    + "FROM     Book INNER JOIN\n"
                    + "                  BorrowedBook ON Book.BookId = BorrowedBook.BookId INNER JOIN\n"
                    + "                  Librarian ON BorrowedBook.LibrarianId = Librarian.LibrarianId INNER JOIN\n"
                    + "                  Reader ON BorrowedBook.ReaderId = Reader.ReaderId\n"
                    + "				  WHERE Reader.FullName LIKE ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, "%" + readerName + "%");
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get borrowedBook by librarianName  //ok
    public List<BorrowedBook> searchBorrowedBookByLibrarianName(String librarianName) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT Book.BookId, Book.BookName, Book.VersionInLibrary, Reader.FullName AS N'Độc giả', Librarian.FullName AS N'Thủ thư', BorrowedBook.BorrowDate\n"
                    + "FROM     Book INNER JOIN\n"
                    + "                  BorrowedBook ON Book.BookId = BorrowedBook.BookId INNER JOIN\n"
                    + "                  Librarian ON BorrowedBook.LibrarianId = Librarian.LibrarianId INNER JOIN\n"
                    + "                  Reader ON BorrowedBook.ReaderId = Reader.ReaderId\n"
                    + "				  WHERE Librarian.FullName LIKE ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, "%" + librarianName + "%");
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get borrowedBook by borrowDate  //ok
    public List<BorrowedBook> searchBorrowedBookByBorrowDate(String borrowDate) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT Book.BookId, Book.BookName, Book.VersionInLibrary, Reader.FullName AS N'Độc giả', Librarian.FullName AS N'Thủ thư', BorrowedBook.BorrowDate\n"
                    + "FROM     Book INNER JOIN\n"
                    + "                  BorrowedBook ON Book.BookId = BorrowedBook.BookId INNER JOIN\n"
                    + "                  Librarian ON BorrowedBook.LibrarianId = Librarian.LibrarianId INNER JOIN\n"
                    + "                  Reader ON BorrowedBook.ReaderId = Reader.ReaderId\n"
                    + "				  WHERE BorrowedBook.BorrowDate = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, borrowDate);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //Kiểm tra bookId muốn mượn có tồn tại trong Book hay không?
    public boolean checkBookIdExist(int BookId) {
//        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT * FROM Book WHERE Book.BookId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, BookId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
//                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));//có tồn tại cuốn sách với bookId đó
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;//ko tồn tại cuốn sách với bookId đó
    }

    //Kiểm tra borrowId có tồn tại trong Book hay không?
    public boolean checkBorrowIdExist(int BorrowId) {
//        List<BorrowedBook> list = new ArrayList<>();
        try {
            int i = 0;
            String queryStatment = "SELECT * FROM BorrowedBook WHERE BorrowedBook.BorrowId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, BorrowId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                i++;
            }
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;//ko tồn tại cuốn sách với bookId đó
    }

    //Tiếp tục, nếu BookId trên tồn tại thì kiểm tra xem cuốn sách tương ứng với bookId có phải đang được mượn hay không?
    public boolean checkBookIdHasBeenBorrowed(int BookId) {
        try {
            String queryStatment = "SELECT * FROM BorrowedBook \n"
                    + "WHERE ReturnStatus = N'Not Yet' and BookId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, BookId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return true;//đang có người mượn chưa trả
                //nếu vẫn muốn mượn cuốn sách (có bookName và infor khác) có trùng thông tin với bookId kia thì
                //sẽ chuyển tới add book to library from inventory
                //để lấy 1 bản khác ra cho mượn
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;//chưa có người mượn
    }

    //thêm phiên mượn bằng thủ tục
    public boolean add_BorrowedBook_ByProcedure(int readerId, int bookId, int librarianId) {
        try {
            String executeStatement = "EXECUTE BorrowBookProcedure @ReaderId = ?, @BookId = ?, @LibrarianId = ?";
            stm = connect.prepareStatement(executeStatement);
            stm.setInt(1, readerId);
            stm.setInt(2, bookId);
            stm.setInt(3, librarianId);
            stm.executeUpdate();//ko có dữ liệu trả về => dùng ExecuteUpdate
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }

    //kiểm tra độc giả có tồn tại ko
    public boolean checkReaderExist(int readerId) {
        List<Reader> l = new ArrayList<>();
        try {
            String executeStatement = "select * from Reader where ReaderId = ?";
            stm = connect.prepareStatement(executeStatement);
            stm.setInt(1, readerId);
            rs = stm.executeQuery();
            while (rs.next()) {
                l.add(new Reader(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
            return !l.isEmpty();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    //kiểm tra thủ thư có tồn tại ko
    public boolean checkLibrarianExist(int librarianId) {
        List<Librarian> l = new ArrayList<>();
        try {
            String executeStatement = "select * from Librarian where LibrarianId = ?";
            stm = connect.prepareStatement(executeStatement);
            stm.setInt(1, librarianId);
            rs = stm.executeQuery();
            while (rs.next()) {
                l.add(new Librarian(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
            }
            return !l.isEmpty();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    //lấy ra phiên mượn gần nhất vừa đc add vào
    public List<BorrowedBook> getRecentBorrowedBook() {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "select top 1 *\n"
                    + "from BorrowedBook\n"
                    + "order by BorrowedBook.BorrowId desc";
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    public List<BorrowedBook> checkBorrowedWithBorrowId_ReaderId(int borrowId, int readerId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT BorrowedBook.*\n"
                    + "FROM     BorrowedBook \n"
                    + "where BorrowedBook.BorrowId = ? AND BorrowedBook.ReaderId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, borrowId);
            stm.setInt(2, readerId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //lấy ra phiên mượn by BorrowId
    public List<BorrowedBook> getBorrowedBookByBookId(int BookId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT top 1 * FROM BorrowedBook \n"
                    + "WHERE BorrowedBook.BookId = ? and BorrowedBook.ReturnDate is null \n"
                    + "order by BorrowedBook.BorrowId desc";
            stm.setInt(1, BookId);
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //Kiểm tra có tồn tại phiên mượn ko
    public boolean checkBorrowedIdExist(int borrowId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "select * from BorrowedBook where BorrowedBook.BorrowId = ?";
            stm.setInt(1, borrowId);
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
            return !list.isEmpty();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    //Kiểm tra phiên mượn xem là phiên mượn đã cập nhật hoàn thiện hay chưa? Đã đủ hết thông tin hay chưa cập nhật hết        
    public boolean checkBorrowedBookHasCompleted(int borrowId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT * FROM BorrowedBook\n"
                    + "                    WHERE BorrowedBook.BorrowId = ? and BorrowedBook.ReturnStatus = N'Done'";
            stm.setInt(1, borrowId);
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
            return !list.isEmpty();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public boolean checkBorrowedBook_NOT_Completed(int borrowId) {
        List<BorrowedBook> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT * FROM BorrowedBook\n"
                    + "                    WHERE BorrowedBook.BorrowId = ? and BorrowedBook.ReturnStatus = N'Not yet'";
            stm.setInt(1, borrowId);
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new BorrowedBook(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
            return !list.isEmpty();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    // Kiểm tra trạng thái trả sách của phiên mượn
    public boolean checkReturnStatus(int borrowId) {
        try {
            String queryStatement = "SELECT returnStatus FROM BorrowedBook WHERE BorrowId = ?";
            stm = connect.prepareStatement(queryStatement);
            stm.setInt(1, borrowId);
            rs = stm.executeQuery();
            if (rs.next()) {
                String returnStatus = rs.getString("returnStatus");
                return "Not yet".equals(returnStatus);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    //THỦ TỤC CẬP NHẬT PHIÊN MƯỢN/TRẢ SÁCH VÀ TÍNH TOÁN PHÍ PHẠT (NẾU CÓ)
    public void update_BorrowedBook_ByProcedure(int readerId, int borrowId, String returnDate, String bookSttAfter) {
        try {
            String executeStatement = "EXEC ReturnBookProcedure @ReaderId = ?, @BorrowId = ?, @ReturnDate = ?, @BookSttAfter = ?";
            stm = connect.prepareStatement(executeStatement);
            stm.setInt(1, readerId);
            stm.setInt(2, borrowId);
            stm.setString(3, returnDate);
            stm.setString(4, bookSttAfter);
            stm.executeUpdate();//ko có dữ liệu trả về => dùng ExecuteUpdate
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        BorrowedBookDAO dao = new BorrowedBookDAO();
//        List<BorrowedBook> list = dao.getAllBorrowedBook();
//        for (BorrowedBook obj : list) {
//            System.out.println(obj); ///                 ok
//        }
        List<BorrowedBook> list = dao.searchBorrowedBookByReaderName("Lưu Văn Vũ");
        for (BorrowedBook obj : list) {
            System.out.println(obj); ///                 ok
        }
//        dao.update_BorrowedBook_ByProcedure(6, 36, "2023-10-30", "Lower");

    }
}
