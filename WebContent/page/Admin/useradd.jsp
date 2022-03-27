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
	<form class="layui-form" action="<%=path %>/useradd.do" method="post">
    <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="uname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="password" name="upassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">真实姓名</label>
    <div class="layui-input-block">
      <input type="text" name="urealname" required  lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
  
    <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	      <input type="radio" name="usex" value="男" title="男" checked="">
	      <input type="radio" name="usex" value="女" title="女">
	    </div>
	  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">年龄</label>
    <div class="layui-input-block">
      <input type="text" name="uage" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="utel" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
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