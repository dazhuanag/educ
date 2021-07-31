package educ.service.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页查询返回体
 *
 * @author: renjw
 * @date : 2021/6/16:14:27
 **/
@ApiModel(description = "分页查询返回体")
@Data
public class PageRespEntity<T> {

    @ApiModelProperty(value = "当前页")
    private Long current;

    @ApiModelProperty(value = "页数")
    private Long pages;

    @ApiModelProperty(value = "当前页码数据大小")
    private Long size;

    @ApiModelProperty(value = "总数")
    private Long total;

    @ApiModelProperty(value = "分页数据")
    private T data;

}