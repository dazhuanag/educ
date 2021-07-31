package educ.service.teacher.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 小节Vo
 *
 * @author: renjw
 * @date : 2021/7/6:16:04
 **/
@Data
public class VideoVO {

    @ApiModelProperty(value = "章节ID")
    private String id;

    @ApiModelProperty(value = "章节名称")
    private String title;
}
