package cn.chen.teachingsystem.model;

import cn.chen.teachingsystem.entity.Base;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 6:27
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("问卷列表展示")
public class QuestionnaireList extends Base implements Serializable {

    @Serial
    private static final long serialVersionUID = 1023724823016880298L;

    /**
     * 填写评价的人
     */
    @ApiModelProperty("填写评价的人")
    private String appraiser;
    /**
     * 用户信息
     */
    @ApiModelProperty("用户信息")
    private User user;
    /**
     * 课程信息
     */
    @ApiModelProperty("课程信息")
    private Course course;
    /**
     * 问卷信息
     */
    @ApiModelProperty("问卷信息")
    private Questionnaire questionnaire;
}
