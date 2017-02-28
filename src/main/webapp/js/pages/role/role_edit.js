
function cancelEdit(){
	window.parent.layer.closeAll();
}

function isBlank(args){
	var result = false;
	if(args == "" || args == null || args == undefined){
		result = true;
	}
	
	return result;
}
function editrole(){
	var roleName = $("#txtRoleName").val();
	if(isBlank(roleName)){
		layer.alert("角色名称不能为空");
		return;
	}
	
	var roleDesc = $("#txtRoleDesc").val();
	if(isBlank(roleDesc)){
		layer.alert("角色描述不能为空");
		return;
	}
	
	var url = ctx + "/inner/role/saveOrUpdate";
	var data = $('#myForm').serialize();
	$.ajax({
        cache: true,
        type: "POST",
        url: url,
        data: data,
        async: false,
        success: function(data) {
          if(data == 1){
        	  layer.alert('新增成功', function(index){
        		  window.parent.addSuccess();
        		  
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

