/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ReaderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Reader;

/**
 *
 * @author User
 */
public class ControllerSearchReader_OneField extends HttpServlet {

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
//            out.println("<title>Servlet ControllerSearchReader_OneField</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerSearchReader_OneField at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String readerName = request.getParameter("inputReaderName");
        request.setAttribute("cOutReaderName", readerName);//dùng để hiển thị lại thông báo
        String readerDOB = request.getParameter("inputReaderDOB");
        request.setAttribute("cOutReaderDOB", readerDOB);//dùng để hiển thị lại thông báo
        String readerSDT = request.getParameter("inputReaderSDT");
        request.setAttribute("cOutReaderSDT", readerSDT);//dùng để hiển thị lại thông báo
        String readerEmail = request.getParameter("inputReaderEmail");
        request.setAttribute("cOutReaderEmail", readerEmail);//dùng để hiển thị lại thông báo

        ReaderDAO dao = new ReaderDAO();
        List<Reader> listByFullName = dao.getAllReaderByFullName(readerName);
        List<Reader> listByDOB = dao.getAllReaderByDOB(readerDOB);
        List<Reader> listByPhoneNumber = dao.getAllReaderByPhoneNumber(readerSDT);
        List<Reader> listByEmail = dao.getAllReaderByEmail(readerEmail);

        if (!listByFullName.isEmpty()) {
            request.setAttribute("resultSearchReader", listByFullName);
        }
        if (!listByDOB.isEmpty()) {
            request.setAttribute("resultSearchReader", listByDOB);
        }
        if (!listByPhoneNumber.isEmpty()) {
            request.setAttribute("resultSearchReader", listByPhoneNumber);
        }
        if (!listByEmail.isEmpty()) {
            request.setAttribute("resultSearchReader", listByEmail);
        }
        request.getRequestDispatcher("ManageSearchReader_OneField.jsp").forward(request, response);
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
