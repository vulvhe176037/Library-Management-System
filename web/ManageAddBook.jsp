<%-- 
    Document   : ManageAddBook
    Created on : Oct 22, 2023, 12:27:54 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG KẾT QUẢ THÊM SÁCH</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #fff6d1;
                margin: 0;
                padding: 20px;
            }

            h1 {
                color: #ff755d;

                margin-bottom: 20px;
                text-align: center;
            }

            .message {
                text-align: center;
                /*background-color: #d4edda;*/
                width: 60%;
                margin: auto;
                background-color: #87CEEB;
                color: #003333;
                font-weight: bold;
                border: 1px solid #c3e6cb;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 4px;
            }

            .flex {
                display: flex;
                justify-content: center;
            }

            table {
                border-collapse: collapse;
                width: 100%;
                margin-bottom: 20px;
            }

            th, td {
                padding: 8px;
                text-align: center;
                border-bottom: 1px solid #ddd;
                border-top: 1px solid #ddd;
                border-left: 1px solid #ddd;
                border-right: 1px solid #ddd;
            }

            th {
                /*              background-color: #007bff;*/
                background-color: #4CAF50;
                color: #fff;
            }

            tr.border-rds td:first-child {
                border-top-left-radius: 5px;
                border-bottom-left-radius: 5px;
            }

            tr.border-rds td:last-child {
                border-top-right-radius: 5px;
                border-bottom-right-radius: 5px;
            }

            a {
                color: #007bff;
                text-decoration: none;
            }

            a:hover {
                text-decoration: underline;
            }

            #back{
                text-align: center;
                margin: 10px;
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
        </style>
    </head>
    <body>
        <c:if test="${requestScope.ThereWasLeftBookInventory==true}">
            <h1>THÊM SÁCH THÀNH CÔNG</h1>
            <div class="message">Bạn đã thêm cuốn sách "<c:out value="${requestScope.thatBook}"></c:out>" vào bảng "Book", bao gồm những thông tin dưới đây:</div>
                <div class="flex">
                    <table>
                        <tr>
                            <th hidden>Mã sách</th>
                            <th id="bookName">Tên sách</th>
                            <th>ISBN</th>
                            <th>Tác giả</th>
                            <th>Thể loại</th>
                            <th>Nhà xuất bản</th>
                            <th>Năm xuất bản</th>
                            <th hidden>Bản số</th>
                            <th>Giá</th>
                            <th hidden>Được lưu hành</th>
                        </tr>
                    <c:forEach var="b" items="${requestScope.listOfBook}">
                        <tr class="border-rds">
                            <td hidden>${b.bookId}</td>
                            <td>${b.bookName}</td>
                            <td>${b.ISBN}</td>
                            <td>${b.author}</td>
                            <td>${b.genre}</td>
                            <td>${b.publisher}</td>
                            <td>${b.publishYear}</td>
                            <td hidden>${b.versionInLibrary}</td>
                            <td>${b.price}</td>
                            <td hidden>${b.isRemaining}</td>
                            <!--<td >${b.locationId}</td>-->
                            <!--<td >${b.inventoryId}</td>-->
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <c:if test="${requestScope.ThereWasLeftBookInventory==false}">
            <h1>THÊM SÁCH THẤT BẠI</h1>
            <div class="message">Số lượng sách "<c:out value="${requestScope.thatBook}"></c:out>" trong kho không đủ để thêm :(</div>
        </c:if>
        <div id="back"><a href="managementBook">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>