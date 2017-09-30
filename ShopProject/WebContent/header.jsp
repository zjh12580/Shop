<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        
<!DOCTYPE html>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>

<script type="text/javascript">

</script>

<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
				<c:if test="${empty user }">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
			<c:if test="${!empty user }">
				<li style="color:red">欢迎您，${user.username }</li>
				<li><a href="${pageContext.request.contextPath }/login?method=logout">退出</a></li>
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				 <c:if test="${empty currectSelectCid}">
				    <a class="navbar-brand" href="#">首页</a>
				  </c:if>
				   <c:if test="${!empty currectSelectCid}">
				    <a class="navbar-brand" href="${pageContext.request.contextPath }/home">首页<span class="sr-only">(current)</span></a>
				  </c:if>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:forEach items="${menuListDatas}" var="menuItem" varStatus="idx">
					 
			             <c:if test="${currectSelectCid==menuItem.cid}">
					       <li class="active"><a href="${pageContext.request.contextPath }/productList?cid=${menuItem.cid}">${menuItem.cname}<span id="${menuItem.cid}" class="sr-only">(current)</span></a></li>
					    </c:if> 
					     <c:if test="${currectSelectCid!=menuItem.cid}">
					       <li id="${menuItem.cid}"><a href="${pageContext.request.contextPath }/productList?cid=${menuItem.cid}">${menuItem.cname}</a></li>
					     </c:if> 
					     
					</c:forEach>
					
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>