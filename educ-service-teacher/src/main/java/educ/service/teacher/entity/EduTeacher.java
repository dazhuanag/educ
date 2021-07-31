package educ.service.teacher.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author renjw
 * @since 2021-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "EduTeacher对象", description = "讲师")
public class EduTeacher extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "讲师姓名", example = "大壮")
    private String name;

    @ApiModelProperty(value = "讲师简介", example = "这个讲师很牛")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师", example = "博士生导师")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师", example = "1")
    private Integer level;

    @ApiModelProperty(value = "讲师头像", example = "test")
    private String avatar;

    @ApiModelProperty(value = "排序", example = "0")
    private Integer sort;

    /**
     * TableLogic:逻辑删除注解
     */
    @TableLogic
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除", example = "false")
    private Boolean isDeleted;

}
