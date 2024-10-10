$('.registration-page form').on("submit", function (e) {
    const inputsAndSelects = $(".registration-page input, .registration-page select");

    inputsAndSelects.each(function () {
        const inputValue = $(this).val();
        if (inputValue === "" || inputValue === null) {
            $('.checkbox h5').show();
            e.preventDefault();
            return false;
        }
    });

    const checkbox = $('#checkbox').is(':checked');
    console.log(checkbox);
    if (!checkbox) {
        e.preventDefault();
        alert('同意條款後才能創建用戶');
        return false;
    }

});

$('form input').on("input", function (e) {
    $('.checkbox h5').hide();
    console.log($(this).val());
})




