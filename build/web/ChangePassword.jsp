<%-- 
    Document   : ChangePassword
    Created on : Nov 4, 2023, 4:31:07 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="author" content="Aldi Duzha" />
        <meta name="description" content="Free Bulma Login Template, part of Awesome Bulma Templates" />
        <meta name="keywords" content="bulma, login, page, website, template, free, awesome" />
        <link rel="canonical" href="https://aldi.github.io/bulma-login-template/" />
        <title>TRANG THAY ĐỔI MẬT KHẨU</title>
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma-social@1/bin/bulma-social.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.0/css/all.min.css" />
        <link rel="stylesheet" href=css/style.css>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                background-image: url('media/background.jpg');
                background-size: cover;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>
            <section class="hero is-fullheight">
                <div class="hero-body">
                    <div class="container has-text-centered">
                        <div class="column is-4 is-offset-4">
                            <div class="box">
                                <p class="subtitle is-4">ĐỔI MẬT KHẨU</p>
                                <form action="changePassword" method="post">
                                    <p>${mess}</p><br>
                                    <div class="field">
                                        <p class="control has-icons-left has-icons-right">
                                            <input class="input is-medium" type="text" placeholder="Tên đăng nhập" name="userName"/>
                                            <span class="icon is-medium is-left">
                                                <i class="fas fa-envelope"></i>
                                            </span>
                                            <span class="icon is-medium is-right">
                                                <i class="fas fa-check"></i>
                                            </span>
                                        </p>
                                    </div>
                                    <div class="field">
                                        <p class="control has-icons-left">
                                            <input class="input is-medium" type="password" placeholder="Mật khẩu cũ" name="passwordOld"/>
                                            <span class="icon is-small is-left">
                                                <i class="fas fa-lock"></i>
                                            </span>
                                        </p>
                                    </div>
                                    <div class="field">
                                        <p class="control has-icons-left">
                                            <input class="input is-medium" type="password" placeholder="Mật khẩu mới" name="passwordChange"/>
                                            <span class="icon is-small is-left">
                                                <i class="fas fa-lock"></i>
                                            </span>
                                        </p>
                                    </div>
                                    <button class="button is-block is-info is-large is-fullwidth" type="submit">Xác nhận</button><br />
                                    <!--<a href="home">Home</a>-->
                                    <p class="has-text-grey">
                                        <!--<a href="#">Sign Up</a> &nbsp;·&nbsp;--> 
                                        <a href="login">Đăng nhập</a>
                                        <!--<a href="#">Need Help?</a>-->
                                    </p>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                                    
    </body>
</html>
