package com.xagd.javaeebackend.Utils;

import org.apache.commons.io.FilenameUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class OSSUtil {

    private static String endpoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;

    @Value("${oss.endpoint}")
    public void setEndpoint(String endpoint) {
        OSSUtil.endpoint = endpoint;
    }

    @Value("${oss.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        OSSUtil.accessKeyId = accessKeyId;
    }

    @Value("${oss.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        OSSUtil.accessKeySecret = accessKeySecret;
    }

    @Value("${oss.bucketName}")
    public void setBucketName(String bucketName) {
        OSSUtil.bucketName = bucketName;
    }

    /**
     * @param file 文件
     * @param pre 文件名字（不用加后缀）,使用表名+id的形式，例如 user20
     * @return url
     */
    public static String uploadFile(MultipartFile file, String pre){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取文件名称
        String filename = file.getOriginalFilename();
        String fe = FilenameUtils.getExtension(filename);
        filename = pre + "." + fe;
        //调用OSS方法实现上传
        ossClient.putObject(bucketName, filename, inputStream);
        return "https://javaee-xjj.oss-cn-shanghai.aliyuncs.com//"+filename;
    }
}
