package com.cslg.system.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("aliyun.oss")
public class AliyunOssConfig {

	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;

	public AliyunOssConfig() {
		super();
	}

	public AliyunOssConfig(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
		super();
		this.endpoint = endpoint;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.bucketName = bucketName;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	@Override
	public String toString() {
		return "AliyunOssConfig [endpoint=" + endpoint + ", accessKeyId=" + accessKeyId + ", accessKeySecret="
				+ accessKeySecret + ", bucketName=" + bucketName + "]";
	}

}
