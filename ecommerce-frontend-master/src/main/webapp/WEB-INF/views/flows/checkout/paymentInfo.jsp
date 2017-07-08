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
		                        <h2>Your Cart</h2>
		                    </div>
							<div class="col-md-2 text-right">
		                        <a href="${baseUrl}" class="btn btn-lg btn-info">Shop More >></a>
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
	                        <div class="col-md-1"></div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Unit Price</h4></p>
	                        </div>
	                        <div class="col-md-1 text-right">
	                        	<p><h4>Item Total</h4></p>
	                        </div>
	                        <div class="col-md-1"></div>
	                    </div>
	
	                    <hr>
	                    <c:set var="cartTotalPrice" scope="session" value="0"/>
						<c:forEach var="cartItem" items="${userCartItems}">
							<form:form role="form" name="cartItemForm" action="${baseUrl}cart/update/${cartItem.id}" method="POST" modelAttribute="userCart">
			                    <div class="row">
			                        <div class="col-md-7">
			                        	<p><c:out value="${cartItem.product.name}"/></p>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<%-- <p><input type="text" name="quantity" value="${cartItem.quantity}" class="form-control" /></p> --%>
			                        	<p><c:out value="${cartItem.quantity}"/></p>
			                        </div>
			                        <div class="col-md-1">
			                        	<button type="submit" class="btn btn-xs btn-warning">Update</button>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<p><c:out value="${cartItem.product.price}"/></p>
			                        </div>
			                        <div class="col-md-1 text-right">
			                        	<p><c:out value="${cartItem.quantity * cartItem.product.price}"/></p>
			                        	<c:set var="cartTotalPrice" scope="session" value="${cartTotalPrice + cartItem.quantity * cartItem.product.price}"/>
			                        </div>
			                        <div class="col-md-1">
			                        	<a href="${baseUrl}cart/delete/${cartItem.id}" class="btn btn-xs btn-danger"><strong>Remove</strong></a>
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
	                    <div class="text-right">
	                    	<button type="button" class="btn btn-lg btn-success">Checkout >></button>
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
