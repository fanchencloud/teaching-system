package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.QuestionnaireList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 6:34
 * @Description:
 */
@Mapper
public interface QuestionnaireListMapper {

    List<QuestionnaireList> selectByCondition(
            @Param("courseId") Integer courseId,
            @Param("courseName") String courseName,
            @Param("teacherId") Integer teacherId,
            @Param("teacherName") String teacherName,
            @Param("qId") Integer qId);
}
