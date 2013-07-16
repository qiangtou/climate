$(function () {
	$('#auth').attr('href', "https://api.weibo.com/oauth2/authorize?client_id=2831263130&redirect_uri=http://sztq.sinaapp.com&response_type=code&state=")
	var m = $('#m').on('hidden', function () {
			location.href = "http://" + location.host;
		});
	var tip = m.find('.modal-body>p');
	$("#send").click(function () {
		$.ajax({
			url : "/SendWeibo",
			type : 'post',
			data : {
				content : $('#content').val()
			},
			success : function (res) {
				if (res == "ok") {
					tip.html("发送成功！！");
				} else {
					tip.html("发送失败！！");
				}
				m.modal('show');
			}
		});
	});
	$("#weather").click(function () {
		$.ajax({
			url : "/FetchWeather",
			type : 'post',
			success : function (res) {
				tip.html(res);
				m.modal('show');
			}
		});
	});
	$("#stop").click(function () {
		$.ajax({
			url : "/StopToken",
			type : 'post',
			success : function (res) {
				if (res == 'ok') {
					tip.html("说的是捏，您的授权已经解除，放心去玩吧，微博不会再自己发了！！");
					m.modal('show');
				}
			},
			error : function () {
				tip.html("出错了哦！！");
				m.modal('show');
			}
		});
	});
})
