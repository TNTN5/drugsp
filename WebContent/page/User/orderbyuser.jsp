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
<link rel="stylesheet" href="<%=path %>/css/order.css">
</head>
<body> 
	<c:forEach items="${order }" var="o">
		<section class="order">
			<c:forEach items="${drug }" var="d">
				<c:if test="${d.drugid==o.drugid}"><span>${d.dname }</span>X${o.dnum }</c:if>
			</c:forEach>
			<span>${o.ocreatetime }</span>
			<c:if test="${o.ofinishtime==null }"><span>
				<a href="<%=path %>/confirmorder.do?oid=${o.oid }&uid=${uid}"><button>确认收货</button></a>
			</span></c:if>
			<c:if test="${o.ofinishtime!=null }"><span>
				${o.ofinishtime }
			</span></c:if>
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