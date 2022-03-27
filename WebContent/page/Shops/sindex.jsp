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
<link rel="stylesheet" href="<%=path %>/css/index.css">
</head>
<body>
	<header>
		<div class="header-top">
			<div class="user">
				<c:if test="${shops==null }">
				<a href="<%=path %>/login.jsp">登录</a>
				</c:if>
				<c:if test="${shops!=null }">
					<ul class="layui-nav layui-layout-right usercontent">
				      <li class="layui-nav-item">
				        <a href="javascript:;">
				          ${shops.srealname}
				        </a>
				        <dl class="layui-nav-child usercontent-child">
				          <dd><a onclick="showinfo()">基本资料</a></dd>
				          <dd><a href="<%=path %>/orderbyshop.do?sid=${shops.sid}" target="nrong">查看订单</a></dd>
				        </dl>
				      </li>
				      <li class="layui-nav-item"><a href="<%=path %>/LoginoutServlet.do">注销</a></li>
				    </ul>
				</c:if>
			</div>
		</div>
		<div class="header-left">
			<img src="<%=path%>/img/logo.jpeg">
		</div>
		<div class="header-middle">
			<!-- 搜索框 -->
			<div class="layui-form">
			  	<div class="layui-form-item search">
				    <div class="layui-input-inline">
				      <input type="search" name="searchu"  lay-verify="required" placeholder="请输入药品" autocomplete="off" class="layui-input ">
				    </div>
				    <button type="submit" class="searchbutton"><i class="layui-icon" style="font-size: 30px; color: #fff">&#xe615;</i>  </button>
		  		</div>
			</div>
		</div>
		<div class="header-right">
			<button class="drugadd">添加药品</button>
		</div>
		
		<div class="header-bottom ">
			<ul class="layui-nav  layui-bg-green nav" style="padding-left: 270px" lay-filter="">
			<li class="layui-nav-item layui-this"><a href="<%=path %>/finddrugbysid.do?" target="nrong">全部</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=1" target="nrong">抗菌消炎</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=2" target="nrong">消化系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=3" target="nrong">呼吸系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=4" target="nrong">泌尿系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=5" target="nrong">妇科用药</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=6" target="nrong">儿科用药</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyshopclassify.do?cid=7" target="nrong">注射液</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/messagelisttoshop.do" target="nrong">留言</a></li>
			</ul>
		</div>
	</header>
	<section class="body">
	<c:if test="${shops.sid!=null }">
		<iframe src="<%=path %>/finddrugbysid.do" name="nrong" width="95%" height="95%">
   		</iframe>
	</c:if>
		
	</section>
	
	<div class="userinfo">
		<section>
		<form class="layui-form updateuser" action="<%=path %>/shopupdatefromshop.do" method="post">
		   <div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="sid" value="${shops.sid }" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
		    <label class="layui-form-label">用户名</label>
		    <div class="layui-input-block">
		      <input type="text" name="sname" value="${shops.sname }" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="password" name="spassword" value="${shops.spassword }" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">真实姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="srealname" value="${shops.srealname }" required  lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">电话</label>
		    <div class="layui-input-block">
		      <input type="text" name="stel" value="${shops.stel }" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		          <div class="layui-input-block">
		            <button type="reset" class="layui-btn layui-btn-primary goback">取消</button>
		            <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
		          </div>
		        </div>
		  </form>
		</section>
	</div>
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
//模糊查询，此处bug over
$(".searchbutton").click(function(){
	console.log($("iframe").contents())
	$.ajax({
		type:"post",
		url: "/drugsp/drupsearchtoshop.do",
		data:"searchu="+$("[name='searchu']").val(),
		success:function(resp){
			$(".body iframe").contents().find('body').html(resp);;
		}
	})
});
//显示商家信息
function showinfo(){
	$(".userinfo").show();
}
//隐藏修改窗口
$(".goback").click(function(){
	$(".userinfo").hide();
})
//  发送请求跳转到新增页面   
$(".drugadd").click(function(){
	$.ajax({
		type:"post",
		url: "/drugsp/godrugadd.do",
		success:function(resp){
			$(".body iframe").contents().find('body').html(resp);;
		}
	})
});
</script>
</body>
</html>