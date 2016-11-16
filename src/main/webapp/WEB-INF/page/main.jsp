<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link rel="shortcut icon" href="<c:url value="aps.ico"/>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理首页</title>


    <jsp:include page="./share/sea-require.jsp">
        <jsp:param name="module" value="pages/main/main"/>
    </jsp:include>

</head>
<body>
<div id="main" class="container-fluid">

    <jsp:include page="share/nav_main.jsp">
        <jsp:param name="nav" value="main"/>
    </jsp:include>

    <div id="main_content">
        <div id="main_navbar" class="page-header">
            <div class="main_navbar_title">
                <span class="glyphicon glyphicon-scale" aria-hidden="true"></span>
                我的工作台
            </div>

            <!-- <ul class="main_navbar_tab">
                <li class="current"><a href="#">我的任务 </a></li>
                <li><a href="#"  data-bind="text: personName">我的日程</a></li>
                <li><a class=""
                        href="javascript:void(0)" data-bind="click: add"><span
                            class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加角色</a></li>
                <li><a class=""
                        href="javascript:Main.showRightPanel({url:'sub',title:'添加角色',blurClose:false,width:500})"><span
                            class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加角色</a></li>

            </ul> -->

        </div>

        <div id="main_body" style="padding-top: 1.6em;">

            <div class="container-fluid">
                <div class="row text-center">
                    <div class="col-xs-3">
                        <div class="panel panel-danger">
                            <div class="panel-heading">面单类型</div>
                            <div class="panel-body">
                                <h3><a href="bill/type/list"> 启用: ${homeModel.billTypeUsableCount} | 停用: ${homeModel.billTypeUnusableCount}</a></h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <div class="panel panel-success">
                            <div class="panel-heading">城市区号</div>
                            <div class="panel-body">
                                <h3><a href="/bill/district">启用:${homeModel.districtUsableCount} | 停用:${homeModel.districtUnusableCount}</a></h3></div>
                        </div></div>
                    <div class="col-xs-3">
                        <div class="panel panel-info">
                            <div class="panel-heading">初始化单量</div>
                            <div class="panel-body">
                                <h3><a href="/billinit/list">${homeModel.billInitCount}</a></h3></div>
                        </div></div>
                    <div class="col-xs-3">
                        <div class="panel panel-warning">
                            <div class="panel-heading">已出库单量</div>
                            <div class="panel-body">
                                <h3><a href="/bill/out">${homeModel.warehouseOutCount}</a></h3></div>
                        </div></div>
                </div>

            </div>

        </div>
    </div>
</div>
</body>
</html>