$('.registration-page form .revise-page form').on("submit", function (e) {
    const inputsAndSelects = $(".registration-page input, .registration-page select");

    let can = false;
    inputsAndSelects.each(function () {
        const inputValue = $(this).val();
        if (inputValue === "" || inputValue === null) {
            $('.checkbox h5').show();
            e.preventDefault();
            can = true;
            return false;
        }
    });

    if (can) {
        alert("有資料未填寫完成")
        return;
    }

    const checkbox = $('#checkbox');

    if (checkbox.length > 0) {
        const isChecked = checkbox.is(':checked'); // 判斷是否被勾選
        if (!isChecked) {
            e.preventDefault();
            alert('同意條款後才能創建用戶');
            return false;
        }
    }


});

const inputCard = $('#inputPhone');
inputCard.on('input', function(e) {
    const v = $(this).val();
    const filteredValue = v.replace(/[^0-9]/g, '');
    $(this).val(filteredValue);

});

$('form input').on("input", function (e) {
    $('.checkbox h5').hide();
})




