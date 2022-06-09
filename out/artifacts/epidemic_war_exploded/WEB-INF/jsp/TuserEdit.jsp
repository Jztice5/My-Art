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
       <a href="<%=path%>/findTuser">查询列表</a>
       <a href="">修改</a>
      </span>
</div>
<div class="x-body">
    <form class="layui-form"  id="f_auto" action="<%=path%>/updateTuser" method="post" >
        <input type="hidden" value="${tuser.id}" name="id" id="id"/>
        <div class="layui-form-item">
            <label for="type" class="layui-form-label">
                <span class="">人员类型</span>
            </label>
            <div class="layui-input-inline">
            <select name="type" id="type"  lay-verify="required">
                <option value="01">管理员</option>
                <option value="02">采购员</option>
                <option value="03">后勤处</option>
                <option value="04">财务处</option>
            </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="">用户名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" lay-verify="username"
                       autocomplete="off" value="${tuser.username}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="password" class="layui-form-label">
                <span class="">密码</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="password" name="password" lay-verify="password"
                       autocomplete="off" value="${tuser.password}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="sex" class="layui-form-label">
                <span class="">性别</span>
            </label>
            <div class="layui-input-inline">
                <select name="sex" id="sex"  lay-verify="required">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="">手机号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" lay-verify="phone"
                       autocomplete="off" value="${tuser.phone}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn layui-btn-sm" id="btn_on"  lay-submit="" lay-filter="updateClass">修改</button>
            <button  class="layui-btn layui-btn-sm" id="close">返回</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    $('#close').click(function() {
        window.location.href='<%=path%>/findTuser';
        return false;
    });

    $("#type").val('${tuser.type}');
    $("#sex").val('${tuser.sex}');

    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;
        form.verify({
            username: function (value, item) {
                //value：表单的值、item：表单的DOM对象
                if (!new RegExp("^(.+){4,18}$").test(value)) {
                    return '用户名长度必须为4-18位'
                }
                if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                    return '用户名不能有特殊字符';
                }
                if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if (/^\d+\d+\d$/.test(value)) {
                    return '用户名不能全为数字';
                }
            },
            password: [
                /^[\S]{6,18}$/,
                '密码必须6到12位，且不能出现空格'
            ]
        });
    });
</script>
</body>
</html>
