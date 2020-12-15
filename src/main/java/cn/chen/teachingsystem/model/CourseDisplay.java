package cn.chen.teachingsystem.model;

import cn.chen.teachingsystem.entity.Base;
import cn.chen.teachingsystem.entity.Course;
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
 * @Date: 2020/12/15
 * @Time: 5:33
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("课程展示列表")
public class CourseDisplay extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = -5682285770794385398L;

    /**
     * 课程教师信息
     */
    @ApiModelProperty("课程教师信息")
    private User user;

    /**
     * 课程信息
     */
    @ApiModelProperty("课程信息")
    private Course course;
}
