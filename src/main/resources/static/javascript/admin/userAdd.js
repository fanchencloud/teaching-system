const backToUserList = function () {
    window.location.href = "/page/admin/userList";
};

const addUser = function () {
    // 封装数据
    let user = {};
    // 读取用户信息
    // 用户名称
    let username = $("#username").val();
    if (!validateParameterRequired(username)) {
        alert("用户名不能为空！");
        return false;
    }
    let name = $("#nickname").val();
    let password = $("#password").val();
    let sex = $("#sex").val();
    let birthday = $("#birthday").val();
    let phone = $("#userPhone").val();
    let address = $("#userAddress").val();
    let age = $("#age").val();
    let level = $("input[name='userLevel']:checked").val();
    let userType = $("input[name='userType']:checked").val();


    if (!validateParameterRequired(password)) {
        alert("密码不能为空，请重试！");
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
    if (!validateParameterRequired(userType)) {
        alert("用户类别不能为空，请重试！");
        return false;
    } else {
        user.userType = userType;
    }

    if (validateParameterRequired(name)) {
        user.name = name;
    }
    if (validateParameterRequired(sex)) {
        user.sex = sex;
    }
    if (validateParameterRequired(birthday)) {
        user.birthday = birthday;
    }
    if (validateParameterRequired(phone)) {
        user.phone = phone;
    }

    if (validateParameterRequired(address)) {
        user.address = address;
    }
    if (validateParameterRequired(age)) {
        user.age = age;
    }
    // 提交数据
    $.ajax({
        type: "POST",
        url: "/user/add",
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
                alert("添加失败！");
            }
        },
        error: function (xhr) {
            console.log("错误提示： " + xhr + " ---- " + xhr.status + " " + xhr.statusText);
            alert("添加失败！");
        },
        //请求完成后回调函数 (请求成功或失败之后均调用)。参数： XMLHttpRequest 对象和一个描述成功请求类型的字符串
        complete: function (XMLHttpRequest, textStatus) {
            console.log("函数调用完成，将按钮设置为可用状态");
            alert("添加失败！");
        }
    });
};