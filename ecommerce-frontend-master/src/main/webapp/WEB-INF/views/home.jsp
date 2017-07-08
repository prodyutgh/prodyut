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
	
	            <%-- <div class="col-md-3">
	                <%@ include file="left-nav.jsp" %>
	            </div> --%>
	
	            <div class="col-md-12">
					
	                <!-- <div class="row carousel-holder">
	
	                    <div class="col-md-12">
	                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	                            <ol class="carousel-indicators">
	                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	                            </ol>
	                            <div class="carousel-inner">
	                                <div class="item active">
	                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
	                                </div>
	                            </div>
	                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
	                                <span class="glyphicon glyphicon-chevron-left"></span>
	                            </a>
	                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
	                                <span class="glyphicon glyphicon-chevron-right"></span>
	                            </a>
	                        </div>
	                    </div>
	
	                </div> -->
	
	                <div class="row">
	                	<c:url var="home" value="/" />
	                	<c:url var="productImgBaseUrl" value="/resources/uploads/products/" />
	                	<c:url var="productDetailUrl" value="/product" />
						<c:forEach var="product" items="${products}">
		                    <div class="col-sm-4 col-lg-4 col-md-4">
		                        <div class="thumbnail home-page-item-card">
		                            <!-- <img src="http://placehold.it/320x150" alt=""> -->
	                                <a href="#" class="item-image">
	                                	<img src="${productImgBaseUrl}${product.image_name}" />
	                                </a>
	                                <div class="caption">
		                                <h4 class="pull-right price">$<c:out value="${product.price}"/></h4>
		                                <h4><a href="${productDetailUrl}/${product.id}"><c:out value="${product.name}"/></a></h4>
		                                <!-- <h4 class="pull-right"><c:out value="${product.productCategory.name}"/></h4>  -->
		                                <p>See more snippets like this online store item.</p>
		                            </div>
		                            <div class="ratings">
		                                <p class="pull-right">15 reviews</p>
		                                <p>
		                                    <span class="glyphicon glyphicon-star"></span>
		                                    <span class="glyphicon glyphicon-star"></span>
		                                    <span class="glyphicon glyphicon-star"></span>
		                                    <span class="glyphicon glyphicon-star"></span>
		                                    <span class="glyphicon glyphicon-star"></span>
		                                </p>
		                            </div>
		                        </div>
		                    </div>
	                    </c:forEach>
	                </div>
	                
	            </div>
	        </div>
	    </div>
	    <!-- /.container -->
	
		<%@ include file="footer.jsp" %>
		
		<%@ include file="js-include.jsp" %>

	</body>

</html>
