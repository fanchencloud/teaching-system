package cn.chen.teachingsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User extends Base implements Serializable {
    /**
     * 唯一id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 用户类别：0-教师，1-专家，2-领导，3-管理员
     */
    private Integer userType;

    /**
     * 用户级别：0-院级，1-校级
     */
    private Integer level;

    /**
     * 用户性别
     */
    private String sex;

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