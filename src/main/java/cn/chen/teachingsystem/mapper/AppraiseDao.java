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

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);

    List<AppraiseModel> selectByCondition(
            @Param("userId") Integer userId,
            @Param("leaderName") String leaderName,
            @Param("id") Integer id);
}