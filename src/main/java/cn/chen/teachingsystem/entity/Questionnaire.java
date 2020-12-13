package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * questionnaire
 * @author 
 */
@Data
public class Questionnaire extends Base implements Serializable {
    /**
     * 问卷唯一id
     */
    private Integer id;

    /**
     * 评价用户id
     */
    private Integer userId;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 教学态度
     */
    private Integer attitude;

    /**
     * 教学内容
     */
    private Integer content;

    /**
     * 教学技巧
     */
    private Integer skill;

    /**
     * 教学效果
     */
    private Integer effect;

    /**
     * 教学特点
     */
    private Integer feature;

    /**
     * 总分
     */
    private Integer total;

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