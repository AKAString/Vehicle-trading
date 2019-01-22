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
<script type="text/javascript">
$(function(){
$.ajax({url:"",success:function(msg){
	
}
	
})	
	
})
</script>
<title>Insert title here</title>
</head>
<body style="margin-top:80px">

 <div id="main" style="width: 1600px;height:800px;">
 
 </div>
  <script type="text/javascript">
  
  $(function fun(x1,x2,y1,y2){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
      var colors = ['#5793f3', '#d14a61', '#675bba'];


option = {
    color: colors,

    tooltip: {
        trigger: 'none',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data:['2017 销售量', '2018 销售量']
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[1]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '销售量  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: x2
        },
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[0]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '销售量  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: x1
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name:'2017 销售量',
            type:'line',
            xAxisIndex: 1,
            smooth: true,
            data: y1
        },
        {
            name:'2018 销售量',
            type:'line',
            smooth: true,
            data: y2
        }
    ]
};
        

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        $(function(){
        $.ajax({url:"${pageContext.request.contextPath}/vehicle/getVehicle.do",success:function(msg){
        	fun(msg.xAxisIndex2017, msg.xAxisIndex2018, msg.axisPointer2017, msg.axisPointer2018)
        }
        })	
        	
        })
        
  })
    </script>

</body>
</html>