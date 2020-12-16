package cn.chen.teachingsystem.model;

import cn.chen.teachingsystem.entity.Base;
import cn.chen.teachingsystem.entity.Supervision;
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
 * @Date: 2020/12/16
 * @Time: 10:10
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("督导任务完成进度展示")
public class SupervisionModel extends Base implements Serializable {
    @Serial
    private static final long serialVersionUID = -8790061694895012952L;

    /**
     * 督导任务进度
     */
    @ApiModelProperty("督导任务进度")
    private Supervision supervision;

    /**
     * 督导个人信息
     */
    @ApiModelProperty("督导个人信息")
    private User user;
}
