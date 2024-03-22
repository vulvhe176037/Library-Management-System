<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG QUẢN LÝ SÁCH</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                background-color: #ccffcc;
                margin: 0;
                padding: 80px;
                background-image: url('media/background-vu-tru-ao-dieu-va-hanh-tinh.jpg');
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

            .alert {
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 4px;
            }

            .alert-success {
                background-color: #d4edda;
                color: #155724;
                border: 1px solid #c3e6cb;
            }

            .alert-danger {
                background-color: #f8d7da;
                color: #721c24;
                border: 1px solid #f5c6cb;
            }

            .hidden {
                display: none;
            }

            .navigation ul {
                display: flex;
                width: 100%;
                list-style: none;
                /*background-color: #00cccc;*/
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                justify-content: center;
                /*padding: 20px;*/
            }

            .navigationChild {
                /*margin: 30px;*/
                /*color: white;*/
                /*font-weight: bold;*/
            }

            .center {
                text-align: center;
            }

            .toDisplay {
                margin: 25px;
            }

            .title {
                color: black;
                background-color: #00cccc;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
            }
            .ragiua{
                display: flex;
                margin: auto;
            }
            .navi{
                /*background-color: #f5c6cb;*/
                border-radius: 5px;
            }
            .h4{
                background-color: #ffcccc;
            }
            .form-margin{
                margin-top: 20px;
            }
            .btn-margin{
                margin-top: 1%;
            }
            .h4-other{
                background-color: #ffcc66;
            }
        </style>
    </head>
    <body>
        <h1 class="title center">QUẢN LÝ SÁCH</h1>
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
        <!-------------------------------CHUYỂN TỚI TRANG HIỂN THỊ SÁCH-------------------------------------->
        <h4 class="container center h4">DANH SÁCH CÁC CUỐN SÁCH</h4>
        <div class="center toDisplay"><a class="comeToOther" href="showAllBook">Tới trang hiển thị sách</a></div>
        <!-------------------------------CHUYỂN TỚI TRANG HIỂN THỊ SỐ LƯỢNG SÁCH TRONG KHO-------------------------------------->
        <h4 class="container center h4">SỐ LƯỢNG SÁCH TRONG KHO</h4>
        <div class="center toDisplay"><a class="comeToOther" href="showQuantityBookInventory">Tới trang hiển thị số lượng sách</a></div>

        <!-------------------------------FORM: TÌM KIẾM SÁCH-------------------------------------->
        <div class="flex-left">
            <h4 class="container center h4">TÌM KIẾM SÁCH</h4>
            <div class="flex">
                <div class="form-margin"> 
                    <!----------------------------------------------------------- Tìm kiếm theo từng mục------------------------------------------------------------------>
                    <h4 class="container center h4-other">TÌM KIẾM THEO MỤC</h4>
                    <form class="container" method="post" action="searchBookOneField">
                        <!------------------------------CHỌN TÊN SÁCH---------------------------------->
                        <c:set var="indexBookName" value="0"/>
                        <label>Tên sách</label>
                        <select id="search_book_name" name="bookName_field" >
                            <option value="">--- Chọn tên sách ---</option>
                            <c:forEach var="book" items="${requestScope.allBookName}" varStatus="loop">
                                <option id="optionBookName${indexBookName}" value="${book.getBookName()}">${book.getBookName()}</option>
                                <c:set var="indexBookName" value="${indexBookName + 1}"/>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_BookName_Selected()">Tìm Kiếm</button>
                    </form>
                    <form class="container" method="post" action="searchBookOneField">
                        <!------------------------------CHỌN TÁC GIẢ---------------------------------->
                        <c:set var="indexAuthor" value="0" />
                        <label>Tác giả</label>
                        <select id="search_author" name="author_field">
                            <option value="">--- Chọn tác giả ---</option>
                            <c:forEach var="author" items="${requestScope.allAuthor}" varStatus="loop">
                                <option id="optionAuthor${indexAuthor}" value="${author.getAuthor()}">${author.getAuthor()}</option>
                                <c:set var="indexAuthor" value="${indexAuthor + 1}" />
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_Author_Selected()">Tìm Kiếm</button>
                    </form>
                    <form class="container" method="post" action="searchBookOneField">
                        <!------------------------------CHỌN THỂ LOẠI---------------------------------->
                        <c:set var="indexGenre" value="0" />  
                        <label>Thể Loại</label>
                        <select id="search_genre" name="genre_field">
                            <option value="">--- Chọn thể loại ---</option>
                            <c:forEach var="genre" items="${requestScope.allGenre}" varStatus="loop">
                                <option id="optionGenre${indexGenre}" value="${genre.getGenre()}">${genre.getGenre()}</option>
                                <c:set var="indexGenre" value="${indexGenre + 1}" />  
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_Genre_Selected()">Tìm Kiếm</button>
                    </form>
                    <form class="container" method="post" action="searchBookOneField">
                        <!------------------------------CHỌN NHÀ XUẤT BẢN---------------------------------->
                        <c:set var="indexPublisher" value="0" /> 
                        <label>Nhà xuất bản</label>
                        <select id="search_publisher" name="publisher_field">
                            <option value="">--- Chọn nhà xuất bản ---</option>
                            <c:forEach var="publisher" items="${requestScope.allNhaXuatBan}" varStatus="loop">
                                <option id="optionPublisher${indexPublisher}" value="${publisher.getPublisher()}">${publisher.getPublisher()}</option>
                                <c:set var="indexPublisher" value="${indexPublisher + 1}" /> 
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_Publisher_Selected()">Tìm Kiếm</button>
                    </form>
                    <form class="container" method="post" action="searchBookOneField">
                        <!------------------------------CHỌN NĂM XUẤT BẢN---------------------------------->
                        <c:set var="indexYear" value="0" />
                        <label>Năm Xuất Bản</label>
                        <select id="search_publish_year" name="publishYear_field">
                            <option value="">--- Chọn năm xuất bản ---</option>
                            <c:forEach var="year" items="${requestScope.allNamXuatBan}" varStatus="loop">
                                <option id="optionPublishYear${indexYear}" value="${year.getPublishYear()}">${year.getPublishYear()}</option>
                                <c:set var="indexYear" value="${indexYear + 1}" />
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_PublishYear_Selected()">Tìm Kiếm</button>
                    </form>
                </div>

                <div class="form-margin">
                    <!-------------------------------------------------------------------------Tìm kiếm nâng cao-------------------------------------------------------->
                    <h4 class="container center h4-other">TÌM KIẾM NÂNG CAO</h4>
                    <form class="container" method="post" action="searchBook" name="searchBook">
                        <!------------------------------CHỌN TÊN SÁCH---------------------------------->
                        <c:set var="indexBookName" value="0" />
                        <label for="bookName">Tên sách</label>
                        <select id="searchBookName" name="searchBookName" >
                            <option value="">--- Chọn tên sách ---</option>
                            <c:forEach var="book" items="${requestScope.allBookName}" varStatus="loop">
                                <option id="optionBookName${indexBookName}" value="${book.getBookName()}">${book.getBookName()}</option>
                                <c:set var="indexBookName" value="${indexBookName + 1}"/>
                            </c:forEach>
                        </select>
                        <!------------------------------CHỌN TÁC GIẢ---------------------------------->
                        <c:set var="indexAuthor" value="0" />
                        <label for="Author">Tác giả</label>
                        <select id="searchAuthor" name="searchAuthor">
                            <option value="">--- Chọn tác giả ---</option>
                            <c:forEach var="author" items="${requestScope.allAuthor}" varStatus="loop">
                                <option id="optionAuthor${indexAuthor}" value="${author.getAuthor()}">${author.getAuthor()}</option>
                                <c:set var="indexAuthor" value="${indexAuthor + 1}" />
                            </c:forEach>
                        </select>
                        <!------------------------------CHỌN THỂ LOẠI---------------------------------->
                        <c:set var="indexGenre" value="0" />  
                        <label for="Genre">Thể Loại</label>
                        <select id="searchGenre" name="searchGenre">
                            <option value="">--- Chọn thể loại ---</option>
                            <c:forEach var="genre" items="${requestScope.allGenre}" varStatus="loop">
                                <option id="optionGenre${indexGenre}" value="${genre.getGenre()}">${genre.getGenre()}</option>
                                <c:set var="indexGenre" value="${indexGenre + 1}" />  
                            </c:forEach>
                        </select>
                        <!------------------------------CHỌN NHÀ XUẤT BẢN---------------------------------->
                        <c:set var="indexPublisher" value="0" /> 
                        <label for="Publisher">Nhà xuất bản</label>
                        <select id="searchPublisher" name="searchPublisher">
                            <option value="">--- Chọn nhà xuất bản ---</option>
                            <c:forEach var="publisher" items="${requestScope.allNhaXuatBan}" varStatus="loop">
                                <option id="optionPublisher${indexPublisher}" value="${publisher.getPublisher()}">${publisher.getPublisher()}</option>
                                <c:set var="indexPublisher" value="${indexPublisher + 1}" /> 
                            </c:forEach>
                        </select>
                        <!------------------------------CHỌN NĂM XUẤT BẢN---------------------------------->
                        <c:set var="indexYear" value="0" />
                        <label for="PublishYear">Năm Xuất Bản</label>
                        <select id="searchPublishYear" name="searchPublishYear">
                            <option value="">--- Chọn năm xuất bản ---</option>
                            <c:forEach var="year" items="${requestScope.allNamXuatBan}" varStatus="loop">
                                <option id="optionPublishYear${indexYear}" value="${year.getPublishYear()}">${year.getPublishYear()}</option>
                                <c:set var="indexYear" value="${indexYear + 1}" />
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn-margin" onclick="return checkSearchBook_5Fields_Selected()">Tìm Kiếm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="flex-right">
        <div class="form-margin">
            <!-------------------------------FORM: THÊM SÁCH VÀO BẢNG BOOK-------------------------------------->
            <h4 class="container center h4">THÊM 1 CUỐN SÁCH TỪ KHO</h4>
            <form class="container" method="post" action="addBook" name="addBook">
                <label>Tên sách</label>
                <c:set var="indexOfBook" value="0"/>
                <select id="bookName" name="bookName">
                    <option value="">--- Chọn tên sách ---</option>
                    <c:forEach var="b" items="${requestScope.allBookName2}" varStatus="loop">
                        <option id="optionBook${indexOfBook}" value="${b.getBookName()}">${b.getBookName()}</option>
                        <c:set var="indexOfBook" value="${indexOfBook + 1}" />
                    </c:forEach>
                </select>
                <!--thẻ input ẩn => chứa dữ liệu boolean => xác nhận còn/hết sách (với bookName cụ thể)-->
                <input type="hidden" id="remainIsMoreThanZero" name="inputHidden" value="${requestScope.TheLeftMoreThanZero}">

                <button type="submit" class="buttonSend btn-margin" onclick="return checkAddBookSelected()">Thêm sách</button>
            </form>
        </div>
        <div class="float form-margin">
            <!-------------------------------FORM: HIỂN THỊ TRẠNG THÁI LƯU HÀNH CỦA 1 CUỐN SÁCH CỤ THỂ-------------------------------------->
            <h4 class="container center h4">HIỂN THỊ TRẠNG THÁI CỦA SÁCH</h4>
            <form class="container" method="post" action="displayBookStatus">
                <label>Tên sách</label>
                <c:set var="indexOfBook" value="0"/>
                <select id="bookDisplaySelected" name="displaySelected">
                    <option value="">--- Chọn tên sách ---</option>
                    <c:forEach var="b" items="${requestScope.allBookName}" varStatus="loop">
                        <option id="optionBook${indexOfBook}" value="${b.getBookName()}">${b.getBookName()}</option>
                        <c:set var="indexOfBook" value="${indexOfBook + 1}"/>
                    </c:forEach>
                </select>

                <input type="hidden" id="remainIsMoreThanZero" name="inputHidden" value="${requestScope.ThereWasLeftBookInventory}">

                <button type="submit" class="buttonSend btn-margin" onclick="return checkDisplayStatusBookSelected()">Hiển thị</button>
            </form>
        </div>
    </div>
    <script>
        function checkSearchBook_BookName_Selected() {
            var idSearch_Book_Name = document.getElementById("search_book_name").value;
            if (idSearch_Book_Name === "") {
                alert("Bạn chưa chọn 'sách' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkSearchBook_Author_Selected() {
            var idSearch_Author = document.getElementById("search_author").value;
            if (idSearch_Author === "") {
                alert("Bạn chưa chọn 'tác giả' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkSearchBook_Genre_Selected() {
            var idSearch_Genre = document.getElementById("search_genre").value;
            if (idSearch_Genre === "") {
                alert("Bạn chưa chọn 'thể loại' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkSearchBook_Publisher_Selected() {
            var idSearch_Publisher = document.getElementById("search_publisher").value;
            if (idSearch_Publisher === "") {
                alert("Bạn chưa chọn 'nhà xuất bản' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkSearchBook_PublishYear_Selected() {
            var idSearch_Publish_Year = document.getElementById("search_publish_year").value;
            if (idSearch_Publish_Year === "") {
                alert("Bạn chưa chọn 'năm xuất bản' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkSearchBook_5Fields_Selected() {
            var idSearchBookName = document.getElementById("searchBookName").value;
            var idSearchAuthor = document.getElementById("searchAuthor").value;
            var idSearchGenre = document.getElementById("searchGenre").value;
            var idSearchPublisher = document.getElementById("searchPublisher").value;
            var idSearchPublishYear = document.getElementById("searchPublishYear").value;
            if (idSearchBookName === "") {
                alert("Bạn chưa chọn 'sách' để tìm kiếm.");
                return false;
            } else if (idSearchAuthor === "") {
                alert("Bạn chưa chọn 'tác giả' để tìm kiếm.");
                return false;
            } else if (idSearchGenre === "") {
                alert("Bạn chưa chọn 'thể loại' để tìm kiếm.");
                return false;
            } else if (idSearchPublisher === "") {
                alert("Bạn chưa chọn 'nhà xuất bản' để tìm kiếm.");
                return false;
            } else if (idSearchPublishYear === "") {
                alert("Bạn chưa chọn 'năm xuất bản' để tìm kiếm.");
                return false;
            } else {
                return true;
            }
        }
        function checkAddBookSelected() {
            var idBookName = document.getElementById("bookName").value;
            if (idBookName === "") {
                alert("Bạn chưa chọn sách để thêm.");
                return false;
            } else {
                return true;
            }
        }
        function checkDisplayStatusBookSelected() {
            var idBookName = document.getElementById("bookDisplaySelected").value;
            if (idBookName === "") {
                alert("Bạn chưa chọn sách để hiển thị.");
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