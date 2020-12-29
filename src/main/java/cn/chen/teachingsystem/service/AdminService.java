package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.AppraiseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/28
 * @Time: 22:39
 * @Description: 管理员服务
 */
@Service
public class AdminService {
    private CourseService courseService;
    private UserService userService;
    private AppraiseDao appraiseDao;

    private AppraiseService appraiseService;

    /**
     * 总结评价页面显示的信息
     *
     * @param teacherId 教师编号
     * @param courseId  课程编号
     * @return 信息
     */
    public Object summaryEvaluation(Integer teacherId, Integer courseId) {
        Map<String, Object> res = new HashMap<>(3);
        // 查询课程信息
        Course course = courseService.selectByPrimaryKey(courseId);
        res.put("course", course);
        // 查询教师信息
        User teacher = userService.getUserInformation(teacherId);
        res.put("teacher", teacher);
        // 查询总结评价信息
        Appraise appraise = appraiseDao.summaryEvaluationOfTeacher(teacherId, courseId);
        if (appraise != null) {
            res.put("appraise", appraise);
        }
        return res;
    }

    /**
     * 总结评价
     *
     * @param appraise 评价总结
     * @return 添加结果
     */
    public boolean fillInTheEvaluationByAdmin(Appraise appraise) {
        Appraise temp = appraiseDao.summaryEvaluationOfTeacher(appraise.getTeacherId(), appraise.getCourseId());
        if (temp != null) {
            return false;
        }
        return appraiseDao.insertSelective(appraise) > 0;
    }


    /**
     * 管理员评价一位督导
     *
     * @param superviseId 督导的用户id
     * @param leaderId    管理员的用户id
     * @param content     评价内容
     * @param level       评优等级
     * @return 评价结果
     */
    public boolean evaluationSupervision(Integer superviseId, Integer leaderId, String content, String level) {
        Appraise a = appraiseDao.selectByAdminIdAndSuperviseId(leaderId, superviseId);
        if (a != null) {
            return false;
        }
        a = new Appraise();
        a.setLeaderId(leaderId);
        a.setTeacherId(superviseId);
        a.setContent(content);
        a.setLevel(level);
        a.setType(ApplicationConfig.APPRAISE_TYPE_SUPERVISE_SUMMARY);
        return appraiseDao.insertSelective(a) > 0;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAppraiseDao(AppraiseDao appraiseDao) {
        this.appraiseDao = appraiseDao;
    }

    @Autowired
    public void setAppraiseService(AppraiseService appraiseService) {
        this.appraiseService = appraiseService;
    }
}
