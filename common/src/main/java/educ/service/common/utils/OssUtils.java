package educ.service.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.AccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import educ.service.common.entity.ALiYunEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * 阿里云对象存储utils
 *
 * @author: renjw
 * @date : 2021/6/24:09:21
 **/
@Service
public class OssUtils {

    @Autowired
    private ALiYunEntity aLiYunEntity;

    public String upload(MultipartFile file) throws IOException {

        String bucketName = aLiYunEntity.getOssConfig().getBucketName();
        String avatarFilePath = aLiYunEntity.getOssConfig().getAvatarFilePath();
        String endpoint = aLiYunEntity.getOssConfig().getEndpoint();
        String accessKeyId = aLiYunEntity.getOssConfig().getAccessKeyId();
        String accessKeySecret = aLiYunEntity.getOssConfig().getAccessKeySecret();

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//         填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "-" + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpg");
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(bucketName, avatarFilePath + fileName, file.getInputStream(), metadata);
        //手动拼接oss图片的url
        String url = "https://" + bucketName + "." + endpoint + "/" + avatarFilePath + fileName;
        ossClient.shutdown();
        return url;
    }
}
