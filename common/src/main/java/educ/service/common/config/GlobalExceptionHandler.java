package educ.service.common.config;

import educ.service.common.entity.DefaultException;
import educ.service.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author: renjw
 * @date : 2021/6/16:16:45
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultEntity exception(Exception e){
        log.error("捕获了一个全局异常,cause:{}"+e);
        return ResultEntity.Fail(300,"系统错误");
    }

    @ExceptionHandler(DefaultException.class)
    public ResultEntity exception(DefaultException e){
        log.error("捕获了一个自定义异常:{}",e.getMsg());
        return ResultEntity.Fail(e.getCode(),e.getMsg());
    }
}
