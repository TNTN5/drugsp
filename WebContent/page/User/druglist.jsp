<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path=request.getServletContext().getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<link rel="stylesheet" href="<%=path %>/css/userdrug.css">
</head>
<body> 
	<c:forEach items="${drugs }" var="d">
		<div class="drug">
			<form method="post" action="<%=path %>/drugsell.do">
			<input type="hidden" name="uid" value="${user.uid}">
			<input type="hidden" name="drugid" value="${d.drugid }">
			<div class="drugname">${d.dname }</div>
			<div>${d.decpict }</div>
			<div>
				<c:forEach items="${shops }" var="s">
      				<c:if test="${s.sid==d.sid }">${s.sname }</c:if>
      			</c:forEach>
			</div>
			<div>还剩${d.stock }件</div>
			<div>￥${d.dprice }</div>
			<div>
				X<input type="num" name="dnum" value="0">
				<input type="submit" value="购买">
			</div>
			</form>
		</div>
	</c:forEach>
	<div class="list-bottom">
	<c:if test="${searchu==null }">
		<div>
			<a href="<%=path %>/drugbyclassify.do?cid=${classify }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		<input type="text" name="page" value="${page}"/>/
	 	<input type="text" name="page" value="${allPage} " readonly/>
	 		<a href="<%=path %>/drugbyclassify.do?cid=${classify }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		</div>
	</c:if>
	<c:if test="${searchu!=null }">
		<div>
			<a href="<%=path %>/drupsearchtouser.do?searchu=${searchu }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		<input type="text" name="page" value="${page}"/>/
	 	<input type="text" name="page" value="${allPage} " readonly/>
	 		<a href="<%=path %>/drupsearchtouser.do?searchu=${searchu }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		</div>
	</c:if>
	</div>
</body>
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</html>