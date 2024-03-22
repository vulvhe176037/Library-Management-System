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
        <title>TRANG HIỂN THỊ SỐ LƯỢNG SÁCH TRONG KHO</title>
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
                /*background-color: #007bff;*/
                background-color: #4CAF50;
                color: #fff;
            }

            tr.border-rds td:first-child {
                /*border-top-left-radius: 5px;*/
                /*border-bottom-left-radius: 5px;*/
            }

            tr.border-rds td:last-child {
                /*border-top-right-radius: 5px;*/
                /*border-bottom-right-radius: 5px;*/
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
            ul li{
                margin: 10px 0; /* Điều chỉnh khoảng cách giữa các dòng */
            }
            #notExist{
                color: #FF0000;
            }
            .formSearch{
                text-align: center;
                margin-bottom: 20px;
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
            button[type="submit"] {
                background-color: #00cccc;
                color: #fff;
                border: none;
                padding: 11px 18px;
                border-radius: 4px;
                cursor: pointer;
            }
            .container {
                /*align-items: center;*/
                /*margin: 10px auto;*/
                background-color: #fff;
                padding: 10px 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);

            }
        </style>
    </head>
    <body>
        <h1>SỐ LƯỢNG SÁCH TRONG KHO</h1>
        <form method="post" action="showQuantityBookInventory">
            <div class="formSearch">
                <!-------------------------------------XEM SỐ LƯỢNG SÁCH TỪNG CUỐN - TẤT CẢ-------------------------------->
                <c:set var="varOption" value="0"/>
                <select class="container" name="bookName">
                    <option value="">--- Chọn tên sách ---</option>
                    <c:forEach var="opt" items="${requestScope.listBookName}">
                        <c:set var="alsoBookName" value="${requestScope.getBookNameAgain}"></c:set>
                        <option id="idBook${varOption}" value="${opt.bookName}" ${alsoBookName eq opt.bookName ?"selected":""}>${opt.bookName}</option>
                        <c:set var="varOption" value="${varOption + 1}" />
                    </c:forEach>
                </select>
                <button type="submit">Tìm kiếm</button>
            </div>
        </form>
        <form method="post" action="showQuantityBookInventory">
            <!-------------------------------------CHỌN SÁCH ĐỂ NHẬP SÁCH NẾU NHƯ CUỐN ĐÓ ĐÃ HẾT-------------------------------->
            <%--<c:set var="varOption" value="0"/>--%>
            <!--<select name="bookPurchased">-->
            <!--<option value="">--- Chọn tên sách ---</option>-->
            <%--<c:forEach var="opt" items="${requestScope.listBookName}">--%>
                <!--<option id="idBook${varOption}" value="${opt.bookName}">${opt.bookName}</option>-->
            <%--<c:set var="varOption" value="${varOption + 1}" />--%>
            <%--</c:forEach>--%>
            <!--</select>-->
            <!--<button type="submit">Nhập sách</button>-->
            <!--</form>-->
            <c:choose>
                <c:when test="${requestScope.resultInventoryOne!=null}">
                    <div>
                        <table>
                            <tr>
                                <th id="bookName">Tên sách</th>
                                <th>Số lượng gốc</th>
                                <th>Số lượng đã lấy ra</th>
                                <th>Số lượng còn lại</th>
                                <th>Ngày cập nhật</th>
                                <th>Đợt nhập sách</th>
                                <th>Ngày nhập sách</th>
                            </tr>
                            <c:forEach var="cart" items="${requestScope.listCart}">
                                <tr>
                                    <td>cart.bookId</td>
                                    <td>cart.bookName</td>
                                    <td></td>
                                    <td></td>
                                </tr> 
                            </c:forEach>
                            
                            <c:forEach var="b" items="${requestScope.resultInventoryOne}">
                                <c:choose>
                                    <c:when test="${b.remainQuantity>0}">
                                        <tr style="background-color: #87CEEB;" class="border-rds">
                                            <td>${b.bookName}</td>
                                            <td>${b.originalQuantity}</td>
                                            <td>${b.takenQuantity}</td>
                                            <td>${b.remainQuantity}</td>
                                            <td>${b.refreshDate}</td>
                                            <td>${b.purchasesId}</td>
                                            <td>${b.purchaseDate}</td>
                                        </tr>    
                                    </c:when>
                                    <c:otherwise>
                                        <tr style="background-color: #ff9966;">
                                            <td>${b.bookName}</td>
                                            <td>${b.originalQuantity}</td>
                                            <td>${b.takenQuantity}</td>
                                            <td>${b.remainQuantity}</td>
                                            <td>${b.refreshDate}</td>
                                            <td>${b.purchasesId}</td>
                                            <td>${b.purchaseDate}</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="bookTableAll">
                        <table>
                            <tr>
                                <th id="bookName">Tên sách</th>
                                <th>Số lượng gốc</th>
                                <th>Số lượng đã lấy ra</th>
                                <th>Số lượng còn lại</th>
                                <th>Ngày cập nhật</th>
                                <th>Đợt nhập sách</th>
                                <th>Ngày nhập sách</th>
                            </tr>
                            <c:forEach var="b" items="${requestScope.resultInventoryAll}">
                                <c:choose>
                                    <c:when test="${b.remainQuantity>0}">
                                        <tr style="background-color: #87CEEB;" class="border-rds">
                                            <td>${b.bookName}</td>
                                            <td>${b.originalQuantity}</td>
                                            <td>${b.takenQuantity}</td>
                                            <td>${b.remainQuantity}</td>
                                            <td>${b.refreshDate}</td>
                                            <td>${b.purchasesId}</td>
                                            <td>${b.purchaseDate}</td>
                                        </tr>    
                                    </c:when>
                                    <c:otherwise>
                                        <tr style="background-color: #ff9966;">
                                            <td>${b.bookName}</td>
                                            <td>${b.originalQuantity}</td>
                                            <td>${b.takenQuantity}</td>
                                            <td>${b.remainQuantity}</td>
                                            <td>${b.refreshDate}</td>
                                            <td>${b.purchasesId}</td>
                                            <td>${b.purchaseDate}</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
            <div id="back"><a href="managementBook">Quay lại</a></div>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
