<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan's Records</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 align="center">______ All Records______</h2>
		
		
	<spring:url value="/home/addLoan/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New</a>
		
		
		<spring:url value="/home/addloan/" var="addURL" />
		<a  class="btn btn-primary" href="${addURL }" role="button">Search</a> 
		
		
	
		
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
                               <th scope="row">Edit</th>
				<th scope="row">View</th>
			</thead>
			<tbody>
				<c:forEach items="${loanList }" var="loan">
					<tr>
						
						<td>${loan.id}</td>
loan						<td>${loan.name}</td>
						<td>${loan.address}</td>
						<td>${loan.mobile}</td>
						<td>${loan.email}</td>
                                                <td>${loan.location}</td>
                                                <td>${loan.date}</td>
                                                <td>${loan.loanamount}</td>
						<td><spring:url
								value="/home/updateLoan/${loan.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Edit</a></td>
						<td><spring:url
								value="/home/viewLoan/${loan.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">View</a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>