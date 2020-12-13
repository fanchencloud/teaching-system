package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionnaireDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);
}