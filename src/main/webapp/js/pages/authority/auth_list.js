function addauth(){
	var url = ctx + "/inner/authority/edit";
	layer.open({
		type: 2,
		title: '添加权限信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyauth(id){
	var url = ctx + "/inner/authority/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑权限信息',
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
function viewConfig(id){
	var url = ctx + "/inner/config/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看基础配置详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function deleteauth(id){
	layer.confirm("确定停用权限信息？", function(){
		var url = ctx + "/inner/authority/delete?id=" + id;
		$.ajax({
	        type: "get",
	        url: url,
	        success: function() {
	        	layer.alert('停用成功', function(index){
	      		  window.location.reload();
	    		});
	        }
	    });
	})
	
}

function startauth(id){
	layer.confirm("确定启用权限信息？", function(){
		var url = ctx + "/inner/authority/start?id=" + id;
		$.ajax({
	        type: "get",
	        url: url,
	        success: function() {
	        	layer.alert('启用成功', function(index){
	      		  window.location.reload();
	    		});
	        }
	    });
	})
	
}

function addSuccess(){
	window.location.href = ctx + "/inner/authority/list";
}

function queryauth(page){
	var url = ctx + "/inner/authority/list?page=" + page;
	var authName = $("#txtQueryAuthName").val();
	if(isNotBlank(authName)){
		url += "&authName=" + authName;
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

