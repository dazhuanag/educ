package educ.service.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis自动填充
 *
 * @author: renjw
 * @date : 2021/6/11:15:55
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时间填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("gmtCreate", LocalDateTime.now(), metaObject);
        setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新时间填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }
}
