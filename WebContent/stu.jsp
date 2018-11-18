<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
如果当前页面提交数据没有文件上传，向服务器提交的数据都是字符流，
如果有文件上传：提交数据方式必须是post
需要引入额外的jar包： common-fileupload
			   common-io

 -->
	
	<form action="uploadFile.do" method="post" enctype="multipart/form-data">
		学生姓名：<input type="text" name="stuName"><br>
		照片：<input type="file" name="stuPhoto"><br>
		<input type="submit" value="提交">
	</form>


</body>
</html>