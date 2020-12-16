package cn.chen.teachingsystem.entity;

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