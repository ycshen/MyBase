function addEmailTemplate(){
	var url = ctx + "/inner/emailTemplate/edit";
	window.location.href = url;
}


function modifyEmailTemplate(id){
	var url = ctx + "/inner/emailTemplate/edit?id=" + id;
	window.location.href = url;
}

function addSameEmailTemplate(id){
	var url = ctx + "/inner/emailTemplate/addSame?id=" + id;
	layer.open({
		type: 2,
		title: '新增邮件模板信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
function viewEmailTemplate(id){
	var url = ctx + "/inner/emailTemplate/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看邮件模板详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function switchStatus(id, status){
	layer.confirm("确定要切换邮件模板的状态？", function(){
		var url = ctx + "/inner/emailTemplate/switchStatus?id=" + id;
		$.ajax({
	        type: "get",
	        url: url,
	        success: function(data) {
	        	layer.alert('切换成功', function(index){
					var html = "<span class=\"btn btn-success\">启用</span>";
					if(data == 0){
						html = "<span class=\"btn btn-warning\">禁用</span>";
					}
					$("#status" + id).html(html);
					layer.closeAll();

	    		});
	        }
	    });
	})
	
}

function addSuccess(){
	window.location.href = ctx + "/inner/emailTemplate/list";
}

function isNotBlank(args){
	var result = false;
	if(args != "" && args != null && args != undefined){
		result = true;
	}
	
	return result;
}


function testEmail(code){
	var email = $("#txtEmail").val();
	var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!emailReg.test(email)){
		layer.alert('请输入正确的邮件格式');
		return false;
	}

	if(isNotBlank(email)){
		var url = ctx + "/inner/emailTemplate/testEmail?code=" + code + "&email=" + email;
		$.ajax({
			cache: true,
			type: "get",
			url: url,
			success: function(data) {
				if(data == 1){
					layer.alert('发送测试邮件成功');
				}else{
					layer.alert("发送测试邮件失败！");
				}
			}
		});
	}else{

		layer.alert("发送测试邮件地址不能为空！");
	}

}

function viewTemplateContent(id){
	$.ajax({
		type: "get",
		url: ctx + "/inner/emailTemplate/getTemplateContent?id=" + id,
		success: function(data){
			layer.open({
				type: 1,
				title: false,
				closeBtn: 1,
				area: ['80%', '80%'],
				skin: 'layui-layer-nobg', //没有背景色
				shadeClose: false,
				content: data
			});
		}
	});

}
