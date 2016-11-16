<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<div id="alertModel" class="modal fade bs-example-modal-sm"
	tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
	data-backdrop="static" data-show="true" data-keyboard="false">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">${model.result.name }</h4>
			</div>
			<div class="modal-body bg-success">
				<h4>${model.message }</h4>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<a class="btn btn-primary">返回任务列表</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#alertModel1").modal()
</script>