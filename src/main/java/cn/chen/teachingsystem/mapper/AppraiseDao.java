package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.model.AppraiseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AppraiseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    /**
     * 添加一条评价列表
     *
     * @param record
     * @return
     */
    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);

    List<AppraiseModel> selectByCondition(
            @Param("userId") Integer userId,
            @Param("leaderName") String leaderName,
            @Param("id") Integer id);

    /**
     * 通过教师编号和课程编号查询对教师的评价总结
     *
     * @param teacherId 教师编号
     * @param courseId  课程编号
     * @return 评价总结
     */
    Appraise summaryEvaluationOfTeacher(@Param("teacherId") Integer teacherId, @Param("courseId") Integer courseId);

    /**
     * 通过管理员编号和督导编号查询督导的评价总结
     *
     * @param adminId     管理员编号
     * @param superviseId 督导编号
     * @return 评价总结
     */
    Appraise selectByAdminIdAndSuperviseId(@Param("adminId") Integer adminId, @Param("superviseId") Integer superviseId);

    /**
     * 查看督导评价总结
     *
     * @param superviseId 督导编号
     * @return 评价总结
     */
    Appraise getAppraiseSupervisorEvaluationSummary(Integer superviseId);

    /**
     * 查看教师评估总结
     *
     * @param teacherId 教师编号
     * @return 评价总结
     */
    Appraise getAppraiseTeacherEvaluationSummary(Integer teacherId);
}