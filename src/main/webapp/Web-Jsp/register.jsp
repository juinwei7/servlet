<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>register</title>
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/UserList.css">

</head>
<body>


<div class="registration-page">

    <div class="registration-text">
        <form action="YourServlet" method="POST">
            <div class="text-title">
                <h3>用戶建立</h3>
            </div>

            <div class="form-group">
                <label for="inputName">姓名</label>
                <input type="text" class="form-control" id="inputName">
            </div>
            <div class="form-group">
                <label for="inputGender">性別</label>
                <select class="form-control" id="inputGender">
                    <option value="" disabled selected>請選擇性別</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                    <option value="不公開">不公開</option>
                </select>
            </div>
            <div class="form-group">
                <label for="inputAge">年齡</label>
                <select class="form-control" id="inputAge">
                    <option value="" disabled selected>請選擇年齡</option>
                    <% for (int age = 20; age <= 80; age++) { %>
                    <option value="<%= age %>"><%= age %>
                    </option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="inputAdderss">縣市</label>
                <select class="form-control" id="inputAdderss">
                    <option value="" disabled selected>請選擇地區</option>
                    <c:forEach items="${requestScope.address}" var="adders">
                    <option value="${adders}">${adders}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="InputEmail1">Email</label>
                <input type="email" class="form-control" id="InputEmail1">
            </div>


            <div class="checkbox">
                <label>
                    <input type="checkbox" id="checkbox"> 已閱讀條款
                </label>
                <h5 hidden="hidden">有資料尚未填寫</h5>
            </div>
            <button type="submit" class="btn btn-default">創建用戶</button>


        </form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/UserList.js"></script>

</body>
</html>
