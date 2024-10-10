<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Login.css">

</head>
<body>

<div class="admin-login">
    <form id="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
        <div class="group">
            <label for="account">帳號</label>
            <input type="text" class="form-control" id="account" name="account" required>
        </div>
        <div class="group">
            <label for="password">密碼</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <!-- Google reCAPTCHA widget -->
        <div class="group">
            <button class="g-recaptcha btn btn-primary"
                    data-sitekey="6LfOAF0qAAAAADJvzL3Oq1ZJsfzghc7TiRaPMhoe"
                    data-callback='onSubmit'
                    data-action='submit'>
                提交驗證
            </button>
        </div>
    </form>

    <div class="login_mse">
        <strong>${requestScope.login_msg}</strong>
    </div>

</div>

<!-- 加載 Google reCAPTCHA 的 API -->
<script src="https://www.google.com/recaptcha/api.js?render=6LfOAF0qAAAAADJvzL3Oq1ZJsfzghc7TiRaPMhoe"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/login.js"></script>

</body>
</html>