/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.BookInventoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author User
 */
public class ControllerManagementBook extends HttpServlet {

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
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerManagementBook</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerManagementBook at servletControllerManagement "+ remainIsMoreThanZero + "</h1>");
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
        BookDAO dao = new BookDAO();
        //---------------------------- PHẦN TÌM KIẾM SÁCH---------------------------
        //Lấy danh sách tất cả các "tên sách" và hiển thị trên trang jsp
        List<Book> listBookName = dao.getAllBookName();
        List<Book> listName = new ArrayList<>();
        for (int i = 0; i < listBookName.size(); i++) {
            listName.add(listBookName.get(i));
        }
        request.setAttribute("allBookName", listName);
        //Lấy danh sách tất cả các "thể loại sách" và hiển thị trên trang jsp
        List<Book> listGenre = dao.getAllGenre();
        List<Book> genre = new ArrayList<>();
        for (int i = 0; i < listGenre.size(); i++) {
            genre.add(listGenre.get(i));
        }
        request.setAttribute("allGenre", genre);

        //Lấy danh sách tất cả các "tác giả" và hiển thị trên trang jsp
        List<Book> listAuthor = dao.getAllAuthor();
        List<Book> author = new ArrayList<>();
        for (int i = 0; i < listAuthor.size(); i++) {
            author.add(listAuthor.get(i));
        }
        request.setAttribute("allAuthor", author);

        //Lấy danh sách tất cả các "nhà xuất bản" và hiển thị trên trang jsp
        List<Book> listNhaXuatBan = dao.getAllPublisher();
        List<Book> nhaXuatBan = new ArrayList<>();
        for (int i = 0; i < listNhaXuatBan.size(); i++) {
            nhaXuatBan.add(listNhaXuatBan.get(i));
        }
        request.setAttribute("allNhaXuatBan", nhaXuatBan);

        //Lấy danh sách tất cả các "năm xuất bản" và hiển thị trên trang jsp
        List<Book> listNamXuatBan = dao.getAllPubLishYear();
        List<Book> namXuatBan = new ArrayList<>();
        for (int i = 0; i < listNamXuatBan.size(); i++) {
            namXuatBan.add(listNamXuatBan.get(i));
        }
        request.setAttribute("allNamXuatBan", namXuatBan);
//------------------------------PHẦN THÊM SÁCH---------------------------------------
        List<Book> listBookName2 = dao.getAllBookName();
        List<Book> listName2 = new ArrayList<>();
        for (int i = 0; i < listBookName2.size(); i++) {
            listName2.add(listBookName2.get(i));
        }
        request.setAttribute("allBookName2", listName2);
//        //----------------------------Vùng lỗi không lấy được tham số từ người dùng-----------------------
//        String nameOfBookFromUserSelected = request.getParameter("name");
//        //----------------------------Vùng lỗi không lấy được tham số từ người dùng-----------------------
//        BookInventoryDAO inventoryDao = new BookInventoryDAO();
//        //Kiểm tra cuốn sách cần thêm vào Book table có còn RemainQuantity (Trong BookInventory) hay không?
//        boolean remainIsMoreThanZero = inventoryDao.checkRemainQuantityOfABook_MoreThanZero(nameOfBookFromUserSelected);
//        request.setAttribute("TheLeftMoreThanZero", remainIsMoreThanZero);
        request.getRequestDispatcher("BookManagement.jsp").forward(request, response);
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
