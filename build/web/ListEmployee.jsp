<%-- 
    Document   : ListEmployee
    Created on : Jan 30, 2024, 11:29:23 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <form action="employee" method="post">
            From <input type="text" name="from" value="${requestScope.min}"/>
            To <input type="text" name="to" value="${requestScope.max}"/>
            <button type="submit">Search</button>
        </form>
        <table border="1px solid black">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>From</td>
                <td>To</td>
                <td>Status</td>
            </tr>
            <c:forEach var="o" items="${listEmployee}">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td>${o.from}</td>
                    <td>${o.to}</td>
                    <td>
                        <c:if test="${o.status == 1}">
                            Approved
                        </c:if>
                        <c:if test="${o.status == -1}">
                            Reject
                        </c:if>
                        <c:if test="${o.status == 0}">
                            <button onclick="changeStatus(this, ${o.id}, 1)">Approved</button>
                            <!--//this => this button-->
                            <button onclick="changeStatus(this, ${o.id}, -1)">Reject</button>
                            <!--<a href="change?id=${o.id}&status=1">Approved</a>-->
                            <!--//truyen nhieu variables ve server => dung dau "&"-->
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
           
        <script>
            function changeStatus(thisButton, eid, estatus) {
                let text = thisButton.textContent; // get text of button
                thisButton.parentElement.innerHTML = text;//

                //su dung ajax de goi toi servlet change
                $.ajax({
                url: '/LibraryManagementSystem/change',
                        type: 'GET',
                        data:{//truyen id va status ve servlet change
                                id: eid,
                                status: estatus
                            },
                success: function (response) { 
                    ////when success, there is data from servlet to here (or not)
                    //do something
                    }
                });
            }
        </script>
    </body>
</html>
