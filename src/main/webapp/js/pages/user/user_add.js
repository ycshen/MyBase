
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
function editUser(){
	/*var txtdepartmentName = $("#txtdepartmentName").val();
	if(isBlank(txtdepartmentName)){
		layer.alert("部门名称不能为空");
		return;
	}*/
	var isHasSub = $("#hidIsHasSub").val();
	if(isHasSub == 1){
		var departmentId = $("#departmentIdSelect").find("option:selected").val();
		if(isBlank(departmentId)){
			layer.alert("请选择部门");
			return;
		}else{
			var departmentName = $("#departmentIdSelect").find("option:selected").text();
			$("#hidDepartmentName").val(departmentName);
		}
	}
	
	var userName = $("#txtuserName").val();
	if(isBlank(userName)){
		layer.alert("请输入用户名");
		return;
	}
	
	var telphone = $("#txttelphone").val();
	if(isBlank(telphone)){
		layer.alert("请输入电话号码");
		return;
	}
	
	var url = ctx + "/inner/user/saveOrUpdate";
	var data = $('#userForm').serialize();
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
          }else if(data == 4){
        	  layer.alert("该员工姓名已经存在！"); 
          }else{
        	  layer.alert("操作失败！"); 
          }
        }
    });
	
}

