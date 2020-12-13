package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * supervision
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Supervision extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 选课用户id
     */
    private Integer userId;

    /**
     * 任务总量
     */
    private Integer amount;

    /**
     * 完成数量
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