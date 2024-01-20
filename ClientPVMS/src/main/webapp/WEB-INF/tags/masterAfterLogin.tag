<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="title" rtexprvalue="true" required="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="content" fragment="true"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/styles/MasterAfterLoginStyle.css">
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="ISO-8859-1"> 
<title>MasterAfterLogin</title>

<style>

.Mastermodal {
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
.Mastermodal-content {
	background-color: #fefefe;
	margin: 10% auto;
	padding: 20px;
	border: 1px solid #888;
	border-radius: 10px;
	width: 30%;
	height: auto;
	position: relative;
}



.Masterok-button {
	display: inline-block;
	padding: 5px 10px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 4px;
	cursor: pointer;
	margin-left: 350px;
}

.Masterok-button:hover {
	background-color: #0056b3;
}

#MastermodalMessage {
	font-size: 20px;
	line-height: 1.2;
}

</style>

<!--  For the Server Sent Event -->
<script>
    // Include the user's userId in the page
    const username = '<%= request.getSession().getAttribute("username") %>';
</script>

<script>
    // SSE JavaScript code
    const eventSource = new EventSource('http://localhost:9000/sse');
  

    eventSource.addEventListener('message', (event) => {
        const data = JSON.parse(event.data);
        
        //checking by session attribute
        //if (data.userId === username)
        if (data.userId === username)
        {
        	
        	
        	var modal = $("#MastermyModal");
			var modalMessage = $("#MastermodalMessage");
			var okButton = $("#MasterokButton");

			modalMessage.html("Session Expired"); 
			modal.css("display", "block");

			okButton.click(function() {
				modal.css("display", "none");
			});
            
            //window.location.href = '/home';
        }
    });

    eventSource.addEventListener('error', (event) => {
        if (event.readyState === EventSource.CLOSED) {
            
          
            alert('SSE connection closed');
        }
    });
</script>
</head>
<body>
	<div class="total-div">
		<div class="navdiv">

			<div class="navlogodiv">
				<a ><b>VisaWave</b></a>
			</div>

			<div class="navlinksdiv">
			<a href="/aboutus">About Us</a>  <a href="/services">Services</a>
				<a href="/contactus">Contact Us</a> <a href="/notices">Notices</a>
			</div>


			<div class="navprofilediv">
				<div class="circular-image">
					<img alt="Profile" src="/images/profile3.png" id="profile-icon">
				</div>
				<div class="dropdown-content" id="profile-dropdown">
					<a href="/myProfile">MyProfile</a> <a href="/Logout">Logout</a>
				</div>
			</div>
		</div>
		<jsp:invoke fragment="head"></jsp:invoke>
		<jsp:invoke fragment="content"></jsp:invoke>
	</div>
	
	<script>

  document.addEventListener("DOMContentLoaded", function () {

    const currentPath = window.location.pathname; // Get the current path

 

    // Get all navigation links

    const navLinks = document.querySelectorAll('.navlinksdiv a');

 

    // Loop through the links and check if the link's href matches the current path

    navLinks.forEach(link => {

      if (link.getAttribute('href') === currentPath) {

        link.classList.add('active');

      }

    });

  });

</script>
</body>
</html>
