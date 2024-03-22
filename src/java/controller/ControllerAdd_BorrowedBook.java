/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.BookInventoryDAO;
import dal.BorrowedBookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import model.Book;
import model.BorrowedBook;

/**
 *
 * @author User
 */
public class ControllerAdd_BorrowedBook extends HttpServlet {

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

        String bookIdInput = request.getParameter("inputBookId");
        String ReaderIdInput = request.getParameter("inputReaderId");
        String LibrarianIdInput = request.getParameter("inputLibrarianId");

        BorrowedBookDAO borrowdao = new BorrowedBookDAO();
        int bookId = 0;
        int readerId = 0;
        int librarianId = 0;
        if (bookIdInput != null) {
            bookId = Integer.parseInt(bookIdInput);
        }
        if (ReaderIdInput != null) {
            readerId = Integer.parseInt(ReaderIdInput);
        }
        if (LibrarianIdInput != null) {
            librarianId = Integer.parseInt(LibrarianIdInput);
        }
        // Kiểm tra độc giả có tồn tại ko
        if (!borrowdao.checkReaderExist(readerId)) {
            request.setAttribute("errorMessage", "Độc giả không tồn tại.");
            request.getRequestDispatcher("ManageAdd_BorrowReturn_Book.jsp").forward(request, response);
            return;
        }
        if (!borrowdao.checkBookIdExist(bookId)) {//BookId cần thêm vào ko tồn tại
            request.setAttribute("errorMessage", "Sách không tồn tại.");
            request.getRequestDispatcher("ManageAdd_BorrowReturn_Book.jsp").forward(request, response);
            return;
        }
        // Kiểm tra sách đã được mượn hay chưa
        if (borrowdao.checkBookIdHasBeenBorrowed(bookId)) {
            request.setAttribute("errorMessage", "Sách đã được mượn.");
            request.getRequestDispatcher("ManageAdd_BorrowReturn_Book.jsp").forward(request, response);
            return;
        }
        
        // Kiểm tra thủ thư có tồn tại ko
        if (!borrowdao.checkLibrarianExist(librarianId)) {
            request.setAttribute("errorMessage", "Thủ thư không tồn tại.");
            request.getRequestDispatcher("ManageAdd_BorrowReturn_Book.jsp").forward(request, response);
            return;
        }
        // Thêm phiên mượn sách vào cơ sở dữ liệu
        if (borrowdao.add_BorrowedBook_ByProcedure(readerId, bookId, librarianId)) {
            List<BorrowedBook> l = borrowdao.getRecentBorrowedBook();
            request.setAttribute("listRecentBorrowedBook", l);
            request.setAttribute("errorMessage", null);
            request.getRequestDispatcher("ManageAdd_BorrowReturn_Book.jsp").forward(request, response);
//            request.setAttribute("addSuccess", true);
        } 

//        lấy phiên mượn mới nhất /mới add vào => gửi lên trang jsp để báo thành công
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerAdd_BorrowedBook</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerAdd_BorrowedBook at " + b.getAuthor() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
