package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.model.SupervisionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupervisionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Supervision record);

    int insertSelective(Supervision record);

    Supervision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supervision record);

    int updateByPrimaryKey(Supervision record);

    /**
     * 通过督导用户id查询督导完成情况
     *
     * @param userId 督导用户id
     * @return 督导完成情况
     */
    Supervision selectByUserId(Integer userId);

    /**
     * 查询督导任务进度
     *
     * @param userId   督导id
     * @param username 督导姓名
     * @return 督导任务进度
     */
    List<SupervisionModel> getSuperviseTaskProgress(@Param("userId") Integer userId, @Param("username") String username);
}