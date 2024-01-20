<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<m:masterBeforeLogin title="Registration">

	<jsp:attribute name="head">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet"
			href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="\styles\UserRegistration.css">
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- Include jQuery UI library before your custom script -->
	
    <style>
textarea.no-resize {
	resize: none;
}

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
	margin-left: 300px;
}

.ok-button:hover {
	background-color: #0056b3;
}

.my-errors {
	margin-left: 3px;
	color: red;
}

.inputval {
	width: 100px;
}

/* Add styling for the formatted message */
#modalMessage {
    font-size: 20px;
    line-height: 1.5;
}

#modalMessage strong {
    font-weight: bold;
}

</style>

    <style>
.highlight {
	background-color: yellow;
	/* You can add more styles here, if needed */
}

.main {
	display: flex;
	flex-direction: row;
}
</style>

<script>
  function updateMaxDate() {
    var today = new Date();
    var maxDate = today.toISOString().split('T')[0];
    document.getElementById('dateInput').setAttribute('max', maxDate);
  }
  // Call the function initially to set the max attribute based on the current date

</script>

   
<script>
  function updateMaxDate() {
    var today = new Date();
    var maxDate = today.toISOString().split('T')[0];
    document.getElementById('dateInput').setAttribute('max', maxDate);
  }
  // Call the function initially to set the max attribute based on the current date

</script>

