<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.ssm.mty.po.Taccount" %>
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
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.3.2.min.js"></script>
    <script src="<%=path%>/js/echarts.min.js"></script>
    <script src="<%=path%>/lib/layui/layui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <script src="<%=path%>/layui_exts/excel.js"></script>
    <style>
        .box {
            display: flex;
            flex-wrap: wrap;
            align-content: space-between;
        }

        .column {
            flex-basis: 100%;
            display: flex;
            justify-content: flex-start;
        }
    </style>
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
       <a href="">首页</a>
        <a href="<%=path%>/findDoc">物资统计</a>
      </span>
    <a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="<%=path%>/findDoc" title="刷新">
        <i class="layui-icon" style="line-height:30px">&#xe669;</i></a>
</div>

<div class="box">
    <div class="column">
        <span id="chart" style="width:500px;height:500px;margin: 40px;"></span>
        <span id="chart1" style="width:500px;height:500px;margin: 40px;"></span>
    </div>
</div>
<script type="text/javascript">
    // 初始化图表标签
    debugger
    var nameArr = ${nameArr};
    var valueArr = ${valueArr};
    var nameArr1 = ${nameArr1};
    var valueArr1 = ${valueArr1};
    var myChart = echarts.init(document.getElementById('chart'));
    var myChart1 = echarts.init(document.getElementById('chart1'));
    var options={
        //定义一个标题
        title:{
            text:'采购物资分类统计'
        },
        legend:{
            data:['物资分类个数']
        },
        //X轴设置
        xAxis:{
            data: nameArr
        },
        yAxis:{
        },
        //name=legend.data的时候才能显示图例
        series:[{
            name:'物资分类个数',
            type:'bar',
            data: valueArr
        }]

    };
    var options1={
        //定义一个标题
        title:{
            text:'入库物资分类统计'
        },
        legend:{
            data:['物资数量']
        },
        //X轴设置
        xAxis:{
            data: nameArr1
        },
        yAxis:{
        },
        series:[{
            name:'物资数量',
            type:'bar',
            data: valueArr1
        }]

    };
    myChart.setOption(options);
    myChart1.setOption(options1);
</script>
</body>
</html>
