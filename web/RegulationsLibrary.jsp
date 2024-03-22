<%-- 
    Document   : RegulationsLibrary
    Created on : Nov 4, 2023, 1:51:09 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG NỘI QUY CỦA THƯ VIỆN</title>
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
            }

            h1 {
                color: #009900;
                margin: 10px 0px;
                text-align: center;
            }

            .message {
                /*text-align: center;*/
                background-color: #d4edda;
                width: 65%;
                margin: auto;
                background-color: #87CEEB;
                color: #003333;
                font-weight: bold;
                border: 1px solid #c3e6cb;
                border-radius: 5px;
            }

            .back{
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
            #list-style-I-II{
                list-style-type: upper-roman;
                padding: 30px 65px;
            }
            .list-style-decimal{
                list-style-type: decimal;
                padding: 0px 18px;
            }
            .list-style-alphabet{
                list-style-type: lower-alpha;
                padding: 0px 20px;
            }
            .list-style-disc{
                list-style-type: disc;
            }
            #list-style-disc{
                padding: 0px 15px;
            }
        </style>
    </head>
    <body>
        <h1>NỘI QUY THƯ VIỆN</h1>
        <div class="message">
            <ol id="list-style-I-II">
                <li> NỘI QUY MƯỢN & TRẢ SÁCH:
                    <ul class="list-style-decimal">
                        <li>Mượn sách: Độc giả khi tới mượn sách sẽ cần kiểm tra xem đã từng mượn sách ở thư viện hay chưa (đã có mã độc giả trong cơ sở dữ liệu của thư viện hay chưa), thông qua việc tìm kiếm độc giả. Trong trường hợp độc giả đã từng mượn sách (đã có mã độc giả), thì sẽ chuyển sang dịch vụ cho mượn sách (thêm phiên mượn sách mới). </li>
                        <li>Trả sách: Độc giả khi tới trả sách cần lưu ý trả sách đúng hạn và việc trả sách sẽ được cập nhật vào phiên mượn của độc giả. Sau khi cập nhật, hệ thống sẽ tính toán liệu độc giả có vi phạm hay không. Nếu độc giả vi phạm nội quy, sẽ có mức phạt phù hợp.</li>
                        <li>Các trường hợp vi phạm khi độc giả mượn/trả sách:
                            <ol class="list-style-alphabet">
                                <li>Độc giả trả sách quá hạn.</li>
                                <li>Độc giả không bảo quản, giữ gìn khiến sách bị hư hỏng, nhàu, rách, không khôi phục lại được nguyên trạng.</li>
                            </ol>
                        </li>
                    </ul>
                </li><br>
                <li>XỬ PHẠT KHI VI PHẠM:
                    <ul class="list-style-decimal">
                        <li>Trả sách quá hạn: độc giả cần lưu ý rằng hạn trả sách là sau 7 ngày kể từ ngày mượn. Nếu sau 7 ngày độc giả không trả sách đúng hạn thì sẽ tính phí phạt quá hạn trả sách là 5000 VNĐ/Ngày.</li>
                        <li>Không bảo quản, sử dụng sách hợp lí: độc giả sẽ bị phạt thêm phí đền bù khi làm chất lượng sách bị giảm nhiều so với ban đầu. <div>Cụ thể, chất lượng của sách được đánh giá theo các mức độ như sau:</div></li>
                        <ol class="list-style-alphabet">
                            <li>Mới: Là sách mới được bổ sung về thư viện, cho mượn lần đầu tiên.</li>
                            <li>Tốt: Là sách đã qua sử dụng và còn nguyên dạng.</li>
                            <li>Trung bình: Là sách đã qua sử dụng, có thể bị rách, bong bìa, quăn mép do sử dụng nhiều nhưng đã được sửa chữa.</li>
                            <li>Kém: Là sách mất trang, ướt, nhàu nát, không thể khôi phục về ban đầu.</li>
                            <div>Phí đền bù tài liệu được tính như sau:</div>
                            <ul id="list-style-disc">
                                <li><div class="list-style-disc">Trường hợp chất lượng cuốn sách khi mượn là 'Mới' và khi trả là 'Trung bình', thì độc giả sẽ phải trả phí phạt bằng 1 NỬA giá tiền của cuốn sách.</div></li>
                                <li><div class="list-style-disc">Trường hợp chất lượng cuốn sách khi mượn là 'Tốt' và khi trả là 'Kém', thì độc giả sẽ phải trả phí phạt bằng 1 NỬA giá tiền của cuốn sách.</div></li>
                                <li><div class="list-style-disc">Trường hợp chất lượng cuốn sách khi mượn là 'Mới' và khi trả là 'Kém', thì độc giả sẽ phải trả phí phạt BẰNG giá tiền của cuốn sách.</div></li>
                            </ul>
                        </ol>
                    </ul>
                </li>
            </ol>

        </div>
        <div class="back"><a href="home">Quay lại</a></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
