package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 课程容量
     */
    private Integer capacity;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 上课地点
     */
    private String place;

    /**
     * 所属学院
     */
    private String college;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 开课时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastEditTime;

    private static final long serialVersionUID = 1L;
}