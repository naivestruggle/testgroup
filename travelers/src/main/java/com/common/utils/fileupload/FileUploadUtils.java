package com.common.utils.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

final public class FileUploadUtils {
	private FileUploadUtils(){}
	/**
	 * 文件上传
	 * @param multipartFile	上传的文件
	 * @param request	请求对象
	 * @param savePath	保存根路径
	 * @return	保存到数据库的路径
	 * @throws IOException
	 * @throws Exception
	 */
	public static String fileupload(MultipartFile multipartFile, HttpServletRequest request,String savePath) throws Exception {
		//图片原始名称
		String originalFilename = multipartFile.getOriginalFilename();
		System.out.println("图片原始名称："+originalFilename);
		if(originalFilename == null || originalFilename.isEmpty()){
			return null;
		}
		//上传图片
		if(multipartFile != null && originalFilename != null && !originalFilename.isEmpty()){
			//存储图片的物理路径
			 //  E:\apache-tomcat-8.0.53\webapps\RLi\images\image
			String path = request.getServletContext().getRealPath(savePath);
			System.out.println("存储图片的物理路径："+path);
			//新的图片名称
			String newFileName = "\\"+UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			System.out.println("新的图片名称："+newFileName);
			//得到hashCode
			int hCode = newFileName.hashCode();
			//转化成16进制
			String hex = Integer.toHexString(hCode);
			
			//生成文件	提升访问效率
			String autoPath = "\\"+hex.charAt(0)+"\\"+hex.charAt(1)+"\\"+hex.charAt(2);
			
			//生成的目录链
			String newFiledir = path+autoPath;
			File dir = new File(newFiledir);
			if(!dir.exists())
				dir.mkdirs();
			System.out.println("目录链："+newFiledir);
			
			//新的图片
			//E:\apache-tomcat-8.0.53\webapps\RLi\images\image\1231weqweeqw123123.jpg
			File newFile = new File(newFiledir+newFileName);
			if(!newFile.exists()){
				newFile.createNewFile();
			}
			System.out.println("最终保存在磁盘中的目录："+newFile.getAbsolutePath());
			
			//将内存中的数据写入磁盘
			multipartFile.transferTo(newFile);
			
			String sqlPath = savePath+autoPath+newFileName;
			
			return sqlPath;
		}
		return null;
	}
}
