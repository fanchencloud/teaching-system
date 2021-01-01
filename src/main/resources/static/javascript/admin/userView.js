// 页面加载完成自动执行
$(function () {
    // 获取请求参数
    const urlSearch = getUrlSearch("userId");
    if (!validateParameterRequired(urlSearch)) {
        // 请求为空，直接跳转回用户页面
        window.location.href = "/page/admin/userList";
    }
    // 查询用户信息
    // 获取用户信息
    $.get("/user/userInfo?userId=" + urlSearch, function (response) {
        if (response.status === 200) {
            let user = response.data;
            console.log(user);
            $("#userId").html(user.id);
            $("#username").html(showStringMessage(user.username));
            $("#sex").html(showStringMessage(user.sex));
            $("#birthday").html(showStringMessage(user.birthday));
            $("#phone").html(showStringMessage(user.phone));
            $("#address").html(showStringMessage(user.address));
            $("#userType").html(getUserType(user.userType));
        }
    });
});
