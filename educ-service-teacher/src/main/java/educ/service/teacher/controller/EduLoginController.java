package educ.service.teacher.controller;

import educ.service.common.entity.ResultEntity;
import educ.service.teacher.entity.User;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录controller
 *
 * @author: renjw
 * @date : 2021/6/17:16:18
 **/
@Api(tags = "用户管理API")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class EduLoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultEntity login(@RequestBody User user) {
        log.info("前端出传入的用户信息:{}",user);
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            Map<String, String> map = new HashMap<>();
            map.put("token", "admin");
            return ResultEntity.Success(map);
        }
       else {
           return ResultEntity.Fail();
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResultEntity getUserInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("roles", "[admin,normal]");
        map.put("name", "大壮");
        map.put("avatar", "http://p0.itc.cn/images01/20200720/55ab0d30270043099516dd149de24119.jpeg");
        return ResultEntity.Success(map);
    }

}
