
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
function editauth(){
	var authName = $("#txtAuthName").val();
	if(isBlank(authName)){
		layer.alert("权限名称不能为空");
		return;
	}
	
	var authDesc = $("#txtAuthDesc").val();
	if(isBlank(authDesc)){
		layer.alert("权限描述不能为空");
		return;
	}
	
	var url = ctx + "/inner/authority/saveOrUpdate";
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

