/**
 * @Company:中享思途   
 * @Title:UploadController.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月7日 上午9:56:31     
 */
package com.situ.layoa.commons.upload.cotroller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.layoa.commons.LayResult;
import com.situ.layoa.commons.upload.domain.UploadFile;

/**
 * @ClassName:UploadController
 * @Description:(UploadController)
 */
@Controller
public class UploadController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ResponseBody
	@RequestMapping("/upload")
	public LayResult doUploadFile(UploadFile uploadFile) {
		System.out.println(uploadFile.getUploadFile());
		// 将上传的文件写出到磁盘后得到一个文件路径
		String src = "layoafile/xxxxx.png";

		return new LayResult(0, "", src);
	}
}
