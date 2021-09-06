<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Loan Form</title>
        <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
              rel="stylesheet" />
        <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <spring:url value="/home/saveLoan" var="saveURL" />
            <h2>Persons's Details</h2>
            <form:form modelAttribute="loanForm" method="post"
                       action="${saveURL }" cssClass="form">
                <form:hidden path="id" />
                <div class="form-group">
                    <label>Id No.</label>
                    <form:input path="id" cssClass="form-control" id="id" />
                </div>

                <div class="form-group">
                    <label>Name</label>
                    <form:input path="name" cssClass="form-control"
                                id="name" />
                </div>

                <div class="form-group">
                    <label>Address</label>
                    <form:input path="address" cssClass="form-control" id="address" />
                </div>
                <h2>Spouse</h2>
                <div class="form-group">
                    <label>Mobile Number</label>
                    <form:input path="mobile" cssClass="form-control"
                                id="mobile" />
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <form:input path="email" cssClass="form-control"
                                id="email" />
                </div>

                <div class="form-group">
                    <label>Location</label>
                    <form:input path="location" cssClass="form-control"
                                id="location" />
                </div>
                <div class="form-group">
                    <label>Date</label>
                    <form:input path="date" cssClass="form-control"
                                id="date" />
                </div>

                <h2>Children</h2>
                <h3>1st child</h3>
                <div class="form-group">
                    <label>Loan Amount</label>
                    <form:input path="loanamount" cssClass="form-control"
                                id="loanamount" />
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form:form>

        </div>

    </body>
</html>