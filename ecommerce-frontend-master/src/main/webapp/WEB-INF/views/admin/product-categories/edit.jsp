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
								<c:when test="${productCategory.id > 0}">
									Edit Product Category
								</c:when>
								<c:otherwise>
									Add Product Category
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
							<c:when test="${productCategory.id > 0}">
								<c:url var="productCategorySubmitURL" value="/admin/product-categories/edit/${productCategory.id}" />
							</c:when>
							<c:otherwise>
								<c:url var="productCategorySubmitURL" value="/admin/product-categories/add" />
							</c:otherwise>
						</c:choose>
						<c:out value="${productCategorySubmitURL}"/>
                        <form:form role="form" name="adminProductCategoryForm" action="${productCategorySubmitURL}" method="POST" modelAttribute="productCategory">

                            <div class="form-group">
                                <label>Name</label>
                                <%-- <input type="text" name="name" value="<c:out value="${product.name}"/>" class="form-control" /> --%>
                                <form:input type="text" path="name" class="form-control" />
                            </div>

                            <button type="submit" class="btn btn-lg btn-primary">Save</button>
                            <c:url var="productCategoryUrl" value="/admin/product-categories" />
                            <a href="${productCategoryUrl}/list" class="btn btn-lg btn-link">Cancel</a>

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
