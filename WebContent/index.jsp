<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").on("click", function() {
			
		});
		$.ajax({
			type:"post",//请求方式
	        url:"${path}/user",//发送请求地址
	        /* dataType:"json", */ // 返回的数据类型*/  
	        data:{//发送给数据库的数据
	        	"id":"1",
	        },
			success : function(data) {
				console.log(data.username)
				var htmlobj = jQuery.parseJSON(data); 
				//$("#show").text(data['name'])
				/* var tr = "";
				$.each(htmlobj, function(index, obj){
					 tr += "<tr>"+
					 "<td>"+obj.id+"</td>"+
					 "<td>"+obj.userName+"</td>"+
					 "<td>"+obj.passWord+"</td>"+
					 "<td>"+obj.nickName+"</td>"+
					 "<td>"+obj.email+"</td>"+
					 "<td><a href=${path}/user?method="+obj.id+">编辑</a></td>"
					 +"</tr>"
				});
				$("#tb").append(tr); */
			},
			error : function() {
				alert("出错");
			}
		});
	});
</script>
<style type="text/css">
	#tb {
		width: 1200px;
		border-right:solid 1px black;
		border-top:solid 1px black;
		margin: 0 auto;
		text-align: center;
	}
	#tb tr td{
		border-left:solid 1px black;
		border-bottom:solid 1px black;
	}
</style>
</head>
<body>
	<h1>首页</h1>
	<input type="button" id="btn" value="获取数据" /><span id="show">原来的数据</span>
	<table id="tb" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>匿名</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
	</table>
</body>
</html>