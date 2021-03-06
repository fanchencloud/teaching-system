package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Elective;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.mapper.CourseDao;
import cn.chen.teachingsystem.mapper.ElectiveDao;
import cn.chen.teachingsystem.mapper.QuestionnaireDao;
import cn.chen.teachingsystem.mapper.SupervisionDao;
import cn.chen.teachingsystem.service.QuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 9:06
 * @Description:
 */
@Service
@Slf4j
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private DataSourceTransactionManager dataSourceTransactionManager;

    private CourseDao courseDao;

    private QuestionnaireDao questionnaireDao;

    private ElectiveDao electiveDao;

    private SupervisionDao supervisionDao;

    @Override
    public List<Course> getQuestionnaireCourse(Integer userId, Integer courseId, String college) {
        return courseDao.getSelectedCourse(userId, null, null, null, college, 1);
    }

    @Override
    public List<Questionnaire> getQuestionnairesByCourseId(Integer courseId) {
        return questionnaireDao.selectByCourseId(courseId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean fillInTheQuestionnaire(Questionnaire questionnaire) {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setName("updateMessage");
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        // 1- 问卷表数据保存
        int insertSelective = questionnaireDao.insertSelective(questionnaire);
        if (insertSelective <= 0) {
            log.error("{}", "问卷表保存失败！");
            throw new RuntimeException("问卷表保存失败！");
        }
        // 2- 选课表修改完成状态
        // 2.1 - 查询选课情况
        Elective temp = electiveDao.selectByCourseIdAndUserId(questionnaire.getCourseId(), questionnaire.getUserId());
        if (temp == null) {
            log.error("{}", "查询选课表出错！");
            throw new RuntimeException("修改选课表数据失败！");
        }
        // 2.2 - 修改选课表
        Elective elective = new Elective();
        elective.setId(temp.getId());
        elective.setUserId(questionnaire.getUserId());
        elective.setCourseId(questionnaire.getCourseId());
        elective.setFinish(2);
        if (electiveDao.updateByPrimaryKeySelective(elective) <= 0) {
            log.error("{}", "修改选课表数据失败！");
            throw new RuntimeException("修改选课表数据失败！");
        }
        // 3- 督导表更改完成数量
        if (supervisionDao.increaseFinish(questionnaire.getUserId()) <= 0) {
            log.error("{}", "修改督导表数据失败！");
            throw new RuntimeException("修改督导表数据失败！");
        }
        return true;
    }

    @Override
    public Questionnaire getQuestionnairesById(Integer id) {
        return questionnaireDao.selectByPrimaryKey(id);
    }

    /**
     * 获取所有的问卷列表
     *
     * @return 问卷列表
     */
    @Override
    public List<Questionnaire> getAllQuestionnaireList() {
        return questionnaireDao.getAllQuestionnaireList();
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    @Autowired
    public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    @Autowired
    public void setElectiveDao(ElectiveDao electiveDao) {
        this.electiveDao = electiveDao;
    }

    @Autowired
    public void setSupervisionDao(SupervisionDao supervisionDao) {
        this.supervisionDao = supervisionDao;
    }
}
