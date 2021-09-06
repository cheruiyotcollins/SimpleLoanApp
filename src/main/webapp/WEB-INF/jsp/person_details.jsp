<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan's Details</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 align="center">Details</h2>
		<spring:url value="/home/list"
			var="deleteURL" />
		<a class="btn btn-primary" href="${deleteURL }" role="button">Back to all</a>

		<spring:url value="/home/deleteLoan/${personDetails.id }"
			var="deleteURL" />
		<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
         <p >Last Modified ${personDetails.date_created }</p>
		<table class="table table-striped">
			<thead>

				<th scope="row">Id Number</th>
				<th scope="row">Name</th>
				<th scope="row">Address</th>
				<th scope="row">Mobile Number</th>
				<th scope="row">Email</th>
                                <th scope="row">Location</th>
                                <th scope="row">Date</th>
                                <th scope="row">Loan Amount</th>
				<th scope="row">Edit.</th>
				

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>

					<td>${personDetails.id}</td>
					<td>${personDetails.name}</td>
					<td>${personDetails.address}</td>
					<td>${personDetails.mobile}</td>
					<td>${personDetails.email}</td>
                                        <td>${personDetails.location}</td>
                                        <td>${personDetails.date}</td>
                                        <td>${personDetails.loanamount}</td>
					
					<td><spring:url
							value="/home/updateLoan/${personDetails.id }"
							var="updateURL" /> <a class="btn btn-primary"
						href="${updateURL }" role="button">Edit Details</a></td>



				</tr>

			</tbody>
		</table>
		<h4>Spouse</h4>
		<table class="table table-striped">
			<thead>

				<th scope="row">Id No.</th>
				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>
				<th scope="row">Mobile No.</th>
			</thead>
			<tbody modelAttribute="personDetails">

				<tr>

					<td>${personDetails.id_number_spouse }</td>
					<td>${personDetails.first_name_spouse }</td>
					<td>${personDetails.last_name_spouse }</td>
					<td>${personDetails.tel_spouse }</td>


				</tr>

			</tbody>
		</table>

		<h4>1st Child</h4>
		<table class="table table-striped">
			<thead>


				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>


					<td>${personDetails.first_name_child1 }</td>
					<td>${personDetails.last_name_child1 }</td>



				</tr>

			</tbody>
		</table>

		<h4>2nd Child</h4>
		<table class="table table-striped">
			<thead>


				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>


					<td>${personDetails.first_name_child2 }</td>
					<td>${personDetails.last_name_child2 }</td>



				</tr>

			</tbody>
		</table>

		<h4>3rd Child</h4>
		<table class="table table-striped">
			<thead>


				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>


					<td>${personDetails.first_name_child3 }</td>
					<td>${personDetails.last_name_child3 }</td>



				</tr>

			</tbody>
		</table>

		<h4>4th Child</h4>
		<table class="table table-striped">
			<thead>


				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>


					<td>${personDetails.first_name_child4 }</td>
					<td>${personDetails.last_name_child4 }</td>



				</tr>

			</tbody>
		</table>

		<h4>5th Child</h4>
		<table class="table table-striped">
			<thead>


				<th scope="row">First Name</th>
				<th scope="row">Last Name</th>

			</thead>
			<tbody modelAttribute="personDetails">

				<tr>


					<td>${personDetails.first_name_child5 }</td>
					<td>${personDetails.last_name_child5 }</td>



				</tr>

			</tbody>
		</table>

	</div>
	<p>all rights reserved kelvin Collins</p>
</body>
</html>