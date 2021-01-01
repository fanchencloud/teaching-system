var searchUser = function () {
    // 查看搜索参数
    let id = $("#userId").val();
    let name = $("#username").val();
    var user = {};
    if (!isStringEmpty(id)) {
        user["userId"] = id;
    }
    if (!isStringEmpty(name)) {
        user["username"] = name;
    }
    $.get("/user/search",
        user,
        function (res) {
            console.log("Data Loaded: " + res.data);
            // 填充数据
            const userList = res.data;
            removeAllChild("userListContainer");
            var userListPage = '';
            userList.map(function (item) {
                userListPage += '<tr>\n' +
                    '                <td>' + item.id + '</td>\n' +
                    '                <td>' + showStringMessage(item.username) + '</td>\n' +
                    '                <td>' + showStringMessage(item.sex) + '</td>\n' +
                    '                <td>' + showStringMessage(item.age) + '</td>\n' +
                    '                <td>' + showStringMessage(item.phone) + '</td>\n' +
                    '                <td>' + getUserType(item.userType) + '</td>\n' +
                    '                <td>\n' +
                    '                    <a href="/page/admin/userView?userId=' + item.id + '"><img src="/img/read.png" alt="查看" title="查看"/></a>' +
                    '                    <a href="/page/admin/userUpdate?userId=' + item.id + '"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>' +
                    '                </td>\n' +
                    '            </tr>'
            });
            $("#userListContainer").append(userListPage);
        });

}

// 页面加载完成自动执行
$(function () {
    searchUser();
});