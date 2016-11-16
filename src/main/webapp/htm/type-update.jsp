<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>面单管理-新增</title>
    <link href="../css/index.css" rel="stylesheet">
    <script type="text/javascript" src="../sea-modules/sea.js"></script>
	<script type="text/javascript" src="../sea-modules/sea-config.js"></script>
</head>
<body>

<header class="m-d-y-w-w-h">
    <span>面单类型-新增</span>
</header>
<div class="m-d-y-w-w-h-ct">
<form action="/billtype/saveOrUpdate"  method="post" enctype="multipart/form-data" >

            <ul class="m-d-y-w-w-h-ct-p u-d-t">
                <li>
                     <label class="itl-lb lb">面单业务类型：</label>
                    <span class="ip">
                         <input name="businessName" class="itl-input" type="text" placeholder="请选择页面代码">
                    </span>
                </li>
                <li>
                    <label class="itl-lb lb">面单代码：</label>
                    <span class="ip">
                         <input name="billCode" class="itl-input" type="text" placeholder="请选择页面代码">
                    </span>
                </li>

 				<li>
                    <label class="itl-lb lb">版本号：</label>
                    <span class="ip">
                        <input name="version" class="itl-input" type="text" placeholder="请输入版本号">
                    </span>
                </li>
                <li>
                    <label class="itl-lb lb">面单第一联颜色值：</label>
                    <span class="ip">
                        <input name="color" class="itl-input" type="text" placeholder="请输入版本号">
                    </span>
                </li>
                  <li>
                    <label class="lb itl-lb">面单模板：</label>
                    <span class="ip">
                        <input name="picture" class="itl-input" type="file">
                        <span>请选.jpg或.png文件</span>
                    </span>
                  <label class="lb itl-lb"></label>
                    <span class="ip">
                        <input name="compress" class="itl-input" type="file">
                        <span>请选择.psd文件</span>
                    </span>
                </li>
                 <li>
                    <label class="itl-lb lb">状态：</label>
                    <span class="ip">
                        <input value="1" name="status" class="itl-input" type="radio"  id="test">
                        <label for="test">正常</label>
                        <input value="2" name="status" class="itl-input" type="radio"  id="test1">
                        <label for="test1">停用</label>
                    </span>
                </li>
                <li>
                    <span class="handle-last-right">
                        <button type="submit" class="itl-btn">保存</button>
                        <button class="itl-btn">取消</button>
                    </span>
                </li>
            </ul>
 </form>
</div>
<script type="text/javascript">
	seajs.use("../js/miandan/mian_type_update");
</script>
</body>
</html>