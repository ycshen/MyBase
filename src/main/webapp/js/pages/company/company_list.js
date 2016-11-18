function addCompany(){
	var url = ctx + "/inner/company/edit";
	layer.open({
		type: 2,
		title: '添加公司信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}


		
function addSubCompany(id){
	var url = ctx + "/inner/company/addSub?id=" + id;
	layer.open({
		type: 2,
		title: '添加子公司信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
function addSuccess(){
	window.location.href = ctx + "/inner/company/list";
}

function queryCompany(page){
	var url = ctx + "/inner/company/list?page=" + page;
	var level = $("#levelSelect").find("option:selected").val();
	if(isNotBlank(level)){
		url += "&level=" + level;
	}
	
	
	
	var companyName = $("#txtCompanyName").val();
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

function addDepartment(id){
	var url = ctx + "/inner/department/add?id=" + id;
	layer.open({
		type: 2,
		title: '添加部门信息',
		shadeClose: true,
		shade: 0.8,
		area: ['550px', '400px'],
		content: url
	});
}
