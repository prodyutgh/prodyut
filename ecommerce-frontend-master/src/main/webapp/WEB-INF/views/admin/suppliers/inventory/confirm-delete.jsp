<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../../header.jsp"%>
		<c:url var="inventoryUrl" value="/admin/suppliers/${inventory.supplier.user.id}/inventory" />
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            <c:choose>
								<c:when test="${inventory.id > 0}">
									Edit Inventory
								</c:when>
								<c:otherwise>
									Add Inventory
								</c:otherwise>
							</c:choose>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:choose>
							<c:when test="${inventoryDeleted}">
	                            <div class="form-group">
	                                <label>Inventory deleted successfully!!!</label>
	                            </div>
	
	                            Go to <a href="${inventoryUrl}/list" class="btn btn-lg btn-primary">Inventory List</a>
							</c:when>
							<c:otherwise>
								
		                    	<form:form role="form" name="adminInventoryConfirmDeleteForm" action="${inventoryUrl}/delete" method="POST" modelAttribute="inventory">
									<form:input type="text" path="id" class="form-control" />
		                            <div class="form-group">
		                                <label>Are you sure you want to delete this inventory?</label>
		                            </div>
		
		                            <button type="submit" class="btn btn-lg btn-primary">Delete</button>
									<a href="${inventoryUrl}/list" class="btn btn-lg btn-link">Cancel</a>
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
	<%@ include file="../../js-include.jsp"%>

</body>

</html>
