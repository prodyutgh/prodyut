<!DOCTYPE html>
<html lang="en">
	
	<head>
		<%@ include file="common_resource.jsp" %>
	</head>
	
	<body>
		<%@ include file="header.jsp" %>
	    <!-- Page Content -->
	    <div class="container">
	
	        <div class="row">
	            <div class="col-md-12">
	                <div class="row">
	                	<c:url var="editProfileSubmitURL" value="/user/profile/edit" />
	                	<form:form role="form" name="editProfileForm" action="${editProfileSubmitURL}" method="POST" modelAttribute="userCustomer">
							<div class="form-group">
								<label for="first_name">First Name:</label> 
								<form:input type="text" path="user.first_name" class="form-control" />
							</div>
							<div class="form-group">
								<label for="last_name">Last Name:</label> 
								<form:input type="text" path="user.last_name" class="form-control" />
							</div>
							<div class="form-group">
								<label for="email">Email:</label> 
								<form:input type="text" path="user.email" class="form-control" />
							</div>
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
							
							<button type="submit" class="btn btn-lg btn-success">Save</button>
						</form:form>
	                </div>
	                
	            </div>
	        </div>
	    </div>
	    <!-- /.container -->
	
		<%@ include file="footer.jsp" %>
		
		<%@ include file="js-include.jsp" %>

	</body>

</html>
