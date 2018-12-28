<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="x_title">
	<h2>List Image</h2>

	<div class="clearfix"></div>
</div>
<div class="x_content">
	<table id="datatable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Image</th>
				<th>Product</th>
				<th>Action</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach items="${allImage}" var="image" varStatus="status">
				<tr>
					<td>${image.imageId}</td>
					<td><img src="${pageContext.request.contextPath}/${image.image}" class="avatar" alt=""></td>
					<td>${image.productName}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/image/edit/${image.imageId}"
						class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit
					</a> <a
						href="${pageContext.request.contextPath}/admin/image/delete/${image.imageId}"
						class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

