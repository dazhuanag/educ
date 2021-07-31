package educ.service.teacher.service;

import educ.service.teacher.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import educ.service.teacher.entity.vo.CourseInfoVO;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程相关信息
     * @param courseInfo
     * @return
     */
    String saveCourseInfo(CourseInfoVO courseInfo);
}
