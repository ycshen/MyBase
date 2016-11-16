<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>纸质面单出库</title>
<link href="${ctx}/css/index.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/sea-modules/sea.js"/></script>
<script type="text/javascript" src="${ctx}/sea-modules/sea-config.js"/></script>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billwarehousein/warehousein.js" />
</jsp:include>
</head>
<body>
<div id="main" class="container-fluid">

		<div id="main_content">
					<div class="m-d-y-w-w-h-ct">
					    <div class="m-d-z-z-m" style="border:0px;">
					         <h3><label class="label label-info">整箱入库</label></h3>
					    </div>
					    <div class="m-d-z-z-t">
							<form id="boxForm" method="post">
						            <ul class="m-d-y-w-w-h-ct-p" style="border-bottom: none">

						        <section  id="z_x_c_k_s" class="active">
						                <li style="width: 100%">
						                    <div class="z-z-md-1" style="height: 200px;">
						                        <table class="table table-bordered itl-table"  id="z_x_c_k_l_table">
													<input type="hidden" name="billWarehouseInEntity.inType" value="1">
						                            <tbody>
						                            <tr>
						                                <td>
						                                    <input type="text" id="txtStartNum" name="list[0].startNum" style="width:150px;" placeholder="扫描起始单号"  maxlength="13"  >
						                                </td>
						                                <td>
						                                    <input type="text" id="txtEndNum" name="list[0].endNum" style="width:150px;" placeholder="扫描结束单号"  maxlength="13" >
						                                </td>
						                                <td width="90px;">
						                                    <input type="text" name="list[0].amount" style="width:80px;"  id="txtAmount"  placeholder="总单数"  maxlength="5" >
						                                </td>
														<td width="60px;"><input type="button" class="btn btn-xs btn-success" style="width:50px;" onclick="PAGE.addRow();" value="增加"></td>
						                            </tr>
						                            </tbody>
						                        </table>
						                    </div>
						                </li>
						        </section>

										<table class="table">

											<tr>
												<td style="width: 100px;border:0px;text-align:right;">总 计:</td>
												<td style="border:0px;">
													<input class="itl-input" type="text" id="hidBoxAmount"  style="width:50px;" name="billWarehouseInEntity.boxAmount" placeholder="0" >箱</td>
												<td>
													<input class="itl-input" type="text" id="hidAmount" style="width:100px;" name="billWarehouseInEntity.amount" placeholder="0" >单
												</td>
												<td style="width: 100px;border:0px;text-align:right;">单价：</td>
												<td style="border:0px;">
													<input class="itl-input" type="text" id="txtPrice" style="width:60px;" placeholder="单价" name="billWarehouseInEntity.price"  maxlength="3">元/单
												</td>
											</tr>
											<tr>

											</tr>
										</table>
						        
						                <li style="width: 100%">
						                    <span class="handle-last-right">
						                        <button class="btn btn-default" style="width: 100px;" onclick="PAGE.cancelInfo();">取消</button>
						                        <button class="btn btn-default" style="width: 100px;" onclick="PAGE.submitInfo();">确定入库</button>
						                    </span>
						                </li>
						            </ul>
							</form>
					    </div>
					</div>
				</div>


</div>


</body>
</html>