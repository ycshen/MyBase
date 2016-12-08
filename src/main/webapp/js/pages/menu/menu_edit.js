
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
		layer.alert("请选择面单业务类型！");
		return;
	}
	/*var txtvalue = $("#txtvalue").val();
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
	}*/
	
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

