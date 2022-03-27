<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買假藥</title>
<%String path=request.getServletContext().getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<link rel="stylesheet" href="<%=path %>/css/index.css">
</head>
<body>
	<header>
		<div class="header-top">
			<div class="user">
				<c:if test="${user==null }">
				<a href="<%=path %>/login.jsp">登录</a>
				</c:if>
				<c:if test="${user!=null }">
					<ul class="layui-nav layui-layout-right usercontent">
				      <li class="layui-nav-item">
				        <a href="javascript:;">
				          ${user.urealname}
				        </a>
				        <dl class="layui-nav-child usercontent-child">
				          <dd><a onclick="showinfo()">基本资料</a></dd>
				          <dd><a href="<%=path %>/orderbyuser.do?uid=${user.uid}" target="nrong">查看订单</a></dd>
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
		
		<div class="header-bottom ">
			<ul class="layui-nav  layui-bg-green nav"  style="padding-left: 270px" lay-filter="">
			<li class="layui-nav-item layui-this"><a href="<%=path %>/alldrug.do" target="nrong">全部</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=1" target="nrong">抗菌消炎</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=2" target="nrong">消化系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=3" target="nrong">呼吸系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=4" target="nrong">泌尿系统</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=5" target="nrong">妇科用药</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=6" target="nrong">儿科用药</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/drugbyclassify.do?cid=7" target="nrong">注射液</a></li>
			  <li class="layui-nav-item"><a href="<%=path %>/messagelisttouser.do?id=${user.uid}" target="nrong">留言</a></li>
			</ul>
		</div>
	</header>
	<section class="body">
		<iframe src="<%=path %>/alldrug.do" name="nrong" width="95%" height="95%">
   		</iframe>
	</section>
	<div class="userinfo">
		<section>
		<form class="layui-form updateuser" action="<%=path %>/userupdatefromuser.do" method="post">
		   <div class="layui-form-item hidden">
		    <div class="layui-input-block">
		      <input type="hidden" name="uid" value="${user.uid }" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
		    <label class="layui-form-label">用户名</label>
		    <div class="layui-input-block">
		      <input type="text" name="uname" value="${user.uname }" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="password" name="upassword" value="${user.upassword }" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">真实姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="urealname" value="${user.urealname }" required  lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
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
		      <input type="text" name="uage" value="${user.uage }" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">电话</label>
		    <div class="layui-input-block">
		      <input type="text" name="utel" value="${user.utel }" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
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
//点击模糊搜索按钮，ajax发送请求，替换ifream
//.....发现bug,替换ifream内容，而非ifream
$(".searchbutton").click(function(){
	$.ajax({
		type:"post",
		url: "/drugsp/drupsearchtouser.do",
		data:"searchu="+$("[name='searchu']").val(),
		success:function(resp){
			$(".body iframe").contents().find('body').html(resp);;
		}
	})
});
//显示修改信息窗口
function showinfo(){
	$(".userinfo").show();
}
//取消修改
$(".goback").click(function(){
	$(".userinfo").hide();
})
</script>
</body>
</html>