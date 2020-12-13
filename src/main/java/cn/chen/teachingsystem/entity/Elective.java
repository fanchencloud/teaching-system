package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * elective
 * @author 
 */
@Data
public class Elective extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 选课用户id
     */
    private Integer userId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 是否完成：0-未完成，1-完成
     */
    private Integer finish;

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