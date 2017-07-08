<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="home" value="/" />
<p class="lead">Choose your category</p>
<div class="list-group">
	<c:forEach var="productCategory" items="${productCategories}">
		<a href="${home}${productCategory.id}" class="list-group-item <c:if test="${selectedProductCategory.id == productCategory.id}">active</c:if>">${productCategory.name}</a> 
	</c:forEach>
</div>
