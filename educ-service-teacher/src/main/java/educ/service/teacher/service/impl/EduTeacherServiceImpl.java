package educ.service.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import educ.service.common.entity.PageRespEntity;
import educ.service.teacher.entity.EduTeacher;
import educ.service.teacher.mapper.EduTeacherMapper;
import educ.service.teacher.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author renjw
 * @since 2021-06-11
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Resource
    EduTeacherMapper eduTeacherMapper;

    @Override
    public boolean removeById(String id) {
        int i = eduTeacherMapper.deleteById(id);
        if (1 == i) {
            return true;
        }
        return false;
    }

    @Override
    public PageRespEntity<List<EduTeacher>> getAllTeacher(long current, long size, EduTeacher eduTeacher) {
        Page<EduTeacher> page = new Page<>(current, size);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper();
        queryWrapper.lambda()
                .like(eduTeacher.getName() != null, EduTeacher::getName, eduTeacher.getName())
                .eq(eduTeacher.getLevel() != null, EduTeacher::getLevel, eduTeacher.getLevel())
                .orderByDesc(EduTeacher::getGmtCreate);
        IPage<EduTeacher> page1 = eduTeacherMapper.selectPage(page, queryWrapper);
        PageRespEntity<List<EduTeacher>> respEntity = new PageRespEntity<>();
        respEntity.setCurrent(page1.getCurrent());
        respEntity.setSize(page1.getSize());
        respEntity.setData(page1.getRecords());
        respEntity.setPages(page1.getPages());
        respEntity.setTotal(page1.getTotal());
        return respEntity;
    }

    @Override
    public List<EduTeacher> getAllTeacher() {
        List<EduTeacher> teacherList = eduTeacherMapper.selectList(null);
        return teacherList;
    }

    @Override
    public boolean updateTeacher(EduTeacher eduTeacher) {
        int i = eduTeacherMapper.updateById(eduTeacher);
        return i==1;
    }
}
