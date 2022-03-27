<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path=request.getServletContext().getContextPath(); %>
 <link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<link rel="stylesheet" href="./css/list.css">
</head>
<body>
<!-- 表格 -->
	<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>序号</th>
      <th>药名</th>
      <th>数量</th>
      <th>买家</th>
      <th>创建时间</th>
      <th>完成时间</th>
    </tr> 
  </thead>
  <tbody>
  <c:forEach items="${order}" var="o">
    <tr>
      <td>${o.oid}</td>
      <td>
      	<c:forEach items="${drugs}" var="d">
      		<c:if test="${d.drugid==o.drugid }">${d.dname}</c:if>
      	</c:forEach>
      </td>
      <td>${o.dnum}</td>
      <td>
      	<c:forEach items="${user }" var="u">
      		<c:if test="${u.uid==o.uid }">${u.uname }</c:if>
      	</c:forEach>
      </td>
      <td>${o.ocreatetime}</td>
      <c:if test="${o.ofinishtime!=null }">
      <td>${o.ofinishtime}</td>
      </c:if>
      <c:if test="${o.ofinishtime==null }">
      <td>待收货</td>
      </c:if>
    </tr>
	</c:forEach>
	</tbody>
	<tfoot>
	  <tr>
	  <c:if test="${search!=null }">
	  	
	  </c:if>
		  <td colspan=9>
		  	<a href="<%=path %>/orderbyshop.do?sid=${sid }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="allpage" value="${allPage} " readonly/>
		  	<a href="<%=path %>/orderbyshop.do?sid=${sid }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	  </tfoot>
	</table>

<script src="<%=path %>/layui/layui.js"></script>
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script>
$("tfoot input").change(function(){
	window.location.assign('orderlist.do?page='+this.value)
})


</script>
</body>
</html>