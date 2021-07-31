package educ.service.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一结果返回体
 *
 * @author: renjw
 * @date : 2021/6/16:10:57
 **/
@ApiModel(description = "统一结果返回体")
@Data
public class ResultEntity<T> implements Serializable {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "状态描述")
    private String message;

    @ApiModelProperty()
    private T data;

    private ResultEntity() {
    }

    public static ResultEntity Success() {
        ResultEntity result = new ResultEntity();
        result.setSuccess(Boolean.TRUE);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static <T> ResultEntity Success(T data) {
        ResultEntity result = new ResultEntity();
        result.setSuccess(Boolean.TRUE);
        result.setCode(200);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    public static ResultEntity Fail() {
        ResultEntity result = new ResultEntity();
        result.setSuccess(Boolean.FALSE);
        result.setCode(300);
        result.setMessage("失败");
        return result;
    }

    public static <T> ResultEntity<T> Fail(T data) {
        ResultEntity result = new ResultEntity();
        result.setSuccess(Boolean.FALSE);
        result.setCode(300);
        result.setMessage("失败");
        result.setData(data);
        return result;
    }
    public static <T> ResultEntity<T> Fail(Integer code,String data) {
        ResultEntity result = new ResultEntity();
        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMessage(data);
        return result;
    }
}