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
            <form class="form-inline" action="${pageContext.request.contextPath}/UserListServlet" >
                <div class="form-group">
                    <label for="name">名稱</label>
                    <input type="text" class="form-control" id="name" name="name" value="${requestScope.condition.name[0]}">
                </div>
                <div class="form-group">
                    <label for="address">城市</label>
                    <input type="text" class="form-control" id="address" name="address" value="${requestScope.condition.address[0]}">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${requestScope.condition.email[0]}">
                </div>
                <button type="submit" class="btn-default">搜尋</button>
            </form>
        </div>
    </div>

    <div class="btn-container my-block">
        <a type="button" class="btn btn-primary btn-sm" href="RegisterServlet">添加用戶</a>
        <a type="button" class="btn btn-primary btn-sm" href="javascript:deleteUserSelect()">刪除用戶</a>
    </div>


    <div class="UserForm">
        <table class="table table-bordered">
            <thead>
            <th><input type="checkbox" class="selectBox-all"></th>
            <th>用戶ID</th>
            <th>用戶姓名</th>
            <th>性別</th>
            <th>年齡</th>
            <th>地區</th>
            <th>電話號碼</th>
            <th>email</th>
            <th>操作</th>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.pageBean.list}" var="user">
                <tr>
                    <td><input type="checkbox" class="selectBox" data-id="${user.id}"></td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>
                        <div class="setting">
                            <a href="${pageContext.request.contextPath}/reviseUserServlet?id=${user.id}">修改</a>

                            <a href="javascript:deleteUser(${user.id})">刪除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>


        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="${requestScope.pageBean.currentPage == 1 ? 'disabled' : ''}">
                        <a href="<c:url value='/UserListServlet?${requestScope.queryString}&page=${requestScope.pageBean.currentPage - 1}' />" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="pg" begin="1" end="${requestScope.pageBean.totalPage}">
                        <li class="${pg == requestScope.pageBean.currentPage ? 'active' : ''}">
                            <a href="<c:url value='/UserListServlet?${requestScope.queryString}&page=${pg}' />">${pg}</a>
                        </li>
                    </c:forEach>
                    <li class="${requestScope.pageBean.currentPage == requestScope.pageBean.totalPage ? 'disabled' : ''}">
                        <a href="<c:url value='/UserListServlet?${requestScope.queryString}&page=${requestScope.pageBean.currentPage + 1}' />" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
                <h4>總比數: ${requestScope.pageBean.totalCount} / 目前頁數: ${requestScope.pageBean.currentPage}</h4>
            </nav>
        </div>

    </div>

</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/JS/UserList.js"></script>


</body>
</html>