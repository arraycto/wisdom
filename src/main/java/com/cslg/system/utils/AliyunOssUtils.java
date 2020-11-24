package com.cslg.system.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cslg.system.oss.AliyunOssConfig;

public class AliyunOssUtils {

	@Autowired
	private AliyunOssConfig aliyunOssConfig;
	
    public String fileUpload(File file, String fileHost) {
	
    	String endpoint = aliyunOssConfig.getEndpoint();
    	String accessKeyId = aliyunOssConfig.getAccessKeyId();
    	String accessKeySecret = aliyunOssConfig.getAccessKeySecret();
    	String bucketName = aliyunOssConfig.getBucketName();
    	
    	if(file == null) {
    		return null;
    	}
    	String filePath = "";
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    	try {
    		// 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(bucketName)) {
            	ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            filePath = fileHost + "/" + file.getName();
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, filePath, file));
            //设置权限(公开读)
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                System.out.println("------OSS文件上传成功------" + filePath);
            }
		} catch (Exception e) {
			
		} finally {
			if(ossClient!=null){
                ossClient.shutdown();
            }
		}
		return filePath;
	}
}
