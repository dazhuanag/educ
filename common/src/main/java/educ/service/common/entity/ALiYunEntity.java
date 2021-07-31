package educ.service.common.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 对象存储Entity
 *
 * @author: renjw
 * @date : 2021/6/24:09:29
 **/
@Component
@Data
@ConfigurationProperties(prefix = ALiYunEntity.PREFIX)
public class ALiYunEntity {
    public static final String PREFIX = "aliyun";
    private OssConfig ossConfig;

    @Data
    public static class OssConfig {
        private String bucketName;
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        /** OSS 头像文件路径*/
        private String avatarFilePath;
    }

}
