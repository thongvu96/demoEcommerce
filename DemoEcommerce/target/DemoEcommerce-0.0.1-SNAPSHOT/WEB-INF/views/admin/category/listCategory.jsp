<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="x_title">
	<h2>List Category</h2>

	<div class="clearfix"></div>
</div>
<div class="x_content">
	<table id="datatable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Category Name</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach items="${allCategory}" var="category" varStatus="status">
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td>${category.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/category/edit/${category.categoryId}"
						class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit
					</a> <a
						href="${pageContext.request.contextPath}/admin/category/delete/${category.categoryId}"
						class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

