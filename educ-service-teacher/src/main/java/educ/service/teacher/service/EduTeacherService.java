package educ.service.teacher.service;

import educ.service.common.entity.PageRespEntity;
import educ.service.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author renjw
 * @since 2021-06-11
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    boolean removeById(String id);

    /**
     * 获取所有教师,分页
     *
     * @param current
     * @param size
     * @return
     */
    PageRespEntity<List<EduTeacher>> getAllTeacher(long current, long size, EduTeacher eduTeacher);

    /**
     * 查询所有讲师
     *
     * @return
     */
    List<EduTeacher> getAllTeacher();

    /**
     * 修改讲师
     *
     * @param eduTeacher
     * @return
     */
    boolean updateTeacher(EduTeacher eduTeacher);
}
