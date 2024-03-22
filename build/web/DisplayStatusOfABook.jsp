<%-- 
    Document   : DisplayStatusOfABook
    Created on : Oct 25, 2023, 9:59:04 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG HIỂN THỊ TRẠNG THÁI SÁCH</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            .flex{
                display: flex;
                justify-content: center;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #d3f9ff;
                margin: 0;
                padding: 80px;
            }

            h1{
                color: #ff755d;
            }
            h2{
                color: #990099;
            }
            .center{
                text-align: center;
            }

            .a-navigation{
                text-decoration: none;
                background-color: #4CAF50;
                color: #fff;
                /*border: none;*/
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            .lend{
                text-decoration: none;
                background-color: #4CAF50;
                color: #fff;
                /*border: none;*/
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            a:hover {
                text-decoration:underline;
            }

            .container {
                align-items: center;
                margin: 10px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);

            }

            form {
                margin-bottom: 20px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            input[type="text"],
            select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            button[type="submit"] {
                background-color: #4CAF50;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }
            .image{
                /*width: 350px;*/
                width: 20%;
            }
            .navigation{
                justify-content: center;
            }
            .navigation ul{
                display: flex;
                list-style: none;
                background-color: #00cccc;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                justify-content: center;
                padding: 20px;
            }
            .navigationChild{
                margin: 30px;
                color: whitesmoke;
                font-family: Arial, sans-serif;
                font-weight: bold;
            }
            .margin{
                margin: 15px;
            }
            .margin-double{
                margin: 0px 15px;
            }
            #button-lend{
                margin-top: 10%;
            }
            .infor-book{
                margin-top: 42%;
                margin-bottom: 4%;
            }
            .ban{
                color: red;
                font-weight: bold;
            }
            .ranh{
                color: green;
                font-weight: bold;
            }
            .notDisplay{
                color: #007bff;
            }
            .info{
                margin: 13px 0px;
            }
            .bolder{
                font-weight: bold;
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
        </style>
    </head>
    <body>
        <h1 class="center">TRẠNG THÁI LƯU HÀNH CỦA SÁCH</h1>
        <h2 class="center">*Lưu ý, trạng thái của sách được định nghĩa rằng:<br>
            <span class="ban">BẬN</span> hoặc <span class="ranh">RẢNH</span> với cuốn sách đã/đang được sử dụng<br>
            <span class="notDisplay">KHÔNG hiển thị</span> với cuốn sách chưa từng được sử dụng</h2>
        <!--        <div class="navigation flex">
                    <ul>
                        <li><h3><a class="navigationChild a-navigation" href="home">TRANG CHỦ</a></h3></li>  
                        <li><h3><a class="navigationChild a-navigation" href="managementBook">SÁCH</a></h3></li>  
                        <li><h3><a class="navigationChild a-navigation" href="managementReader">ĐỘC GIẢ</a></h3></li>  
                        <li><h3><a class="navigationChild a-navigation" href="managementBorrowReturn">MƯỢN & TRẢ</a></h3></li>  
                        <li><h3><a class="navigationChild a-navigation" href="#">BÁO CÁO & THỐNG KÊ</a></h3></li>  
                    </ul>
                </div>-->
        <table class="flex">
            <c:set var="indexBorrow" value="0" />
            <c:forEach var="book" items="${requestScope.listBookOfBookNameSelected}">
                <tr>
                    <td>
                        <div class="margin flex">
                            <div class="imgBound margin-double">
                                <span class="image">
                                    <img src="picture_for_book_library/${requestScope.pathToImage}" alt="Ảnh không thể hiển thị">
                                    <!--<img src="/media/69-hinh-nen-galaxy-vu-tru-full-hd-3d-4k-cuc-dep-cho-ban_22.jpg" alt="Ảnh không thể hiển thị">-->
                                </span>
                            </div>
                            <div class="infor-img margin-double">
                                <div id="split">
                                    <div class="infor-book">
                                        <div class="info"><span class="bolder">Mã sách:</span> ${book.bookId}</div>
                                        <div class="info"><span class="bolder">Tên sách:</span> ${book.bookName}</div>
                                        <div class="info"><span class="bolder">Tác giả:</span> ${book.author}</div>
                                        <div class="info"><span class="bolder">Thể loại:</span> ${book.genre}</div>
                                        <div class="info"><span class="bolder">Nhà xuất bản:</span> ${book.publisher}</div>
                                        <div class="info"><span class="bolder">Năm xuất bản:</span> ${book.publishYear}</div>
                                        <div class="info"><span class="bolder">ISBN:</span> ${book.ISBN}</div>
                                        <div class="info"><span class="bolder">Giá:</span> ${book.price} VNĐ</div>
                                        <div class="info" id="returnStt"><span class="bolder">Trạng thái:</span> 
                                            <span class="ranh"><c:if test="${book.returnStatus=='Done'}">Rảnh</c:if></span>
                                            <span class="ban"><c:if test="${book.returnStatus=='Not yet'}">Bận</c:if></span>
                                            </div>
                                            <!--<button type="submit">Cho mượn</button>-->
                                            <div id="button-lend">

                                            <c:if test="${book.returnStatus=='Done'}">
                                                <!--<a id="managementBorrowReturn${indexBorrow}" class="lend" href="#managementBorrowReturn?bookId=${book.getBookId()}">-->
                                                <a id="managementBorrowReturn${indexBorrow}" class="lend" href="managementBorrowReturn">
                                                    Cho mượn
                                                </a>
                                            </c:if>
                                            <c:set var="indexBorrow" value="${indexBorrow + 1}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div id="back"><a href="managementBook">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
