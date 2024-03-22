<%-- 
    Document   : ManageAddReader
    Created on : Oct 23, 2023, 1:30:25 PM
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
                background-color: #d4edda;
                width: 50%;
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
            .addFail{
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .addFail ul{
                list-style: none;
                padding: 0px;
            }
            .addFail ul li{
                margin: 10px;
            }
            #message {

                text-align: center;
                width: 60%;
                margin: auto;
                background-color: #87CEEB;
                color: #003333;
                font-weight: bold;
                /*border: 1px solid #c3e6cb;*/
                padding: 10px;
                /*margin-bottom: 20px;*/
                border-radius: 4px;
            }
            .notification{
                font-family: Arial, sans-serif;
                text-align: center;
                font-weight: bold;
                color: #4cb700;
                margin-bottom: 10px;
                font-size: 18px;
            }
            .cannotAdd{
                color: #FF0000;
            }
        </style>
    </head>
    <body>
        <c:if test="${requestScope.cannotAdd==true}">
            <h1>THÊM ĐỘC GIẢ THẤT BẠI</h1>
            <div class="notification"><span class="cannotAdd">KHÔNG THỂ THÊM</span> độc giả với những thông tin <span class="cannotAdd">dưới đây</span> vào bảng "Reader" vì đã tồn tại dữ liệu trùng lặp. Hãy kiểm tra lại <span class="cannotAdd">Số điện thoại</span> hoặc <span class="cannotAdd">Email</span>.</div>
            <div class="message">
                <div class="addFail" id="message">
                    <ul>
                        <li>Tên độc giả: <c:out value="${requestScope.cOutFullName}"></c:out></li>
                        <li>Ngày sinh: <c:out value="${requestScope.cOutDOB}"></c:out></li>
                        <li>Số điện thoại: <c:out value="${requestScope.cOutSDT}"></c:out></li>
                        <li>Email: <c:out value="${requestScope.cOutEmail}"></c:out></li>
                        </ul> 
                    </div>
                </div>
        </c:if>

        <c:if test="${requestScope.cannotAdd==false}">
            <h1>THÊM ĐỘC GIẢ THÀNH CÔNG</h1>
            <div class="message">Bạn đã thêm độc giả "<c:out value="${requestScope.cOutFullName}"></c:out>" vào bảng "Reader", bao gồm những thông tin dưới đây:</div>
                <div class="flex">
                    <table>
                        <tr>
                            <th>Tên độc giả</th>
                            <th>Ngày sinh</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                        </tr>
                        <tr class="border-rds">
                            <td>${requestScope.cOutFullName}</td>
                        <td>${requestScope.cOutDOB}</td>
                        <td>${requestScope.cOutSDT}</td>
                        <td>${requestScope.cOutEmail}</td>
                    </tr>
                </table>
            </div>
        </c:if>
        <div id="back"><a href="managementReader">Quay lại</a></div>
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
