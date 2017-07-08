<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../header.jsp"%>
	
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <c:choose>
								<c:when test="${product.id > 0}">
									Edit Product
								</c:when>
								<c:otherwise>
									Add Product
								</c:otherwise>
							</c:choose>
                        </h1>
                        <!-- <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Forms
                            </li>
                        </ol> -->
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:choose>
							<c:when test="${product.id > 0}">
								<c:url var="productSubmitURL" value="/admin/products/edit/${product.id}" />
							</c:when>
							<c:otherwise>
								<c:url var="productSubmitURL" value="/admin/products/add" />
							</c:otherwise>
						</c:choose>
						<form:form role="form" name="adminProductForm" action="${productSubmitURL}" method="POST" modelAttribute="product" enctype="multipart/form-data">

                            <div class="form-group">
                                <label>Name</label>
                                <form:input type="text" path="name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Type</label>
                                <form:input type="text" path="type" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Image</label>
                                <form:input type="file" path="file" class="form-control" />
                                <form:hidden path="image_name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Description</label>
                                <form:textarea path="description" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Price</label>
                                <form:input type="text" path="price" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Category</label>
                                <form:select path="productCategory.id" class="form-control" >
                                	<form:option value="0" label="Select Product Category"/>
                                	<form:options items="${productCategories}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </div>
                            
							<div class="form-group">
                                <label>Supplier</label>
                                <form:select path="supplier.id" class="form-control" >
                                	<form:option value="0" label="Select Supplier"/>
                                	<form:options items="${userSuppliers}" itemValue="id" itemLabel="user.first_name" />
                                </form:select>
                            </div>
                            
							<div class="form-group">
                                <label>Stock</label>
                                <form:input type="text" path="quantity" class="form-control" />
                            </div>

                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            <button type="submit" class="btn btn-lg btn-primary">Save</button>
                            <c:url var="productUrl" value="/admin/products" />
                            <a href="${productUrl}/list" class="btn btn-lg btn-link">Cancel</a>

                        </form:form>

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
