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

function addSuccess(){
	window.location.href = ctx + "/inner/company/list";
}

