<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.ssm.mty.po.Tpurchase" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<html>
<head>
    <title>epidemic</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="icon" href="<%=path%>/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.3.2.min.js"></script>
    <script src="<%=path%>/lib/layui/layui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <script src="<%=path%>/layui_exts/excel.js"></script>
    <style type="text/css">
        .layui-table{
            text-align: center;
        }
        .layui-table th{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
       <a href="">首页</a>
        <a href="<%=path%>/findTpurchase">查询列表</a>
      </span>
    <a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="<%=path%>/findTpurchase" title="刷新">
        <i class="layui-icon" style="line-height:30px">&#xe669;</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="<%=path%>/findTpurchase" >
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="5">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">物资分类</label>
                    <div class="layui-input-block">
                        <select name="category">
                            <option value="" selected>请选择</option>
                            <c:forEach items="${allCategory}" var="c">
                                <option value="${c.code}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">物品名称</label>
                    <div class="layui-input-block">
                        <input class="layui-input" type="text" name="material">
                    </div>
                </div>

                <button class="layui-btn layui-btn-sm"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
            </div>
        </form>
    </div>
    <c:if test="${sessionScope.type == '02'}">
    <xblock>
        <button id="addTpurchaseBtn" class="layui-btn layui-btn-sm"> <i class="layui-icon">&#xe654;</i>创建采购计划 </button>
        <span class="x-right" style="line-height:40px">共有数据：${pageList.totalCount} 条</span>
    </xblock>
    </c:if>

    <%--表格数据--%>
    <table class="layui-table">
        <thead>
        <tr>
             <th>物资分类</th>
             <th>物品名称</th>
             <th>数量</th>
             <th>单价</th>
             <th>采购时间</th>
             <th>采购人员</th>
            <c:if test="${sessionScope.type == '02'}">
                <th>操作</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageList.list}" var="di">
            <tr>
                  <th>${di.category}</th>
                  <th>${di.material}</th>
                  <th>${di.quantity}</th>
                  <th>${di.unitPrice}</th>
                  <th>${di.purseTime}</th>
                  <th>${di.purseId}</th>
                  <c:if test="${sessionScope.type == '02'}">
                      <td>
                      <c:if test="${sessionScope.ad.username == di.purseId}">
                          <a title="编辑" id= "updateEdit" href="<%=path%>/findTpurchaseById?id=${di.id}">
                              <i class="layui-icon">&#xe642;</i>
                          </a>
                          <a title="删除" onclick="member_del(this,'${di.id}')" href="javascript:;">
                              <i class="layui-icon">&#xe640;</i>
                          </a>
                      </c:if>
                      <c:if test="${sessionScope.ad.username != di.purseId}">
                          <a title="" href="javascript:;" >
                              <i class="layui-icon">&#xe642;</i>
                          </a>
                          <a title="" href="javascript:;">
                              <i class="layui-icon">&#xe640;</i>
                          </a>
                      </c:if>
                      </td>
                  </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="" >
        <input type="hidden" id="totalPageCount" value="${pageList.pageTotalCount}"/>
        <c:import url="pageBtn.jsp">
            <c:param name="totalCount" value="${pageList.totalCount}"/>
            <c:param name="currentPageNo" value="${pageList.pageIndex}"/>
            <c:param name="totalPageCount" value="${pageList.pageTotalCount}"/>
        </c:import>
    </div>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addTpurchaseForm">
                <div style="margin-top: 20px;"></div>
                <div class="layui-form-item">
                    <label class="layui-form-label">物资分类：</label>
                    <div class="layui-input-block">
                        <select name="category" id="category"  lay-verify="required">
                            <c:forEach items="${allCategory}" var="c">
                              <option value="${c.code}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">物品名称：</label>
                    <div class="layui-input-block">
                        <input type="text" name="material" lay-verify="required" class="layui-input" placeholder="">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">数量：</label>
                    <div class="layui-input-block">
                        <input type="text" name="quantity" lay-verify="number" class="layui-input" placeholder="">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单价：</label>
                    <div class="layui-input-block">
                        <input type="text" name="unitPrice" lay-verify="money" class="layui-input" placeholder="">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">采购时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="purseTime" id="purseTime" lay-verify="required" class="layui-input" placeholder="">
                    </div>
                </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
             </form>
        </div>
    </div>

    <script>
        window.jQuery= layui.$;
        layui.config({
            base: 'layui_exts/',
        }).extend({
            excel: 'excel',
        });

        layui.use(['jquery', 'excel','form','layer','laydate'], function(){
            var form = layui.form,
                $ = layui.jquery,
                laydate = layui.laydate;
            var excel = parent.layui.excel;


            /*添加弹出框*/
            $("#addTpurchaseBtn").click(function () {

                laydatess = layui.laydate;
                layer.open({
                    type:1,
                    title:"添加",
                    skin:"myclass",
                    area:["50%"],
                    anim:2,
                    content:$("#test"),
                    success: function(layero, index) { laydate.render({ elem: '#purseTime',trigger: 'click', type: 'datetime',format: 'yyyy-MM-dd HH:mm:ss' }); }
                });
                $("#addTpurchaseForm")[0].reset();
                form.on('submit(formDemo)', function(data) {
                    var param=data.field;
                    $.ajax({
                        url: '<%=path%>/addTpurchase',
                        type: "post",
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8",
                        success:function(){
                            layer.msg('添加成功', {icon: 1, time: 3000});
                            setTimeout(function () {window.location.href='<%=path%>/findTpurchase';},2000);

                        },
                        error:function(){
                            layer.msg('添加失败',{icon:0,time:3000});
                            setTimeout(function () {window.location.href='<%=path%>/findTpurchase';},2000);
                        }
                    });
                    // return false;
                });
            });

        });

        layui.use(['layer', 'form'], function () {
            var form = layui.form;
            form.verify({
                password: [
                    /^[\S]{6,18}$/,
                    '密码必须6到12位，且不能出现空格'
                ],
                money: [
                    /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
                    '金额格式有误'
                ]
            });
        });

        /*删除*/
        function member_del(obj,id){
            layer.confirm('确认要删除吗？',function(index){
                //发异步删除数据
                $.get("<%=path%>/deleteTpurchase",{"id":id},function (data) {
                    if(data =true){
                        layer.msg('删除成功!',{icon:1,time:2000});
                        setTimeout(function () {window.location.href='<%=path%>/findTpurchase';},2000);

                    }else {
                        layer.msg('删除失败!',{icon:1,time:2000});
                        setTimeout(function () {window.location.href='<%=path%>/findTpurchase';},2000);
                    }
                });
            });
        }

    </script>
</body>
</html>
