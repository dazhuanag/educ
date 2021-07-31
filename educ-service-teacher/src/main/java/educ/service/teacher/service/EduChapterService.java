package educ.service.teacher.service;

import educ.service.teacher.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import educ.service.teacher.entity.vo.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 根据课程ID（courseId）获取课程大纲列表
     *
     * @param courseId
     * @return
     */
    List<ChapterVO> getChapterListByCourseId(String courseId);
}
