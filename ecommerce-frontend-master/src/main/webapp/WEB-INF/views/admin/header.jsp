<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="appUrl" value="/" />

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${appUrl}admin/dashboard">My Shop Admin</a>
                
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
            	<li>
            		<a href="#"><i class="fa fa-user"></i> ${loggedInUser}</a>
            	</li>
            	<li>
            		<a href="${appUrl}logout">Logout</a>
            	</li>
                <%-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                        	<c:url var="logoutUrl" value="/logout" />
                            <a href="${logoutUrl}"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li> --%>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="">
                        <a href="${appUrl}admin/products/list"><i class="fa fa-fw fa-table"></i> Products</a>
                    </li>
                    <li class="">
                        <a href="${appUrl}admin/product-categories/list"><i class="fa fa-fw fa-table"></i> Product Categories</a>
                    </li>
                    <li class="">
                        <a href="${appUrl}admin/suppliers/list"><i class="fa fa-fw fa-table"></i> Suppliers</a>
                    </li>
                    <li class="">
                        <a href="${appUrl}admin/customers/list"><i class="fa fa-fw fa-table"></i> Customers</a>
                    </li>
                    <li class="">
                        <a href="${appUrl}admin/orders/list"><i class="fa fa-fw fa-table"></i> Orders</a>
                    </li>
                	<!-- 
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i> Charts</a>
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-fw fa-table"></i> Tables</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-fw fa-edit"></i> Forms</a>
                    </li>
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                    </li>
                    <li>
                        <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
                    </li>
                    -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>