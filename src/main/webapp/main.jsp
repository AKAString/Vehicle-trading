<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="js/jquery.min.js"  type="application/javascript"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <link href="css/dashboard.css" rel="stylesheet" type="text/css">
</head>
<body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">信息可视化</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">流量数据<span class="sr-only">(current)</span></a></li>
            <li><a href="${pageContext.request.contextPath}/ranking.jsp" target="main">全国各销售省份排名</a></li>
            <li><a href="${pageContext.request.contextPath}/vehicle.jsp" target="main">交易量同期对比</a></li>
            <li><a href="${pageContext.request.contextPath}/price.jsp" target="main">价格空间占比</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         <iframe width="100%" height="100%" name="main" style="border-style: none;">
         
         </iframe>
        </div>
      </div>
    </div>
    
</body>
</html>