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
	
	            <%-- <div class="col-md-3">
	                <%@ include file="left-nav.jsp" %>
	            </div> --%>
	
	            <div class="col-md-12">
					<c:url var="productImgBaseUrl" value="/resources/uploads/products/" />
	                <div class="thumbnail">
	                    <img width="100px" class="img-responsive" src="${productImgBaseUrl}${selectedProduct.image_name}" alt="">
	                    <div class="caption-full">
	                        <h4 class="pull-right">$${selectedProduct.price}</h4>
	                        <h4>${selectedProduct.name}</h4>
	                        <p>${selectedProduct.description}</p>
	                    </div>
	                    <div class="ratings clearfix">
	                    	<div class="pull-right">
	                    		<c:url var="productImgBaseUrl" value="/resources/uploads/products/" />
	                        	<a href="${baseUrl}user/cart/add/${selectedProduct.id}" class="btn btn-success">Add to cart</a>
	                        <%-- <a href="${baseUrl}user/checkout" class="btn btn-success">Buy now</a>--%>

	                    	</div>
	                    </div>
	                    <br/>
	                    <div class="ratings clearfix">
	                        <p class="pull-right">3 reviews</p>
	                        <p>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            4.0 stars
	                        </p>
	                    </div>
	                </div>
	
	                <div class="well">
	
	                    <div class="text-right">
	                        <a class="btn btn-success">Leave a Review</a>
	                    </div>
	
	                    <hr>
	
	                    <div class="row">
	                        <div class="col-md-12">
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            Anonymous
	                            <span class="pull-right">10 days ago</span>
	                            <p>This product was great in terms of quality. I would definitely buy another!</p>
	                        </div>
	                    </div>
	
	                    <hr>
	
	                    <div class="row">
	                        <div class="col-md-12">
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            Anonymous
	                            <span class="pull-right">12 days ago</span>
	                            <p>I've alredy ordered another one!</p>
	                        </div>
	                    </div>
	
	                    <hr>
	
	                    <div class="row">
	                        <div class="col-md-12">
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star"></span>
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            Anonymous
	                            <span class="pull-right">15 days ago</span>
	                            <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
	                        </div>
	                    </div>
	
	                </div>
	
	            </div>
	
	        </div>
	
	    </div>
	    <!-- /.container -->
	
	    	<%@ include file="footer.jsp" %>
			
			<%@ include file="js-include.jsp" %>
	
	</body>

</html>
