package educ.service.teacher.controller;


import educ.service.common.entity.ResultEntity;
import educ.service.teacher.entity.vo.SubjectVO;
import educ.service.teacher.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author renjw
 * @since 2021-06-25
 */
@Api(tags = "课程分类管理API")
@CrossOrigin
@RestController
@RequestMapping("/subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @ApiModelProperty(value = "获取课程分类列表（树形结构）")
    @RequestMapping(value = "getSubjectTree",method = RequestMethod.GET)
    public ResultEntity getSubjectList(){
        List<SubjectVO> list =  subjectService.getAllSubject();
        return ResultEntity.Success(list);
    }

}

