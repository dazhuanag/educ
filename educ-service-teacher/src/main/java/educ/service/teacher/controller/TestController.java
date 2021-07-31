package educ.service.teacher.controller;

import com.aliyun.oss.model.MultipartUpload;
import com.aliyun.oss.model.PutObjectResult;
import educ.service.common.entity.ResultEntity;
import educ.service.common.utils.OssUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 测试
 *
 * @author: renjw
 * @date : 2021/6/24:10:35
 **/
@CrossOrigin
@RestController
@Api(tags = "测试")
@RequestMapping("test")
public class TestController {

    @Autowired
    private OssUtils ossUtils;

    @ApiModelProperty(value = "上传图片至oss")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResultEntity uploadToOss(MultipartFile file) throws IOException {
        String url = ossUtils.upload(file);
        return ResultEntity.Success(url);
    }
}
