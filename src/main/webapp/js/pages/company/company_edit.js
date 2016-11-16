
function cancelEdit(){
	layer.closeAll();
}

function editCompany(){
	var formObj = window.document.getElementById("companyForm");//获取domainForm对象
	var url = ctx + "/inner/company/saveOrUpdate";
	var data = $('#companyForm').serialize();
	alert(data)
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

