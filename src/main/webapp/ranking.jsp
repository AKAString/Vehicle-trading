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
<body style="margin-top:80px;margin-left: 80px">
<!-- <table class="table table-striped" id="tb">
		<thead>
			<tr>
				<td>省份</td>
				<td>数量</td>
				
			</tr>
		</thead>		
		
	</table> -->


 <div id="main" style="width: 1000px;height:1000px;">
 
 </div>
  <script type="text/javascript">
  $(function fun(y,d){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
     

 option = {
    title: {
        text: '全国各销售省份排名',
        subtext: '数据来自mysql'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: '2018年'
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: y
    },
    series: 
        {
            name: '2018年',
            type: 'bar',
            data: d
        }
      
    
};
        

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
     
        	  $(function(){
        		  $.ajax({url:"${pageContext.request.contextPath}/vehicle/getRabking.do",success:function(msg){
        		  	
        		  	fun(msg.yAxis,msg.series);
        		  	/* for(i=0;i<msg.rankings.length;i++){
        		  		
        		  		var tr="<tr><td>"+msg.rankings[i].province+"</td><td>"+msg.rankings[i].dealcount+"</td></tr>";
        				$("#tb").append(tr);
        		  	} */
        		  }
        		  	
        		  })	
        		  	
        		  })
  })
    </script>

</body>
</html>