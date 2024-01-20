<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<m:masterAfterLogin title="VisaApply">

	<jsp:attribute name="head">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/ApplyVisa.css">
	
	
<style>
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: 10% auto;
	padding: 20px;
	border: 1px solid #888;
	border-radius: 10px;
	width: 30%;
	height: auto;
	position: relative;
	font-size: 20px;
}

/* Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
.ok-button {
    display: inline-block;
    padding: 5px 10px;
    background-color: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 4px;
    cursor: pointer;
    margin-left:300px;
}
#modalMessage {
    font-size: 20px;
    line-height: 1.5;
}

#modalMessage strong {
    font-weight: bold;
}
.ok-button:hover {
    background-color: #0056b3;
}
</style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

     <script>
	var data = [];

	  $(document).ready(function(){
		  
		var check = true;
		
		var message = "${message}";
	
		
var messageArray = message.split(",");


        if (messageArray.length === 5) {
        	
        	check = false;
        	
      
        	var formattedMessage = "Dear User,<br>" +
	        "<strong>Your New Visa Id :</strong> " + messageArray[0] + "<br>" +
	        "<strong>Occupation :</strong> " + messageArray[1] + "<br>" +
	        "<strong>Issue Date :</strong> " + messageArray[2] + "<br>" +
	        "<strong>Expiry Date :</strong> " + messageArray[3] + "<br>" +
	        "<strong>Cost :</strong> " + messageArray[4];

	    var modal = $("#myModal");
	    var modalMessage = $("#modalMessage");
	    var okButton = $("#okButton");

	    modalMessage.html(formattedMessage); // Use .html() to render HTML content
	    modalMessage.css("white-space", "pre-line");
	    modal.css("display", "block");

	    okButton.click(function() {
	        modal.css("display", "none");
	    });
        }
		
        else if(message) {
			
			var modal = $("#myModal");
	        var modalMessage = $("#modalMessage");
	        var okButton = $("#okButton");

	        modalMessage.text(message);
	        modal.css("display", "block");

	        // Close the modal and navigate to the /home controller when the OK button is clicked
	        okButton.click(function() {
	            modal.css("display", "none");
	        });
			
		}
		
	
		var userId = $("#userID").val();
		var status = "Active";
		
		
		$.ajax({
			type : "Get",
			url : "http://localhost:9000/getUserVisaByIdAndStatus2/"+userId+"/"+status,
			dataType : "json",
			async : false,
			contentType : "application/json;charset=utf-8",
			
			success : function(data) {
				
				if(check && data.length == 3) {

					var modal = $("#myModal");
			        var modalMessage = $("#modalMessage");
			        var okButton = $("#okButton");

			        modalMessage.text("You have applied all countries Visa's");
			        modal.css("display", "block");

			        // Close the modal and navigate to the /home controller when the OK button is clicked
			        okButton.click(function() {
			            modal.css("display", "none");
			        });
				}
					
				else if (data === []) {
				// If no active visas, set the default value to include all three countries
				console.log(data[0].country);

				$("#countryId").empty(); // Clear existing options

				$("#countryId").append('<option value="USA">USA</option>');
				$("#countryId").append('<option value="JAPAN">JAPAN</option>');
				$("#countryId").append('<option value="CHINA">CHINA</option>');

				} else {
				
					let userActiveCountries = [];
					
					for (let i = 0; i < data.length; i++) {

						userActiveCountries.push(data[i].country);

						console.log(data[i].country);

				}

				// Define all available countries

				let allCountries = ["USA","JAPAN","CHINA" ];

				// Filter out the countries with active visas from all available countries

				let availableCountries = allCountries.filter(function(country) {

					return !userActiveCountries.includes(country);

				});

				// Clear existing options and update the dropdown options

				$("#countryId").empty();

				for (let i = 0; i < availableCountries.length; i++) {

					$("#countryId").append('<option value="' + availableCountries[i] + '">'+ availableCountries[i]+ '</option>');

				}

				}

			},

			error : function(x, error) {
	
				alert("server error");
			}

		}); // end of ajax

		});//end of jquery  
		
</script>
    </jsp:attribute>

	<jsp:attribute name="content">

    

 
<div class="big-container" >
<div class="form-container" >
<div class="form-content"  >
    

    

<f:form action="insertIntoVisa" modelAttribute="visaDetails"
			method="post" class="container form-group" style="background-color: rgba(255, 255, 255, 0.7);">
			<!-- <h1 style="margin-bottom:10px;margin-left:30px;">Apply VISA</h1> -->
			<h1
								style="margin-bottom: 10px; margin-left: 140px; font-size: 36px; color: #05386B; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;">
    <span style="font-weight: bold;">Apply VISA</span><br>
</h1>

<table>

<tr>

    <td><f:input path="visaId" style="display: none;"></f:input></td>

    <td><f:errors path="visaId"></f:errors></td>

</tr>

<tr> <td>User Id </td>

    <td><f:input path="userId.userId" id="userID" readonly="true"></f:input></td>

    <td><f:errors path="userId"></f:errors></td>

</tr>

 

<tr> <td>Passport Id </td>

    <td><f:input path="passportId.passportId" readonly="true"></f:input></td>

    <td><f:errors path="passportId"></f:errors></td>

</tr>

<tr>

                    <td>Country</td>

                    <td>

                        <f:select path="country" id="countryId">

                        <f:option value="">Select an option</f:option>

                            

                        </f:select>

                    </td>

                    <td><f:errors path="country"></f:errors></td>

                </tr>

<tr>

    <td>Occupation</td>

    <td>

        <f:select path="occupation">

            <f:option value="">Select</f:option>

            <f:option value="Student">Student</f:option>

            <f:option value="Private Employee">Private Employee</f:option>

            <f:option value="Government Employee">Government Employee</f:option>

            <f:option value="Self Employed">Self Employed</f:option>

            <f:option value="Retired Employee">Retired Employee</f:option>

        </f:select>

    </td>

    <td><f:errors path="occupation"></f:errors></td>

</tr>

 

 

<tr> <td>DateOfApplication</td>

    <td><f:input path="dateOfApplication" type="date"
							readonly="true"></f:input></td>

    <td><f:errors path="dateOfApplication"></f:errors></td>

</tr>

<tr>

    <td><f:input path="dateOfIssue" type="date"
							style="display: none;"></f:input></td>

    <td><f:errors path="dateOfIssue"></f:errors></td>

</tr>

<tr>

    <td><f:input path="registrationCost" style="display: none;"></f:input></td>

    <td><f:errors path="registrationCost"></f:errors></td>

</tr>

<tr>

    <td><f:input path="expiryDate" type="date"
							style="display: none;"></f:input></td>

    <td><f:errors path="expiryDate"></f:errors></td>

</tr>

<tr>

    <td><f:input path="status" style="display: none;"></f:input></td>

    <td><f:errors path="status"></f:errors></td>

</tr>

<tr>
<td></td>
                    <td><input type="submit" style="margin-top:-160px;margin-left:50px;"></td> </tr>            

    </table>

</f:form>
</div>
</div>
</div>


		<div id="myModal" class="modal">
    <div class="modal-content">
        <p id="modalMessage"></p>
        <div class="modal-buttons">
            <a href="/services" class="ok-button">services</a>
        </div>
    </div>
</div>

  <div id="MastermyModal" class="Mastermodal">
  <div class="Mastermodal-content">
      <p id="MastermodalMessage"></p>
      <div class="Mastermodal-buttons">
            <a href="/Logout" class="Masterok-button">Home</a>
      </div>
  </div>
</div>

</jsp:attribute>


</m:masterAfterLogin> 