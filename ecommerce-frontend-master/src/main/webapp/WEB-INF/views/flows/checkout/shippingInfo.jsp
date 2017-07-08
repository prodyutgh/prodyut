<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<%@ include file="../../header.jsp"%>
	<!-- Page Content -->
	<div class="container">
		<c:url var="baseUrl" value="/" />
		<div class="well row">
			<div class="col-lg-12">
				<h2>Shipping Details</h2>
			</div>
		</div>
		<div class="row">

			<div class="col-md-6">
				<form:form role="form" name="shippingForm" action="${flowExecutionUrl}" method="POST" modelAttribute="userCustomer">
					<div class="form-group">
						<label for="mobile_no">Mobile Number:</label> 
						<form:input type="text" path="mobile_no" class="form-control" />
					</div>
					<div class="form-group">
						<label for="shipping_address">Your Shipping Address:</label> 
						<form:textarea path="shipping_address" class="form-control" />
					</div>
					<div class="form-group">
						<label for="billing_address">Your Billing Address:</label> 
						<form:textarea path="billing_address" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cardno">Card Number:</label> 
						<form:input type="text" path="cardno" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cardname">Card Holder Name:</label> 
						<form:input type="text" path="cardname" class="form-control" />
					</div>
					<div class="form-group">
						<label for="card_exp_month">Expiry Month:</label> 
						<form:input type="text" path="card_exp_month" class="form-control" />
					</div>
					<div class="form-group">
						<label for="card_exp_year">Expiry Year:</label> 
						<form:input type="text" path="card_exp_year" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cardcvc">Card CVC:</label> 
						<form:input type="text" path="cardcvc" class="form-control" />
					</div>
					
					<button name="_eventId_proceed" type="submit" class="btn btn-lg btn-success">Review Order</button>
					<button name="_eventId_cancel" type="submit" class="btn btn-lg btn-info">Cancel</button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<%@ include file="../../footer.jsp"%>

	<%@ include file="../../js-include.jsp"%>

</body>

</html>
