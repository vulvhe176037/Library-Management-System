/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserLoginDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserLogin;

/**
 *
 * @author User
 */
public class ControllerLogin extends HttpServlet {

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
//            out.println("<title>Servlet ControllerLogin</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerLogin at " + request.getContextPath () + "</h1>");
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
//        processRequest(request, response);
        response.sendRedirect("LoginPage.jsp");
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
//        processRequest(request, response);
        String accountName = request.getParameter("userName");
        String pass = request.getParameter("password");
        //Kiểm tra xem người dùng đã nhập tên người dùng và mật khẩu hay chưa
        if (accountName == null || accountName.isEmpty() || pass == null || pass.isEmpty()) {
            // Nếu không nhập đủ thông tin, quay lại trang jsp
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            return;
        }
        
        UserLoginDAO userlgDao = new UserLoginDAO();
        UserLogin account = userlgDao.login(accountName, pass);
        if (account == null) {
            request.setAttribute("mess", "Sai tài khoản hoặc mật khẩu.");
            request.setAttribute("userNameValue", accountName);
            request.setAttribute("passwordValue", pass);
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("accountSession", account);
            session.setMaxInactiveInterval(600);//a session with 600 seconds = 10 minutes
            response.sendRedirect("HomePage.jsp");
        }
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
