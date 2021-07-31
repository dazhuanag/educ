package educ.service.teacher.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.javafx.runtime.eula.Eula;
import educ.service.common.entity.DefaultException;
import educ.service.common.entity.PageRespEntity;
import educ.service.common.entity.ResultEntity;
import educ.service.common.utils.OssUtils;
import educ.service.teacher.entity.EduTeacher;
import educ.service.teacher.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author renjw
 * @since 2021-06-11
 */
@Slf4j
@CrossOrigin
@RestController
    @RequestMapping("/teacher")
@Api(tags = "讲师管理API")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Autowired
    private OssUtils ossUtils;

    @ApiOperation(value = "条件查询讲师列表（分页）")
    @RequestMapping(value = "getAllTeacher/{current}/{size}", method = RequestMethod.POST)
    public ResultEntity<IPage<EduTeacher>> getAllTeacher(@PathVariable long current, @PathVariable long size,@RequestBody EduTeacher eduTeacher) {
        log.info("前端传入查询讲师条件:{}",eduTeacher);
        PageRespEntity<List<EduTeacher>> respEntity = eduTeacherService.getAllTeacher(current, size,eduTeacher);
        return ResultEntity.Success(respEntity);
    }

    @ApiOperation(value = "查询所有讲师")
    @RequestMapping(value = "getAllTeacher", method = RequestMethod.GET)
    public ResultEntity<IPage<EduTeacher>> getAllTeacher() {
        List<EduTeacher> teacherList = eduTeacherService.getAllTeacher();
        return ResultEntity.Success(teacherList);
    }

    @ApiOperation(value = "根据讲师id查询讲师")
    @RequestMapping(value = "getTeacher/{id}", method = RequestMethod.GET)
    public ResultEntity<IPage<EduTeacher>> getTeacherById(@PathVariable String id) {
        log.info("前端传入查询讲师id:{}",id);
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ResultEntity.Success(eduTeacher);
    }

    @ApiOperation( value = "逻辑删除讲师")
    @RequestMapping(value = "deleteTeacher/{id}", method = RequestMethod.POST)
    public ResultEntity deleteById(@PathVariable String id) {
        log.info("前端传入删除的id:{}",id);
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return ResultEntity.Success();
        } else {
            return ResultEntity.Fail();
        }
    }

    @ApiOperation(value = "修改讲师")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultEntity updateById(@RequestBody EduTeacher eduTeacher) {
        log.info("前端传入修改的讲师body:{}",eduTeacher);
        boolean flag = eduTeacherService.updateTeacher(eduTeacher);
        if (flag) {
            return ResultEntity.Success();
        } else {
            return ResultEntity.Fail();
        }
    }

    @ApiOperation(value = "新增讲师")
    @RequestMapping(value = "addEduTeacher", method = RequestMethod.POST)
    public ResultEntity addEduTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save ;
        log.info("前端传入新增讲师body:{}",eduTeacher);
        try {
            save = eduTeacherService.saveOrUpdate(eduTeacher);
        } catch (Exception e) {
            log.error("addEduTeacher异常");
            throw new DefaultException(111,"新增讲师异常");
        }
        if (save){
            return ResultEntity.Success();
        }
        return ResultEntity.Fail();
    }


    @ApiModelProperty(value = "上传图片至oss")
    @RequestMapping(value = "upload/avatar", method = RequestMethod.POST)
    public ResultEntity uploadToOss(MultipartFile file) throws IOException {
        String url = ossUtils.upload(file);
        return ResultEntity.Success(url);
    }
}

