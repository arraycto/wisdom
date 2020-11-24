package com.cslg.system.utils;

import java.io.File;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cslg.common.domain.UserDO;

public class FileUtils {
	
	/**
	 * 修改上传文件的名称并存储到服务器返回路径
	 */
	public static String changeFileName(String uploadPath, String httpUrl, MultipartFile file, String courseName, String fileName) {
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		String path = "";
		String result = "";
		if(!file.isEmpty()) {
			String oldFileName = file.getOriginalFilename();
			int index = oldFileName.indexOf('.');
			String suffix = oldFileName.substring(index, oldFileName.length());
			String newFileName = fileName+suffix;
			File filePath = new File(uploadPath+"/"+userDO.getUsername()+"/"+courseName);
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			try {
				path = filePath +"/" + newFileName;
				File targetFile = new File(path);
				file.transferTo(targetFile);
				result = httpUrl+userDO.getUsername()+"/"+courseName+"/"+newFileName;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	} 
	
}
