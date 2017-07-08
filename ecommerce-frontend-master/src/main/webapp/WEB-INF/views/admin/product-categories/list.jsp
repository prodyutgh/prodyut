<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../common_resource.jsp"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../header.jsp"%>
	
		<div id="page-wrapper">
	
			<div class="container-fluid">
				<c:url var="productCategoryUrl" value="/admin/product-categories" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${appUrl}admin/dashboard">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Product Categories
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
				<div class="row">
					<div class="col-lg-2">
						<a href="${productCategoryUrl}/add" class="btn btn-lg btn-primary">Add Product Category</a>
					</div>
				</div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Product Categories</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach var="productCategory" items="${productCategories}">
	                                    <tr>
	                                        <td><c:out value="${productCategory.name}"/></td>
	                                        <td><a href="${productCategoryUrl}/edit/<c:out value="${productCategory.id}"/>">Edit</a></td>
	                                        <td><a href="${productCategoryUrl}/confirm-delete/<c:out value="${productCategory.id}"/>">Delete</a></td>
	                                    </tr>
	                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
				
	
			</div>
			<!-- /.container-fluid -->
	
		</div>
		<!-- /#page-wrapper -->
	</div>
	<%@ include file="../js-include.jsp"%>

</body>

</html>
