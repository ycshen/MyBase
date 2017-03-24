


function returnEmailTemplate(){
	window.location.href = ctx + "/inner/emailTemplate/list";
}

function isNotBlank(args){
	var result = false;
	if(args != "" && args != null && args != undefined){
		result = true;
	}
	
	return result;
}


function editEmailTemplate(){
	/*var txtkey = $("#txtkey").val();
	if(isBlank(txtkey)){
		layer.alert("键不能为空");
		return;
	}
	
	var txtvalue = $("#txtvalue").val();
	if(isBlank(txtvalue)){
		layer.alert("值不能为空");
		return;
	}
	
	var txtcode = $("#txtcode").val();
	if(isBlank(txtcode)){
		layer.alert("键值编码不能为空");
		return;
	}
	
	var txtremark = $("#txtremark").val();
	if(isBlank(txtremark)){
		layer.alert("备注不能为空");
		return;
	}
	*/
	var url = ctx + "/inner/emailTemplate/saveOrUpdate";
	var data = $('#emailTemplateForm').serialize();
	$.ajax({
        cache: true,
        type: "POST",
        url: url,
        data: data,
        async: false,
        success: function(data) {
          if(data == 1){
        	  layer.alert('新增成功', function(index){
        		 window.location.href = ctx + "/inner/emailTemplate/list"
      		});
          }else if(data == 2){
        	  layer.alert('更新成功', function(index){
         		 window.location.href = ctx + "/inner/emailTemplate/list" 
      		});
          }else{
        	  layer.alert("操作失败！"); 
          }
        }
    });
	
}