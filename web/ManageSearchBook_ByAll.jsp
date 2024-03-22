<%-- 
    Document   : ManageSearchBook
    Created on : Oct 22, 2023, 3:20:54 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG KẾT QUẢ TÌM SÁCH</title>
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
            .notification{
                font-family: Arial, sans-serif;
                text-align: center;
                font-weight: bold;
                color: #4cb700;
                margin-bottom: 10px;
                font-size: 18px;
            }
            #message {
                text-align: center;
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
                align-items: center;
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
            .searchFail{
                display: flex;
                justify-content: center;
                /*align-items: center;*/
            }

            ul{
                list-style: none;
                text-align: center;
                /*align-items: center;*/
                padding: 0; /* Loại bỏ khoảng cách giữa các dòng */
            }
            ul li{
                margin: 10px 0; /* Điều chỉnh khoảng cách giữa các dòng */
            }
            #notExist{
                color: #FF0000;
            }
        </style>
    </head>
    <body>
        <div>
            <c:if test="${requestScope.resultNotNull==false}">
                <h1>TÌM KIẾM THẤT BẠI</h1>
                <div class="notification">Thông tin của cuốn sách dưới đây <span id="notExist">KHÔNG TỒN TẠI</span>:</div>
                <div class="searchFail" id="message">
                    <ul>
                        <span><li>Tên sách: <c:out value="${requestScope.cOutBook}"></c:out></li>
                            <li>Tác giả: <c:out value="${requestScope.cOutAuthor}"></c:out></li>
                            <li>Thể loại: <c:out value="${requestScope.cOutGenre}"></c:out></li>
                            <li>Nhà xuất bản: <c:out value="${requestScope.cOutPublisher}"></c:out></li>
                            <li>Năm xuất bản: <c:out value="${requestScope.cOutYear}"></c:out></li></span>
                        </ul> 
                    </div>
            </c:if>
            <c:if test="${requestScope.resultNotNull==true}">
                <h1>KẾT QUẢ TÌM KIẾM</h1>
                <div class="searchSuccess">
                    <div id="message">Cuốn sách mà bạn đã tìm là "<c:out value="${cOutBook}"></c:out>", bao gồm những thông tin dưới đây:</div>
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
                                    <th>Được lưu hành</th>
                                </tr>
                            <c:forEach var="b" items="${requestScope.resultSearch}">
                                <tr class="border-rds">
                                    <td>${b.bookId}</td>
                                    <td>${b.bookName}</td>
                                    <td>${b.ISBN}</td>
                                    <td>${b.author}</td>
                                    <td>${b.genre}</td>
                                    <td>${b.publisher}</td>
                                    <td>${b.publishYear}</td>
                                    <td>${b.versionInLibrary}</td>
                                    <td>${b.price}</td>
                                    <td>
                                        <c:if test="${b.isRemaining=='Yes'}">Có</c:if>
                                        <c:if test="${b.isRemaining=='No'}">Không</c:if>
                                        </td>
                                        <!--<td >${b.locationId}</td>-->
                                        <!--<td >${b.inventoryId}</td>-->
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </c:if>
            <div id="back"><a href="managementBook">Quay lại</a></div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
