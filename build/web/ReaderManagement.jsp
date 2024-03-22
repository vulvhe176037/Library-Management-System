<%-- 
    Document   : ReaderManagement
    Created on : Oct 23, 2023, 11:04:12 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG QUẢN LÝ ĐỘC GIẢ</title>
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
                gap: 3%;
                width: 100%;
            }
            body {
                background-color: #ccffcc;
                margin: 0;
                padding: 80px;
                
            }
            #body{
                background-image: url('media/9617cc77bded8b0904569d37c3b49efb.jpg');
                background-size: cover;
                background-repeat: no-repeat;
            }
            h1{
                color: #ff755d;
                text-align: center;
            }
            .center{
                text-align: center;
            }

            .comeToOther{
                                border-radius: 4px;
                color: whitesmoke;
                background-color: #4CAF50;
                text-decoration: none;
                padding: 10px 20px;
                /*border-radius: 4px;*/
                cursor: pointer;
            }

            a:hover {
                text-decoration: none;
            }

            .container {
                align-items: center;
                justify-content: center;
                /*margin: 10px auto;*/
                background-color: #fff;
                /*padding: 15px;*/
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
                background-color: #00cccc;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
            }
            .margin-right{
                margin-right: 5px;
                margin-top: 15px;
            }
            .margin-left{
                /*margin-left: 15px;*/
                margin-top: 15px;
            }
            .addForm{
                width: 40%;

            }
            .addFormMargin{
                /*margin: 5% 0%;*/
            }
            .formByEachField{
                display: flex;
            }
            .searchFormFlexLeft{
                margin-right: 1%;
            }
            .searchFormFlexRight{
                margin-left: 1%;
            }
            .authorForm{
                padding: 3% 0%;
            }
            .margin-top{
                margin-top: 5%;
            }
            #addFromPadding{
                padding: 9% 0%;
            }
            .searchFormMargin{
                margin-top: 7%;
            }
            .searchFormPadding{
                /*                padding-top : 5%;
                                padding-bottom: 5%;*/
                padding: 10px 20px;
            }
            #title{
                color: black;
                background-color: #00cccc;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
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
            }
            .navigationChild{
                /*margin: 30px;*/
                /*color: whitesmoke;*/
                /*font-family: Arial, "Helvetica Neue", Helvetica, sans-seriff;*/
                /*font-weight: bold;*/
            }
            .toDisplay{
                margin: 25px;
            }
            body {
                background-image: url('media/');
                background-size: cover;
                background-repeat: no-repeat;
            }
            .btn-padding{
                margin: 15px 0px;
            }
            h4{
                padding: 3% 0%;
            }
            #inputReaderDOB{
                margin: 6px 0px;
            }
            .title-padding{
                padding-top: 18px;
                margin-top: 13px;
            }
            .searchAdvance-title{
                padding: 17px;
            }
            .btn-search-advance{
                margin: 6px 0px;
            }
            .btn-add-reader{
                margin-top: 15px;
                /*margin: 6px 0px;*/
            }
            .addNewReader{
                padding: 27px 35px;
            }
            .label-addReader{
                margin: 5px 0px;
            }
            .ragiua{
                display: flex;
                margin: auto;
            }
            .navi{
                /*background-color: #FFA07A;*/
                border-radius: 5px; 
            }
            .h4{
                background-color: #ffcccc;
                color: black;
            }
            
            .listReader{
                padding: 20px;
                margin: 15px 0px;
                border-radius: 4px;
            }
            .h4-other{
                background-color: #ffcc66;
            }
        </style>
    </head>
    <body id="body">
        <h1 id="title">QUẢN LÝ ĐỘC GIẢ</h1>
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
        <!-------------------------------CHUYỂN TỚI TRANG HIỂN THỊ ĐỘC GIẢ-------------------------------------->
        <h4 class="listReader center h4">DANH SÁCH CÁC ĐỘC GIẢ</h4>
        <div class="center toDisplay"><a class="comeToOther" href="showAllReader">Tới trang hiển thị độc giả</a></div>
        <!-------------------------------FORM: TÌM KIẾM SÁCH-------------------------------------->
        <div class="flex">
            <div class="searchForm">
                <h4 class="container center h4">TÌM KIẾM ĐỘC GIẢ</h4>
                <div class="flex">
                    <div class="margin-right"> <!----------------------------------------------------------- Tìm kiếm theo từng mục------------------------------------------------------------------>
                        <h4 class="container center h4-other">TÌM KIẾM THEO MỤC</h4>
                        <div class="formByEachField">
                            <div class="searchFormFlexLeft">
                                <form class="container" method="post" action="searchReaderOneField">
                                    <!------------------------------NHẬP TÊN ĐỘC GIẢ---------------------------------->
                                    <label class="title-padding">Họ và Tên</label>
                                    <input placeholder="Kí tự a-z, A-Z có dấu hoặc không dấu" type="text" id="inputReaderName" name="inputReaderName" pattern="[a-zA-ZÀ-ỹ ]+">
                                    <button class="btn-padding" type="submit" onclick="return checkSearchReader_fullName_Selected()">Tìm Kiếm</button>
                                </form>
                                <form class="container" method="post" action="searchReaderOneField">
                                    <!------------------------------NHẬP NGÀY SINH---------------------------------->
                                    <label class="title-padding">Ngày sinh</label>
                                    <input type="date" id="inputReaderDOB" name="inputReaderDOB">
                                    <br>
                                    <button class="btn-padding" type="submit" onclick="return checkSearchReader_DOB_Selected()">Tìm Kiếm</button>
                                </form>
                            </div>
                            <div class="searchFormFlexRight">
                                <form class="container" method="post" action="searchReaderOneField">
                                    <!------------------------------NHẬP SỐ ĐIỆN THOẠI---------------------------------->
                                    <label class="title-padding">Số điện thoại</label>
                                    <input placeholder="Kí tự số 0-9" type="text" id="inputReaderSDT" name="inputReaderSDT" maxlength="10" pattern="[0-9._%+\-]{10}">
                                    <button class="btn-padding" type="submit" onclick="return checkSearchReader_PhoneNumber_Selected()">Tìm Kiếm</button>
                                </form>
                                <form class="container" method="post" action="searchReaderOneField">
                                    <!------------------------------NHẬP EMAIL---------------------------------->
                                    <label class="title-padding">Email</label>
                                    <input placeholder="Email có đuôi '@gmail.com'" type="text" id="inputReaderEmail" name="inputReaderEmail" pattern="[a-z0-9._%+\-]+@gmail.com$">
                                    <button class="btn-padding" type="submit" onclick="return checkSearchReader_Email_Selected()">Tìm Kiếm</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="margin-left">    
                        <div>
                            <!-------------------------------------------------------------------------Tìm kiếm nâng cao-------------------------------------------------------->
                            <div>
                                <h4 class="container center searchAdvance-title h4-other">TÌM KIẾM NÂNG CAO</h4>
                            </div>
                            <div class="searchFormMargin">
                                <form class="container searchFormPadding" method="post" action="searchReaderByAll" name="searchBook">
                                    <div>
                                        <!------------------------------NHẬP TÊN ĐỘC GIẢ---------------------------------->
                                        <label>Họ và Tên</label>
                                        <input placeholder="Kí tự a-z, A-Z có dấu hoặc không dấu" type="text" id="inputReaderName2" name="inputReaderName2" pattern="[a-zA-ZÀ-ỹ ]+">
                                        <!------------------------------NHẬP NGÀY SINH---------------------------------->
                                        <label>Ngày sinh</label>
                                        <input type="date" id="inputReaderDOB2" name="inputReaderDOB2">
                                        <br>
                                        <!------------------------------NHẬP SỐ ĐIỆN THOẠI----------------------------------> 
                                        <label>Số điện thoại</label>
                                        <input placeholder="Kí tự số 0-9" type="text" id="inputReaderSDT2" name="inputReaderSDT2" maxlength="10" pattern="[0-9._%+\-]{10}">
                                        <!------------------------------NHẬP EMAIL---------------------------------->
                                        <label>Email</label>
                                        <input placeholder="Email có đuôi '@gmail.com'" type="text" id="inputReaderEmail2" name="inputReaderEmail2" pattern="[a-z0-9._%+\-]+@gmail.com$">
                                        <button class="btn-search-advance" type="submit" onclick="return checkSearchReader_4Fields_Selected()">Tìm Kiếm</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="addForm">
                <div class="addFormMargin">
                    <!-------------------------------FORM: THÊM ĐỘC GIẢ MỚI VÀO BẢNG READER-------------------------------------->
                    <h4 class="container center addNewReader h4">THÊM ĐỘC GIẢ MỚI</h4>
                    <form class="container margin-top" method="post" action="addReader" name="addReader">
                        <div>
                            <div id="addFromPadding">
                                <!------------------------------NHẬP TÊN ĐỘC GIẢ---------------------------------->
                                <label class="label-addReader">Họ và Tên</label>
                                <input placeholder="Kí tự a-z, A-Z có dấu hoặc không dấu" type="text" id="addReaderInputName" name="addReaderInputName" pattern="[a-zA-ZÀ-ỹ ]+">
                                <!------------------------------NHẬP NGÀY SINH---------------------------------->
                                <label class="label-addReader">Ngày sinh</label>
                                <input type="date" id="addReaderInputDOB" name="addReaderInputDOB">
                                <br>
                                <!------------------------------NHẬP SỐ ĐIỆN THOẠI----------------------------------> 
                                <label class="label-addReader">Số điện thoại</label>
                                <input placeholder="Kí tự số 0-9" type="text" id="addReaderInputSDT" name="addReaderInputSDT" maxlength="10" pattern="[0-9._%+\-]{10}">
                                <!------------------------------NHẬP EMAIL---------------------------------->
                                <label class="label-addReader">Email</label>
                                <input placeholder="Email có đuôi '@gmail.com'" type="text" id="addReaderInputEmail" name="addReaderInputEmail" pattern="[a-z0-9._%+\-]+@gmail.com$">
                                <button class="btn-add-reader" type="submit" class="buttonSend" onclick="return checkAddReaderInput()">Thêm độc giả</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function checkSearchReader_fullName_Selected() {
                var idSearchFullName = document.getElementById("inputReaderName").value;
                if (idSearchFullName === "") {
                    alert("Bạn chưa nhập 'Họ và Tên' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchReader_DOB_Selected() {
                var idSearchDOB = document.getElementById("inputReadesrDOB").value;
                var dateInput = new Date(idSearchDOB);
                var currentDate = new Date();
                if (idSearchDOB === "") {
                    alert("Bạn chưa nhập 'Ngày sinh' để tìm kiếm.");
                    return false;
                } else if (dateInput > currentDate) {
                    alert('Ngày sinh cần nhỏ hơn ngày hiện tại.');
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchReader_PhoneNumber_Selected() {
                var idSearchSDT = document.getElementById("inputReaderSDT").value;
                if (idSearchSDT === "") {
                    alert("Bạn chưa nhập 'Số điện thoại' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
            function checkSearchReader_Email_Selected() {
                var idSearchEmail = document.getElementById("inputReaderEmail").value;
                if (idSearchEmail === "") {
                    alert("Bạn chưa nhập 'Email' để tìm kiếm.");
                    return false;
                } else {
                    return true;
                }
            }
//            function checkSearchBook_PublishYear_Selected() {
//                var idSearch_Publish_Year = document.getElementById("search_publish_year").value;
//                if (idSearch_Publish_Year === "") {
//                    alert("Bạn chưa chọn 'năm xuất bản' để tìm kiếm.");
//                    return false;
//                } else {
//                    return true;
//                }
//            }
            function checkSearchReader_4Fields_Selected() {
                var idSearchFullName2 = document.getElementById("inputReaderName2").value;
                var idSearchDOB2 = document.getElementById("inputReaderDOB2").value;
                var idSearchSDT2 = document.getElementById("inputReaderSDT2").value;
                var idSearchEmail2 = document.getElementById("inputReaderEmail2").value;

                var dateInput = new Date(idSearchDOB2);
                var currentDate = new Date();
                if (idSearchFullName2 === "") {
                    alert("Bạn chưa nhập 'Họ và Tên' để tìm kiếm.");
                    return false;
                } else if (idSearchDOB2 === "") {
                    alert("Bạn chưa nhập 'Ngày sinh' để tìm kiếm.");
                    return false;
                } else if (idSearchSDT2 === "") {
                    alert("Bạn chưa nhập 'Số điện thoại' để tìm kiếm.");
                    return false;
                } else if (idSearchEmail2 === "") {
                    alert("Bạn chưa nhập 'Email' để tìm kiếm.");
                    return false;
                } else if (dateInput > currentDate) {
                    alert('Ngày sinh cần nhỏ hơn ngày hiện tại.');
                    return false;
                } else {
                    return true;
                }
            }
            function checkAddReaderInput() {
                //Get input
                var idAddFullName = document.getElementById("addReaderInputName").value;
                var idAddDOB = document.getElementById("addReaderInputDOB").value;
                var idAddSDT = document.getElementById("addReaderInputSDT").value;
                var idAddEmail = document.getElementById("addReaderInputEmail").value;

                //Check input
                var dateOfBirthInput = new Date(idAddDOB);//Convert value of idDate to Date type
                var currenDate = new Date();//Get the current date 


                if (idAddFullName === "") {
                    alert("Bạn chưa nhập 'Họ và Tên' để thêm.");
                    return false;
                } else if (idAddDOB === "") {
                    alert("Bạn chưa nhập 'Ngày sinh' để thêm.");
                    return false;
                } else if (idAddSDT === "") {
                    alert("Bạn chưa nhập 'Số điện thoại' để thêm.");
                    return false;
                } else if (idAddEmail === "") {
                    alert("Bạn chưa nhập 'Email' để thêm.");
                    return false;
                } else if (dateOfBirthInput > currenDate) {
                    alert('Ngày sinh cần nhỏ hơn ngày hiện tại.');
                    return false;
                } else {
                    return true;
                }
            }

//                  <form action="/action_page.php">   từ W3Schools
<!--<label for="email">Email:</label>-->
<!--<input type="email" id="email" name="email"-->
<!--                  "[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$"                -->
<!--After the "." sign, add at least 2 letters from a to z:-->

<!--                  "[a-z0-9._%+\-]+@gmail.com$"                -->

<!--<input type="submit">-->
<!--</form>-->

<!--<form action="/action_page.php">-->
<!--<label for="pwd">Password:</label>-->
<!--<input type="password" id="pwd" name="pwd"-->
<!--                  "(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"                  -->
<!--title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">-->
<!--<input type="submit">-->
<!--</form>-->


        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>

