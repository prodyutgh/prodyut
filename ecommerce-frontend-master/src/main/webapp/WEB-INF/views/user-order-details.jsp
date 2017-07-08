<!DOCTYPE html>
<html lang="en">

	<head>
		<%@ include file="common_resource.jsp" %>
	</head>

	<body>
	
	    <!-- Navigation -->
	    <%@ include file="header.jsp" %>
	    
	    <!-- Page Content -->
	    <div class="container">
			<c:url var="baseUrl" value="/" />
	        <div class="row">
	            <div class="col-md-12">
	                <div class="well">
	                	<div class="row">
		                	<div class="col-md-10 text-left">
		                        <h2>Your Order Details</h2>
		                    </div>
	                    </div>
	                	
	                    <hr>
	                    <div class="row">
	                        <div class="col-md-7">
	                        	<p><h4>Item</h4></p>
	                        </div>
	                        <div class="col-md-2 text-right">
	                        	<p><h4>Quantity</h4></p>
	                        </div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Unit Price</h4></p>
	                        </div>
	                        <div class="col-md-2 text-right">
	                        	<p><h4>Item Total</h4></p>
	                        </div>
	                    </div>
	
	                    <hr>
	                    <c:set var="cartTotalPrice" scope="session" value="0"/>
						<c:forEach var="orderItem" items="${orderItems}">
						    <div class="row">
		                        <div class="col-md-7">
		                        	<p><c:out value="${orderItem.product.name}"/></p>
		                        </div>
		                        <div class="col-md-2 text-right">
		                        	<%-- <p><input type="text" name="quantity" value="${cartItem.quantity}" class="form-control" /></p> --%>
		                        	<p><c:out value="${orderItem.quantity}"/></p>
		                        </div>
		                        <div class="col-md-1 text-right">
		                        	<p><c:out value="${orderItem.product.price}"/></p>
		                        </div>
		                        <div class="col-md-2 text-right">
		                        	<p><c:out value="${orderItem.quantity * orderItem.product.price}"/></p>
		                        </div>
		                    </div>
		                    <hr>
	                    </c:forEach>
	                    <div class="row">
	                        <div class="col-md-10"></div>
	                        <div class="col-md-1  text-right"><strong>Total:</strong></div>
	                        <div class="col-md-1  text-right"><strong><c:out value="${order.total_amount}"/></strong></div>
	                    </div>
	
	                </div>
	
	            </div>
	
	        </div>
	
	    </div>
	    <!-- /.container -->
	
	    	<%@ include file="footer.jsp" %>
			
			<%@ include file="js-include.jsp" %>
	
	</body>

</html>
