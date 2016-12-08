
function cancelEdit(){
	layer.closeAll();
}

function isBlank(args){
	var result = false;
	if(args == "" || args == null || args == undefined){
		result = true;
	}
	
	return result;
}
function editMenu(){
	var menuName = $("#txtmenuName").val();
	if(isBlank(menuName)){
		layer.alert("菜单名称不能为空");
		return;
	}
	
	var menuType = $("#menuTypeSelect").find("option:selected").text();
	if(menuType == "请选择菜单类型"){
		layer.alert("请选择菜单类型！");
		return;
	}
	
	/*var menuUrl = $("#txtmenuUrl").val();
	if(isBlank(menuUrl)){
		layer.alert("请输入菜单URL或者事件");
		return;
	}*/
	
	var parentMenuId = $("#hidParentMenuId").val();
	$.ajax({
		url : ctx + "/inner/menu/isExistMenu?parentMenuId=" + parentMenuId + "&menuName=" + menuName,
		type: "get",
		success: function(result){
			if(result == 1){
				layer.alert("该系统存在相同的菜单");
			}else if(result == 2){
				layer.alert("存在相同的系统");
			}else{
				var url = ctx + "/inner/menu/saveOrUpdate";
				var data = $('#menuForm').serialize();
				$.ajax({
			        cache: true,
			        type: "POST",
			        url: url,
			        data: data,
			        async: false,
			        success: function(data) {
			          if(data == 1){
			        	  layer.alert('新增成功', function(index){
			        		  var isTree = $("#hidIsTree").val();
			        		  if(isTree == 1){
			        			  var parentMenuId = $("#hidParentMenuId").val(); 
			        			  window.parent.addSuccess(parentMenuId, menuName);
			        		  }else{
			        			  window.parent.addSuccess();
			        		  }
			      		});
			          }else if(data == 2){
			        	  layer.alert('更新成功', function(index){
			        		  window.parent.addSuccess();
			        		  
			      		});
			          }else{
			        	  layer.alert("操作失败！"); 
			          }
			        }
			    });
			}
		}
	});
	
	
}

