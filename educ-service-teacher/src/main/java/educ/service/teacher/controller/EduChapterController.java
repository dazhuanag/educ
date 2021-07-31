package educ.service.teacher.controller;


import educ.service.common.entity.ResultEntity;
import educ.service.teacher.entity.EduChapter;
import educ.service.teacher.entity.vo.ChapterVO;
import educ.service.teacher.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author renjw
 * @since 2021-06-28
 */
@RestController
@RequestMapping("/teacher/chapter")
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    /**
     * 根据课程ID（courseId）获取课程大纲列表
     */
    @RequestMapping(value = "getChapterList/{courseId}", method = RequestMethod.GET)
    public ResultEntity getChapterList(@PathVariable String courseId) {
        List<ChapterVO> list = chapterService.getChapterListByCourseId(courseId);
        return ResultEntity.Success(list);
    }
}

