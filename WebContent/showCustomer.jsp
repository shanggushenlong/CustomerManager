<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- 首先必须导入jstl标签库 -->
	<c:if test="${ empty cs }">
		无客户信息
	</c:if>
	<c:if test="${ not empty cs }">
		
		<form action="${ pageContext.request.contextPath }/CustomerSimpleSelectServlet" method="post">
			<div align="center" >
				<select name="field">
				<option>选择条件查询</option>
					<option value="name">按照姓名查询</option>
					<option value="cellphone">按照手机号查询</option>
					<option value="descsription">描述查询</option>	
				</select>
				<input type="text" name="msg">
				<input type="submit" value="查询">
			</div>
			
		</form>
		<br>
	
		<form action="${ pageContext.request.contextPath }/CustomerDelSelectServlet" method="post" id="f">
			<table border="1" align="center" width="90%">
				<tr>
					<td><input type="checkbox" id="main" onclick="change()"></td>
					<td>客户编号</td>
					<td>客户姓名</td>
					<td>客户性别</td>
					<td>客户生日</td>
					<td>客户电话</td>
					<td>客户邮箱</td>	
					<td>客户爱好</td>
					<td>客户类型</td>
					<td>客户备注</td>
					<td>操作</td>
				</tr>
	
				<c:forEach items="${ cs }" var="a">
					<tr>
						<td><input type="checkbox" value="${ a.id }" name="ck"></td>
						<td>${ a.id }</td>
						<td>${ a.name }</td>
						<td>${ a.gender }</td>
						<td>${ a.birthday }</td>
						<td>${ a.cellphone }</td>
						<td>${ a.email }</td>
						<td>${ a.preference }</td>
						<td>${ a.type }</td>
						<td>${ a.description }</td>
						<td>
							<a href="${ pageContext.request.contextPath }/CustomerFindByIdServlet?id=${ a.id }">编辑</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" onclick="del('${a.id}')">删除</a>
						 </td>				
					</tr>
				</c:forEach>
					<tr>
						<td colspan="10"><a href="javascript:void(0)" onclick="sendDel();">删除选中</a></td>
						<td><a href="${ pageContext.request.contextPath }/add.jsp">添加</a></td>
					</tr>
			</table>
		</form>
	</c:if>
</body>
<script type="text/javascript">
	function del(id){
		var flag = window.confirm("确认删除吗?");
		if(flag){
			//确认删除
			window.location.href = "${ pageContext.request.contextPath }/CustomerDelByIdServlet?id=" + id;
		}
	}
	
	function change(){
		//1.得到id为main的这个checkbox
		var main = document.getElementById("main");
		
		var flag = main.checked;

		//2.得到所有的name=ck的checkbox,通过getElementsByName()得到一个数组
		var cks = document.getElementsByName("ck");
		
		//3.将cks中的所有checkbox的checked的值设置为flag
		for(var i=0;i<cks.length;i++){
			cks[i].checked = flag;
		}
	}
	
	//表单提交,通过js函数也可以使表单提交
	function sendDel(){
		document.getElementById("f").submit(); 
	}
</script>
</html>

























