package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Questionnaire;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/20
 * @Time: 0:42
 * @Description:
 */
public interface TeacherService {

    List<Questionnaire> getAppraiseList(Integer courseId);
}
