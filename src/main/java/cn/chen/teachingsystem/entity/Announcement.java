package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * announcement
 * @author 
 */
@Data
public class Announcement extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastEditTime;

    /**
     * 是否发布，0-不发布，1-发布
     */
    private Integer flag;

    private static final long serialVersionUID = 1L;
}