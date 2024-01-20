<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<m:masterAfterLogin title="VisaApply">
	<jsp:attribute name="head">
	
	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<!-- Link to your custom CSS file -->
<link href="/styles/profile.css" rel="stylesheet">

 <!-- <style>
body {
	/* font-family: Arial, sans-serif; */
	margin: 0;
	padding: 0;
	background-color: #grey; /* 
	background-image: url('/images/wm2.png');
	background-size: cover;
	background-repeat: no-repeat; */
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.no-records {
	font-style: italic;
	color: #888;
	margin-top: 10px;
}

.navlinksdiv a {
	text-decoration: none !important;
	font-size: 20px;
	margin: 0 8px;
}

.navlinksdiv a:hover {
	background-color: #5CDB95;
	color: #05386B;
}
</style>  -->
</jsp:attribute>

	<jsp:attribute name="content">
    
    
    
    <body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-6">
                <h1>My Profile</h1>
                <form>
                    <!-- User Profile Fields -->
                    <div class="form-group">
                        <label>User ID</label>
                        <input type="text" class="form-control"
									value="${userDetails.userId}" readonly>
                    </div>
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control"
									value="${userDetails.firstName}" readonly>
                    </div>
                    <div class="form-group">
                        <label>Surname</label>
                        <input type="text" class="form-control"
									value="${userDetails.surname}" readonly>
                    </div>
                    <div class="form-group">
                        <label>DOB</label>
                        <input type="text" class="form-control"
									value="${userDetails.dateOfBirth}" readonly>
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <input type="text" class="form-control"
									value="${userDetails.gender}" readonly>
                    </div>
                    <div class="form-group">
                        <label>Contact No</label>
                        <input type="text" class="form-control"
									value="${userDetails.contactNo}" readonly>
                    </div>
                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="text" class="form-control"
									value="${userDetails.emailAddress}" readonly>
                    </div>
                </form>
            </div>
        </div>

        <!-- Passport Records -->
        <div class="row mt-4">
            <div class="col-md-12">
                <h2>Passport Records</h2>
                <c:if test="${not empty passportDetails}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Passport Id</th>
                                <th>Country</th>
                                <th>Issue Date</th>
                                <th>Expiry Date</th>
                                <th>Cost</th>
                                <th>Status</th>
                                <!-- Add other table headers here -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${passportDetails}"
										var="pd">
                                <tr>
                                    <td>${pd.passportId}</td>
                                    <td>${pd.country}</td>
                                    <td>${pd.issueDate}</td>
                     				<td>${pd.expiryDate}</td>
                     					<td>${pd.cost}</td>
                     					<td>${pd.status}</td>
                                    <!-- Add other table data here -->
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty passportDetails}">
                    <p class="no-records">No Records found for Passport</p>
                </c:if>
            </div>
        </div>

        <!-- Visa Records -->
        <div class="row mt-4">
            <div class="col-md-12">
                <h2>Visa Records</h2>
                <c:if test="${not empty visaDetails}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Visa Id</th>
                                <th>Passport Id</th>
                                 <th>Country</th>
                 					<th>Occupation</th>
                  				<th>Date Of Application</th>
                  				 <th>Date Of Issue</th>
                    <th>Date Of Expiry</th>
                     <th>Registration Cost</th>
                	<th>Status</th>
                                <!-- Add other table headers here -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${visaDetails}" var="vd">
                                <tr>
                                    <td>${vd.visaId}</td>
                                    <td>${vd.passportId.passportId}</td>
                                     <td>${vd.country}</td>
                                       <td>${vd.occupation}</td>
                                           <td>${vd.dateOfApplication}</td>
                                             <td>${vd.dateOfIssue}</td>
                                               <td>${vd.expiryDate}</td>
                                                 <td>${vd.registrationCost}</td>
                                                 <td>${vd.status}</td>
                                    <!-- Add other table data here -->
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty visaDetails}">
                    <p class="no-records">No Records found for Visa</p>
                </c:if>
            </div>
        </div>
    </div>
    <!-- Include Bootstrap JS scripts here if needed -->
</body>
    
    
    
</jsp:attribute>
</m:masterAfterLogin>