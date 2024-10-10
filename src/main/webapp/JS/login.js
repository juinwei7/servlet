// 表單驗證

const loginForm = $('#loginForm');

loginForm.on('submit', function (event) {
    console.log("a");
    const inputList = $('.admin-login input');
    let isValid = true;

    inputList.each(function () {
        if ($(this).val() === '' || $(this).val() === null) {
            $(this).css("border", "2px solid red");
            isValid = false;
        } else {
            $(this).css("border", "");
        }
    });

    if (!isValid) {
        event.preventDefault();
        alert("請輸入帳號密碼");
        return false; // 阻止表單提交
    }
});

// 當 ReCAPTCHA 驗證成功時，觸發提交
function onSubmit(token) {
    loginForm.submit(); // 確保表單提交
}