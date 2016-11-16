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
	<jsp:param name="module" value="pages/billapprove/out" />
</jsp:include>
</head>
<body>
<div id="main" class="container-fluid">

		<div id="main_content">
					<div class="m-d-y-w-w-h-ct">
					    <div class="m-d-z-z-m" style="border:0px;">
					         <h3><label class="label label-info">整箱出库</label></h3>
					    </div>
					    <div class="m-d-z-z-t">
						            <ul class="m-d-y-w-w-h-ct-p" style="border-bottom: none">
						            
					    			<form method="post" id="boxForm">
					    				<table class="table">
					    					<tr>
					    						<td style="width: 100px;border:0px;text-align:right;">申请编号:</td>
					    						<td style="border:0px;"> ${approve.id}
					    							<input type="hidden" value="${approve.id}" name="approveId"/>
					    						</td>
					    					</tr>
					    					<tr>
					    						<td style="width: 100px;border:0px;text-align:right;">出库到:</td>
					    						<td style="border:0px;"> ${approve.bigAreaName }</td>
					    					</tr>
					    					<tr>
					    						<td style="width: 100px;border:0px;text-align:right;">总 计:</td>
					    						<td style="border:0px;"> 
													<input class="itl-input" type="hidden" readonly="readonly" id="hidBoxAmount" name="boxAmount" placeholder="0"   onkeyup="this.value=this.value.replace(/\D/g,'')">
						                       		 <span id="txtBoxAmount">0</span>		箱
						                       		 <input class="itl-input" type="hidden" id="hidAmount" readonly="readonly" name="amount" placeholder="0"  onkeyup="this.value=this.value.replace(/\D/g,'')">
						                        <span id="txtAmount">0</span>	单
												</td>
												<td style="width: 100px;border:0px;text-align:right;">单价：</td>
					    						<td style="border:0px;"> 
													<input class="itl-input" type="text" id="txtPrice" placeholder="请输入单价" name="price" onkeyup="PAGE.validatePrice(this);" maxlength="8">元/单
												</td>
					    					</tr>
					    					<tr>
					    						
					    					</tr>
					    				</table>
					    			 
						               
						        <input type="hidden" id="hidBillFaceNumStr" name="billFaceNumStr" value=""/>
						        <input type="hidden" id="hidOutType" name="outType" value="${outType}"/>
					          
						               
<div id="hidDiv" style="display:none;">
	<table class="table">
		<tr>
			<td style="width:150px;border:0px;">是否走物流配送</td>
			<td>
				<input type="radio" name="expressSend" value="0" checked="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="expressSend" value="1" />否
			</td>
		</tr>
		<tr>
			<td colspan="2" style="border:0px;">
				<input type="text" name="expressName" class="form-control" placeholder="请输入快递公司"/>
			</td>
			
		</tr>
	
		<tr>
			<td colspan="2" style="border:0px;"><input type="text" class="form-control" name="expressNo" placeholder="请输入快递单号"/></td>
		</tr>
		
		<tr>
			<td colspan="2" style="border:0px;"><h4>补充备注:</h4></td>
		</tr>
		
		<tr>
			<td colspan="2" style="border:0px;"><input type="text" name="remark" class="form-control" placeholder="请输入补充备注"/></td>
		</tr>
		
		<tr>
			<td colspan="2" style="border:0px;text-align:center;"><input onclick="PAGE.cancelOut();" type="button" value="取消" class="btn btn-default" style="width:80px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="确定"  class="btn btn-default" style="width:80px;" onclick="PAGE.confirmSubmitInfo();"/></td>
		</tr>
	</table>
</div>
						                
							</form> 
						        <section  id="z_x_c_k_s" class="active">
						                <li style="width: 100%">
						                    <div class="z-z-md-1" style="height: 200px;">
						                        <table class="itl-table"  id="z_x_c_k_l_table">
						                            <tbody>
						                            <tr>
						                                <td>
						                                    <input type="text" id="txtStartNum" placeholder="扫描起始单号"  maxlength="13" onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" id="txtEndNum" placeholder="扫描结束单号"  maxlength="13"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" alt="txtAmount" disabled="disabled" placeholder="总单数"  maxlength="5"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						
						                            </tr>
						                            <tr>
						                            	 <td>
						                                    <input type="text" id="txtStartNum" placeholder="扫描起始单号"  maxlength="13" onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" id="txtEndNum" placeholder="扫描结束单号"  maxlength="13"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" alt="txtAmount" disabled="disabled" placeholder="总单数"  maxlength="5"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						
						                            </tr>
						                            <tr>
						                            	 <td>
						                                    <input type="text" id="txtStartNum" placeholder="扫描起始单号"  maxlength="13" onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" id="txtEndNum" placeholder="扫描结束单号"  maxlength="13"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" alt="txtAmount" disabled="disabled" placeholder="总单数"  maxlength="5"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						
						                            </tr>
						                            <tr>
						                            	 <td>
						                                    <input type="text" id="txtStartNum" placeholder="扫描起始单号"  maxlength="13" onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" id="txtEndNum" placeholder="扫描结束单号"  maxlength="13"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						                                <td>
						                                    <input type="text" alt="txtAmount" disabled="disabled" placeholder="总单数"  maxlength="5"  onkeyup="PAGE.validateNum(this);">
						                                </td>
						                            </tr>
						                            </tbody>
						                        </table>
						                    </div>
						                </li>
						        </section>
						        
						                <li style="width: 100%">
						                    <span class="handle-last-right">
						                        <button class="btn btn-default" style="width: 100px;" onclick="PAGE.cancelInfo();">取消</button>
						                        <button class="btn btn-default" style="width: 100px;" onclick="return PAGE.submitInfo();">确定出库</button>
						                    </span>
						                </li>
						            </ul>
					        
					    </div>
					</div>
				</div>


</div>


</body>
</html>