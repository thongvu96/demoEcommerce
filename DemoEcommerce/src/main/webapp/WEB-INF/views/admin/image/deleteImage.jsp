<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.vuthong.ecommerce.vo.ImageVO"%>
<div class="x_title">
	<h2>Delete Image</h2>

	<div class="clearfix"></div>
</div>
<div class="x_content">

	<!-- start form for validation -->
	<form:form id="demo-form" modelAttribute="imageVO"
		action="${pageContext.request.contextPath}/admin/image/delete"
		method="post" enctype="multipart/form-data">
		<form:input type="text" path="imageId" placeholder="" hidden="hidden"/>
		<img src="${pageContext.request.contextPath}/${image}" class="" alt="" width="64px" height="64px">
		<br>
		<br>
		<label for="heard">Product *:</label>
		<form:select id="heard" path="product" class="form-control" required="required">
			<form:option value="" label="Choose" />
			<form:options items="${productList}" />
		</form:select>
		<br>
		<div class="form-group">
			<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
				<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/image'">Cancel</button>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</div>
	</form:form>
	<!-- end form for validations -->

</div>