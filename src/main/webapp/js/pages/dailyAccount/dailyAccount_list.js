


function deleteDailyAccount(id){
	layer.confirm("确定删除该日常账号信息？", function(){
		var url = ctx + "/inner/dailyAccount/delete?id=" + id;
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


function queryDailyAccount(page){
	var url = ctx + "/inner/dailyAccount/list?page=" + page;
	var account = $("#txtAccount").val();
	if(isNotBlank(account)){
		url += "&account=" + account;
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

