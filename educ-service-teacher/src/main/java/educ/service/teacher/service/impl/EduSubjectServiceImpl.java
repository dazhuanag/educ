package educ.service.teacher.service.impl;

import educ.service.teacher.entity.EduSubject;
import educ.service.teacher.entity.vo.SubjectVO;
import educ.service.teacher.mapper.EduSubjectMapper;
import educ.service.teacher.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author renjw
 * @since 2021-06-25
 */
@Service
@Slf4j
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Resource
    private EduSubjectMapper subjectMapper;
    private static final String  PARENT_ID = "0";

    @Override
    public List<SubjectVO> getAllSubject() {
        List<EduSubject> list = subjectMapper.selectList(null);
        List<SubjectVO> parentList = new ArrayList<>();

        for (EduSubject subject : list) {
            //一级分类 parentId = 0
            if (StringUtils.isNoneBlank(subject.getParentId()) && PARENT_ID.equals(subject.getParentId())) {
                SubjectVO subjectVo = new SubjectVO();
                subjectVo.setId(subject.getId());
                subjectVo.setLabel(subject.getTitle());
                parentList.add(subjectVo);
            }
        }
        log.info("课程一级分类:{}",parentList);
        for (SubjectVO subjectVo : parentList) {
            for (EduSubject subject : list) {
                if (!PARENT_ID.equals(subject.getParentId())){
                    if (subjectVo.getId().equals(subject.getParentId())){
                        SubjectVO subjectVO1 = new SubjectVO();
                        subjectVO1.setId(subject.getId());
                        subjectVO1.setLabel(subject.getTitle());
                        subjectVo.getChildren().add(subjectVO1);
                    }
                }
            }
        }
        log.info("课程分类:{}",parentList);
        return parentList;
    }
}
