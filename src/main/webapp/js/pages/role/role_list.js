function addrole(){
	var url = ctx + "/inner/role/edit";
	layer.open({
		type: 2,
		title: '添加角色信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyrole(id){
	var url = ctx + "/inner/role/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑角色信息',
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

function deleterole(id){
	layer.confirm("确定停用角色信息？", function(){
		var url = ctx + "/inner/role/delete?id=" + id;
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

function startrole(id){
	layer.confirm("确定启用角色信息？", function(){
		var url = ctx + "/inner/role/start?id=" + id;
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
	window.location.href = ctx + "/inner/role/list";
}

function queryrole(page){
	var url = ctx + "/inner/role/list?page=" + page;
	var roleName = $("#txtQueryRoleName").val();
	if(isNotBlank(roleName)){
		url += "&roleName=" + roleName;
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

