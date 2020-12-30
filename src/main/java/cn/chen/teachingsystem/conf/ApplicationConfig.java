package cn.chen.teachingsystem.conf;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/18
 * @Time: 19:37
 * @Description: 系统配置型
 */
public class ApplicationConfig {
    /**
     * 用户密码错误
     */
    public static final int USER_PASSWORD_ERROR = 1001;

    /**
     * 请求成功
     */
    public static final int APPLICATION_OK = 200;

    /**
     * 请求失败
     */
    public static final int APPLICATION_ERROR = 400;

    /**
     * 评价督导
     */
    public static final int APPRAISE_TYPE_SUPERVISE = 1;

    /**
     * 评价教师
     */
    public static final int APPRAISE_TYPE_TEACHER = 2;

    /**
     * 教师自评
     */
    public static final int APPRAISE_TYPE_TEACHER_SELF = 3;

    /**
     * 教师评价总结
     */
    public static final int APPRAISE_TYPE_TEACHER_SUMMARY = 4;

    /**
     * 教师评价总结
     */
    public static final int APPRAISE_TYPE_SUPERVISE_SUMMARY = 5;

    /**
     * 用户类别——教师
     */
    public static final int USER_TYPE_TEACHER = 0;

    /**
     * 用户类别——专家
     */
    public static final int USER_TYPE_EXPERT = 1;

    /**
     * 用户类别——领导
     */
    public static final int USER_TYPE_LEADER = 2;

    /**
     * 用户类别——管理员
     */
    public static final int USER_TYPE_ADMIN = 3;

    /**
     * 用户类别——教师督导
     */
    public static final int USER_TYPE_TEACHER_SUPERVISION = 4;

    /**
     * 院级督导的课程任务量
     */
    public static final int SUPERVISE_COURSE_TASK_AMOUNT_COLLEGE_LEVEL = 10;

    /**
     * 院级督导
     */
    public static final int SUPERVISE_COURSE_TASK_TYPE_COLLEGE_LEVEL = 0;

    /**
     * 校级督导的课程任务量
     */
    public static final int SUPERVISE_COURSE_TASK_AMOUNT_SCHOOL_LEVEL = 20;

    /**
     * 校级督导
     */
    public static final int SUPERVISE_COURSE_TASK_TYPE_SCHOOL_LEVEL = 1;
}
