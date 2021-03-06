<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="utf-8"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="application/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="application/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js" type="application/javascript"></script>
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css" rel="stylesheet"type="text/css">
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/js/echarts.js"></script>

<title>Insert title here</title>
</head>
<body style="margin-top:80px">

 <div id="main" style="width: 1600px;height:800px;">
 
 </div>
  <script type="text/javascript">
  
 
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
      var colors = ['#5793f3', '#d14a61', '#675bba'];


      option = {
    		    title : {
    		        text: '某站点用户访问来源',
    		        subtext: '纯属虚构',
    		        x:'center'
    		    },
    		    tooltip : {
    		        trigger: 'item',
    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		    },
    		    legend: {
    		        orient: 'vertical',
    		        left: 'left',
    		        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    		    },
    		    series : [
    		        {
    		            name: '访问来源',
    		            type: 'pie',
    		            radius : '55%',
    		            center: ['50%', '60%'],
    		            data:[
    		                {value:335, name:'直接访问'},
    		                {value:310, name:'邮件营销'},
    		                {value:234, name:'联盟广告'},
    		                {value:135, name:'视频广告'},
    		                {value:1548, name:'搜索引擎'}
    		            ],
    		            itemStyle: {
    		                emphasis: {
    		                    shadowBlur: 10,
    		                    shadowOffsetX: 0,
    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    		                }
    		            }
    		        }
    		    ]
    		};

        

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

    </script>

</body>
</html>