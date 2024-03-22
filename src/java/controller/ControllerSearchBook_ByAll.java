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

/**
 *
 * @author User
 */
public class ControllerSearchBook_ByAll extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

            String pBookName = request.getParameter("searchBookName"); 
            String pAuthor = request.getParameter("searchAuthor");
            String pGenre = request.getParameter("searchGenre");
            String pPublisher = request.getParameter("searchPublisher");
            String pYear = request.getParameter("searchPublishYear");
            
            BookDAO dao = new BookDAO();
            List<Book> listSearch = dao.searchBookBy5Fields(pBookName, pAuthor, pGenre, pPublisher, pYear);
            request.setAttribute("resultSearch", listSearch);
            request.setAttribute("cOutBook", pBookName);
            request.setAttribute("cOutAuthor", pAuthor);
            request.setAttribute("cOutGenre", pGenre);
            request.setAttribute("cOutPublisher", pPublisher);
            request.setAttribute("cOutYear", pYear);
            if(!listSearch.isEmpty()){
                request.setAttribute("resultNotNull", true);
            } else {
                request.setAttribute("resultNotNull", false);
            }
            request.getRequestDispatcher("ManageSearchBook_ByAll.jsp").forward(request, response);

////--------------------------------------------TEST DATA---------------------------------------
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerSearchBook_ByAll</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerSearchBook_ByAll at " + pBookName + "</h1>");  //get OK
//            out.println("<h1>Servlet ControllerSearchBook_ByAll at " + pAuthor + "</h1>");  /// get OK
//            out.println("<h1>Servlet ControllerSearchBook_ByAll at " + pGenre + "</h1>");  //get OK
//            out.println("<h1>Servlet ControllerSearchBook_ByAll at " + pPublisher + "</h1>");  //get OK
//            out.println("<h1>Servlet ControllerSearchBook_ByAll at " + pYear + "</h1>");  //get OK
//            out.println("</body>");
//            out.println("</html>");
//        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
