<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){

		var count = $("#count").val();
		$(".pagination").pagination(count, {
		    num_edge_entries: 5,
		    num_display_entries: 10,
		    callback: pageselectCallback,
		    items_per_page:10,
		    maxentries: count,
		    prev_text: "上一页",
		    next_text: "下一页"
		}); 
	});

	function pageselectCallback(page){
		var departmentId = $("#txtDepartmentId").val();
		getJsonData(departmentId, page + 1);
        return false;
	}
	
	function getHead(tableId){
		var head =  $("#syslist").find("thead").html();
		head = "<thead>" + head  + "</thead>";
		return head;
	}

	function getJsonData(departmentId, page){
		var url = ctx + "/inner/user/getUserListByDepartmentId?departmentId=" + departmentId + "&page=" + page
		$.ajax({
			type: "get",
			url: url,
			success: function(data){
				var tbody = "<tbody>";
				$.each(data, function(index, obj){
					tbody += getTr(obj);
				})
				var tableHead = getHead();
				tbody += "</tbody>";
				tableHead += tbody;
				$("#syslist").html(tableHead)
			}
			
		})
		
	}

	function getTr(obj){
		var tr = "";
		tr+="<tr>";
		tr+="<td>";
		var statusName = getStatusName(obj.status);
		tr+= statusName + "</td>";
		tr += "<td>" + obj.userName + "</td>";			
		tr += "<td>" + obj.telphone + "</td>";	
		tr += "<td>" + obj.createUser + "</td>";
		var objCreateTime = obj.createTime;
		var createTime = "";
		if(isNotBlank(objCreateTime)){
			createTime = new Date(obj.createTime).Format("yyyy-MM-dd hh:mm:ss"); 
		}

		tr += "<td>" + createTime + "</td>";
		var updateUser = obj.updateUser;
		if(updateUser == undefined){
			updateUser = "";
		}
		tr += "<td>" + updateUser + "</td>";
		var objUpdateTime = obj.updateTime;
		var updateTime = "";
		if(isNotBlank(objUpdateTime)){
			updateTime = new Date(obj.updateTime).Format("yyyy-MM-dd hh:mm:ss"); 
		}
		
		tr += "<td>" + updateTime + "</td>";		

		tr+="</tr>";

		return tr;
	
	}

	function isNotBlank(args){
		var result = false;
		if(args != null && args != "" && args != undefined){
			result = true;
		}

		return result;
	}

	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}

	function getStatusName(status){
		var statusName = "在职";
		if(status == 100){
			statusName = "<span style=\"color:red;\">离职</span>";
		}else if(status == 102){
			statusName = "<span style=\"color:green;\">禁用</span>";
		}

		return statusName;
	}
</script>
<div class="pagination"></div> 
