<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>面单区号</title>
    <link href="../css/index.css" rel="stylesheet">
</head>
<body>

<header class="m-d-y-w-w-h">
    <span>面单区号管理</span>
</header>
<div class="m-d-y-w-w-h-ct">

            <ul class="m-d-y-w-w-h-ct-p">
                <li>
                    <label class="itl-lb lb">省份：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">
                    </span>
                </li>
                <li>
                    <label class="itl-lb lb">城市：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">
                    </span>
                </li>

                <li>
                    <label class="itl-lb lb">状态:</label>
                    <span class="ip">
                        <input class="itl-input" type="radio" name="test" id="test">
                        <label for="test">正常</label>
                        <input class="itl-input" type="radio" name="test" id="test1">
                        <label for="test1">停用</label>
                    </span>
                </li>
                <li>
                    <label class="itl-lb lb">上传模板：</label>
                    <span class="ip">
                        <input class="itl-input" style="width: 140px" type="file" placeholder="请输入版本号">
                        <button class="itl-btn">上传</button>
                    </span>
                </li>
                <li >
                    <span  style="padding-left:10px"></span>

                    <button class="itl-btn">导入模板</button>
                    <button class="itl-btn">导入详情</button>
                </li>
                <li>
                    <span class="handle-last-right">
                        <button class="itl-btn">查询</button>
                        <button class="itl-btn">新增</button>
                    </span>
                </li>
            </ul>
    <table class="itl-table">
        <thead>
            <tr>
                <th>省份</th>
                <th>城市/区县</th>
                <th>区号</th>
                <th>区号代码</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>普通快递、如风达到</td>
                <td>1</td>
                <td>201601-1</td>
                <td>赤</td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>校园快递</td>
                <td>2</td>
                <td>201601-1</td>
                <td>赤</td>
                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>菜鸟裹裹</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>

                <td><a href="#">修改</a></td>
            </tr>
            <tr>
                <td>贵品</td>
                <td>3</td>
                <td>201601-1</td>
                <td>赤</td>

                <td><a href="#">修改</a></td>
            </tr>

        </tbody>
    </table>


</div>
</body>
</html>