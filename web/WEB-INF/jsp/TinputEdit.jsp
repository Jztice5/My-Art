<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="<%=path%>/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <link rel="stylesheet" href="<%=path%>/css/pg_btn.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.3.2.min.js"></script>
    <script src="<%=path%>/lib/layui/layui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <style>
        .layui-form-item .layui-input-inline {
            width: 400px !important;
        }
    </style>
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
       <a href="">首页</a>
       <a href="<%=path%>/findTinput">查询列表</a>
       <a href="">修改</a>
      </span>
</div>
<div class="x-body">
    <form class="layui-form"  id="f_auto" action="<%=path%>/updateTinput" method="post" >
        <input type="hidden" value="${tinput.id}" name="id" id="id"/>

        <div class="layui-form-item">
            <label for="category" class="layui-form-label">
                <span class="">物资分类</span>
            </label>
            <div class="layui-input-inline">
                <select name="category" id="category"  lay-verify="required">
                    <c:forEach items="${allCategory}" var="c">
                        <option value="${c.code}">${c.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label for="material" class="layui-form-label">
                <span class="">物品名称</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="material" name="material" lay-verify="required"
                       autocomplete="off" value="${tinput.material}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="quantity" class="layui-form-label">
                <span class="">数量</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="quantity" name="quantity" lay-verify="number"
                       autocomplete="off" value="${tinput.quantity}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="money" class="layui-form-label">
                <span class="">单价</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="money" name="money" lay-verify="money"
                       autocomplete="off" value="${tinput.money}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="purseTime" class="layui-form-label">
                <span class="">采购时间</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="purseTime" name="purseTime" lay-verify="required"
                       autocomplete="off" value="${tinput.purseTime}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="purseId" class="layui-form-label">
                <span class="">采购人员</span>
            </label>
            <div class="layui-input-inline">
                <select name="purseId" id="purseId"  lay-verify="required">
                    <c:forEach items="${userByType}" var="c">
                        <option value="${c.id}">${c.username}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn layui-btn-sm" id="btn_on"  lay-submit="" lay-filter="updateClass">修改</button>
            <button  class="layui-btn layui-btn-sm" id="close">返回</button>
        </div>
    </form>
</div>
<script>
    window.jQuery= layui.$;
    $('#close').click(function() {
        window.location.href='<%=path%>/findTinput';
        return false;
    });

    layui.use(['layer', 'form'], function () {
        var form = layui.form;
        form.verify({
            money: [
                /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
                '金额格式有误'
            ]
        });
    });
    $("#category").val('${tinput.category}');
    $("#purseId").val('${tinput.purseId}');

    layui.use(['jquery','form','layer','laydate'], function() {
        var laydate = layui.laydate;
        laydate.render({elem: '#purseTime', trigger: 'click', type: 'datetime', format: 'yyyy-MM-dd HH:mm:ss'});
    });
</script>
</body>
</html>
