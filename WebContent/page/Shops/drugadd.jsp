<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>賣假藥</title>
<%String path=request.getServletContext().getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
</head>
<body>
		<form class="layui-form updateuser" action="<%=path %>/drugadd.do" method="post">

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
		            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		            <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
		          </div>
		        </div>
		  </form>
		
		
		
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>