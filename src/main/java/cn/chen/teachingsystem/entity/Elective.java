package cn.chen.teachingsystem.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * elective 选课表
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("选课表")
public class Elective extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = 7749613988765406691L;
    /**
     * 选课表唯一标识ID
     */
    @ApiModelProperty("选课表唯一标识ID")
    private Integer id;

    /**
     * 选课用户id
     */
    @ApiModelProperty("选课用户id")
    private Integer userId;

    /**
     * 课程id
     */
    @ApiModelProperty("课程id")
    private Integer courseId;

    /**
     * 是否完成：0-未完成，1-完成
     */
    @ApiModelProperty("是否完成：0-未完成，1-完成听课，2-完成评价")
    private Integer finish;

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