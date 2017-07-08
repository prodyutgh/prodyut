<!DOCTYPE html>
<html lang="en">

	<head>
		<%@ include file="../../common_resource.jsp" %>
	</head>

	<body>
	
	    <!-- Navigation -->
	    <%@ include file="../../header.jsp" %>
	    
	    <!-- Page Content -->
	    <div class="container">
			<c:url var="baseUrl" value="/" />
	        <div class="row">
	            <div class="col-md-12">
	                <div class="well">
	                	<div class="row">
		                	<div class="col-md-10 text-left">
		                        <h2>Please review your order</h2>
		                    </div>
							<div class="col-md-2 text-right">
		                        
		                    </div>
	                    </div>
	                	
	                    <hr>
	                    <div class="row">
	                        <div class="col-md-7">
	                        	<p><h4>Item</h4></p>
	                        </div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Quantity</h4></p>
	                        </div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Unit Price</h4></p>
	                        </div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Item Total</h4></p>
	                        </div>
	                    </div>
	
	                    <hr>
	                    <c:set var="cartTotalPrice" scope="session" value="0"/>
						<c:forEach var="cartItem" items="${cartItems}">
							<form:form role="form" name="cartItemForm" action="${baseUrl}cart/update/${cartItem.id}" method="POST" modelAttribute="userCart">
			                    <div class="row">
			                        <div class="col-md-7">
			                        	<p><c:out value="${cartItem.product.name}"/></p>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<%-- <p><input type="text" name="quantity" value="${cartItem.quantity}" class="form-control" /></p> --%>
			                        	<p><c:out value="${cartItem.quantity}"/></p>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<p><c:out value="${cartItem.product.price}"/></p>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<p><c:out value="${cartItem.quantity * cartItem.product.price}"/></p>
			                        	<c:set var="cartTotalPrice" scope="session" value="${cartTotalPrice + cartItem.quantity * cartItem.product.price}"/>
			                        </div>
			                    </div>
							</form:form>
		                    <hr>
	                    </c:forEach>
	                    <div class="row">
	                        <div class="col-md-9"></div>
	                        <div class="col-md-1  text-right"><strong>Total:</strong></div>
	                        <div class="col-md-1  text-right"><strong><c:out value="${cartTotalPrice}"/></strong></div>
	                        <div class="col-md-1"></div>
	                    </div>
	                    <hr>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<h3><u>Shipping Address</u></h3>
	                    		<p>
	                    			<c:out value="${userCustomer.user.first_name}"/> <c:out value="${userCustomer.user.last_name}"/>,
	                    			<br/>
	                    			<c:out value="${userCustomer.shipping_address}"/>
	                    		</p>
	                    	</div>
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                    		<h3><u>Billing Address</u></h3>
	                    		<p>
	                    			<c:out value="${userCustomer.user.first_name}"/> <c:out value="${userCustomer.user.last_name}"/>,
	                    			<br/>
	                    			<c:out value="${userCustomer.billing_address}"/>
	                    		</p>
	                    	</div>
	                    </div>
	                    <div class="text-right">
		                    <form role="form" name="reviewOrderForm" action="${flowExecutionUrl}" method="POST">
		                    	<button  name="_eventId_proceed" type="submit" class="btn btn-lg btn-success">Place Order</button>
		                    	<button  name="_eventId_cancel" type="submit" class="btn btn-lg btn-info">Cancel</button>
		                    </form>
	                    </div>
	
	                </div>
	
	            </div>
	
	        </div>
	
	    </div>
	    <!-- /.container -->
	
	    	<%@ include file="../../footer.jsp" %>
			
			<%@ include file="../../js-include.jsp" %>
	
	</body>

</html>
