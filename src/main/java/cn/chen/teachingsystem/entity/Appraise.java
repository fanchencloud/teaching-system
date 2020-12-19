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
    @ApiModelProperty("领导评价唯一标识id")
    private Integer id;

    /**
     * 领导id
     */
    @ApiModelProperty("领导id")
    private Integer leaderId;

    /**
     * 教师id
     */
    @ApiModelProperty("教师id")
    private Integer teacherId;

    /**
     * 评论类型：1-领导对督导的评价，2-领导对教师的评价
     */
    @ApiModelProperty("评论类型：1-领导对督导的评价，2-领导对教师的评价")
    private Integer type;

    /**
     * 评价内容
     */
    @ApiModelProperty("评价内容")
    private String content;

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