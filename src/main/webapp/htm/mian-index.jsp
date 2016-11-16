<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>面单管理</title>
    <link href="../css/index.css" rel="stylesheet">
    <script type="text/javascript" src="../sea-modules/sea.js"/></script>
	<script type="text/javascript" src="../sea-modules/sea-config.js"/></script>
</head>
<body>
<header class="m-d-y-w-w-h">
    <span>面单类型维护</span>
</header>
<div class="m-d-y-w-w-h-ct">

            <ul class="m-d-y-w-w-h-ct-p"> 
                <li>
                    <label class="itl-lb lb"></label>
                    <span class="ip">

                    </span>
                </li>
                <li>
                    <label class="lb"> </label>
                    <span class="ip"></span>
                </li>
                <li>
                    <span class="handle-last-right">

                        <button class="itl-btn" onclick="window.location.href='type-update.jsp'">新增</button>
                    </span>
                </li>
            </ul>
    <table class="itl-table" id="tb_list_type">
        <thead>
            <tr>
                <th>面单业务类型</th>
                <th>面单代码</th>
                <th>版本号</th>
                <th>面单第一联颜色属性
                    	(用拾色器选择颜色)
                </th>
                <th>状态</th>
                <th>模板</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <!--  
            <tr>
                <td>普通快递、如风达到</td>
                <td>1</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>校园快递</td>
                <td>2</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>菜鸟裹裹</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>贵品</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>普通订单</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>上门退货单、上门换货单</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>
                <td>正常</td>
                <td>
                    <a href="#">查看</a>
                    <a href="#">下载</a>
                </td>
                <td><a href="#">修改</a></td>
            </tr> -->
        </tbody>
    </table>


</div>
<script type="text/javascript"/>
	seajs.use("../js/miandan/mian_type" , function(mian_type){});
</script>
</body>
</html>