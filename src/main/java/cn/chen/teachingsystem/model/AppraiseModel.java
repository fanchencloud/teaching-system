package cn.chen.teachingsystem.model;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.entity.Base;
import cn.chen.teachingsystem.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/18
 * @Time: 22:47
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("领导评价展示模型")
public class AppraiseModel extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = -1821590401910382989L;

    /**
     * 评价内容
     */
    @ApiModelProperty("评价内容")
    private Appraise appraise;

    /**
     * 领导个人信息
     */
    @ApiModelProperty("领导个人信息")
    private User leader;
    
    /**
     * 被评价人的信息
     */
    @ApiModelProperty("被评价人的信息")
    private User user;
}
