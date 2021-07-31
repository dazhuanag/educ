package educ.service.teacher.service.impl;

import educ.service.common.entity.DefaultException;
import educ.service.teacher.entity.EduCourse;
import educ.service.teacher.entity.EduCourseDescription;
import educ.service.teacher.entity.vo.CourseInfoVO;
import educ.service.teacher.mapper.EduCourseDescriptionMapper;
import educ.service.teacher.mapper.EduCourseMapper;
import educ.service.teacher.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
@Slf4j
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Resource
    private EduCourseMapper courseMapper;
    @Resource
    private EduCourseDescriptionMapper courseDescMapper;

    @Override
    public String saveCourseInfo(CourseInfoVO courseInfo) {

        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfo, eduCourse);
        log.info("添加的course实体:{}", eduCourse);
        //添加edu_course表
        int i = courseMapper.insert(eduCourse);
        if (i != 1) {
            throw new DefaultException(222, "{}新增课程基本信息异常" + courseInfo.getId());
        }
        //添加edu_course_description表
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(eduCourse.getId());
        courseDescription.setDescription(courseInfo.getDescription());
        int j = courseDescMapper.insert(courseDescription);
        if (1!=j){
            log.info("课程简介添加失败:{}", courseDescription);
            throw  new DefaultException(333,"课程简介添加失败");
        }
        return eduCourse.getId();
    }
}
