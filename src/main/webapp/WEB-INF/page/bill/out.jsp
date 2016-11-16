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
	<jsp:param name="module" value="pages/bill/out" />
</jsp:include>
</head>
<body>
<div id="main" class="container-fluid">
		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_out" />
		</jsp:include>

		<div id="main_content">
					<header class="m-d-y-w-w-h">
					    <span>纸质面单操作</span>
					</header>
					<div class="m-d-y-w-w-h-ct">
					    <div class="m-d-z-z-m">
					        <a class="active" id="z_x_c_k" >整箱出库</a>
					        <a id="p_l_c_k">批量出库</a>
					        <a id="s_j_c_k">散件出库</a>
					    </div>
					    <div class="m-d-z-z-t">
						            <ul class="m-d-y-w-w-h-ct-p" style="border-bottom: none">
						            
					    			<form method="post" id="boxForm">
						                <li class="c-d-k">
						                    <label class="itl-lb lb">出库到：</label>
						                    <span class="ip">
						                         <select class="js-example-basic-single js-states  form-control input-sm" name="stationId">
						                             <c:if test="${departmentTypeList != null && departmentTypeList.size() > 0 }">
														<c:forEach var="departmentType" items="${departmentTypeList}">
															<option value="${departmentType.id}">${departmentType.value}</option>
														</c:forEach>
														
													</c:if>
						                         </select>
						                    </span>
						                    <style>
						                    	.select2-container{width:130px !important;}
						                    	.lb ,.ip{float: left;margin-right: 10px;}
						                    </style>
						                    <div  style="float:left" id="location_city_data">
						                        <span class="ip">
						                         <select class="js-example-basic-single js-states  form-control" name="provinceId">
						                         <!-- <option value="">--请选择省--</option> -->
						                         </select>
						                        </span>
						                        <span class="ip">
						                         <select class="js-example-basic-single js-states  form-control input-sm" name="cityId">
						                         <!-- <option value="">--请选择市--</option> -->
						                         </select>
						                        </span>
						                        <span class="ip">
						                         <select class="js-example-basic-single js-states  form-control input-sm" name="areaId">
						                         	<!-- <option value="">--请选择区县--</option> -->
						                         </select>
						                        </span>
						                    </div>
						                    <span class="ip" >
						                         <select class="js-example-basic-single js-states  form-control input-sm" name="stationTypeId">
						                            <!-- <option value="">--请选择站点--</option> -->
						                         </select>
						                    </span>
						                </li>
						          <input type="hidden" id="hidStation" name="station" value="自建配送站"/>
						          <input type="hidden" id="hidStationTypeName" name="stationTypeName" value=""/>
						          <input type="hidden" id="hidProvince" name="province" value=""/>
						          
						          <input type="hidden" id="hidCity" name="city" value=""/>
						          <input type="hidden" id="hidArea" name="area" value=""/>  
						        <input type="hidden" id="hidBillFaceNumStr" name="billFaceNumStr" value=""/>
						        <input type="hidden" id="hidOutType" name="outType" value="${outType}"/>
					          
						                <li style="width: 50%">
						                    <label class="itl-lb lb">总计：</label>
						                    <span class="ip" id="spanBox">
						                        <input class="itl-input" type="text" readonly="readonly" id="txtBoxAmount" name="boxAmount" placeholder="0"   onkeyup="this.value=this.value.replace(/\D/g,'')">箱
						                    </span>
						
						                    <span class="ip">
						                        <input class="itl-input" type="text" id="txtAmount" readonly="readonly" name="amount" placeholder="0"  onkeyup="this.value=this.value.replace(/\D/g,'')">单
						                    </span>
						                </li>
						                <li style="width: 40%">
						
						                    <label class="itl-lb lb">单价：</label>
						                    <span class="ip">
						                        <input class="itl-input" type="text" id="txtPrice" placeholder="请输入单价" name="price" onkeyup="PAGE.validatePrice(this);" maxlength="8">元/单
						                    </span>
						                </li>
						                <li style="width: 100%">
						
						                    <label class="itl-lb lb">历史单:</label>
						                    <span class="ip">
						                        <input type="checkbox" class="itl-input" id="chkHistory"/>
						                    </span>
						                </li>
							</form> 
						        <section  id="z_x_c_k_s" class="active">
						                <li style="width: 100%">
						                    <div class="z-z-md-1">
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
						         <section class="" id="p_l_c_k_s">
							                <li style="width: 100%">
							                    <div class="z-z-md-1">
							                        <table class="itl-table"  id="messyTable">
							                            <tbody>
							                            <tr>
							                                <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                           <tr>
							                                 <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                            <tr>
							                                 <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                            </tr>
							                            <tr>
							                                <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                            </tbody>
							                        </table>
							                    </div>
							
							                </li>
							        </section>
							        <section class="" id="s_j_c_k_s">
							                <li style="width: 100%">
							                    <div class="z-z-md-1">
							                        <table class="itl-table"  id="messyTable">
							                            <tbody>
							                            <tr>
							                                <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                           <tr>
							                                 <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                            <tr>
							                                 <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                            </tr>
							                            <tr>
							                                <td>
							                                    <input type="text" id="oneNum" placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="twoNum"  placeholder="请扫描单号"  maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							                                <td>
							                                    <input type="text" id="threeNum"  placeholder="请扫描单号" maxlength="13"  onkeyup="PAGE.validateMessyNum(this);">
							                                </td>
							
							                            </tr>
							                            </tbody>
							                        </table>
							                    </div>
							
							                </li>
							        </section>
						                <li style="width: 100%">
						                    <span class="handle-last-right">
						                        <button class="itl-btn" onclick="PAGE.cancelInfo();">取消</button>
						                        <button class="itl-btn" onclick="return PAGE.submitInfo();">确定出库</button>
						                    </span>
						                </li>
						            </ul>
					        
					    </div>
					</div>
					<input type="hidden" id="hidIsSuccess"  value="${isSuccess}"/>
				</div>
</div>
<script type="text/javascript"/>
	<%-- seajs.use("${ctx}/js/miandan/mian_zhi_zhi"); --%>
</script>
</body>
</html>