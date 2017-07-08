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
				<c:url var="supplierUrl" value="/admin/suppliers" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${appUrl}admin/dashboard">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Suppliers
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
				<div class="row">
					<div class="col-lg-2">
						<a href="${supplierUrl}/add" class="btn btn-lg btn-primary">Add Supplier</a>
					</div>
				</div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Suppliers</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach var="supplier" items="${suppliers}">
	                                    <tr>
	                                        <td>${supplier.user.first_name} ${supplier.user.last_name}</td>
	                                        <td>${supplier.user.email}</td>
	                                        <td><a href="${supplierUrl}/edit/${supplier.user.id}">Edit</a></td>
	                                        <td><a href="${supplierUrl}/${supplier.user.id}/inventory/list">Edit Inventory</a></td>
	                                        <td><a href="${supplierUrl}/confirm-delete/${supplier.user.id}">Delete</a></td>
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
