package cn.chen.teachingsystem.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * appraise
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("领导的评价")
public class Appraise extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = -4641308808415368068L;
    /**
     * 唯一id
     */
    @ApiModelProperty("评价唯一标识id")
    private Integer id;

    /**
     * 领导id
     */
    @ApiModelProperty(value = "领导id", required = true)
    private Integer leaderId;

    /**
     * 教师id
     */
    @ApiModelProperty(value = "教师id", required = true)
    private Integer teacherId;
    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id", required = false)
    private Integer courseId;

    /**
     * 评论类型：1-领导对督导的评价，2-领导对教师的评价，3-教师对自己的评价
     */
    @ApiModelProperty("评论类型：1-领导对督导的评价，2-领导对教师的评价，3-教师对自己的评价")
    private Integer type;

    /**
     * 评价内容
     */
    @ApiModelProperty(value = "评价内容", required = true)
    private String content;

    /**
     * 评优等级
     */
    @ApiModelProperty(value = "评优等级", required = true)
    private String level;

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