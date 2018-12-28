<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- menu profile quick info -->
<div class="profile clearfix">
	<div class="profile_info">
		<span>Welcome,</span>
		<h2>Admin</h2>
	</div>
</div>
<!-- /menu profile quick info -->
<br />
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<ul class="nav side-menu">
			<li><a><i class="fa fa-home"></i> Home </a></li>
			<li><a><i class="fa fa-clone"></i> Product <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/admin/product/create">Thêm mới sản phẩm</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/product">Danh sách sản phẩm</a></li>
				</ul></li>
			<li><a><i class="fa fa-edit"></i> Category <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/admin/category/create">Thêm loại sản phẩm</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/category">Danh sách loại hàng</a></li>
				</ul></li>
			<li><a><i class="fa fa-desktop"></i> Images <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/admin/image">List Images</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/image/create">Add Images</a></li>
				</ul></li>
			<li><a><i class="fa fa-user"></i> User <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="tables.html">List User</a></li>
				</ul></li>
			<li><a><i class="fa fa-cart-plus"></i> Orders <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="chartjs.html">List Order</a></li>
				</ul></li>
		</ul>
	</div>

</div>
<!-- /menu footer buttons -->
<div class="sidebar-footer hidden-small">
	<a data-toggle="tooltip" data-placement="top" title="Logout"
		href="login.html"> <span class="glyphicon glyphicon-off"
		aria-hidden="true"></span>
	</a>
</div>
<!-- /menu footer buttons -->