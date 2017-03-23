function addPosition(){
	var url = ctx + "/inner/position/edit";
	layer.open({
		type: 2,
		title: '添加职位信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyPosition(id){
	var url = ctx + "/inner/position/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑职位信息',
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

function deletePosition(id){
	layer.confirm("确定删除该职位信息？", function(){
		var url = ctx + "/inner/position/delete?id=" + id;
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
	window.location.href = ctx + "/inner/position/list";
}

function queryConfig(page){
	var url = ctx + "/inner/config/list?page=" + page;
	var key = $("#txtkey").val();
	if(isNotBlank(key)){
		url += "&key=" + key;
	}
	
	
	
	var code = $("#txtcode").val();
	if(isNotBlank(code)){
		url += "&code=" + code;
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

