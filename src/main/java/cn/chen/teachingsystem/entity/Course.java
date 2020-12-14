package cn.chen.teachingsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * course
 * @author 
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("课程信息")
public class Course extends Base implements Serializable {
    /**
     * 唯一id
     */
    @ApiModelProperty("用户唯一标识")
    private Integer id;

    /**
     * 教师id
     */
    @ApiModelProperty("教师id")
    private Integer teacherId;

    /**
     * 课程容量
     */
    @ApiModelProperty("课程容量")
    private Integer capacity;

    /**
     * 课程名
     */
    @ApiModelProperty("课程名")
    private String courseName;

    /**
     * 上课地点
     */
    @ApiModelProperty("上课地点")
    private String place;

    /**
     * 所属学院
     */
    @ApiModelProperty("所属学院")
    private String college;

    /**
     * 评价内容
     */
    @ApiModelProperty("评价内容")
    private String content;

    /**
     * 开课时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty("开课时间")
    private Date startTime;

    /**
     * 结束时间
     */
//    @JSONField(format = "yyyy-MM-dd HH:mm")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty("结束时间")
    private Date endTime;

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
     * 课程类型
     */
    @ApiModelProperty("课程类型")
    private String type;

    /**
     * 上课时间
     */
    @ApiModelProperty("上课时间")
    private String time;

    private static final long serialVersionUID = 1L;
}