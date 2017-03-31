function subtract(subtractId, curIndex, maxIndex){
	if(curIndex != maxIndex){
		var status = Number(curIndex) + 1;
		var plusId = $("#td" + status).html();
		var url = ctx + "/inner/menu/sortMenu?plusId=" + plusId + "&subtractId=" + subtractId;
		$.ajax({
			type: "get",
			url: url,
			success: function(){
				location.reload();
			}
		});
	}
}
function plus(plusId, curIndex){
	if(curIndex != 0){
		var status = curIndex - 1;
		var subtractId = $("#td" + status).html();
		var url = ctx + "/inner/menu/sortMenu?plusId=" + plusId + "&subtractId=" + subtractId;
		$.ajax({
			type: "get",
			url: url,
			success: function(){
				location.reload();
			}
		});
	}
}