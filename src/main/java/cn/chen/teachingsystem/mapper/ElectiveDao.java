package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Elective;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chen
 */
@Mapper
public interface ElectiveDao {
    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    int insert(Elective record);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    int insertSelective(Elective record);

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */
    Elective selectByPrimaryKey(Integer id);

    /**
     * 通过选课的课程编号和选课人员的编号查询选课情况
     *
     * @param courseId 课程编号
     * @param userId   选课的人员编号
     * @return 选课情况
     */
    Elective selectByCourseIdAndUserId(@Param("courseId") Integer courseId, @Param("userId") Integer userId);

    int updateByPrimaryKeySelective(Elective record);

    int updateByPrimaryKey(Elective record);

    int sigIn(@Param("userId") Integer userId, @Param("courseId") Integer courseId);
}