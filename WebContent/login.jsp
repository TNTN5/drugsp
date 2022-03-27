<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String path=request.getServletContext().getContextPath(); %>
 <link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<link rel="stylesheet" href="<%=path %>/css/login.css">
<title>登录</title>
</head>
<body>
	<section class="choose">
		<div onclick="adminlogin()">
			管理员登录
		</div>
		<div onclick="shopslogin()">
			商家登录
		</div>
		<div onclick="userlogin()">
			用户登录
		</div>
	</section>
	<!-- 管理员登录 -->
	<section class="login adminlogin">
		<form class="layui-form" action="adminlogin.do" method="post">
        <div class="layui-form-item">
          <label class="layui-form-label">账号</label>
          <div class="layui-input-inline">
            <input type="text" name="loginname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">密码</label>
          <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">验证码</label>
          <div class="layui-input-inline" style="width: 100px">
            <input type="text" name="yzm" required  lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
          </div>
          <div class="layui-input-inline" style="width: 80px">
          <img src="kaptcha.do" class="k" width="80px" height="36px">
          </div>
        </div>
          <div class="layui-form-mid layui-word-aux">${msg}</div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
          </div>
        </div>
    </form>
	</section>
	<!-- 商家登录 -->
	<section class="login shopslogin">
		<form class="layui-form" action="shopslogin.do" method="post">
        <div class="layui-form-item">
          <label class="layui-form-label">账号</label>
          <div class="layui-input-inline">
            <input type="text" name="loginname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">密码</label>
          <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">验证码</label>
          <div class="layui-input-inline" style="width: 100px">
            <input type="text" name="yzm" required  lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
          </div>
          <div class="layui-input-inline" style="width: 80px">
          <img src="kaptcha.do" class="k" width="80px" height="36px">
          </div>
        </div>
          <div class="layui-form-mid layui-word-aux">${msg}</div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
          </div>
        </div>
    </form>
	</section>
	<!-- 用户登录 -->
	<section class="login userlogin">
	<form class="layui-form" action="userlogin.do" method="post">
        <div class="layui-form-item">
          <label class="layui-form-label">账号</label>
          <div class="layui-input-inline">
            <input type="text" name="loginname" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">密码</label>
          <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">验证码</label>
          <div class="layui-input-inline" style="width: 100px">
            <input type="text" name="yzm" required  lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
          </div>
          <div class="layui-input-inline" style="width: 80px">
          <img src="kaptcha.do" class="k" width="80px" height="36px">
          </div>
        </div>
          <div class="layui-form-mid layui-word-aux">${msg}</div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
          </div>
        </div>
    </form>
	</section>
	<script src="./js/jquery-3.6.0.min.js"></script>
	<script src="./layui/layui.js"></script>
	<script>
//点击管理员登录，商家登录，用户登录，控制显示隐藏
		function adminlogin(){
			$(".choose").hide();
			$(".adminlogin").show();
		}
		function shopslogin(){
			$(".choose").hide();
			$(".shopslogin").show();
		}
		function userlogin(){
			$(".choose").hide();
			$(".userlogin").show();
		}
//点击验证码图片，刷新
		$($(".k").click(function(){
			this.src="kaptcha.do";
		}
		))
	</script>
</body>
</html>