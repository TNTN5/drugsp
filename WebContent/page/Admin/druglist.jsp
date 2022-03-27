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
	<form class="layui-form" action="drugsearch.do">
	  	<div class="layui-form-item search">
		    <div class="layui-input-inline">
		      <input type="search" name="searchu"  lay-verify="required" placeholder="请输入药品" autocomplete="off" class="layui-input ">
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
      <th>药名</th>
      <th class="decpict">描述</th>
      <th>所属分类</th>
      <th>价格</th>
      <th>商家</th>
      <th>库存</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  <c:forEach items="${drugs}" var="ds">
    <tr>
      <td>${ds.drugid}</td>
      <td>${ds.dname}</td>
      <td class="decpict">${ds.decpict}</td>
      <td>
      	<c:forEach items="${classify }" var="c">
      		<c:if test="${c.cid==ds.cid }">${c.cname}</c:if>
      	</c:forEach>
      </td>
      <td>${ds.dprice}</td>
      <td>
      	<c:forEach items="${shops }" var="s">
      		<c:if test="${s.sid==ds.sid }">${s.sname }</c:if>
      	</c:forEach>
      </td>
      <td>${ds.stock}</td>
      <td>
		  <button class="layui-btn layui-btn-sm update">
   		  <i class="layui-icon">&#xe642;</i>
		  </button>
		  <a href="drugsdelete.do?id=${ds.drugid}">
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
		  	<a href="<%=path %>/drugsearch.do?searchu=${searchu }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="page" value="${allPage} " readonly/>
		  	<a href="<%=path %>/drugsearch.do?searchu=${searchu }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	  </tfoot>
	</table>
	
<!-- 修改页面 -->
	<div class="updateuserdiv">
		<form class="layui-form updateuser" action="drugsupdate.do" method="post">
		   <div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="drugid" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
		    <label class="layui-form-label">药名</label>
		    <div class="layui-input-block">
		      <input type="text" name="dname" required  lay-verify="required" placeholder="请输入药品名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">功效</label>
		    <div class="layui-input-block">
		      <input type="text" name="decpict" required lay-verify="required" placeholder="请输入药品功效" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">价格</label>
		    <div class="layui-input-block">
		      <input type="text" name="dprice" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-inline">
      <label class="layui-form-label">商家</label>
      <div class="layui-input-inline">
        <select name="shops" lay-verify="required" lay-search="">
          <c:forEach items="${shops}" var="s">
          	<option value="${s.sid}">${s.sname}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">分类</label>
      <div class="layui-input-inline">
        <select name="classify" lay-verify="required" lay-search="">
          <c:forEach items="${classify}" var="c">
          	<option value="${c.cid}">${c.cname}</option>
          </c:forEach>
        </select>
      </div>
    </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">库存</label>
		    <div class="layui-input-block">
		      <input type="text" name="stock" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
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
	$(".updateuserdiv input")[3].value=this.parentNode.parentNode.childNodes[9].innerHTML;
	$(".updateuserdiv input")[4].value=this.parentNode.parentNode.childNodes[11].innerHTML;
	$(".updateuserdiv input")[5].value=this.parentNode.parentNode.childNodes[7].innerHTML;
	$(".updateuserdiv input")[6].value=this.parentNode.parentNode.childNodes[13].innerHTML;
	$(".updateuserdiv").css({display:"block"});
})
$(".goback").click(function(){
	$(".updateuserdiv").css({display:"none"});
})
</script>
</body>
</html>