<script>
$(document).ready(function() {
	
	
	if (typeof $.fn.datepicker !== 'undefined') {
		$('#dateOfBirth').datepicker({
			dateFormat : 'dd-mm-yy', // Set your desired date format
			showAnim : 'slideDown', // Specify animation when the datepicker is shown
			changeMonth : true,
			changeYear : true,
			yearRange : '1900:2030', // Specify the year range
		});
											
		$('#dateOfBirth').attr('placeholder','Date of Birth');
	} else {
		console.error('jQuery UI Datepicker is not properly loaded.');
	}
											
	$("#submit").click(function() {
		var dateOfBirthValue = $("#dateOfBirth").val();
		var dateOfBirthType = typeof dateOfBirthValue;

	});
	
	  	
	$("#registrationForm").submit(function(event) {
        var emailErrorMessage = $("#emailErrorMessage").text();
        var contactErrorMessage = $("#contactErrorMessage").text();
        
        // Check if error messages are empty
        if (emailErrorMessage.trim() !== "" || contactErrorMessage.trim() !== "") {
            event.preventDefault(); // Prevent form submission
            alert("Please enter valid ContactNo/Email");
        }
    });
	
	var message = "${message}";
	
	var FailMessage = "${FailMessage}";

	if (message) {
	    var messageArray = message.split(",");
	    var formattedMessage = "Dear User,<br>" +
	        "<strong>Your User ID:</strong> " + messageArray[0] + "<br>" +
	        "<strong>Password:</strong> " + messageArray[1] + "<br>" +
	        "<strong>Planning for:</strong> " + messageArray[2] + "<br>" +
	        "<strong>Citizen Type:</strong> " + messageArray[3];

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
 else if(FailMessage) {
		
		var modal = $("#myModal");
        var modalMessage = $("#modalMessage");
        var okButton = $("#okButton");
		
        modalMessage.text(FailMessage);
        modal.css("display", "block");
        
        okButton.click(function() {
            modal.css("display", "none");
        });
		
	}
	 
	 
	 $("#email").blur(function(){
			var email = $("#email").val();
			
			 $.ajax({
				type:"Get",
				url:"http://localhost:9000/checkEmail/"+email,
				dataType:"text",
				contentType:"application/json;charset=utf-8",
				success:function(data)
				{
					if(data === "Exist") {
						$("#emailErrorMessage").text("Email already exists");
					}
					else {
						$("#emailErrorMessage").empty();
					}
				},
				error:function(x,error)
				{
					/* alert(x.readyState);
					alert(x.responseText); */
					alert("server error, please try again");
				}
			}); 
		});
	 
	 $("#contact").blur(function(){
			var contact = $("#contact").val();

			
			$.ajax({
				type:"Get",
				url:"http://localhost:9000/checkContactNo/"+contact,
				dataType:"text",
				contentType:"application/json;charset=utf-8",
				success:function(data)
				{
					if(data === "Exist") {
						$("#contactErrorMessage").text("contact already exists");
					}
					else {
						$("#contactErrorMessage").empty();
					}
				},
				error:function(x,error)
				{
					/* alert(x.readyState);
					alert(x.responseText); */
					alert("server error, please try again");
					
				}
			});
		});
	 
	
});




</script>
</jsp:attribute>

	<jsp:attribute name="content">
    <body>
    
    <div class="big-container">
        <div class="form-container" style="background-color: rgba(255, 255, 255, 0.9);">
            <div class="form-content">
            
                <f:form method="post" modelAttribute="userRegistration"
							id="registrationForm" action="RegistrationCheck" class="container form-group">
                   <!--  <h1 style="margin-bottom: 10px; margin-left: 140px;">Registration Now</h1> -->
                   <h1
								style="margin-bottom: 10px; margin-left: 140px; font-size: 36px; color: #05386B; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;">
    <span style="font-weight: bold;">Register Now</span><br>
</h1>
                   
                    
                    <div class="main">
                    <div class="side-by-side">
                    <div>
                        <f:input path="firstName" required="true"
											class="inputval" placeholder="First Name" />
                        <div class="my-errors">
											<f:errors path="firstName" class="f-errors"></f:errors>
										</div>
                    </div>
                    <div>
                        <f:input path="surname" required="true"
											placeholder="Surname" />
                        <div class="my-errors">
											<f:errors path="surname" class="f-errors"></f:errors>
										</div>
                    </div>
                    <div>
                        <f:input type="text" path="dateOfBirth"
											required="true" id="dateOfBirth" placeholder="Date of Birth" />
                        <div class="my-errors">
											<f:errors path="dateOfBirth" class="f-errors"></f:errors>
										</div>
                    </div>
                    <div>
                        <f:select path="gender" required="true"
											id="gender">
                            <option value="" selected disabled>Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </f:select>
                    </div>
                    <div>
                        <f:input path="contactNo" id="contact" required="true"
											placeholder="Contact Number" />
                    	
        				<div id="contactErrorMessage" class="error-message"></div>
    				
                    </div>
                    <div>
                        <f:input path="emailAddress"  id="email" required="true"
											placeholder="Email Address" />
                     <div id="emailErrorMessage" class="error-message"></div>
                    </div>
                    </div>
                    <div class="side-by-side">
                    <div>
                        <f:select path="qualification" required="true"
											id="qualification">
                            <option value="" selected disabled>Qualification</option>
                            <option value="highschool">High School</option>
                            <option value="diploma">Diploma</option>
                            <option value="bachelors">Bachelor's Degree</option>
                            <option value="masters">Master's Degree</option>
                            <option value="phd">Ph.D.</option>
                            <option value="other">Other</option>
                        </f:select>
                    </div>
                    <div>
                        <div class="apply-type-div">
                            <h4 class="applyType" style="color: grey;">Apply Type </h4>
                            <f:radiobutton path="applyType"
												value="Passport" required="true" />
                            <p style="color: grey;"> Passport</p>
                            <f:radiobutton path="applyType" value="Visa" />
                           	<p style="color: grey;">Visa</p>
                        </div>
                    </div>
                    <div>
                        <f:select path="hintQuestion" required="true"
											id="hintQuestion">
                            <option value="" selected disabled>Hint Question</option>
                            <option value="motherMaidenName">What is your mother's maiden name?</option>
                            <option value="firstPet">What was the name of your first pet?</option>
                            <option value="birthCity">In which city were you born?</option>
                            <option value="favoriteBook">What is your favorite book?</option>
                            <option value="schoolName">Which school did you attend in childhood?</option>
                        </f:select>
                    </div>
                    <div>
                        <f:input path="hintAnswer" required="true"
											placeholder="Hint Answer" />
                        <div class="my-errors">
											<f:errors path="hintAnswer" class=".f-errors"></f:errors>
										</div>
                    </div>
                    <div>
                        <f:textarea path="address" class="no-resize"
											rows="5" cols="40" required="true" placeholder="Address"></f:textarea>
                        <div class="my-errors">
											<f:errors path="address"></f:errors>
										</div>
                    </div>
                    <div style="margin-left: 20px; margin-top: 10px;">
                         <input type="submit" value="Register"
											id="submit">
                    </div>
                    </div>
                    </div>
                </f:form>
            </div>
        </div>
    </div>

    <div id="myModal" class="modal">
        <div class="modal-content">
            <p id="modalMessage"></p>
            <div class="modal-buttons">
                <a href="/home" class="ok-button">Home</a>
            </div>
        </div>
    </div>
    </body>
</jsp:attribute>
</m:masterBeforeLogin>