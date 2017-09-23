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
	<c:if test="${ empty pb.cs }">
		无客户信息
	</c:if>
	<c:if test="${ not empty pb.cs }">

			<table border="1" align="center" width="90%">
				<tr>
					<td>客户编号</td>
					<td>客户姓名</td>
					<td>客户性别</td>
					<td>客户生日</td>
					<td>客户电话</td>
					<td>客户邮箱</td>	
					<td>客户爱好</td>
					<td>客户类型</td>
					<td>客户备注</td>
				</tr>
	
				<c:forEach items="${ pb.cs }" var="a">
					<tr>
						<td>${ a.id }</td>
						<td>${ a.name }</td>
						<td>${ a.gender }</td>
						<td>${ a.birthday }</td>
						<td>${ a.cellphone }</td>
						<td>${ a.email }</td>
						<td>${ a.preference }</td>
						<td>${ a.type }</td>
						<td>${ a.description }</td>			
					</tr>
				</c:forEach>
					<tr>
						<td colspan="9" align="center">
							<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=1&currentPage=${ pb.currentPage }">首页</a>&nbsp;&nbsp;&nbsp;
							
							<c:if test="${ pb.pageNum == 1 }">
								上一页
							</c:if>&nbsp;&nbsp;&nbsp;
							<c:if test="${ pb.pageNum != 1 }">
								<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=${ pb.pageNum - 1 }&currentPage=${ pb.currentPage }">上一页</a>&nbsp;&nbsp;&nbsp;
							</c:if>
							
							<c:if test="${ pb.pageNum == pb.totalPage }">
								下一页
							</c:if>&nbsp;&nbsp;&nbsp;
							<c:if test="${ pb.pageNum != pb.totalPage }">
								<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=${ pb.pageNum + 1 }&currentPage=${ pb.currentPage }">下一页</a>&nbsp;&nbsp;&nbsp;
							</c:if>
							
							<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=${ pb.totalPage }&currentPage=${ pb.currentPage }">尾页</a>&nbsp;&nbsp;&nbsp;
							
							<select name="currentPage" onchange="changeCurrentPage(this.value)">
								<option>--请选择每页条数--</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="20">20</option>
							</select>
						</td>
					</tr>
					<%-- 给页面增加页码 --%>
					<%-- 给页码添加颜色,每当展示当前的页的时候,颜色为红色,使用标签判断是否为当前页 --%>
					<tr>
						<td  colspan="9" align="center">
							<%-- 使用forEach循环,begin开始 end结束 step增长速度--%>
							<c:forEach begin="1" end="${ pb.totalPage }" var="n" step="1">
								
								<c:if test="${ n == pb.pageNum }">
									<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=${ n }&currentPage=${ pb.currentPage }"><font color="red">第${ n }页</font></a>&nbsp;&nbsp;
								</c:if>
								<c:if test="${ n != pb.pageNum }">
									<a href="/day05_2/CustomerFindAllByPageServlet?pageNum=${ n }&currentPage=${ pb.currentPage }">第${ n }页</a>&nbsp;&nbsp;
								</c:if>
							</c:forEach>
						</td>
					</tr>
			</table>
	</c:if>
</body>
<script type="text/javascript">
	function changeCurrentPage(value) {
		location.href = "/day05_2/CustomerFindAllByPageServlet?currentPage="+value;
	}
</script>
</html>











































































