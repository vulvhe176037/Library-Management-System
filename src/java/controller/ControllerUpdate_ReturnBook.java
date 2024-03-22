/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BorrowedBookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BorrowedBook;

/**
 *
 * @author User
 */
public class ControllerUpdate_ReturnBook extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerUpdate_ReturnBook</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerUpdate_ReturnBook at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String readerId = request.getParameter("readerId");
        String borrowId = request.getParameter("borrowId");
        String returnDate = request.getParameter("bookReturnDate");
        String bookQuality = request.getParameter("bookQuality");
        int readerID = Integer.parseInt(readerId);
        int borrowID = Integer.parseInt(borrowId);

        BorrowedBookDAO borrowdao = new BorrowedBookDAO();

        // Kiểm tra độc giả có tồn tại ko
        if (!borrowdao.checkReaderExist(readerID)) {
            request.setAttribute("errorMessage", "Độc giả không tồn tại.");
            request.getRequestDispatcher("ManageUpdate_BorrowReturn_Book.jsp").forward(request, response);
//            return;
        } else if (borrowdao.checkBorrowedBookHasCompleted(borrowID)) { //Kiểm tra xem phiên mượn đã được hoàn tất trước đó hay chưa?
            request.setAttribute("errorMessage", "Không thể cập nhật phiên mượn đã được hoàn tất.");
            request.getRequestDispatcher("ManageUpdate_BorrowReturn_Book.jsp").forward(request, response);
//            return;
        } else if (borrowdao.getBorrowedBookByID(borrowID).isEmpty()) {//Kiểm tra phiên mượn có tồn tại không
            request.setAttribute("errorMessage", "Phiên mượn không tồn tại.");
            request.getRequestDispatcher("ManageUpdate_BorrowReturn_Book.jsp").forward(request, response);
//            return;
        } else if (!borrowdao.checkBorrowedBookHasCompleted(borrowID)) {
            borrowdao.update_BorrowedBook_ByProcedure(readerID, borrowID, returnDate, bookQuality);
            List<BorrowedBook> l = borrowdao.checkBorrowedWithBorrowId_ReaderId(borrowID, readerID);
            request.setAttribute("returnBookRecentUpdate", l);
            request.setAttribute("successMessage", "note");
            request.getRequestDispatcher("ManageUpdate_BorrowReturn_Book.jsp").forward(request, response);
        } else {//(borrowdao.checkBorrowedBook_NOT_Completed(borrowID))
//            borrowdao.checkReaderExist(readerID) && !borrowdao.checkBorrowedBookHasCompleted(borrowID) && !borrowdao.getBorrowedBookByID(borrowID).isEmpty() && !borrowdao.checkBorrowedBook_NOT_Completed(borrowID)
            request.setAttribute("errorMessage", "Phiên trả sách đã được cập nhật trước đó nên không thể cập nhật lại.");
            request.getRequestDispatcher("ManageUpdate_BorrowReturn_Book.jsp").forward(request, response);

        }

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
