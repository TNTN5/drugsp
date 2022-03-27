<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String path=request.getServletContext().getContextPath(); %>
<meta charset="UTF-8">
 <link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
 <script type="text/javascript" src="<%=path %>/layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form class="layui-form" action="<%=path %>/shopsadd.do" method="post">
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
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo">新增</button>
          </div>
        </div>
  </form>
</body>

</html>