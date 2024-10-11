function deleteUser(id) {
    if (confirm("確認刪除用戶嗎？")) {
        window.location.href = contextPath + "/delUserServlet?id=" + id;
    }
}

$('.selectBox-all').on('click', function () {
    const selectBox = $('tr .selectBox');
    const isChecked = $(this).prop('checked');

    selectBox.each(function () {
        $(this).prop('checked', isChecked);
    });
});

function deleteUserSelect() {
    if (confirm("確認刪除選中用戶嗎？")) {
        const selectBox = $('tr .selectBox');
        let st = '';
        selectBox.each(function () {
            if ($(this).prop('checked') === true) {
                const id = $(this).data('id');
                if (id !== null) {
                    st += "id=" + id + "&";
                }
            }
        });

        if (st.length > 0) {
            st = st.slice(0, -1);
            window.location.href = contextPath + "/delUserServlet?" + st;
        } else {
            alert("請選擇至少一個用戶！");
        }
    }
}

$('.pagination a').on('click', function (event) {
    const closestLi = $(this).closest('li');

    if (closestLi.hasClass('disabled')) {
        event.preventDefault(); // 阻止預設行為
        return false; // 停止事件傳遞
    }
});