<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:masterBeforeLogin title="HomeBeforeLogin">


	<jsp:attribute name="head"> 
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
	
<style>
body {
	margin: 0;
	padding: 0; /* 
	background-image: url('/images/flight.png');
	background-size: cover; */
}

.image {
	background-image: url('/images/flight.png');
	background-size: cover;
	height: 100vh;
	width: 100vw;
	position: absolute;
	top: 0;
	left: 0;
	z-index: -2;
	margin-top: -300px;
	margin-left: -692px;
}

.overlay {
	background-color: rgba(0, 0, 0, 0.3);
	height: 100vh;
	width: 100vw;
	position: absolute;
	top: 0;
	left: 0;
	z-index: -1;
	height: 100vh;
	margin-top: -300px;
	margin-left: -692px;
}

.center .btns {
	margin-top: 20px;
}

.center .btns button {
	height: 55px;
	width: 170px;
	border-radius: 5px;
	border: none;
	margin: 0 10px;
	border: 2px solid white;
	font-size: 20px;
	font-weight: 500;
	padding: 0 10px;
	cursor: pointer;
	outline: none;
	transition: all 0.3s ease;
}

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}

.title {
	font-size: 60px;
	font-weight: bold;
	margin-bottom: 20px;
	color: white;
	white-space: nowrap;
}

.btns button {
	background-color: white;
	color: #ffffff;
	/* Set default text color to white */
	padding: 15px 30px;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease, color 0.3s ease;
	color: #ffffff;
}

.btns button a {
	font-family: Arial, sans-serif;
	text-decoration: none;
	color: black;
}

.btns button:hover {
	font-family: Arial, sans-serif;
	background-color: #05386B; /* Change background color on hover */
	color: white; /* Change text color on hover */
}

.btns button:hover a {
	color: white;
}

span {
	color: yellow;
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
	margin-left: 350px;
}

.ok-button:hover {
	background-color: #0056b3;
}

.alert-container {
	display: none; 
	width: 300px;
	height: 55px;
	
	text-align: center;
	margin-top: -250px;
	margin-left: -200px;
	padding: 20px;
	border-radius: 6px;
	background-color: #d4edda;
	color: #155724;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
} 

.alert-icon {
	display: inline-block;
	width: 40px;
	height: 40px;
	background-color: #28a745;
	color: white;
	border-radius: 50%;
	font-size: 24px;
	line-height: 40px;
	margin-bottom: 10px;
}
</style>
	

<script>
	$(document).ready(function() {

		var FailMessage = "${FailMessage}";
		
		var LogoutMessage = "${sessionScope.LogoutMessage}";

		if (FailMessage) {
			
			var modal = $("#myModal");
			var modalMessage = $("#modalMessage");
			var okButton = $("#okButton");

			modalMessage.html(FailMessage); 
			modal.css("display", "block");

			okButton.click(function() {
				modal.css("display", "none");
			});

		}
		else if(LogoutMessage === "true") {
		    var alertContainer = $("#logoutAlert");

		        alertContainer.find(".alert-message").text("Successfully Logged Out");
		        alertContainer.show();

		        setTimeout(function() {
		            alertContainer.hide();
		        }, 3000);
		    
		}

	});
</script>
	

</jsp:attribute>

	<jsp:attribute name="content">
	
	
	
	
	
	<div class="image"></div>
	<div class="overlay"></div>
	<div class="main">
	 <div class="alert-container" id="logoutAlert">
        <div class="alert-icon">&#10003;</div>
        <div class="alert-message"></div>
    </div>
	<div class="center">
  <div class="title">Welcome to <span class="auto-type"></span> Management System</div>
  <div class="btns">
    <button>
					<a href="/Login">Login</a>
				</button>
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
	
	<script>
		var typed = new Typed(".auto-type", {
			strings : [ "Passport", "Visa" ],
			typeSpeed : 150,
			backSpeed : 100,
			loop : true
		})
	</script>
	
	</jsp:attribute>



</m:masterBeforeLogin>
