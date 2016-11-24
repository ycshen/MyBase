function addUser(){
	var url = ctx + "/inner/user/add";
	layer.open({
		type: 2,
		title: '添加员工信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyUser(id){
	var url = ctx + "/inner/user/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑员工信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function addSameConfig(id){
	var url = ctx + "/inner/config/addSame?id=" + id;
	layer.open({
		type: 2,
		title: '新增基础配置信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
function viewDepartment(id){
	var url = ctx + "/inner/department/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看部门详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['800px', '600px'],
		content: url
	});
}

function addSuccess(){
	window.location.href = ctx + "/inner/user/list";
}

function queryUser(page){
	var url = ctx + "/inner/user/list?page=" + page;
	var userName = $("#txtUserName").val();
	if(isNotBlank(userName)){
		url += "&userName=" + userName;
	}
	
	
	
	var telphone = $("#txtTelphone").val();
	if(isNotBlank(telphone)){
		url += "&telphone=" + telphone;
	}
	
	window.location.href = url;
}
function isNotBlank(args){
	var result = false;
	if(args != "" && args != null && args != undefined){
		result = true;
	}
	
	return result;
}


function leaveUser(userId){
	layer.confirm("确定把该员工置为离职状态？", function(){
		var url = ctx + "/inner/user/leave?id=" + userId;
		$.ajax({
			type: 'get',
			url: url,
			success: function(data){
				if(data == 2){					
					layer.alert('操作成功', function(){
						$("#userStatus" + userId).html("<span style=\"color:red;\">离职</span>")
						layer.closeAll();
					});
				}else{
					layer.alert("操作失败");
				}
			}
		});
	})
	
}

function deleteUser(userId){
	layer.confirm("确定删除该员工吗？", function(){
		var url = ctx + "/inner/user/delete?id=" + userId;
		$.ajax({
			type: 'get',
			url: url,
			success: function(data){
				if(data == 2){					
					layer.alert('操作成功', function(){
						$("#userStatus" + userId).html("<span style=\"color:green;\">禁用</span>")
						layer.closeAll();
					});
				}else{
					layer.alert("操作失败");
				}
			}
		});
	})
	
}


