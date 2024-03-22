<%-- 
    Document   : Profile
    Created on : Oct 16, 2023, 9:10:28 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROFILE PAGE</title>
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
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            form {
                background-color: #fff;
                width: 35%;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                text-align: center;
            }

            h1 {
                font-size: 24px;
            }

            div {
                margin: 10px 0;
                text-align: left;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            input[type="text"], input[type="date"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            input[type="text"][readonly], input[type="date"][readonly] {
                background-color: #f0f0f0;
                border: none;
            }

            button {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;
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
            .back{
                text-align: center;
            }
            .fmt{
                background-color: #f0f0f0;
                border: 0px;
                padding: 10px 10px;
            }
        </style>
    </head>
    <body>
        <form method="post" action="profile">
            <h1>THÔNG TIN CÁ NHÂN</h1>
            <div>Tên đăng nhập: <input type="text" value="${user.getAccountName()}" readonly></div>
            <div>Họ và Tên: <input type="text" value="${user.getFullName()}" readonly></div>
            <div>Email: <input type="text" value="${user.getEmail()}" readonly></div>
            <div>Số điện thoại: <input type="text" value="${user.getPhoneNumber()}" readonly></div>
            <div>Ngày sinh (dd/MM/yyyy):
                <div class="fmt"><format:formatDate value="${user.getDateOfBirth()}" pattern="dd/MM/yyyy"/></div>
            </div>
            <div>Ngày tạo tài khoản (dd/MM/yyyy):
                <div class="fmt"><format:formatDate value="${user.getCreatedDate()}" pattern="dd/MM/yyyy"/></div>
            </div>
            <div>Cấp độ truy cập: <input type="text" value="${user.getAccessLevel()}" readonly></div>
            <br>
            <div class="back"><a href="home">Quay lại</a></div>
        </form>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
