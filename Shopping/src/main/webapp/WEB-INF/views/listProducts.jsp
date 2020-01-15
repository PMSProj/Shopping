<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">

		<!-- Would to display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<!--  display actual products-->
		<div class="col-md-9">


			<!-- added breadcrum products -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickedAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item-active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickedCategoryProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item-active">Category</li>
							<li class="breadcrumb-item-active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
							</tr>
						</thead>


					</table>


				</div>
			</div>
		</div>
	</div>
</div>