package com.zzxtit.fileUpload.editor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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

import com.google.gson.Gson;

@WebServlet("/editorImgUpload.do")
public class WangEditorImgUploadServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1855528716758521842L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		EditImgResMsg eirm = new EditImgResMsg();
		
		DiskFileItemFactory dif = new DiskFileItemFactory();
		
		ServletFileUpload sfu = new ServletFileUpload(dif);
		sfu.setFileSizeMax(1024*1024*10);
		
		String imgPath = "editor";
		
		String uuid = UUID.randomUUID().toString();
		try {
			List<FileItem> fiList = sfu.parseRequest(request);
			List<String> imgUrlList = new ArrayList<String>();
			for(FileItem fi : fiList) {
				if(!fi.isFormField()) {
					String imgName = uuid + "." + FilenameUtils.getExtension(fi.getName());
					File file = new File("D:\\Program Files\\img-tomcat-8.5\\webapps\\ROOT\\img\\" + imgPath + "\\"+ imgName);
					OutputStream os = new FileOutputStream(file);
					
					IOUtils.copy(fi.getInputStream(), os);
					os.close();
					imgUrlList.add("http://localhost:8080/img/" + imgPath + "/"+ imgName);
				}
			}
			eirm.setErrno(0);
			eirm.setData(imgUrlList);
			response.getWriter().write(new Gson().toJson(eirm));;
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
