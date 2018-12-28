<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.vuthong.ecommerce.vo.ImageVO"%>
<div class="x_title">
	<h2>Create Image</h2>

	<div class="clearfix"></div>
</div>
<div class="x_content">

	<!-- start form for validation -->
	<form:form id="demo-form" modelAttribute="imageVO"
		action="${pageContext.request.contextPath}/admin/image/create"
		method="post" data-parsley-validate="" enctype="mutipart/form-data">
		<label for="fullname">Select a file to upload * :</label>
		<form:input type="file" id="fullname" path="pathImage" class="form-control" name="file"
			required="required" />
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