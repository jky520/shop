<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 一定要是post请求， multipart/form-data属于二进制的文本格式, 默认是文本编码格式 -->
	<form action="/shop/file" method="post"  enctype="multipart/form-data">
		<input type="text" name="username"/><br>
		<input type="file" name="myFile"/><br>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>