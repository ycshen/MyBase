function addMenu(){
	var url = ctx + "/inner/menu/edit";
	layer.open({
		type: 2,
		title: '添加菜单权限信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


function modifyConfig(id){
	var url = ctx + "/inner/config/edit?id=" + id;
	layer.open({
		type: 2,
		title: '编辑基础配置信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}

function addSameConfig(id){
	var url = ctx + "/inner/config/addSame?id=" + id;
	layer.open({
		type: 2,
		title: '新增基础配置信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
function viewConfig(id){
	var url = ctx + "/inner/config/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看基础配置详细信息',
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

function addSuccess(parentMenuId, menuName){
	$("#tree").treeview("addNode", [nodeId, { node: { text: menuName, href: "001005" } }]);  
	layer.closeAll();
	
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
   
$(function(){
	initTree();
})

var nodeId = "";
function initTree() {
   $.ajax({
	   type : 'get',
	   url : ctx + "/inner/menu/treeData",
	   success: function(data){
		   $('#tree').treeview({data: data});
		   $("#divLoader").hide();
		   $('#tree').treeview('collapseAll', { silent: true });
	   }
   })  
   
   
   
   $("#btnView").click(function (e) {
	   var arr = $('#tree').treeview('getSelected');
	   var menuId = "";
	   for (var key in arr) {
		   menuId = arr[key].id;
	   }
	   
	   if(isNotBlank(menuId)){
		   var url = ctx + "/inner/menu/view?id=" + menuId;
			layer.open({
				type: 2,
				title: '查看菜单详细信息',
				shadeClose: true,
				shade: 0.8,
				area: ['550px', '400px'],
				content: url
			});
	   }else{
		   layer.alert("请选择菜单"); 
	   }
   });
   
   $("#btnAddSub").click(function (e) {
	   var arr = $('#tree').treeview('getSelected');
	   var menuId = "";
	   for (var key in arr) {
		   menuId = arr[key].id;
		   nodeId = arr[key].nodeId;
	   }
	   
	   if(isNotBlank(menuId)){
		  var url = ctx + "/inner/menu/isSystemOrUrl?id=" + menuId;
		   $.ajax({
			   type: "get",
			   url: url,
			   success: function(isSystem){
				   if(isSystem == 1){
					   addSub(menuId, 3);
				   }else if(isSystem == 2){
					   addMultiSub(menuId);
				   }else{
					   layer.alert("请选择菜单或者系统,事件不能拥有子元素!");
				   }
			   }
			   
		   });
		   
	   }else{
		   layer.alert("请选择父菜单"); 
	   }
   });
        
}
 
function addSub(id, menuType){
	var url = ctx + "/inner/menu/addSubMenu?isTree=1&parentMenuId=" + id + "&menuType=" + menuType;
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
