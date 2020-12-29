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
}
