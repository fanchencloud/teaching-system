package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * appraise
 * @author 
 */
@Data
public class Appraise extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 领导id
     */
    private Integer leaderId;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 评价内容
     */
    private String content;

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