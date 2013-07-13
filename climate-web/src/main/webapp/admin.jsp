<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://lib.sinaapp.com/js/bootstrap/latest/css/bootstrap.min.css" />
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/bootstrap/latest/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
		var m= $('#m').on('hidden', function () {
   				location.href="http://"+location.host;
    });
			$("#stop").click(function(){
				$.ajax({
					url:"/StopToken",type:'post',
					success:function(res){
					if(res=='ok'){ 
						m.modal('show');
					}
					},
error:function(){
alert("time out")	
}
					});
			});
		})
	</script>
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
			</div>

		</div>
		<div class="row">
			<div class="span6 offset3">
				<a  class="btn btn-large" href="/AccessToken">还没有授权哦，这就去找渣浪111</a>
				<a  class="btn btn-large" id="stop" href="#">已经授权，但是我不想用了</a>
			</div>
				
		</div>
	</div>
	<!--模态提示框  -->
    <div id="m" class="modal hide fade">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>提示信息</h3>
    </div>
    <div class="modal-body">
    <p>说的是捏，您的授权已经解除，放心去玩吧，微博不会再自己发了！！</p>
    </div>
    <div class="modal-footer">
    <a href="#m" class="btn" data-toggle="modal" >关闭</a>
    </div>
    </div>
    <!--  -->
</body>
</html>
