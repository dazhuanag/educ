package educ.service.teacher.service;

import educ.service.teacher.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import educ.service.teacher.entity.vo.SubjectVO;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author renjw
 * @since 2021-06-25
 */
public interface EduSubjectService extends IService<EduSubject> {

    List<SubjectVO> getAllSubject();
}
