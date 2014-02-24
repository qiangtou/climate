<%@ page language="java" import="java.util.*,com.qiangtou.climate.task.App" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://lib.sinaapp.com/js/bootstrap/2.3.2/css/bootstrap.min.css" />
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/main.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="hero-unit">
				<h1>Climate Weibo</h1>
				<p>这是一个自动发天气预报的微博机器人哦</p>
				<p>
				<a class="btn btn-primary btn-large" href="http://qiangtou.github.io"/> 我的github博客 </a>
				</p>
				<p>
				<%=App.log %>
				</p>
				<p>
				${weather}
				</p>
				<c:if test="${weibo}">
				<div class="row">
					<div class="span4 ">
						<input id="content"  class="input-xlarge search-query" placeholder="写一点东西吧…"/>
					</div>
					<div class="span4">
						<a class="btn btn-medium" id="send" href="#">试着发一下微博</a>
						<input id="attach" type="checkbox" value="true" />附加天气信息
					</div>
				</div>
				</c:if>
			
				
				
			</div>

		</div>
			<c:if test="${!weibo}">
				<div class="row">
					<div class="span3 offset1">
						<a class="btn btn-large" id="weather" href="#">试着拉一下天气</a>
					</div>
					<div class="span5 offset1">
						<a class="btn btn-large" id="auth" href="#">还没有授权哦，这就去找渣浪</a>
					</div>
				</div>
			</c:if>


			<c:if test="${weibo}">
				<div class="row">
					<div class="span3 offset1">
						<a class="btn btn-large" id="weather" href="#">试着拉一下天气</a>
					</div>


					<div class="span4 offset1">
						<a class="btn btn-large" id="stop" href="#">已经授权，但是我不想用了</a>
					</div>
				</div>

			</c:if>
		</div>
	</div>
	<!--模态提示框  -->
    <div id="m" class="modal hide fade">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>提示信息</h3>
    </div>
    <div class="modal-body">
    <p></p>
    </div>
    <div class="modal-footer">
    <a href="#m" class="btn" data-toggle="modal" >关闭</a>
    </div>
    </div>
    <!--  -->
</body>
</html>
