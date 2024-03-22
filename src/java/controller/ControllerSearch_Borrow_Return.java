/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BorrowedBookDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import model.BorrowedBook;

/**
 *
 * @author User
 */
public class ControllerSearch_Borrow_Return extends HttpServlet {

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
        
        String bookName = request.getParameter("bookName_field");
        String readerName = request.getParameter("reader_field");
        String librarianName = request.getParameter("librarian_field");
        String dateBorrow = request.getParameter("dateBorrow_field");

        BorrowedBookDAO dao = new BorrowedBookDAO();
        List<BorrowedBook> listByBookName = dao.searchBorrowedBookByBookName(bookName);
        List<BorrowedBook> listByReaderName = dao.searchBorrowedBookByReaderName(readerName);
        List<BorrowedBook> listByLibrarianName = dao.searchBorrowedBookByLibrarianName(librarianName);
        List<BorrowedBook> listByDateBorrow = dao.searchBorrowedBookByBorrowDate(dateBorrow);

        if (!listByBookName.isEmpty()) {
            request.setAttribute("resultSearchBorrowReturn", listByBookName);
        }
        if (!listByReaderName.isEmpty()) {
            request.setAttribute("resultSearchBorrowReturn", listByReaderName);
        }
        if (!listByLibrarianName.isEmpty()) {
            request.setAttribute("resultSearchBorrowReturn", listByLibrarianName);
        }
        if (!listByDateBorrow.isEmpty()) {
            request.setAttribute("resultSearchBorrowReturn", listByDateBorrow);
        }
        
        request.getRequestDispatcher("ManageSearch_BorrowReturn_ByOne.jsp").forward(request, response);
//        int size = listByBookName.size();
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerSearch_Borrow_Return</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerSearch_Borrow_Return at " + bookName + "</h1>");
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
