package educ.service.teacher.controller;


import educ.service.common.entity.ResultEntity;
import educ.service.teacher.entity.vo.CourseInfoVO;
import educ.service.teacher.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
@Api(tags = "课程管理API")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/course")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @ApiModelProperty(value = "添加课程基本信息")
    @RequestMapping(value = "addCourseInfo",method = RequestMethod.POST)
    public ResultEntity addCourseInfo(@RequestBody CourseInfoVO courseInfo){
        log.info("前端传入新增课程body:{}",courseInfo);
        String id = courseService.saveCourseInfo(courseInfo);
        return ResultEntity.Success(id);
    }
}

