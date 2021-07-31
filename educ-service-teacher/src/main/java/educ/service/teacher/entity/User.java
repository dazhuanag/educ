package educ.service.teacher.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * 用户entity
 *
 * @author: renjw
 * @date : 2021/6/17:16:38
 **/
@ApiModel(value = "User对象")
@Data
public class User {

    @ApiModelProperty(value = "用户名" ,example = "admin")
    private String username;

    @ApiModelProperty(value = "用户密码" ,example = "admin")
    private String password;

    @ApiModelProperty(value = "简介" ,example = "admin")
    private List info;

    @ApiModelProperty(value = "头像" ,example = "http://p0.itc.cn/images01/20200720/55ab0d30270043099516dd149de24119.jpeg")
    private String avatar;

}
