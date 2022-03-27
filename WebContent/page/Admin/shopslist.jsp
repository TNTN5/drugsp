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
<!-- 搜索框 -->
	<form class="layui-form" action="shopssearch.do">
	  	<div class="layui-form-item search">
		    <div class="layui-input-inline">
		      <input type="search" name="searchu"  lay-verify="required" placeholder="请输入商家" autocomplete="off" class="layui-input ">
		    </div>
		    <button type="submit"><i class="layui-icon" style="font-size: 30px; color: #00988b">&#xe615;</i>  </button>
  		</div>
	</form>
	
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
      <th>用户名</th>
      <th>密码</th>
      <th>真实姓名</th>
      <th>电话</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  <c:forEach items="${shops}" var="shops">
    <tr>
      <td>${shops.sid}</td>
      <td>${shops.sname}</td>
      <td>${shops.spassword}</td>
      <td>${shops.srealname}</td>
      <td>${shops.stel}</td>
      <td>
		  <button class="layui-btn layui-btn-sm update">
   		  <i class="layui-icon">&#xe642;</i>
		  </button>
		  <a href="shopsdelete.do?id=${shops.sid }">
		  <button class="layui-btn layui-btn-sm">
		  <i class="layui-icon">&#xe640;</i>
		  </button>
		  </a>
	  </td>
    </tr>
	</c:forEach>
	</tbody>
	<tfoot>
	  <tr>
		  <td colspan=9>
		  	<a href="shopssearch.do?searchu=${searchu }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="page" value="${allPage} " readonly/>
		  	<a href="shopssearch.do?searchu=${searchu }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	  </tfoot>
	</table>
	
<!-- 修改页面 -->
	<div class="updateuserdiv">
		<form class="layui-form updateuser" action="shopsupdate.do" method="post">
		   <div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="sid" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
		    <label class="layui-form-label">用户名</label>
		    <div class="layui-input-block">
		      <input type="text" name="sname" required  lay-verify="required" placeholder="请输入商家用户名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="password" name="spassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">真实姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="srealname" required  lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">电话</label>
		    <div class="layui-input-block">
		      <input type="text" name="stel" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		          <div class="layui-input-block">
		            <button type="reset" class="layui-btn layui-btn-primary goback">取消</button>
		            <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
		          </div>
		        </div>
		  </form>
	</div>

<script src="<%=path %>/layui/layui.js"></script>
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script>
$("tfoot input").change(function(){
	window.location.assign('userlist.do?page='+this.value)
})

$(".update").click(function(){
	$(".updateuserdiv input")[0].value=this.parentNode.parentNode.childNodes[1].innerHTML;
	$(".updateuserdiv input")[1].value=this.parentNode.parentNode.childNodes[3].innerHTML;
	$(".updateuserdiv input")[2].value=this.parentNode.parentNode.childNodes[5].innerHTML;
	$(".updateuserdiv input")[3].value=this.parentNode.parentNode.childNodes[7].innerHTML;
	$(".updateuserdiv input")[4].value=this.parentNode.parentNode.childNodes[9].innerHTML;
	$(".updateuserdiv").css({display:"block"});
})
$(".goback").click(function(){
	$(".updateuserdiv").css({display:"none"});
})
</script>
</body>
</html>