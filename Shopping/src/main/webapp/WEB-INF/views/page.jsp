<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Ecommerce</title>
<script>
	window.menu = '${title}'; //title from page controller
	
	window.contextRoot='${contextRoot}'
	
	
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap readable theme -->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Bootstrap jquery datatable -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet" type="text/css">




</head>

<body>
	<div class="wrapper">
		<!-- navbar  -->
		<%@include file="./shared/navbar.jsp"%>'

		<!-- Page Content -->
		<div class="content">
			<!-- Loading the home content -->
			<c:if test="${userClickedHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickedAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickedContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if
				test="${userClickedAllProducts==true or userClickedCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user clicked single product -->
           <c:if
				test="${userClickedShowProducts==true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
		</div>

		<!-- /.container -->
		<!-- footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jquery -->
		<script src="${js}/jquery.js"></script>
		<!-- Bootstrap core Javascript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Datatable plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
			<!-- Datatable Bootrap script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
