<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <title>register</title>
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/revise.css">

</head>
<body>

<div class="revise-page">

    <div class="registration-text">
        <form action="${pageContext.request.contextPath}/reviseUserServlet" method="POST">
            <div class="text-title">
                <h3>用戶資料修改</h3>
            </div>

            <div class="form-group">
                <label for="inputId">編號</label>
                <input type="text" class="form-control" id="inputId" name="inputId" value="${requestScope.user.id}"
                       readonly>
            </div>
            <div class="form-group">
                <label for="inputName">姓名</label>
                <input type="text" class="form-control" id="inputName" name="inputName"
                       value="${requestScope.user.name}">
            </div>
            <div class="form-group">
                <label for="inputGender">性別</label>
                <select class="form-control" id="inputGender" name="inputGender">
                    <option value="${requestScope.user.gender}" selected>${requestScope.user.gender}</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                    <option value="不公開">不公開</option>
                </select>
            </div>
            <div class="form-group">
                <label for="inputAge">年齡</label>
                <select class="form-control" id="inputAge" name="inputAge">
                    <option value="${requestScope.user.age}" selected>${requestScope.user.age}</option>
                    <% for (int age = 20; age <= 80; age++) { %>
                    <option value="<%= age %>"><%= age %>
                    </option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="inputAdderss">縣市</label>
                <select class="form-control" id="inputAdderss" name="inputAdderss">
                    <option value="${requestScope.user.address}" selected>${requestScope.user.address}</option>
                    <c:forEach items="${requestScope.address}" var="adders">
                        <option value="${adders}">${adders}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="inputPhone">電話</label>
                <input type="text" class="form-control" id="inputPhone" name="inputPhone"
                       value="${requestScope.user.phone}">
            </div>
            <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="email" class="form-control" id="inputEmail" name="inputEmail"
                       value="${requestScope.user.email}">
            </div>

            <button type="submit" class="btn btn-default">修改用戶</button>

            <div class="error-msg">
                <h5 hidden="hidden">有資料尚未填寫</h5>
                <h5>${requestScope.error_msg}</h5>
            </div>

        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/register.js"></script>

</body>


</html>
