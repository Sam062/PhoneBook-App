<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script>
	$(function() {
		// Initialize form validation on the registration form.
		// It has the name attribute "registration"
		$("form[name='registration']").validate({
			// Specify validation rules
			rules : {
				// The key name on the left side is the name attribute
				// of an input field. Validation rules are defined
				// on the right side
				contactName : "required",

				contactEmail : {
					required : true,
					// Specify that email should be validated
					// by the built-in "email" rule
					contactEmail : true
				},
				contactNumber : {
					required : true,
					minlength : 10
				}
			},
			// Specify validation error messages
			messages : {
				contactName : "Please enter your name",

				contactNumber : {
					required : "Please provide phone no",
					minlength : "Your phno must be at least 10 characters long"
				},
				contactEmail : "Please enter a valid email address"
			},
			// Make sure the form is submitted to the destination defined
			// in the "action" attribute of the form when valid
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
<title>Phone Book App</title>
</head>

<body>
	<%@include file="Header.jsp"%>
	<div class="container" align="center">
		<form:form action="/add" method="POST" modelAttribute="Model"
			name="registration">
			<table class="table-hover">
				<tr>
					<td colspan="2" class="success">
						<h3 class="text text-warning" align="center">CONTACT DETAILS</h3>
					</td>
				</tr>
				<tr>
					<td><form:hidden path="contactID" /></td>
				</tr>
				<tr>
					<td>CONTACT NAME</td>
					<td><form:input path="contactName" required="required" /></td>
				</tr>
				<tr>
					<td>CONTACT EMAIL</td>
					<td><form:input path="contactEmail" required="required" /></td>
				</tr>
				<tr>
					<td>CONTACT NUMBER &nbsp;</td>
					<td><form:input path="contactNumber" required="required" /></td>
				</tr>

				<tr>
					<td align="right"><input type="submit" class="btn btn-primary"
						value="SAVE" /></td>
					<td align="center"><input type="reset" class="btn btn-danger"
						value="RESET" /></td>
				</tr>
			</table>
		</form:form>
		<h3 class="text-success">${msg}</h3>
	</div>
</body>
</html>