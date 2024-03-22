/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;
import model.Book_BookInventory_BookPurchases_Collapse;

/**
 *
 * @author User
 */
public class ControllershowBookQuantityFromInventory extends HttpServlet {

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
//            out.println("<title>Servlet ControllershowBookQuantityFromInventory</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllershowBookQuantityFromInventory at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        BookDAO dao = new BookDAO();
        List<Book> getAllBook = dao.getAllBookName();
        request.setAttribute("listBookName", getAllBook);
        String bookName = request.getParameter("bookName");
        request.setAttribute("getBookNameAgain", bookName);
        String bookPurchased = request.getParameter("bookPurchased");
        //---------------------------------------XEM SỐ LƯỢNG SÁCH CÒN LẠI---------------------------------------
        if (bookName != "") {//Nếu user chỉ ấn tìm kiếm mà ko chọn gì thì giá trị mặc định được gán ở trang jsp là "" (chuỗi rỗng)
            List<Book_BookInventory_BookPurchases_Collapse> listOne = dao.showOneBookFromInventoryWithQuantity(bookName);
            request.setAttribute("resultInventoryOne", listOne);
        }else{
            List<Book_BookInventory_BookPurchases_Collapse> listAll = dao.showAllBookFromInventoryWithQuantity();
            request.setAttribute("resultInventoryAll", listAll);
        }
        //---------------------------------------NHẬP SÁCH-------------CHƯA (BIẾT) LÀM GÌ :)---------------------------------------------

        request.getRequestDispatcher("AllBookFromInventoryWithQuantityShow.jsp").forward(request, response);
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
