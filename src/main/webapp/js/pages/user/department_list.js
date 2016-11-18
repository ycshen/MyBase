function addConfig(){
	var url = ctx + "/inner/config/edit";
	layer.open({
		type: 2,
		title: '添加基础配置信息',
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
function viewDepartment(id){
	var url = ctx + "/inner/department/view?id=" + id;
	layer.open({
		type: 2,
		title: '查看部门详细信息',
		shadeClose: true,
		shade: 0.8,
		area: ['800px', '600px'],
		content: url
	});
}

function addSuccess(){
	window.location.href = ctx + "/inner/config/list";
}

function queryDepartment(page){
	var url = ctx + "/inner/department/list?page=" + page;
	var departmentName = $("#txtdepartmentName").val();
	if(isNotBlank(departmentName)){
		url += "&departmentName=" + departmentName;
	}
	
	
	
	var companyName = $("#txtcompanyName").val();
	if(isNotBlank(companyName)){
		url += "&companyName=" + companyName;
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

function addUser(id){
	
}

