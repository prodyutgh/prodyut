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
		                        <h2>Your Orders</h2>
		                    </div>
	                    </div>
	                	
	                    <hr>
	                    <div class="row">
	                        <div class="col-md-2">
	                        	<p><h4>Order No.</h4></p>
	                        </div>
	                        <div class="col-md-6">
	                        	<p><h4>Description</h4></p>
	                        </div>
	                        <div class="col-md-2">
	                        	<p><h4>Date</h4></p>
	                        </div>
	                        <div class="col-md-2 text-right">
	                        	<p><h4>Total Amount</h4></p>
	                        </div>
	                    </div>
	
	                    <hr>
	                    <c:set var="cartTotalPrice" scope="session" value="0"/>
						<c:forEach var="order" items="${orders}">
		                    <div class="row">
		                        <div class="col-md-2">
		                        	<p><a href="${baseUrl}/user/order/${order.id}"><c:out value="${order.order_no}"/></a></p>
		                        </div>
		                        <div class="col-md-6">
		                        	<p><c:out value="${order.description}"/></p>
		                        </div>
		                        <div class="col-md-2">
		                        	<p><c:out value="${order.created_on}"/></p>
		                        </div>
		                        <div class="col-md-2 text-right">
		                        	<p><c:out value="${order.total_amount}"/></p>
		                        </div>
		                    </div>
		                    <hr>
	                    </c:forEach>
	                    <hr>
	
	                </div>
	
	            </div>
	
	        </div>
	
	    </div>
	    <!-- /.container -->
	
	    	<%@ include file="footer.jsp" %>
			
			<%@ include file="js-include.jsp" %>
	
	</body>

</html>
