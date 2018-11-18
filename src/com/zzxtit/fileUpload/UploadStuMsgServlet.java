package com.zzxtit.fileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/uploadFile.do")
public class UploadStuMsgServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3108662200577234338L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String stuName = req.getParameter("stuName");
		
		System.out.println("==================>" + stuName);
		
		DiskFileItemFactory dif = new DiskFileItemFactory();
		
		ServletFileUpload sfu = new ServletFileUpload(dif);
		sfu.setFileSizeMax(1024*1024*10);
		
		String imgPath = "default";
		
		String uuid = UUID.randomUUID().toString();
		
		
		//解析request请求
		try {
			List<FileItem> fItemList = sfu.parseRequest(req);
			for(FileItem item : fItemList) {
				
				System.out.println("----getName-------->"+item.getName());//文件名称
				System.out.println("----getFieldName-------->"+item.getFieldName());//intput对应的name
				System.out.println("----getSize-------->"+item.getSize());
				String imgName = "";
				if(item.isFormField()) {
				System.out.println("----getString-------->"+item.getString("utf-8"));
				imgPath = item.getString("utf-8");
				}else {
					imgName = uuid + "." + FilenameUtils.getExtension(item.getName());
					File file = new File("D:\\Program Files\\img-tomcat-8.5\\webapps\\ROOT\\img\\" + imgPath + "\\"+ imgName);
					OutputStream os = new FileOutputStream(file);
					
					IOUtils.copy(item.getInputStream(), os);
					os.close();
					System.out.println("图片的访问地址：http://localhost:8080/img/" + imgPath + "/"+ imgName);
				}
				
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
	
	}

	
	
	
}
