<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-12">
				<c:url var="signUpUrl" value="/signup" />
				<form:form role="form" name="signUpForm" action="${signUpUrl}" method="POST" modelAttribute="user">
					<div class="form-group">
						<label for="first_name">First Name:</label> 
						<form:input type="text" path="first_name" class="form-control" />
					</div>
					<div class="form-group">
						<label for="last_name">Last Name:</label> 
						<form:input type="text" path="last_name" class="form-control" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label> 
						<form:input type="text" path="email" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password:</label> 
						<form:password path="password" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cpassword">Confirm Password:</label> 
						<form:password path="cpassword" class="form-control" />
					</div>
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<%@ include file="footer.jsp"%>

	<%@ include file="js-include.jsp"%>

</body>

</html>
