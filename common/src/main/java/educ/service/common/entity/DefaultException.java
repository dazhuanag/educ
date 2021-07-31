package educ.service.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义系统异常
 *
 * @author: renjw
 * @date : 2021/6/16:17:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultException extends RuntimeException{
    @ApiModelProperty(value = "错误码")
    private Integer code;
    @ApiModelProperty(value = "错误信息")
    private String msg;
}