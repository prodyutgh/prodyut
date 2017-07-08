<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../../common_resource.jsp"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../../header.jsp"%>
	
		<div id="page-wrapper">
	
			<div class="container-fluid">
				<c:url var="supplierInventoryUrl" value="/admin/suppliers/${userSupplier.user.id}/inventory" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Tables
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Tables
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
				<div class="row">
					<div class="col-lg-2 pull-left">
						<a href="${supplierInventoryUrl}/add" class="btn btn-lg btn-primary">Add Inventory</a>
					</div>
					<div class="col-lg-10 pull-right">
						<c:url var="supplierUrl" value="/admin/suppliers" />
						<a href="${supplierUrl}/list" class="btn btn-lg btn-primary">Back to Suppliers</a>
					</div>
				</div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2>${userSupplier.user.first_name} ${userSupplier.user.last_name} Inventory</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Product Name</th>
                                        <th>Product Title</th>
                                        <th>Quantity</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach var="inventory" items="${inventoryList}">
	                                    <tr>
	                                        <td>${inventory.product.name}</td>
	                                        <td>${inventory.product_title}</td>
	                                        <td>${inventory.quantity}</td>
	                                        <td><a href="${supplierInventoryUrl}/edit/${inventory.id}">Edit</a></td>
	                                        <td><a href="${supplierInventoryUrl}/confirm-delete/${inventory.id}">Delete</a></td>
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
	<%@ include file="../../js-include.jsp"%>

</body>

</html>
