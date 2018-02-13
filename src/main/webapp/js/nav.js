/**
 * 用户退出
 */
$('#logoutLink').click(function () {
    $.ajax({
        type: 'post',
        url: '/api/logout',
        dataType: 'json',
        success: function (data) {
            if (data.code === -1) {
                console.log(data.info);
            } else {
                window.location.href = ("/login");
            }
        }
    });
});