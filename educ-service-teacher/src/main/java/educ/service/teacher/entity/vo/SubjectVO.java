package educ.service.teacher.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程分类树形属性
 *
 * @author: renjw
 * @date : 2021/6/28:10:42
 **/
@Data
public class SubjectVO {

    private String id;
    private String label;

    private List<SubjectVO> children = new ArrayList<>();
}
