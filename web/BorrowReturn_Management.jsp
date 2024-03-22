<%-- 
    Document   : BorrowedReturn_Management
    Created on : Oct 28, 2023, 5:01:44 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG QUẢN LÝ MƯỢN TRẢ PHIÊN MƯỢN</title>
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
                background-color: #ccffcc;
                margin: 0;
                padding: 80px;
                background-image: url('media/9617cc77bded8b0904569d37c3b49efb.jpg');
                background-size: cover;
                background-repeat: no-repeat;
            }


            .comeToOther{
                border-radius: 4px;
                text-decoration: none;
                background-color: #4CAF50;
                color: whitesmoke;
                padding: 10px 20px;
                cursor: pointer;
            }
            a:hover {
                text-decoration: none;
            }

            button[type="submit"] {
                background-color: #00cccc;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }

            .container {
                align-items: center;
                /*margin: 10px auto;*/
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);

            }
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            /*            .flex .flex-left{
                            width: 35%;
                        }
                        .flex .flex-right{
                            width: 65%;
                        }*/
            input[type="text"],
            select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .hidden {
                display: none;
            }
            .float{
                /*display: flex;*/
                /*float: bottom;*/
            }
            .navigation{
                justify-content: center;
            }
            .navigation ul{
                display: flex;
                list-style: none;
                /*background-color: #00cccc;*/
                /*border-radius: 5px;*/
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                justify-content: center;
                /*padding: 20px;*/
            }
            .navigationChild{

            }
            .center{
                text-align: center;
            }
            .toDisplay{
                margin: 25px;
            }
            .title{
                color: black;
                background-color: #00cccc;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
            }
            .adjustWidthForm{
                width: 27%;
            }
            .adjustWidthForm2{
                width: 50%;
            }
            .ragiua{
                display: flex;
                margin: auto;
            }
            .navi {
                /*background-color: #87CEEB;*/

                border-radius: 5px;
            }

            .h4{
                background-color: #ffcccc;
            }
            .h4-child{
                background-color: #ffcccc;
            }
            .form-margin{
                margin-top: 20px;
            }
            .margin-top{
                margin-top: 10px;
            }
            .btn-margin{
                margin-top: 1%;
            }
            .a{
                border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <h1 class="title center">QUẢN LÝ MƯỢN & TRẢ SÁCH</h1>
        <!--<div class="navigation flex">-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navi">
            <div class="collapse navbar-collapse navi" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto ragiua navigation navi">
                    <li class="nav-item active">
                        <a class="nav-link navigationChild" href="home">TRANG CHỦ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link navigationChild" href="managementBook">SÁCH<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link navigationChild" href="managementReader">ĐỘC GIẢ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link navigationChild" href="managementBorrowReturn">MƯỢN & TRẢ<span class="sr-only">(current)</span></a>
                    </li>
<!--                    <li class="nav-item active">
                        <a class="nav-link" href="regulations">NỘI QUY THƯ VIỆN<span class="sr-only">(current)</span></a>
                    </li>-->
                </ul>
            </div>
        </nav>
        <!--</div>-->
        <!-------------------------------CHUYỂN TỚI TRANG HIỂN THỊ PHIÊN MƯỢN-------------------------------------->
        <h4 class="container center h4 margin-top">DANH SÁCH CÁC PHIÊN MƯỢN</h4>
        <div class="center toDisplay"><a class="comeToOther" href="showAllBorrowReturn">Tới trang hiển thị phiên mượn sách</a></div>

        <!-------------------------------FORM: TÌM KIẾM PHIÊN MƯỢN-------------------------------------->
        <div>
            <div>
                <h4 class="container center h4">TÌM KIẾM PHIÊN MƯỢN</h4>
                <div>
                    <div> <!----------------------------------------------------------- Tìm kiếm theo từng mục------------------------------------------------------------------>
                        <div>
                            <form class="container" method="post" action="searchBorrowReturnBook">
                                <!------------------------------CHỌN TÊN SÁCH---------------------------------->
                                <label>Tên sách</label>
                                <c:set var="indexOfBook" value="0"/>
                                <select id="search_book_name" name="bookName_field">
                                    <option value="">--- Chọn tên sách ---</option>
                                    <c:forEach var="b" items="${requestScope.allBookName}" varStatus="loop">
                                        <option id="optionBook${indexOfBook}" value="${b.getBookName()}">${b.getBookName()}</option>
                                        <c:set var="indexOfBook" value="${indexOfBook + 1}"/>
                                    </c:forEach>
                                </select>

                                <!--<input type="text" id="search_book_name" name="bookName_field">-->
                                <!--<br>-->
                                <button type="submit" class="btn-margin" onclick="return checkSearchBorrow_BookName_Selected()">Tìm Kiếm</button>
                            </form>

                        </div>
                        <div class="margin-top">
                            <form class="container" method="post" action="searchBorrowReturnBook">
                                <!------------------------------ TÊN ĐỘC GIẢ---------------------------------->
                                <label>Độc giả</label>
                                <input placeholder="Kí tự a-z, A-Z" type="text" id="search_reader" name="reader_field" pattern="[a-zA-ZÀ-ỹ ]+">
                                <br>
                                <button type="submit" class="btn-margin" onclick="return checkSearchBorrow_ReaderName_Selected()">Tìm Kiếm</button>
                            </form>
                        </div>
                        <div class="margin-top">
                            <form class="container" method="post" action="searchBorrowReturnBook">
                                <!------------------------------ TÊN THỦ THƯ---------------------------------->
                                <label>Thủ thư</label>
                                <input placeholder="Kí tự a-z, A-Z" type="text" id="search_librarian" name="librarian_field" pattern="[a-zA-ZÀ-ỹ ]+">
                                <br>
                                <button type="submit" class="btn-margin" onclick="return checkSearchBorrow_LibrarianName_Selected()">Tìm Kiếm</button>
                            </form>
                        </div>
                        <div class="margin-top">
                            <form class="container" method="post" action="searchBorrowReturnBook">
                                <!------------------------------ NGÀY MƯỢN---------------------------------->
                                <label>Ngày mượn</label>
                                <input type="date" id="search_dateBorrow" name="dateBorrow_field">
                                <br>
                                <button type="submit" class="btn-margin" onclick="return checkSearchBorrow_DateBorrow_Selected()">Tìm Kiếm</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <!--<h4 class="container center h4">QUẢN LÝ MƯỢN/TRẢ</h4>-->                       
            <div class="gap">  <!--   QUẢN LÝ MƯỢN / TRẢ SÁCH -->
                <div class="form-margin">
                    <!-------------------------------FORM: THÊM PHIÊN MƯỢN VÀO BẢNG BOOK-------------------------------------->
                    <h4 class="container center h4-child">THÊM PHIÊN MƯỢN SÁCH</h4>
                    <form class="container" method="post" action="addBorrowedBook" name="addBorrowedBook">
                        <label>Mã độc giả</label>
                        <input placeholder="Kí tự số 0-9" type="text" id="inputReaderId" name="inputReaderId" pattern="[0-9]+">
                        <br>
                        <label>Mã sách</label>
                        <input placeholder="Kí tự số 0-9" type="text" id="inputBookId" name="inputBookId" pattern="[0-9]+">
                        <br>
                        <label>Mã thủ thư</label>
                        <input placeholder="Kí tự số 0-9" type="text" id="inputLibrarianId" name="inputLibrarianId" pattern="[0-9]+">
                        <button type="submit" class="buttonSend btn-margin" onclick="return checkAddBorrowingSelected()">Thêm phiên mượn</button>
                    </form>
                </div>
                <div class="form-margin">
                    <!-------------------------------FORM: HIỂN THỊ TRẠNG THÁI LƯU HÀNH CỦA 1 CUỐN PHIÊN MƯỢN CỤ THỂ-------------------------------------->
                    <h4 class="container center h4-child">CẬP NHẬT ĐỘC GIẢ TRẢ SÁCH</h4>
                    <form class="container" method="post" action="updateReturnBook">
                        <div>
                            <label>Mã độc giả</label>
                            <input id="readerId" type="text" name="readerId" pattern="[0-9]+" placeholder="Kí tự số 0-9">
                        </div>
                        <div>
                            <label>Mã phiên mượn</label>
                            <input id="borrowId" type="text" name="borrowId" pattern="[0-9]+" placeholder="Kí tự số 0-9">
                        </div>
                        <div>
                            <label>Ngày trả sách</label>
                            <input id="bookReturnDate" type="date" name="bookReturnDate">
                        </div>
                        <div>
                            <label>Chất lượng sách khi trả</label>
                            <select name="bookQuality" id="bookQuality">
                                <option id="nothing" value="">--- Chất lượng sách ---</option>
                                <option id="newBook" value="New">New</option>
                                <option id="goodBook" value="Good">Good</option>
                                <option id="lowBook" value="Lower">Lower</option>
                                <option id="worstBook" value="Worst">Worst</option>
                            </select>
                        </div>
                        <input type="hidden" id="remainIsMoreThanZero" name="inputHidden" value="${requestScope.ThereWasLeftBookInventory}">

                        <button type="submit" class="buttonSend btn-margin" onclick="return checkUpdate_ReturnBook_4Fields_Selected()">Cập nhật</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            function checkSearchBorrow_BookName_Selected() {
                var idSearch_Book_Name = document.getElementById("search_book_name").value;
                if (idSearch_Book_Name === "") {
                    alert("Bạn chưa chọn 'Tên sách' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchBorrow_ReaderName_Selected() {
                var idSearchReader = document.getElementById("search_reader").value;
                if (idSearchReader === "") {
                    alert("Bạn chưa chọn 'Độc giả' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchBorrow_LibrarianName_Selected() {
                var idSearchLibrarian = document.getElementById("search_librarian").value;
                if (idSearchLibrarian === "") {
                    alert("Bạn chưa chọn 'Thủ thư' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchBorrow_DateBorrow_Selected() {
                var idSearch_DateBorrow = document.getElementById("search_dateBorrow").value;
                if (idSearch_DateBorrow === "") {
                    alert("Bạn chưa chọn 'Ngày mượn' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            //-----------------------------------------------------------------------
            function checkAddBorrowingSelected() {
                var inputReaderId = document.getElementById("inputReaderId").value;
                var inputBookId = document.getElementById("inputBookId").value;
                var inputLibrarianId = document.getElementById("inputLibrarianId").value;

                if (inputReaderId === "") {
                    alert("Bạn chưa điền vào ô 'Mã độc giả' để thêm phiên mượn.");
                    return false;
                } else if (inputBookId === "") {
                    alert("Bạn chưa điền vào ô 'Mã sách' để thêm phiên mượn.");
                    return false;
                } else if (inputLibrarianId === "") {
                    alert("Bạn chưa điền vào ô 'Mã thủ thư' để thêm phiên mượn.");
                    return false;
                } else {
                    return true;
                }
            }
            //--------------------------------------------------------------------

            function checkUpdate_ReturnBook_4Fields_Selected() {
                var readerId = document.getElementById("readerId").value;
                var borrowId = document.getElementById("borrowId").value;
                var bookReturnDate = document.getElementById("bookReturnDate").value;
                var bookQuality = document.getElementById("bookQuality").value;

                var dateInput = new Date(bookReturnDate);
                var currentDate = new Date();
                if (readerId === "") {
                    alert("Bạn chưa nhập 'Mã độc giả' để cập nhật.");
                    return false;
                } else if (borrowId === "") {
                    alert("Bạn chưa nhập 'Mã phiên mượn' để cập nhật.");
                    return false;
                } else if (bookReturnDate === "") {
                    alert("Bạn chưa nhập 'Ngày trả sách' để cập nhật.");
                    return false;
                } else if (bookQuality === "") {
                    alert("Bạn chưa nhập 'Chất lượng sách khi trả' để cập nhật.");
                    return false;
                } else if (dateInput > currentDate) {
                    alert("'Ngày trả sách' cần nhỏ hơn hoặc bằng ngày hiện tại.");
                    return false;
                } else {
                    return true;
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>

