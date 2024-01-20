<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<m:masterBeforeLogin title="LoginPage">


	<jsp:attribute name="head">
	 
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	 
<link rel="stylesheet" href="\styles\login.css">



<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

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

/* .close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
} */

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

.Logoutmodal {
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
.Logoutmodal-content {
	background-color: #fefefe;
	margin: 10% auto;
	padding: 20px;
	border: 1px solid #888;
	border-radius: 10px;
	width: 30%;
	height: auto;
	position: relative;
}

.Logoutok-button {
	display: inline-block;
	padding: 5px 10px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 4px;
	cursor: pointer;
	margin-left: 350px;
}


.Logoutok-button:hover {
	background-color: #0056b3;
}

#LogoutmodalMessage {
	font-size: 20px;
	line-height: 1.2;
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


<script>
	$(document).ready(function() {

		var FailMessage = "${FailMessage}";

		if (FailMessage === "Please Logout.") {
			
			var modal = $("#LogoutmyModal");
			var modalMessage = $("#LogoutmodalMessage");
			var okButton = $("#LogoutokButton");

			modalMessage.html(FailMessage); 
			modal.css("display", "block");

			okButton.click(function() {
				modal.css("display", "none");
			});

		}
		else if(FailMessage){
			var modal = $("#myModal");
			var modalMessage = $("#modalMessage");
			var okButton = $("#okButton");

			modalMessage.html(FailMessage); 
			modal.css("display", "block");

			okButton.click(function() {
				modal.css("display", "none");
			});
		}

	});
</script>

</jsp:attribute>

	<jsp:attribute name="content">

<body>

  <div class="big-container">
        <div class="form-container"
					style="background-color: rgba(255, 255, 255, 0.9);">
            <div class="form-content">
                <form method="post" action="/checkUser"
							class="container form-group">
                   <!--  <h1 style="margin-bottom: 10px; margin-left: 140px;">Registration Now</h1> -->
                   <h1
								style="margin-bottom: 10px; margin-left: 140px; font-size: 36px; color: #05386B; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;">
    				<span style="font-weight: bold;">Login</span><br>
					</h1>
                    <div class="main">
                    <div class="side-by-side">
                    	<div>
                        	<input required class="inputval"
											name="username" placeholder="User Name" type="text" />		
						</div>
                    
                   		 <div>
                       			 <input required class="inputval"
											name="password" placeholder="Password" type="password" />
						</div>
						</div>
                    </div>
                    
                    <div class="terms">
                    	<input type="checkbox" id="terms" name="terms"
									required>
            			I agree to the <a href="/termsandconditions" class="a2">Terms and Conditions</a>.
                    </div>
                    <div style="margin-left: 140px; margin-top: 20px;">
                         <input type="submit" value="Login" id="submit">
                    </div>
                   <div class="signup">
                    		<p>Not a User?<a href="/Registration"
										class="a1">Register</a>
								</p>
                    </div>
                  
              </form>
              </div>
            </div>
</div>


  
    <div id="LogoutmyModal" class="Logoutmodal">
        <div class="Logoutmodal-content">
            <p id="LogoutmodalMessage"></p>
            <div class="Logoutmodal-buttons">
                <a href="/Logout" class="Logoutok-button">Logout</a>
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