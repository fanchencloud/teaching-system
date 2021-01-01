// 在页面加载完成执行函数
$(function () {
    // console.log("页面加载完成自动执行！");

    // 获取用户信息
    $.get("/getUserInformation", function (response) {
        if (response.status === 200) {
            let user = response.data;
            $("#loginUserType").html(getUserType(user.userType));
            $("#usernameLabel").html(user.name);
        }
    });
});

/**
 *字符串去除所有空格
 */
const commonTrim = function (a) {
    if (typeof a == 'string') {
        return a.replace(/\s+/, '');
    } else {
        return a;
    }
};


/**
 *字符串判空
 */
const isStringEmpty = function (a) {
    const b = commonTrim(a);
    return !((typeof a) == 'string' && b);
}
//用户类别：0-教师，1-专家，2-领导，3-管理员 4 - 教师督导
const getUserType = function (typeId) {
    let userType = "教师";
    switch (typeId) {
        case 0:
            userType = "教师";
            break;
        case 1:
            userType = "专家";
            break;
        case 2:
            userType = "领导";
            break;
        case 3:
            userType = "管理员";
            break;
        case 4:
            userType = "教师督导";
            break;
    }
    return userType;
}
const removeAllChild = function (elementId) {
    let div = document.getElementById(elementId);
    //当div下还存在子节点时 循环继续
    while (div.hasChildNodes()) {
        div.removeChild(div.firstChild);
    }
}

/**
 * 检查数据的有效性
 * @param value 数据
 * @param message 提示消息
 * @returns {boolean} 参数为空返回真，否则反复假
 */
const validateRequired = function (value, message) {
    // if (validateParameterRequired(value)) {
    //     $.alert(message);
    //     return true;
    // }
    // return false;
    if (checkIsNullOrEmpty(value)) {
        // 数据不为空
        return false;
    } else {
        $.alert(message);
        return true;
    }
};

/**
 * 检查数据的有效性
 * @param value 数据
 * @returns {boolean} 参数为非空返回 true 否则返回 false
 */
const validateParameterRequired = function (value) {
    // return !!(value === undefined //未初始化的判断
    //     || value == null //object类型的判断
    //     || (typeof (value) == 'string' && (value === '' || value.match(/\s+/)))
    //     || (typeof (value) == 'number' && isNaN(value)));
    return checkIsNullOrEmpty(value);
};

const checkIsNullOrEmpty = function (value) {
    //正则表达式用于判斷字符串是否全部由空格或换行符组成
    const reg = /^\s*$/;
    //返回值为true表示不是空字符串
    return (value != null && value !== undefined && !reg.test(value));
};

const showStringMessage = function (phone) {
    if (validateParameterRequired(phone)) {
        return phone;
    } else {
        return "";
    }
}

/**
 * 获取地址栏参数
 * @param name
 * @returns {string|null}
 */
const getUrlSearch = function (name) {
    // 未传参，返回空
    if (!name) return null;
    // 查询参数：先通过search取值，如果取不到就通过hash来取
    let after = window.location.search;
    after = after.substr(1) || window.location.hash.split('?')[1];
    // 地址栏URL没有查询参数，返回空
    if (!after) return null;
    // 如果查询参数中没有"name"，返回空
    if (after.indexOf(name) === -1) return null;

    const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)');
    // 当地址栏参数存在中文时，需要解码，不然会乱码
    const r = decodeURI(after).match(reg);
    // 如果url中"name"没有值，返回空
    if (!r) return null;

    return r[2];
}

