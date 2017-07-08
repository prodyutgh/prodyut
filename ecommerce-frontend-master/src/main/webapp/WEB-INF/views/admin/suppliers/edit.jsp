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
                            <c:choose>
								<c:when test="${userSupplier.id > 0}">
									Edit Supplier
								</c:when>
								<c:otherwise>
									Add Supplier
								</c:otherwise>
							</c:choose>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<c:choose>
							<c:when test="${userSupplier.id > 0}">
								<c:url var="userSupplierSubmitURL" value="/admin/suppliers/edit/${userSupplier.user.id}" />
							</c:when>
							<c:otherwise>
								<c:url var="userSupplierSubmitURL" value="/admin/suppliers/add" />
							</c:otherwise>
						</c:choose>
						<c:out value="${userSupplierSubmitURL}"/>
                        <form:form role="form" name="adminuserSupplierForm" action="${userSupplierSubmitURL}" method="POST" modelAttribute="userSupplier">

                            <div class="form-group">
                                <label>First Name</label>
                                <form:input type="text" path="user.first_name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Last Name</label>
                                <form:input type="text" path="user.last_name" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <form:input type="text" path="user.email" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <form:input type="password" path="user.password" class="form-control" />
                            </div>

                            <div class="form-group">
                                <label>Confirm Password</label>
                                <form:input type="password" path="user.cpassword" class="form-control" />
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                            <button type="submit" class="btn btn-lg btn-primary">Save</button>
                            <c:url var="supplierUrl" value="/admin/suppliers" />
                            <a href="${supplierUrl}/list" class="btn btn-lg btn-link">Cancel</a>

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
