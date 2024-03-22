<%-- 
    Document   : AllBookFromInventoryWithQuanTityShow
    Created on : Oct 24, 2023, 8:00:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KẾT QUẢ THÊM PHIÊN MƯỢN/TRẢ SÁCH</title>
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
                padding: 80px;
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

            a {
                color: #007bff;
                text-decoration: none;
            }

            a:hover {
                text-decoration: underline;
            }
            #back{
                text-align: center;
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
            #notExist{
                color: #FF0000;
            }
            .formSearch{
                text-align: center;
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
            #borrowID{
                width: 5%;
            }
            .adjust-width{
                width: 10%;
            }
            .center{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <c:if test="${requestScope.errorMessage!=null}">
            <h1>THÊM PHIÊN MƯỢN SÁCH THẤT BẠI</h1>
            <h3 class="center">${requestScope.errorMessage}</h3>
        </c:if>
        <c:if test="${requestScope.errorMessage==null}">
            <h1>THÊM PHIÊN MƯỢN SÁCH THÀNH CÔNG</h1>
            <div>
                <table>
                    <tr>
                        <th id="borrowID">Mã phiên mượn</th>
                        <th class="adjust-width">Ngày mượn</th>
                        <th>Trạng thái trả</th>
                        <th class="adjust-width">Ngày trả</th>
                        <th>Tình trạng sách trước khi mượn</th>
                        <th>Tình trạng sách sau khi mượn</th>
                        <th>Vi phạm nội quy thư viện</th>
                        <th>Tổng phí phạt (VNĐ)</th>
                        <th>Mã thủ thư</th>
                        <th>Mã độc giả</th>
                        <th>Mã sách</th>
                    </tr>
                    <c:forEach var="list" items="${requestScope.listRecentBorrowedBook}">
                        <tr class="border-rds">
                            <td>${list.borrowId}</td>
                            <td>${list.borrowDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${list.returnStatus=='Done'}">Đã trả</c:when>
                                    <c:otherwise>Chưa trả</c:otherwise>
                                </c:choose>      
                            </td>
                            <td>
                                <c:if test="${list.returnDate!=null}">${list.returnDate}</c:if>
                                <c:if test="${list.returnDate==null}">Chưa cập nhật</c:if>
                                </td>
                                <td>
                                <c:if test="${list.bookSttBefore=='New'}">Mới</c:if>
                                <c:if test="${list.bookSttBefore=='Good'}">Tốt</c:if>
                                <c:if test="${list.bookSttBefore=='Lower'}">Trung bình</c:if>
                                <c:if test="${list.bookSttBefore=='Worst'}">Kém</c:if>

                                </td>
                                <td>
                                <c:choose>
                                    <c:when test="${list.bookSttAfter=='New'}">Mới</c:when>
                                    <c:when test="${list.bookSttAfter=='Good'}">Tốt</c:when>
                                    <c:when test="${list.bookSttAfter=='Lower'}">Trung bình</c:when>
                                    <c:when test="${list.bookSttAfter=='Worst'}">Kém</c:when>
                                    <c:otherwise>Chưa cập nhật</c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:if test="${list.numberOfFlag=='1'}">Có</c:if>
                                <c:if test="${list.numberOfFlag=='0'}">Không</c:if>
                                </td>
                                <td>${list.totalFine}</td>
                            <td>${list.librarianId}</td>
                            <td>${list.readerId}</td>
                            <td>${list.bookId}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <div id="back"><a href="managementBorrowReturn">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
