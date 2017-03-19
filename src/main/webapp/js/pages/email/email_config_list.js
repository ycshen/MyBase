function addEmailConfig(){
	var url = ctx + "/inner/emailConfig/edit";
	window.location.href = url;
}


function modifyEmailConfig(id){
	var url = ctx + "/inner/emailConfig/edit?id=" + id;
	window.location.href = url;
}

function addSameEmailConfig(id){
	var url = ctx + "/inner/emailConfig/addSame?id=" + id;
	layer.open({
		type: 2,
		title: '新增基础配置信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
function viewEmailConfig(id){
	var url = ctx + "/inner/emailConfig/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看基础配置详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function deleteEmailConfig(id){
	layer.confirm("确定删除该配置信息？", function(){
		var url = ctx + "/inner/emailConfig/delete?id=" + id;
		$.ajax({
	        type: "get",
	        url: url,
	        success: function() {
	        	layer.alert('删除成功', function(index){
	      		  window.location.reload();
	    		});
	        }
	    });
	})
	
}

function addSuccess(){
	window.location.href = ctx + "/inner/emailConfig/list";
}

function isNotBlank(args){
	var result = false;
	if(args != "" && args != null && args != undefined){
		result = true;
	}
	
	return result;
}

