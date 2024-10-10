<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UserInfo</title>

    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/UserList.css">

</head>
<body>

<h2 class="hand">用戶個人資料 UserInfo</h2>

<div class="main">
    <div class="up-head">
        <div class="form-inline-parent">
            <form class="form-inline">
                <div class="form-group">
                    <label for="InputName">名稱</label>
                    <input type="text" class="form-control" id="InputName">
                </div>
                <div class="form-group">
                    <label for="InputGender">城市</label>
                    <input type="text" class="form-control" id="InputGender">
                </div>
                <div class="form-group">
                    <label for="Email">Email</label>
                    <input type="email" class="form-control" id="Email">
                </div>
                <button type="submit" class="btn-default">搜尋</button>
            </form>
        </div>
    </div>

    <div class="btn-container my-block">
        <a type="button" class="btn btn-primary btn-sm" href="RegisterServlet">添加用戶</a>
        <a type="button" class="btn btn-primary btn-sm" href="">刪除用戶</a>
    </div>


    <div class="UserForm">
        <table class="table table-bordered">
            <thead>
            <th><input type="checkbox"></th>
            <th>用戶ID</th>
            <th>用戶姓名</th>
            <th>性別</th>
            <th>年齡</th>
            <th>地區</th>
            <th>電話號碼</th>
            <th>email</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.users}" var="user">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>


</body>
</html>