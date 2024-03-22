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
import model.Book_BookInventory_BookPurchases_Collapse;

/**
 *
 * @author User
 */
public class BookDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Book> listGlobal = new ArrayList<>();

    //get all Book  // ok
    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        String queryStatment = "SELECT * FROM Book";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get All BookName of Book               //ok
    public List<Book> getAllBookName() {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT DISTINCT BookName FROM Book";
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all Genre  // ok
    public List<Book> getAllGenre() {
        List<Book> list = new ArrayList<>();
        String queryStatment = "select distinct Genre from Book";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book(0, "", "", "", rs.getString(1), "", "", "", 0, "", 0, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all Author  // ok
    public List<Book> getAllAuthor() {
        List<Book> list = new ArrayList<>();
        String queryStatment = "SELECT distinct Author FROM Book";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book(0, "", "", rs.getString(1), "", "", "", "", 0, "", 0, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all Publisher  // ok
    public List<Book> getAllPublisher() {
        List<Book> list = new ArrayList<>();
        String queryStatment = "SELECT distinct Publisher FROM Book";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book(0, "", "", "", "", rs.getString(1), "", "", 0, "", 0, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get all publish year  // ok
    public List<Book> getAllPubLishYear() {
        List<Book> list = new ArrayList<>();
        String queryStatment = "SELECT distinct PublishYear FROM Book";
        try {
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Book(0, "", "", "", "", "", rs.getString(1), "", 0, "", 0, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by an ID  //ok
    public Book getBookByID(int bookId) {
        try {
            String queryStatment = "SELECT * FROM Book WHERE BookId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, bookId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //get book by name  // ok
    public List<Book> getBookByName(String bookName) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT * FROM Book WHERE BookName = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //lấy ra các bản ghi là cập nhật tình trạng mới nhất của 1 cuốn sách
    //tránh tình trạng lấy ra nhiều bản ghi đều là Done
    //select distinct nhưng vì các ngày mượn trả khác nhau cho nên vẫn hiển thị ra nhiều bản có vẻ trùng lặp
    public List<Book> getBookReturnSttByName(String bookName) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "WITH LatestBorrows AS (\n"
                    + "    SELECT \n"
                    + "        Book.BookId, \n"
                    + "        Book.BookName, \n"
                    + "        Book.ISBN, \n"
                    + "        Book.Author, \n"
                    + "        Book.Genre, \n"
                    + "        Book.Publisher, \n"
                    + "        Book.PublishYear, \n"
                    + "        Book.VersionInLibrary, \n"
                    + "        Book.Price, \n"
                    + "        Book.IsRemaining, \n"
                    + "        Book.LocationId, \n"
                    + "        Book.InventoryId, \n"
                    + "        Book.ImagePath,\n"
                    + "        BorrowedBook.BorrowId,\n"
                    + "        BorrowedBook.BorrowDate,\n"
                    + "		BorrowedBook.ReturnStatus,\n"
                    + "        BorrowedBook.ReturnDate,\n"
                    + "        ROW_NUMBER() OVER (PARTITION BY Book.BookId ORDER BY BorrowedBook.BorrowId DESC) AS rn\n"
                    + "    FROM Book\n"
                    + "    INNER JOIN BorrowedBook ON Book.BookId = BorrowedBook.BookId\n"
                    + "    WHERE Book.BookName LIKE ?\n"
                    + ")\n"
                    + "SELECT \n"
                    + "    BookId, \n"
                    + "    BookName, \n"
                    + "    ISBN, \n"
                    + "    Author, \n"
                    + "    Genre, \n"
                    + "    Publisher, \n"
                    + "    PublishYear, \n"
                    + "    VersionInLibrary, \n"
                    + "    Price, \n"
                    + "    IsRemaining, \n"
                    + "    LocationId, \n"
                    + "    InventoryId, \n"
                    + "    ImagePath,\n"
                    + "    BorrowId,\n"
                    + "    BorrowDate,\n"
                    + "	ReturnStatus,\n"
                    + "    ReturnDate\n"
                    + "FROM LatestBorrows\n"
                    + "WHERE rn = 1"; //lấy dòng đầu tiên (mới nhất) ứng với bản ghi của bookId đó
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();
            while (rs.next()) {
                Book collap = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getDate(15), rs.getString(16), rs.getDate(17));
                list.add(collap);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by name but get only one book because they are the same except id and something  // ok
    public List<Book> getBookByNameButOnlyOneBook(String bookName) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select top 1 * from book where bookname like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get A BookName of Book By BookId
    public Book getABookNameByBookId(int bookId) {
        try {
            String queryStatment = "SELECT BookName FROM Book where bookId = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setInt(1, bookId);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    //get book by part of name //  ok
    public List<Book> getBookByPartOfName(String bookName) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * from Book where BookName like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, "%" + bookName + "%");
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by publisher // ok
    public List<Book> getBookByPublisher(String publisher) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * from Book where Publisher like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, publisher);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by genre  //ok
    public List<Book> getBookByGenre(String genre) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * from Book where Genre like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, genre);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by a specific year //ok
    public List<Book> getBookByPublishYear(String publishYear) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * from Book where PublishYear like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, publishYear);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //get book by an author  //ok
    public List<Book> getBookByAuthor(String author) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * from Book where Author like ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, author);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //Add a book to Book Table (Get available book from BookInventory)  // ok
    //Add THỦ CÔNG
//    public void addBook(String bookName, String ISBN, String author, String genre, String publisher, String publishYear, String versionInLibrary, float price, String isRemaining, int locationId, int invenrotyId) {
//        try {
//            String addStatement = "INSERT INTO Book VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            stm = connect.prepareStatement(addStatement);
//            stm.setString(1, bookName);
//            stm.setString(2, ISBN);
//            stm.setString(3, author);
//            stm.setString(4, genre);
//            stm.setString(5, publisher);
//            stm.setString(6, publishYear);
//            stm.setString(7, versionInLibrary);
//            stm.setFloat(8, price);
//            stm.setString(9, isRemaining);
//            stm.setInt(10, locationId);
//            stm.setInt(11, invenrotyId);
//            stm.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//    }
    //Add bằng thủ tục (PROCEDURE) // Chèn ảnh theo đường dẫn cụ thể
    public void addBookByStoredProcedure(int BookId, String bookName, String ISBN, String author, String genre, String publisher, String publishYear, float price, int locationId, int invenrotyId, String imagePath) {
//       EXEC AddBookToLibrary @BookId, @BookName, @ISBN, @Author, @Genre, @Publisher, @PublishYear, @Price, @LocationId, @InventoryId, @ImagePath
        try {
            List<Book> bookList = getAllBook();
            int size = bookList.size();
            String storedProcedure = "EXEC AddBookToLibrary ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            stm = connect.prepareStatement(storedProcedure);
            stm.setInt(1, size + 1);
            stm.setString(2, bookName);
            stm.setString(3, ISBN);
            stm.setString(4, author);
            stm.setString(5, genre);
            stm.setString(6, publisher);
            stm.setString(7, publishYear);
            stm.setFloat(8, price);
            stm.setInt(9, locationId);
            stm.setInt(10, invenrotyId);
            stm.setString(11, imagePath);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    //search a book by 5 fiels: BookName, Genre, Author, Publisher, PublishYear   // ok
    public List<Book> searchBookBy5Fields(String BookName, String Genre, String Author, String Publisher, String PublishYear) {
        List<Book> list = new ArrayList<>();
        try {
            String queryStatment = "select * \n"
                    + "from Book\n"
                    + "where BookName = ? and Author = ? and Genre = ? and Publisher = ? and PublishYear = ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, BookName);
            stm.setString(2, Genre);
            stm.setString(3, Author);
            stm.setString(4, Publisher);
            stm.setString(5, PublishYear);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //Hiển thị các thông tin về số lượng sách còn lại của 1 quyển sách trong Kho (BookInventory)          //ok
    public List<Book_BookInventory_BookPurchases_Collapse> showOneBookFromInventoryWithQuantity(String bookName) {
        List<Book_BookInventory_BookPurchases_Collapse> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT DISTINCT BookPurchases.BookName, BookInventory.OriginalQuantity, BookInventory.TakenQuantity, BookInventory.RemainQuantity, BookInventory.RefreshDate,BookPurchases.PurchasesId, BookPurchases.PurchaseDate \n"
                    + "FROM BookInventory INNER JOIN\n"
                    + " BookPurchases ON BookPurchases.PurchasesId = BookInventory.PurchasesId\n"
                    + " where BookPurchases.BookName LIKE ?";
            stm = connect.prepareStatement(queryStatment);
            stm.setString(1, bookName);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book_BookInventory_BookPurchases_Collapse(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6), rs.getDate(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //Hiển thị các thông tin về số lượng của tất cả sách còn lại trong Kho (BookInventory)         //ok
    public List<Book_BookInventory_BookPurchases_Collapse> showAllBookFromInventoryWithQuantity() {
        List<Book_BookInventory_BookPurchases_Collapse> list = new ArrayList<>();
        try {
            String queryStatment = "SELECT DISTINCT BookPurchases.BookName, BookInventory.OriginalQuantity, BookInventory.TakenQuantity, BookInventory.RemainQuantity, BookInventory.RefreshDate,BookPurchases.PurchasesId, BookPurchases.PurchaseDate \n"
                    + "FROM BookInventory INNER JOIN\n"
                    + " BookPurchases ON BookPurchases.PurchasesId = BookInventory.PurchasesId";
            stm = connect.prepareStatement(queryStatment);
            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
            while (rs.next()) {
                list.add(new Book_BookInventory_BookPurchases_Collapse(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6), rs.getDate(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    //search a book by 1 in 5 fiels: BookName, Genre, Author, Publisher, PublishYear   // ok
//    public List<Book> searchBookByAnyFields(String BookName,String Genre,String Author,String Publisher,String PublishYear) {
//        List<Book> list = new ArrayList<>();
//        try {
//            String queryStatment = "select * \n"
//                    + "from Book\n"
//                    + "where BookName = ? or Author = ? or Genre = ? or Publisher = ? or PublishYear = ?";
//            stm = connect.prepareStatement(queryStatment);
//            stm.setString(1, BookName);
//            stm.setString(2, Genre);
//            stm.setString(3, Author);
//            stm.setString(4, Publisher);
//            stm.setString(5, PublishYear);
//            rs = stm.executeQuery();//có dữ liệu trả về => dùng executeQuery
//            while (rs.next()) {
//                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getString(10), rs.getInt(11), rs.getInt(12)));
//            }
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//        return list;
//    }
    public static void main(String[] args) {
        BookDAO t = new BookDAO();
//        List<Book> l = t.getAllBook(); //         ok
//for (List obj : l) {
//            System.out.println(obj);
//        }
        //   Book l = t.getBookByID(1); //              ok
        //   System.out.println(l);

//          List<Book> harry = t.getBookByName("Harry Potter and the Sorcerer's Stone");//         ok
//          for (Book o : harry) {
//              System.out.println(o);
//        }
//          List<Book> getBookByPartName = t.getBookByPartOfName("vin");///             ok
//          for (Book o : getBookByPartName) {
//              System.out.println(o);
//        }
//         List<Book> getBookByPublisher = t.getBookByPublisher("Viking");///             ok
//          for (Book o : getBookByPublisher) {
//              System.out.println(o);
//        }
//         List<Book> getBookByGenre = t.getBookByGenre("Horror");///             ok
//          for (Book o : getBookByGenre) {
//              System.out.println(o);
//        }
//         List<Book> getBookByPublishYear = t.getBookByPublishYear("1948");///             ok
//          for (Book o : getBookByPublishYear) {
//              System.out.println(o);
//        }
//         List<Book> getBookByAuthor = t.getBookByAuthor("J. K. Rowling");///             ok
//          for (Book o : getBookByAuthor) {
//              System.out.println(o);
//        }
//        t.addBook("Quak quak", "123-456-789-123-5", "adu", "hoho", "hehe", "1996", "1st", 100000, "No", 1, 1);//ok
//          
//            t.addBookByStoredProcedure("To Kill a Mockingbird", "978-006-093-546-7", "Harper Lee", "Southern Gothic", "J. B. Lippincott & Co.", "1960", 195000.0f, 1, 1);
//            System.out.println("OK");
//            List<Book> b = t.getAllBookName();
//            for (Book obj : b) {                                  //ok
//                System.out.println(obj.getBookName());
//        }
//            List<Book> b = t.getBookByName("To Kill a Mockingbird");
//            for (Book book : b) {                                 //ok
//                System.out.println(book);
//        }
//            List<Book> b = t.getAllGenre();
//            for (Book book : b) {             //ok
//                System.out.println(book);
//        }
//            List<Book> b = t.getAllAuthor();
//            for (Book book : b) {             //ok
//                System.out.println(book);
//        }
//            List<Book> b = t.getAllPublisher();
//            for (Book book : b) {             //ok
//                System.out.println(book);
//        }
//            List<Book> b = t.getAllPubLishYear();
//            for (Book book : b) {             //ok
//                System.out.println(book);
//        }
//            List<Book> b = t.searchBook("Doctor Sleep", "Stephen King", "Horror", "Scribner", "2013");
//            for (Book book : b) {             //ok
//                System.out.println(book);
//        }
//        List<Book_BookInventory_BookPurchases_Collapse> l = t.showOneBookFromInventoryWithQuantity("Bird Box");
//        for (Book_BookInventory_BookPurchases_Collapse book : l) {             //ok
//            System.out.println(book);
//        }
//        List<Book_BookInventory_BookPurchases_Collapse> l = t.showAllBookFromInventoryWithQuantity();
//        for (Book_BookInventory_BookPurchases_Collapse book : l) {             //ok
//            System.out.println(book);
//        }
//EXEC AddBookToLibrary @BookId, @BookName, @ISBN, @Author, @Genre, @Publisher, @PublishYear, @Price, @LocationId, @InventoryId, @ImagePath
//        t.addBookByStoredProcedure(55, "Coraline", "978-038-080-734-5", "Neil Gaiman", "Horror", "HarperCollins", "2002", 260000, 4, 46, "D:\\Users\\Public\\Documents\\tai lieu ki 4 - fall2023\\PRJ301\\Image_Books_for_Library\\Coraline.jpg");
        //ok
        List<Book> l = t.getBookByName("To Kill a Mockingbird");
        for (Book obj : l) {            //ok
            System.out.println(obj);
        }
    }
}
