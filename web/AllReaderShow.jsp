<%-- 
    Document   : AllReaderShow
    Created on : Oct 21, 2023, 1:53:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG HIỂN THỊ ĐỘC GIẢ</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
        <h1 id="h1">ĐỘC GIẢ</h1>
        <div class="flex">
            <table>
                <tr>
                    <th>Mã độc giả</th>
                    <th>Họ và Tên</th>
                    <th>Ngày sinh</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Số lượng sách đã mượn</th>
                    <th>Số lượng sách đã trả</th>
                </tr>
                <c:forEach var="reader" items="${requestScope.listReader}">
                    <tr>
                        <td>${reader.readerId}</td>
                        <td>${reader.fullNameReader}</td>
                        <td><fm:formatDate value="${reader.dateOfBirth}" pattern="dd-MM-yyyy"/></td>
                        <td>${reader.phoneNumber}</td>
                        <td>${reader.email}</td>
                        <td>${reader.numberOfBooksBorrowed}</td>
                        <td>${reader.numberOfBooksReturned}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="back"><a href="managementReader">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
