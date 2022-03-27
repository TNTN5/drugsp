<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>假药管理系统</title>
  <%String path=request.getServletContext().getContextPath(); %>
  <link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
  <style>
  	.layui-body iframe {
		margin: 10px 10px;
		border: none;
	}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">假药管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
     	 <li class="layui-nav-item">用户管理</li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
           ${admin.aname}
        </a>
      </li>
      <li class="layui-nav-item"><a href="<%=path %>/LoginoutServlet.do">注销登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;" onclick="zhui('用户管理')">用户管理</a>
          <dl class="layui-nav-child">
            <dd><a href="<%=path %>/userlist.do" target="nrong" onclick="zhui('用户管理>用户列表')">用户列表</a></dd>
            <dd><a href="<%=path %>/page/Admin/useradd.jsp" target="nrong" onclick="zhui('用户管理>新增用户')">新增用户</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;" onclick="zhui('商家管理')">商家管理</a>
          <dl class="layui-nav-child">
            <dd><a href="<%=path %>/shopslist.do"  target="nrong"  onclick="zhui('商家管理>商家列表')">商家列表</a></dd>
            <dd><a href="<%=path %>/page/Admin/shopsadd.jsp"  target="nrong"  onclick="zhui('商家管理>新增商家')">新增商家</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"  onclick="zhui('药品管理')"><a href="<%=path %>/druglist.do" target="nrong" >药品管理</a></li>
        <li class="layui-nav-item"  onclick="zhui('订单管理')"><a href="<%=path %>/orderlist.do" target="nrong" >订单记录</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
     <iframe src="<%=path %>/userlist.do" name="nrong" width="95%" height="95%">
    </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 	<a href="https://www.bilibili.com">bilibili.com</a>&emsp;&emsp;&emsp;
  </div>
</div>
<script src="<%=path %>/js/jquery-3.6.0.min.js"></script>
<script src="<%=path %>/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
function zhui(str) {
	$('.layui-nav-item')[0].innerHTML=str;
}
</script>
</body>
</html>