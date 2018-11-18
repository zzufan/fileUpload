<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="editor">
     <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
 </div>
<button onclick="getEditorData();">获取数据</button>
<!-- 
当使用script引入js文件时，此标签包含的Js代码将失去作用。

 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/static/wangEditor/wangEditor.min.js">
</script>
<script type="text/javascript">
var E = window.wangEditor
var editor = new E('#editor')
// 或者 var editor = new E( document.getElementById('editor') )

// 配置服务器端地址
editor.customConfig.uploadImgServer = '${pageContext.request.contextPath }/editorImgUpload.do'

editor.create()

function getEditorData(){
	var editorDiv = document.getElementById("editor");
	console.log(editorDiv.innerHTML);
}
</script>

</body>
</html>