
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
	var departmentId = $("select[name='departmentId']").val();
	if(isBlank(departmentId)){
		layer.alert("请选择部门");
		return;
	}else{
		var departmentName = $("select[name='departmentId']").find("option:selected").text();
		$("#txtdepartmentName").val(departmentName);
	}
	
	var txtuserName = $("#txtuserName").val();
	if(isBlank(txtuserName)){
		layer.alert("员工姓名不能为空");
		return;
	}
	
	var telphone = $("#txtTelphone").val();
	var reg = /^1[3|7|5|8|4]\d{9}$/;
	var regular = /^([^`+~!#$%^&*()|}{=])$/;
	if (isBlank(telphone)) {
		layer.alert("请输入员工手机号码");
		return;
	} else if (telphone.length < 11) {
		layer.alert("员工手机号码长度是11位数字");
		return;
	} else if (telphone.length > 11) {
		layer.alert("员工手机号码长度过长");
		return;
	} else if (!reg.test(telphone)) {
		layer.alert("员工手机号码格式异常");
		return;
	}else{
		var url = ctx + "/inner/user/isExistTelphone?departmentId=" + departmentId + "&telphone=" + telphone;
		$.ajax({
	        cache: true,
	        type: "GET",
	        url: url,
	        async: false,
	        success: function(data) {
	          if(data == 1){
	        	  layer.alert("该手机号码已被使用！");
	      			return;
	          }else{
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
	        }
	    });
	}
	
	
	
	
	
}

