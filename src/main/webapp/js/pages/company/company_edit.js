
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
function editCompany(){
	var companyName = $("#txtCompanyName").val();
	if(isBlank(companyName)){
		layer.alert("企业名称不能为空");
		return;
	}
	
	var companyAddress = $("#txtCompanyAddress").val();
	if(isBlank(companyAddress)){
		layer.alert("企业地址不能为空");
		return;
	}
	
	var companyTelphone = $("#txtCompanyTelphone").val();
	if(isBlank(companyTelphone)){
		layer.alert("企业联系方式不能为空");
		return;
	}else if(companyTelphone.length > 13){
		layer.alert("请输入正确的企业联系方式");
		return;
	}else if(companyTelphone.length < 7){
		layer.alert("请输入正确的企业联系方式");
		return;
	}
	
	var companyCeo = $("#txtCompanyCeo").val();
	if(isBlank(companyCeo)){
		layer.alert("企业负责人不能为空");
		return;
	}
	
	var url = ctx + "/inner/company/saveOrUpdate";
	var data = $('#companyForm').serialize();
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

