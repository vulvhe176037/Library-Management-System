<%-- 
    Document   : Home
    Created on : Oct 16, 2023, 12:07:39 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ - Home</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                background-image: url('media/9617cc77bded8b0904569d37c3b49efb.jpg');
                background-size: cover;
                background-repeat: no-repeat;
            }
            .ragiua{
                display: flex;
                margin: auto;
            }
            b{
                color: #4CAF50;
            }
            .logoutlogin{
                color: #007bff;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto ragiua">
                    <li class="nav-item active">
                        <span class="nav-link"><b>CHÀO MỪNG TỚI THƯ VIỆN!</b></span>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="HomePage.jsp">TRANG CHỦ<span class="sr-only">(current)</span></a>
                    </li>
                    <c:if test="${sessionScope.accountSession != null}">
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="managementAll" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                QUẢN LÝ
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="managementBook">SÁCH</a>
                                <a class="dropdown-item" href="managementReader">ĐỘC GIẢ</a>
                                <a class="dropdown-item" href="managementBorrowReturn">MƯỢN & TRẢ</a>
                                <!--<div class="dropdown-divider"></div>-->

                                <!--<a class="dropdown-item" href="#">Something else here</a>-->
                            </div>
                        </li>
                    </c:if>
                    <li class="nav-item active">
                        <a class="nav-link" href="regulations">NỘI QUY THƯ VIỆN<span class="sr-only">(current)</span></a>
                    </li>
                    <c:if test="${sessionScope.accountSession == null}">
                        <li class="nav-item active">
                            <a href="LoginPage.jsp" class="nav-link disabled"><span class="logoutlogin">ĐĂNG NHẬP</span></a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.accountSession != null}">
                        <li class="nav-item active"><a class="nav-link user"><strong>XIN CHÀO, ${sessionScope.accountSession.getAccountName()}!</strong></a></li>
                        <li class="nav-item active"><a class="nav-link" href="logout"><span class="logoutlogin">ĐĂNG XUẤT</span></a></li>
                        <!--<li><a class="nav-link" href="profile"><span>PROFILE</span></a></li>-->
                    </c:if>
                </ul>

                <c:if test="${sessionScope.accountSession != null}">
                    <a class="nav-link btn btn-outline-success my-2 my-sm-0" href="profile"><span>THÔNG TIN CÁ NHÂN</span></a>
                </c:if>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>

