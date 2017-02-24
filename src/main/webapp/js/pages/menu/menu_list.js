function addSystem(){
	var title = "添加外部系统信息";
	var url = ctx + "/inner/menu/edit?menuType=0";
	layer.open({
		type: 2,
		title: title,
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function addInnerSystem(){
	var title = "添加内部系统信息";
	var url = ctx + "/inner/menu/edit?menuType=6";
	layer.open({
		type: 2,
		title: title,
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyMenu(id){
	var url = ctx + "/inner/menu/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑菜单信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function addSub(id, menuType){
	var url = ctx + "/inner/menu/addSubMenu?isTree=0&parentMenuId=" + id + "&menuType=" + menuType;
	layer.open({
		type: 2,
		title: '新增菜单信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function addMultiSub(id){
	var divMenuTag = $("#divMenuType");
	//var url = ctx + "/inner/menu/addSubMenu?parentMenuId=" + id + "&menuType=" + menuType;
	$("#hidMenuId").val(id);
	layer.open({
		  title: "请选择事件类型",
		  type: 1,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['600px', '200px'], //宽高
		  content: divMenuTag
	});
}

function confirmType(){
	var value = $("input[name='menuType']:checked").val()
	if(isNotBlank(value)){
		var id = $("#hidMenuId").val();
		addSub(id, value);
	}else{
		layer.alert("请选择子元素类型");
	}
}

function cancleType(){
	layer.closeAll();
}
function viewMenu(id){
	var url = ctx + "/inner/menu/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看菜单详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function deleteMenu(id){
	layer.confirm("确定删除该菜单信息？", function(){
		var url = ctx + "/inner/menu/delete?id=" + id;
		$.ajax({
	        type: "get",
	        url: url,
	        success: function() {
	        	layer.alert('删除成功', function(index){
	      		  window.location.reload();
	    		});
	        }
	    });
	})
	
}

function addSuccess(){
	window.location.href = ctx + "/inner/menu/list";
}

function queryMenu(page){
	var url = ctx + "/inner/menu/list?page=" + page;
	var menuName = $("#txtmenuName").val();
	if(isNotBlank(menuName)){
		url += "&menuName=" + menuName;
	}
	
	var menuTypeName = $("#menuTypeSelect").find("option:selected").text();
	if(menuTypeName != "请选择菜单类型"){
		var menuType = $("#menuTypeSelect").find("option:selected").val();
		url += "&menuType=" + menuType;
	}
	
	
	var menuUrl = $("#txtmenuUrl").val();
	if(isNotBlank(menuUrl)){
		url += "&menuUrl=" + menuUrl;
	}
	
	window.location.href = url;
}
function isNotBlank(args){
	var result = false;
	if(args != "" && args != null && args != undefined){
		result = true;
	}
	
	return result;
}

function isBlank(args){
	var result = false;
	if(args == "" || args == null || args == undefined){
		result = true;
	}
	
	return result;
}
$(function(){
	var size = $("#hidCurPageCount").val();
	if(isBlank(size)){
		size = 0;
	}
	
	for(var i=0; i< size; i++){
		$("#selectOper" + i).change(function(){
			var selectValue = $(this).val();
			var menuId = $(this).parent().siblings().eq(0).html();
			if(selectValue == 0){
				//不做任何动作
			}else if(selectValue == 1){
				modifyMenu(menuId); //编辑
			}else if(selectValue == 2){
				deleteMenu(menuId);
			}else if(selectValue == 3){
				viewMenu(menuId);
			}else if(selectValue == 4){
				addSub(menuId, 3);
			}else if(selectValue == 6){
				addMultiSub(menuId);
			}else if(selectValue == 5){
				addSub(menuId, 7);
			}else if(selectValue == 7){
				addSub(menuId, 8);
			}
		});
	}

	
});
