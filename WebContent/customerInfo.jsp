<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="http://www.itcast.cn/tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${ pageContext.request.contextPath }/CustomerUpdateServlet" method="post">
		<input type="hidden" name="id" value="${ c.id }">
		客户姓名:<input type="text" name="name" value="${ c.name }"><br/>
		客户性别:<my:sex gender="${ c.gender }"/>
		客户生日:<input type="text" name="birthday" value="${ c.birthday }"><br/>
		客户电话:<input type="text" name="cellphone" value="${ c.cellphone }"><br/>
		客户邮箱:<input type="text" name="email" value="${ c.email }"><br/>
		客户爱好:<input type="text" name="preference" value="${ c.preference }"><br/>
		客户类型:<input type="text" name="type" value="${ c.type }"><br/>
		客户备注:<input type="text" name="descripton" value="${ c.description }"><br/>
		<input type="submit" value="修改">
	</form>
</body>
</html>