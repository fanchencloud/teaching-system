package cn.chen.teachingsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户")
public class User extends Base implements Serializable {
    /**
     * 唯一id
     */
    @ApiModelProperty("用户唯一标识")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 用户名字
     */
    @ApiModelProperty("用户名字")
    private String name;

    /**
     * 用户类别：0-教师，1-专家，2-领导，3-管理员 4 - 教师督导
     */
    @ApiModelProperty("用户类别：0-教师，1-专家，2-领导，3-管理员 4 - 教师督导")
    private Integer userType;

    /**
     * 用户级别：0-院级，1-校级
     */
    @ApiModelProperty("用户级别：0-院级，1-校级")
    private Integer level;

    /**
     * 用户性别
     */
    @ApiModelProperty("用户性别")
    private String sex;

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
     * 用户出生日期
     */
    @ApiModelProperty("用户出生日期")
    private String birthday;


    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;


    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;


    private static final long serialVersionUID = 1L;
}