<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../header.jsp"%>
		<c:url var="productUrl" value="/admin/products" />
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <c:choose>
								<c:when test="${productId > 0}">
									Edit Product
								</c:when>
								<c:otherwise>
									Add Product
								</c:otherwise>
							</c:choose>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:choose>
							<c:when test="${productDeleted}">
	                            <div class="form-group">
	                                <label>Product deleted successfully!!!</label>
	                            </div>
	
	                            Go to <a href="${productUrl}/list" class="btn btn-lg btn-primary">Product List</a>
							</c:when>
							<c:otherwise>
								
		                    	<c:url var="productDeleteSubmitURL" value="/admin/products/delete" />
		                        <form:form role="form" name="adminProductConfirmDeleteForm" action="${productDeleteSubmitURL}" method="POST" modelAttribute="product">
									<form:input type="text" path="id" class="form-control" />
		                            <div class="form-group">
		                                <label>Are you sure you want to delete this product?</label>
		                            </div>
		
		                            <button type="submit" class="btn btn-lg btn-primary">Delete</button>
									<a href="${productUrl}/list" class="btn btn-lg btn-link">Cancel</a>
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
