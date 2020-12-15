package cn.chen.teachingsystem.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * supervision
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("督导情况表")
public class Supervision extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = 5359940490173441493L;
    /**
     * 唯一id
     */
    @ApiModelProperty("督导表唯一标识id")
    private Integer id;

    /**
     * 督导用户id
     */
    @ApiModelProperty("督导用户id")
    private Integer userId;

    /**
     * 任务总量
     */
    @ApiModelProperty("任务总量")
    private Integer amount;

    /**
     * 完成数量
     */
    @ApiModelProperty("完成数量")
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