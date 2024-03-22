<%-- 
    Document   : AllBookShow
    Created on : Oct 20, 2023, 12:56:28 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALL OF BOOK</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
          
            .flex{
                display: flex;
                /*justify-content: space-around;*/
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #fff6d1;
                margin: 0;
                padding: 80px;
            }

            h1{
                color: #ff755d;
                text-align: center;
            }

            a {
                color: #007bff;
                text-decoration: none;
            }

            a:hover {
                text-decoration: underline;
            }

            /*            button[type="submit"] {
                            background-color: #007bff;
                            color: #fff;
                            border: none;
                            padding: 10px 20px;
                            border-radius: 4px;
                            cursor: pointer;
                        }*/

            table {
                border-collapse: collapse; /*kết hợp các border thay vì border riêng lẻ cho từng ô td*/
                width: 100%;
            }

            th, td {
                border: 1px solid black;
                padding: 13px;
                text-align: center;
            }

            th {
                background-color: #4CAF50; /* Màu nền cho hàng đầu tiên (tiêu đề) */
                color: white;
            }

            td:first-child, th:first-child {
                /*border-radius: 5px 0 0 5px;*/
            }

            td:last-child, th:last-child {
                /*border-radius: 0 5px 5px 0;*/
            }

            tr:nth-child(odd) td {
                background-color: #FFA07A; /*Màu nền cho các hàng lẻ*/
            }

            tr:nth-child(even) td {
                background-color: #87CEEB; /* Màu nền cho các hàng chẵn */
            }
            #bookName{
                width: 20%;
            }
            #back{
                text-align: center;
                margin: 20px;
            }
            a {
                color: #007bff;
                text-decoration: none;
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            a:hover {
                text-decoration: none;
            }
            #h1{
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <h1 id="h1">SÁCH</h1>
        <div class="flex">
            <table>
                <tr>
                    <th>Mã sách</th>
                    <th id="bookName">Tên sách</th>
                    <th>ISBN</th>
                    <th>Tác giả</th>
                    <th>Thể loại</th>
                    <th>Nhà xuất bản</th>
                    <th>Năm xuất bản</th>
                    <th>Bản số</th>
                    <th>Giá</th>
                    <th>Được lưu hành</th><!-- Có: tức là sách vẫn có thể sử dụng  / Không: tức là sách đã hỏng/được lưu trữ/không đem ra sử dụng được nữa -->
                    <!--<th >Vị trí</th>-->
                    <!--<th >Kho số</th>-->
                    <!--<th>Đường dẫn</th>-->
                </tr>
                <c:forEach var="book" items="${requestScope.listBook}">
                    <tr class="border-rds">
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.ISBN}</td>
                        <td>${book.author}</td>
                        <td>${book.genre}</td>
                        <td>${book.publisher}</td>
                        <td>${book.publishYear}</td>
                        <td>${book.versionInLibrary}</td>
                        <td>${book.price}</td>
                        <td>
                            <c:if test="${book.isRemaining=='Yes'}">
                                Có
                            </c:if>
                            <c:if test="${book.isRemaining=='No'}">
                                Không
                            </c:if>
                        </td>
                        <!--<td >${book.locationId}</td>-->
                        <!--<td >${book.inventoryId}</td>-->
                        <!--<td>${book.imagePath}</td>-->
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="back"><a href="managementBook">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
