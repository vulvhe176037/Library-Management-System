/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.BookInventoryDAO;
import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;

/**
 *
 * @author User
 */
public class ControllerAddBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BookDAO bookDao = new BookDAO();
        String nameOfBookFromUserSelected = request.getParameter("bookName");

        //get all information of book by that bookName
        List<Book> bookList = bookDao.getBookByNameButOnlyOneBook(nameOfBookFromUserSelected);
        request.setAttribute("listOfBook", bookList);
        request.setAttribute("thatBook", nameOfBookFromUserSelected);

        BookInventoryDAO inventoryDao = new BookInventoryDAO();
        //Kiểm tra cuốn sách cần thêm vào Book table có còn RemainQuantity (Trong BookInventory) hay không?
        boolean remainIsMoreThanZero = inventoryDao.checkRemainQuantityOfABook_MoreThanZero(nameOfBookFromUserSelected);
        if (remainIsMoreThanZero == true) {
            Book b = bookList.get(0);
            String imagePath = getImagePathForBook("D:\\Users\\Public\\Documents\\tai lieu ki 4 - fall2023\\PRJ301\\APACHE_NETBEANS_PROJECT\\LibraryManagementSystem\\web\\picture_for_book_library", b.getBookName());
            bookDao.addBookByStoredProcedure(b.getBookId(), b.getBookName(), b.getISBN(), b.getAuthor(), b.getGenre(), b.getPublisher(), b.getPublishYear(), b.getPrice(), b.getLocationId(), b.getInventoryId(), imagePath);
        }
        request.setAttribute("ThereWasLeftBookInventory", remainIsMoreThanZero);
        request.getRequestDispatcher("ManageAddBook.jsp").forward(request, response);
    }
////        ---------------------------TEST DATA----------- PERFECT--------------
//    //         try ( PrintWriter out = response.getWriter()) {
//    //                /* TODO output your page here. You may use following sample code. */
//    //                out.println("<!DOCTYPE html>");
//    //                out.println("<html>");
//    //                out.println("<head>");
//    //                out.println("<title>Servlet ControllerManageBook</title>");
//    //                out.println("</head>");
//    //                out.println("<body>");
//    //                out.println("<h1>Servlet ControllerManageBook at " + imagePath + "</h1>");
//    //                out.println("</body>");
//    //                out.println("</html>");
//    //            }
    //quạc quạc quạc
//    }


    public String getImagePathForBook(String directoryPath, String bookName) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            return null;
        }

        File[] imageFiles = directory.listFiles((dir, name)
                -> (name.endsWith(".jpg") || name.endsWith(".png")) && name.contains(bookName)
        );

        if (imageFiles != null && imageFiles.length > 0) {
            return imageFiles[0].getAbsolutePath();
        }

        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
