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
<link rel="stylesheet" href="<%=path %>/css/message.css">
</head>
<body> 
		<div class="content">
		<form method="post" action="<%=path %>/messageadd.do">
			<div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="uid" value="${uid }" required  lay-verify="required"  autocomplete="off" class="layui-input">
		    </div>
		  	</div>
		  	<div class="layui-input-inline contentinput">
				<input type="text" name="content"  lay-verify="required" placeholder="请输入留言" autocomplete="off" class="layui-input ">
		 	</div>
			<button type="submit">提交</button>
		</form>
		</div>
	<c:forEach items="${message }" var="m">
		<section>
		<div>
			<c:forEach items="${user }" var="u">
				<c:if test="${m.uid==u.uid }"><span class="user">${u.uname }:</span></c:if>
			</c:forEach>
			<span class="mcontent">${m.mcontent }</span>
			<div class="time">${m.mtime }</div>
		</div>
		<div class="reply">
		<c:forEach items="${reply }" var="r">
			<div>
				<c:if test="${m.mid==r.mid }">
					<c:forEach items="${shop }" var="s">
						<c:if test="${r.sid==s.sid }"><sapn class="user">${s.sname }:</sapn></c:if>
					</c:forEach>
				${r.rcontent }
				<div class="time">${r.rtime }</div>
				</c:if>
			</div>
			
		</c:forEach>
		</div>
		</section>
	</c:forEach>
	
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