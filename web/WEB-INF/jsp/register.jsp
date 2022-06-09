<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<html>
<head>
    <link rel="stylesheet" href="<%=path%>/css/usersLogin.css">
    <link rel="icon" href="<%=path%>/images/favicon.ico" sizes="32x32" />
    <script src="<%=path%>/js/jquery-1.3.2.min.js"></script>
    <script src="<%=path%>/js/login.js"></script>

    <title>注册</title>
</head>
<body>

<div class="body">
    <div class="panel">
        <div class="top">
            <p>注册</p>
        </div>

        <div class="middle1">
            <form action="<%=path%>/registerSub" method="post">
                <span class="erro">${msg}</span>
                <span class="s1"></span>
                <span class="s2"></span><br>
                <input type="text" name="username" placeholder="请输入用户名" value="" />
                <input type="password" name="password" placeholder="请输入密码" value=""/>
                <input type="text" name="phone" placeholder="请输入电话" style="padding-left: 40px;" value=""/>
                <div class="checkbox" style="margin-left: 30px;">
                    <label class="radio-inline">
                        <input type="radio" name="type" id="inlineRadio1" value="01"> 管理员
                    </label>&nbsp;&nbsp;
                    <label class="radio-inline">
                        <input type="radio" name="type" id="inlineRadio2" value="02"> 收费人员
                    </label>&nbsp;
                    <label class="radio-inline">
                        <input type="radio" name="type" id="inlineRadio3" value="03"> 医生
                    </label>&nbsp;
                </div>
                <input type="submit" value="注册"/>
            </form>
            <div style="text-align: center;text-align: center;font-size: smaller;">已经有账号？去<a href="<%=path%>/gologin" >登录</a></div>
        </div>
    </div>
</div>

</body>
</html>
