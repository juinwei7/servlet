<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用戶資料</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/serachUser.css">

</head>
<body>

<div class="header">
    <h2>管理員： ${sessionScope.admin.adminName}</h2>

</div>


<div class="fuc">
    <div class="group">
        <a href="${pageContext.request.contextPath}/UserListServlet"> 查看用戶資料</a>
    </div>
    <div class="group">
        <a href="${pageContext.request.contextPath}/UserListServlet"> 查看用戶資料</a>
    </div>
</div>
</body>
</html>
