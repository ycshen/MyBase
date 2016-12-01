
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
	
	var departmentId = $("#departmentIdSelect").find("option:selected").val();
	if(isBlank(departmentId)){
		layer.alert("请选择部门");
		return;
	}else{
		var departmentName = $("#departmentIdSelect").find("option:selected").text();
		$("#hidDepartmentName").val(departmentName);
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

