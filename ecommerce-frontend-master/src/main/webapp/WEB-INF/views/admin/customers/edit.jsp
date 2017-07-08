<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="../common_resource.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<div id="wrapper">
		<%@ include file="../header.jsp"%>
	
		<div id="page-wrapper">
	
			<div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Edit Customer
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:url var="userCustomerSubmitURL" value="/admin/customers/edit/${user.id}" />
						<form:form role="form" name="adminuserCustomerForm" action="${userCustomerSubmitURL}" method="POST" modelAttribute="user">

                            <div class="form-group">
                                <label>First Name</label>
                                <form:input type="text" path="first_name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Last Name</label>
                                <form:input type="text" path="last_name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <form:input type="text" path="email" class="form-control" />
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            <button type="submit" class="btn btn-lg btn-primary">Save</button>
                            <c:url var="customerUrl" value="/admin/customers" />
                            <a href="${customerUrl}/list" class="btn btn-lg btn-link">Cancel</a>

                        </form:form>

                    </div>
                </div>
                <!-- /.row -->

            </div>
	
		</div>
		<!-- /#page-wrapper -->
	</div>
	<%@ include file="../js-include.jsp"%>

</body>

</html>
