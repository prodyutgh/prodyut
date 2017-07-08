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
				<c:url var="orderUrl" value="/admin/orders" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-10">
                        <h1 class="page-header">
                            View Order
                        </h1>
                    </div>
                    <div class="col-lg-2">
                        <h1 class="page-header">
                            <a href="${orderUrl}/list" class="btn btn-lg btn-primary">Back to Orders</a>
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                    	<strong>Order No.: <c:out value="${order.order_no}"/></strong>
                    </div>
                    <div class="col-lg-3 pull-right">
                    	<strong>Ordered On:</strong> <c:out value="${order.created_on}"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                    	<strong>Description: </strong><c:out value="${order.description}"/>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Order Items</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Unit Price</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach var="orderItem" items="${orderDetails}">
	                                    <tr>
	                                        <td><c:out value="${orderItem.product.name}"/></td>
	                                        <td><c:out value="${orderItem.product.price}"/></td>
	                                        <td><c:out value="${orderItem.quantity}"/></td>
	                                        <td><c:out value="${orderItem.quantity * orderItem.product.price}"/></td>
	                                    </tr>
	                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
				<div class="row">
                    <div class="col-lg-2 pull-right">
                    	<strong>Total Amount: <c:out value="${order.total_amount}"/></strong>
                    </div>
                </div>
	
			</div>
			<!-- /.container-fluid -->
	
		</div>
		<!-- /#page-wrapper -->
	</div>
	<%@ include file="../js-include.jsp"%>

</body>

</html>
