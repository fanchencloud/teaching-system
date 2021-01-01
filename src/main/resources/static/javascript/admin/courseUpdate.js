let userId;
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
            userId = user.id;
            $("#userName").val(showStringMessage(user.username));
            $("#nickname").val(showStringMessage(user.name));
            $("#userSex").val(showStringMessage(user.sex));
            $("#birthday").val(showStringMessage(user.birthday));
            $("#userPhone").val(showStringMessage(user.phone));
            $("#userAddress").val(showStringMessage(user.address));
            $("#age").val(showStringMessage(user.age));
            $('input:radio').eq(user.level).attr('checked', 'true');
        } else {
            alert("系统出错，请重试！");
            window.location.href = "/page/admin/userList";
        }
    });
});

const backToUserList = function () {
    window.location.href = "/page/admin/userList";
};

const modifyUser = function () {
    // 封装数据
    let user = {};
    if (!validateParameterRequired(userId)) {
        alert("系统出错，请重试！");
        window.location.href = "/page/admin/userList";
    }
    user.id = userId;
    // 读取用户信息
    // 用户名称
    let username = $("#userName").val();
    let name = $("#nickname").val();
    let sex = $("#userSex").val();
    let birthday = $("#birthday").val();
    let phone = $("#userPhone").val();
    let address = $("#userAddress").val();
    let age = $("#age").val();
    let level = $("input[name='userLevel']:checked").val();


    if (!validateParameterRequired(username)) {
        alert("用户名不能为空，请重试！");
        return false;
    } else {
        user.username = username;
    }
    if (!validateParameterRequired(level)) {
        alert("用户级别不能为空，请重试！");
        return false;
    } else {
        user.level = level;
    }
    if (validateParameterRequired(address)) {
        user.address = address;
    }
    if (validateParameterRequired(age)) {
        user.age = age;
    }
    if (validateParameterRequired(birthday)) {
        user.birthday = birthday;
    }
    if (validateParameterRequired(name)) {
        user.name = name;
    }
    if (validateParameterRequired(phone)) {
        user.phone = phone;
    }
    if (validateParameterRequired(sex)) {
        user.sex = sex;
    }
    console.log(JSON.stringify(user));
    // let formData = new FormData();
    // formData.append("user", JSON.stringify(user));
    // 提交数据
    $.ajax({
        type: "POST",
        url: "/user/modify",
        dataType: "json",
        cache: false,         //不设置缓存
        processData: false,  // 不处理数据
        contentType: "application/json;charset=utf-8",  //发送信息至服务器时内容编码类型。
        data: JSON.stringify(user),
        success: function (response) {
            console.log(response);
            if (response.status === 200) {
                console.log("添加成功！");
                alert(response.msg);
                // 数据修改成功，重新跳转回查询界面
                window.location.href = "/page/admin/userList";
            } else {
                console.log("请求失败");
            }
        },
        error: function (xhr) {
            console.log("错误提示： " + xhr + " ---- " + xhr.status + " " + xhr.statusText);
        },
        //请求完成后回调函数 (请求成功或失败之后均调用)。参数： XMLHttpRequest 对象和一个描述成功请求类型的字符串
        complete: function (XMLHttpRequest, textStatus) {
            console.log("函数调用完成，将按钮设置为可用状态");
        }
    });
}
