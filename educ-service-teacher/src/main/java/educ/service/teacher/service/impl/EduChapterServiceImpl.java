package educ.service.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import educ.service.teacher.entity.EduChapter;
import educ.service.teacher.entity.EduVideo;
import educ.service.teacher.entity.vo.ChapterVO;
import educ.service.teacher.mapper.EduChapterMapper;
import educ.service.teacher.mapper.EduVideoMapper;
import educ.service.teacher.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sf.cglib.core.CollectionUtils;
import org.ehcache.core.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Resource
    private EduChapterMapper chapterMapper;

    @Resource
    private EduVideoMapper videoMapper;

    /**
     * 根据课程ID（courseId）获取课程大纲列表
     *
     * @param courseId
     * @return
     */
    @Override
    public List<ChapterVO> getChapterListByCourseId(String courseId) {
        //根据courseId获取章节列表
        QueryWrapper<EduChapter> wrapper = new QueryWrapper();
        wrapper.lambda().eq(courseId != null, EduChapter::getCourseId, courseId);
        List<EduChapter> eduChapters = chapterMapper.selectList(wrapper);

        //根据courseId获取小节列表
        QueryWrapper<EduVideo> wrapper1 = new QueryWrapper();
        wrapper1.lambda().eq(courseId != null, EduVideo::getCourseId, courseId);
        List<EduVideo> eduVideos = videoMapper.selectList(wrapper1);
        return null;
    }
}
