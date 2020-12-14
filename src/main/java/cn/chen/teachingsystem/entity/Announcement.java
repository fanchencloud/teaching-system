package cn.chen.teachingsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * announcement
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("课程信息")
public class Announcement extends Base implements Serializable {
    /**
     * 唯一id
     */
    @ApiModelProperty("公告唯一id")
    private Integer id;

    /**
     * 公告内容
     */
    @ApiModelProperty("公告内容")
    private String content;

    /**
     * 公告标题
     */
    @ApiModelProperty("公告标题")
    private String title;

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

    /**
     * 是否发布，0-不发布，1-发布
     */
    @ApiModelProperty("是否发布，0-不发布，1-发布")
    private Integer flag;

    private static final long serialVersionUID = 1L;
}