package cn.chen.teachingsystem.model;

import cn.chen.teachingsystem.entity.Base;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Elective;
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
 * @Date: 2020/12/15
 * @Time: 5:13
 * @Description: 督导课程情况表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("督导课程情况表")
public class SupervisedCourse extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = -829426648776731932L;

    /**
     * 课程情况
     */
    @ApiModelProperty("课程情况")
    private Course course;

    /**
     * 选课表
     */
    @ApiModelProperty("选课表情况")
    private Elective elective;
}
