/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.BorrowedBookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author User
 */
public class ControllerDisplayBookStatus extends HttpServlet {

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
        String bookSelected = request.getParameter("displaySelected");
        BookDAO dao = new BookDAO();
        //return a path to image file: 
        String imagePath = getImagePathForBook("D:\\Users\\Public\\Documents\\tai lieu ki 4 - fall2023\\PRJ301\\APACHE_NETBEANS_PROJECT\\LibraryManagementSystem\\web\\picture_for_book_library\\", bookSelected);
        String PATH_TO_IMAGE_FILE = imagePath.substring(imagePath.lastIndexOf("\\") + 1);
        request.setAttribute("pathToImage", PATH_TO_IMAGE_FILE);
        List<Book> listBook = dao.getBookReturnSttByName(bookSelected);
        request.setAttribute("listBookOfBookNameSelected", listBook);
        request.getRequestDispatcher("DisplayStatusOfABook.jsp").forward(request, response);

//            try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerDisplayBookStatus</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerDisplayBookStatus at " + PATH_TO_IMAGE_FILE + "</h1>");
//            //trả về 1 đường dẫn cụ thể của ảnh
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

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
