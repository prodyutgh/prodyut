<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../../header.jsp"%>
	
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                        	${userSupplier.user.first_name} ${userSupplier.user.last_name} ->
                            <c:choose>
								<c:when test="${inventory.id > 0}">
									Edit Inventory
								</c:when>
								<c:otherwise>
									Add Inventory
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
							<c:when test="${inventory.id > 0}">
								<c:url var="inventorySubmitURL" value="/admin/suppliers/${userSupplier.user.id}/inventory/edit/${inventory.id}" />
							</c:when>
							<c:otherwise>
								<c:url var="inventorySubmitURL" value="/admin/suppliers/${userSupplier.user.id}/inventory/add" />
							</c:otherwise>
						</c:choose>
						<c:out value="${inventorySubmitURL}"/>
                        <form:form role="form" name="adminInventoryForm" action="${inventorySubmitURL}" method="POST" modelAttribute="inventory">

                            <div class="form-group">
                                <label>Product</label>
                                <form:select path="product.id" class="form-control" >
                                	<option value="">Choose Product</option>
                                	<form:options items="${products}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </div>
                            
                            <div class="form-group">
                                <label>Product Title</label>
                                <form:input type="text" path="product_title" class="form-control" />
                            </div>
                            
                            <div class="form-group">
                                <label>Quantity</label>
                                <form:input type="text" path="quantity" class="form-control" />
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            <button type="submit" class="btn btn-lg btn-primary">Save</button>
                            <c:url var="inventoryUrl" value="/admin/suppliers/${inventory.supplier.user.id}/inventory" />
                            <a href="${inventoryUrl}/list" class="btn btn-lg btn-link">Cancel</a>

                        </form:form>

                    </div>
                </div>
                <!-- /.row -->

            </div>
	
		</div>
		<!-- /#page-wrapper -->
	</div>
	<%@ include file="../../js-include.jsp"%>

</body>

</html>
