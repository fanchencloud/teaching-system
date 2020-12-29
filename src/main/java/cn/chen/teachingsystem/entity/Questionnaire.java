package cn.chen.teachingsystem.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aspectj.weaver.bcel.BcelVar;
import springfox.documentation.annotations.ApiIgnore;

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
    @ApiModelProperty(value = "评价用户id", required = true)
    private Integer userId;

    /**
     * 教师id
     */
    @ApiModelProperty(value = "教师id", required = true)
    private Integer teacherId;

    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id", required = true)
    private Integer courseId;

    /**
     * 教学态度
     */
    @ApiModelProperty(value = "教学态度", required = true)
    private Integer attitude;

    /**
     * 教学内容
     */
    @ApiModelProperty(value = "教学内容", required = true)
    private Integer content;

    /**
     * 教学技巧
     */
    @ApiModelProperty(value = "教学技巧", required = true)
    private Integer skill;

    /**
     * 教学效果
     */
    @ApiModelProperty(value = "教学效果", required = true)
    private Integer effect;

    /**
     * 教学特点
     */
    @ApiModelProperty(value = "教学特点", required = true)
    private Integer feature;

    /**
     * 总分
     */
    @ApiModelProperty(value = "总分", required = true)
    private Integer total;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date lastEditTime;

    /**
     * 教学过程
     */
    @ApiModelProperty(value = "教学过程", required = true)
    private String teachingProcess;

    /**
     * 教学保障情况
     */
    @ApiModelProperty(value = "教学保障情况", required = true)
    private String teachingGuaranteeSituation;

    /**
     * 学生学习情况
     */
    @ApiModelProperty(value = "学生学习情况", required = true)
    private String studentLearning;

    /**
     * 意见与建议
     */
    @ApiModelProperty(value = "意见与建议", required = true)
    private String commentsAndSuggestions;

}