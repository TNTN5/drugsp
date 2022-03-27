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
 <style>
 	
.updateuserdiv{
	position: absolute;
	top:0px;
	left: 0px;
	width: 100%;
	height: 100%;
	background-color: rgba(205,205,205,0.5);
	overflow:scroll;
	display: none;
}
.updateuser{
	border:1px solid #808080;
	width: 500px;
	height: 400px;
	padding:30px 30px 20px 0px;
	margin:100px auto;
	background-color: #fff;
}
.hidden{
	display:none;
}
.decpict{
	max-width: 150px;
	white-space:nowrap;
	overflow:hidden;
	text-overflow: ellipsis;
}
body{
	background-color: #fff;
}
tfoot{
	text-align: center;
}
tfoot input{
	width: 15px;
	border:0px;
}
 
 </style>
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
      <th class="decpict">描述</th>
      <th>所属分类</th>
      <th>价格</th>
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
      <td>${ds.stock}</td>
      <td>
		  <button class="layui-btn layui-btn-sm update">
   		  <i class="layui-icon">&#xe642;</i>
		  </button>
		  <a href="drugsdeletebyshop.do?id=${ds.drugid}">
		  <button class="layui-btn layui-btn-sm">
		  <i class="layui-icon">&#xe640;</i>
		  </button>
		  </a>
	  </td>
    </tr>
	</c:forEach>
	</tbody>
	<tfoot>
<!-- 如果分类和搜索框内容都为空，页码跳转所有商家下的商品列表分页-->
	<c:if test="${cid==null&&searchu==null }">
		<tr>
		  <td colspan=9>
		  	<a href="<%=path %>/finddrugbysid.do?page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="page" value="${allPage} " readonly/>
		  	<a href="<%=path %>/finddrugbysid.do?page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	</c:if>
<!-- 如果分类不为空，搜索框内容都为空，页码跳转所有商家下的商品分类列表分页-->	
	<c:if test="${cid!=null&&searchu==null }">
		<tr>
		  <td colspan=9>
		  	<a href="<%=path %>/drugbyshopclassify.do?cid=${cid }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="page" value="${allPage} " readonly/>
		  	<a href="<%=path %>/drugbyshopclassify.do?cid=${cid }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	</c:if>
	<!-- 如果分类为空，搜索框内容不为空，页码跳转所有商家下的商品模糊查询列表分页-->	
	  <c:if test="${searchu!=null }">
		<tr>
		  <td colspan=9>
		  	<a href="<%=path %>/drupsearchtoshop.do?searchu=${searchu }&page=${page-1>0?page-1:1} " class="layui-btn">上一页</a>
		  	<input type="text" name="page" value="${page}"/>/
		  	<input type="text" name="page" value="${allPage} " readonly/>
		  	<a href="<%=path %>/drupsearchtoshop.do?searchu=${searchu }&page=${page+1<allPage?page+1:allPage} " class="layui-btn">下一页</a>
		  </td>
	  </tr>
	</c:if>
	  </tfoot>
	</table>
	
<!-- 修改页面 -->
	<div class="updateuserdiv">
		<form class="layui-form updateuser" action="drugsupdatebyshop.do" method="post">
		   <div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="drugid" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
		    <label class="layui-form-label">药名</label>
		    <div class="layui-input-block">
		      <input type="text" name="dname" required  lay-verify="required" placeholder="请输入药名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">功效</label>
		    <div class="layui-input-block">
		      <input type="text" name="decpict" required lay-verify="required" placeholder="请输入功效" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">价格</label>
		    <div class="layui-input-block">
		      <input type="text" name="dprice" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
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
		      <input type="text" name="stock" required  lay-verify="required" placeholder="请输入库存" autocomplete="off" class="layui-input">
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
//输入页码跳转
$("tfoot input").change(function(){
	window.location.assign('userlist.do?page='+this.value)
})
//将初始值写入修改窗口input中
$(".update").click(function(){
	console.log($(".updateuserdiv input"))
	console.log(this.parentNode.parentNode.childNodes)
	$(".updateuserdiv input")[0].value=this.parentNode.parentNode.childNodes[1].innerHTML;
	$(".updateuserdiv input")[1].value=this.parentNode.parentNode.childNodes[3].innerHTML;
	$(".updateuserdiv input")[2].value=this.parentNode.parentNode.childNodes[5].innerHTML;
	$(".updateuserdiv input")[3].value=this.parentNode.parentNode.childNodes[9].innerHTML;
	$(".updateuserdiv input")[5].value=this.parentNode.parentNode.childNodes[11].innerHTML;
	$(".updateuserdiv").css({display:"block"});
})
//点击取消后，修改窗口隐藏
$(".goback").click(function(){
	$(".updateuserdiv").css({display:"none"});
})
</script>
</body>
</html>