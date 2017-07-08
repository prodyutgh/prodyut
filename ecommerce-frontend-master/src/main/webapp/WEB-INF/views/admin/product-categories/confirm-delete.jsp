<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../header.jsp"%>
		<c:url var="productCategoryUrl" value="/admin/product-categories" />
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <c:choose>
								<c:when test="${productId > 0}">
									Edit Product Category
								</c:when>
								<c:otherwise>
									Add Product Category
								</c:otherwise>
							</c:choose>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:choose>
							<c:when test="${productCategoryDeleted}">
	                            <div class="form-group">
	                                <label>Product Category deleted successfully!!!</label>
	                            </div>
	
	                            Go to <a href="${productCategoryUrl}/list" class="btn btn-lg btn-primary">Product Category List</a>
							</c:when>
							<c:otherwise>
								
		                    	<c:url var="productCategoryDeleteSubmitURL" value="/admin/product-categories/delete" />
		                        <form:form role="form" name="adminProductCategoryConfirmDeleteForm" action="${productCategoryDeleteSubmitURL}" method="POST" modelAttribute="productCategory">
									<form:input type="text" path="id" class="form-control" />
		                            <div class="form-group">
		                                <label>Are you sure you want to delete this product category?</label>
		                            </div>
		
		                            <button type="submit" class="btn btn-lg btn-primary">Delete</button>
									<a href="${productCategoryUrl}/list" class="btn btn-lg btn-link">Cancel</a>
		                        </form:form>
							</c:otherwise>
						</c:choose>

                    </div>
                </div>
                <!-- /.row -->

            </div>
	
		</div>
		<!-- /#page-wrapper -->
	</div>
	<%@ include file="../js-include.jsp"%>

</body>

</html>
