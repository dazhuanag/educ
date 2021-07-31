package educ.service.teacher.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 章节VO
 *
 * @author: renjw
 * @date : 2021/7/6:16:04
 **/
@Data
public class ChapterVO {
    @ApiModelProperty(value = "章节ID")
    private String id;

    @ApiModelProperty(value = "章节名称")
    private String title;

    /**
     * 章节有多个小节
     */
    private List<VideoVO> videoVOS = new ArrayList<>();
}
