<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>纸质面单</title>
    <link href="../css/index.css" rel="stylesheet">
    <script type="text/javascript" src="../sea-modules/sea.js"/></script>
	<script type="text/javascript" src="../sea-modules/sea-config.js"/></script>
</head>
<body>

<header class="m-d-y-w-w-h">
    <span>纸质面单操作</span>
</header>
<div class="m-d-y-w-w-h-ct">
    <div class="m-d-z-z-m">
        <a class="active" id="z_x_c_k" >整箱出库</a>
        <a id="s_j_c_k">散件出库</a>
    </div>
    <div class="m-d-z-z-t">
        <section  id="z_x_c_k_s" class="active">
            <ul class="m-d-y-w-w-h-ct-p" style="border-bottom: none">
                <li class="c-d-k">
                    <label class="itl-lb lb">出库到：</label>
                    <span class="ip">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                    </span>
                    <div class="location-city-data" id="location_city_data">
                        <span class="ip">
                         <select class="itl-input"></select>
                        </span>
                        <span class="ip">
                         <select class="itl-input"></select>
                        </span>
                        <span class="ip">
                         <select class="itl-input"></select>
                        </span>
                    </div>
                    <span class="ip" style="margin-left: 30px">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                    </span>
                </li>
                <li style="width: 50%">
                    <label class="itl-lb lb">总计：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">箱
                    </span>

                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">单
                    </span>
                </li>
                <li style="width: 40%">

                    <label class="itl-lb lb">单价：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">元/单
                    </span>
                </li>

                <li style="width: 100%">
                    <div class="z-z-md-1">
                        <table class="itl-table"  id="z_x_c_k_l_table">
                            <tbody>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr><tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            </tbody>
                        </table>
                    </div>

                </li>
                <li style="width: 100%">
                    <span class="handle-last-right">
                        <button class="itl-btn">取消</button>
                        <button class="itl-btn">确定出库</button>
                    </span>
                </li>
            </ul>
        </section>
        <section class="" id="s_j_c_k_s">
            <ul class="m-d-y-w-w-h-ct-p" style="border-bottom: none">
                <li class="c-d-k">
                    <label class="itl-lb lb">出库到：</label>
                    <span class="ip">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                    </span>
                    <div class="location-city-data" >
                        <span class="ip">
                         <select class="itl-input">
                             
                         </select>
                        </span>
                        <span class="ip">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                        </span>
                        <span class="ip">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                        </span>
                    </div>
                    
                    <span class="ip" style="margin-left: 30px">
                         <select class="itl-input">
                             <option>asdf</option>
                             <option>asdf</option>
                             <option>这个值有可能很长</option>
                             <option>asdf</option>
                         </select>
                    </span>
                </li>
                <li style="width: 50%">
                    <label class="itl-lb lb">总计：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">箱
                    </span>

                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">单
                    </span>
                </li>
                <li style="width: 40%">

                    <label class="itl-lb lb">单价：</label>
                    <span class="ip">
                        <input class="itl-input" type="text" placeholder="请选择页面代码">元/单
                    </span>
                </li>

                <li style="width: 100%">
                    <div class="z-z-md-1">
                        <table class="itl-table"  >
                            <tbody>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr><tr>
                                <td>
                                    <input type="text" placeholder="扫描起始单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="扫描结束单号">
                                </td>
                                <td>
                                    <input type="text" placeholder="总单数">
                                </td>

                            </tr>
                            </tbody>
                        </table>
                    </div>

                </li>
                <li style="width: 100%">
                    <span class="handle-last-right">
                        <button class="itl-btn">取消</button>
                        <button class="itl-btn">确定出库</button>
                    </span>
                </li>
            </ul>
        </section>
    </div>
</div>

<script type="text/javascript"/>
	seajs.use("../js/miandan/mian_zhi_zhi");
</script>
</body>
</html>