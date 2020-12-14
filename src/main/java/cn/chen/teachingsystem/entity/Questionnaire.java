package cn.chen.teachingsystem.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * questionnaire
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("问卷信息")
public class Questionnaire extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = 4658106444291961997L;
    /**
     * 问卷唯一id
     */
    @ApiModelProperty("问卷唯一id")
    private Integer id;

    /**
     * 评价用户id
     */
    @ApiModelProperty("评价用户id")
    private Integer userId;

    /**
     * 教师id
     */
    @ApiModelProperty("教师id")
    private Integer teacherId;

    /**
     * 课程id
     */
    @ApiModelProperty("课程id")
    private Integer courseId;

    /**
     * 教学态度
     */
    @ApiModelProperty("教学态度")
    private Integer attitude;

    /**
     * 教学内容
     */
    @ApiModelProperty("教学内容")
    private Integer content;

    /**
     * 教学技巧
     */
    @ApiModelProperty("教学技巧")
    private Integer skill;

    /**
     * 教学效果
     */
    @ApiModelProperty("教学效果")
    private Integer effect;

    /**
     * 教学特点
     */
    @ApiModelProperty("教学特点")
    private Integer feature;

    /**
     * 总分
     */
    @ApiModelProperty("总分")
    private Integer total;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @ApiModelProperty("最后修改时间")
    private Date lastEditTime;

}