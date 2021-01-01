/**
 * 查询课程
 */
const searchCourse = function () {
    // 查看搜索参数
    // 课程号
    let id = $("#courseId").val();
    // 课程名
    let courseName = $("#courseName").val();
    // 学院
    let college = $("#college").val();
    let course = {};
    if (!isStringEmpty(id)) {
        course["courseId"] = id;
    }
    if (!isStringEmpty(courseName)) {
        course["courseName"] = courseName;
    }
    if (!isStringEmpty(college)) {
        course["college"] = college;
    }
    $.get("/course/search",
        course,
        function (res) {
            // 填充数据
            const courseList = res.data;
            console.log(courseList);
            removeAllChild("courseListContainer");
            let courseListPage = '';
            // 判断变量x是否为undefined
            if (typeof (courseList) != "undefined") {
                courseList.map(function (item) {
                    courseListPage += '<tr>\n' +
                        '                <td>' + item.id + '</td>\n' +
                        '                <td>' + showStringMessage(item.courseName) + '</td>\n' +
                        '                <td>' + showStringMessage(item.type) + '</td>\n' +
                        '                <td>' + showStringMessage(item.college) + '</td>\n' +
                        '                <td>' + showStringMessage(item.time) + '</td>\n' +
                        '                <td>' + showStringMessage(item.place) + '</td>\n' +
                        '                <td>' + item.capacity + '</td>\n' +
                        '                <td>\n' +
                        '                    <a href="/page/admin/courseUpdate?courseId=' + item.id + '"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>\n' +
                        '                </td>\n' +
                        '            </tr>';
                });
            }
            $("#courseListContainer").append(courseListPage);
        });

};

// 页面加载完成自动执行
$(function () {
    searchCourse();
});