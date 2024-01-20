<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>




<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:masterAfterLogin title="HomeAfterLogin">


	<jsp:attribute name="head"> 
	
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	 <style>
body {
	margin: 0;
	padding: 0;
	background-image: url('/images/wm2.png');
	background-size: cover;
	background-repeat: no-repeat;
}

.card {
	width: 250px;
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 10px;
	margin: 10px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.card img {
	width: 100%;
	height: auto;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}

.card-content {
	padding: 10px;
	text-align: center;
}

.cards-container {
	display: flex;
	justify-content: space-between;
	margin-top: 150px;
}

.card {
	flex: 1;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	text-align: center;
	transition: transform 0.3s;
	margin: 20px;
	max-width: calc(25% - 40px);
	background-color: #05386B;
}

.card1 {
	flex: 1;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	text-align: center;
	transition: transform 0.3s;
	margin: 20px;
	max-width: calc(25% - 40px);
	background-color: #05386B;
}

.card1 a {
	text-decoration: none;
}

.card img {
	width: 100%;
	max-height: 200px;
	margin-bottom: 15px;
	border-radius: 5px;
}

.card1 img {
	width: 100%;
	height: 200px;
	margin-bottom: 15px;
	border-radius: 5px;
}

.card1:hover {
	transform: translateY(-5px);
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.card1:hover img {
	transform: scale(1.1);
}

.navlinksdiv a {
	text-decoration: none;
	color: #EDF5E1;
	font-size: 20px;
	transition: background-color 0.3s ease;
}

.navlinksdiv a:hover {
	background-color: #5CDB95;
	color: #05386B;
}

.alert-container {
	display: none; /* Initially hidden */
	width: 300px;
	height: 55px;
	margin-left:600px;
	text-align: center;
	padding: 20px;
	border-radius: 6px;
	background-color: #d4edda;
	color: #155724;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Styles for the success icon */
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script>
$(document).ready(function() {
    var loginSuccess = "${loginSuccess}";
    var alertContainer = $("#loginAlert");

    if (loginSuccess === "true") {
        alertContainer.find(".alert-message").text("Login is Successful");
        alertContainer.show();

        // Hide the alert after 2 seconds
        setTimeout(function() {
            alertContainer.hide();
        }, 3000);
    }
});
</script>

</jsp:attribute>

	<jsp:attribute name="content">

<div class="alert-container" id="loginAlert">
        <div class="alert-icon">&#10003;</div>
        <div class="alert-message"></div>
    </div>

		<form>
  <div style="display: flex; flex-direction: row">
        <div class="cards-container">
        			<div class="card1">

                        <img src="/images/passport4.png" class="images"
							alt="Hassle-Free Booking" class="hassle-free-img">

<a href="/applyPassport"
							style="margin-bottom: 10px; margin-left: 140px; font-size: 25px; color: white; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;">  <span
							style="font-weight: bold;">Passport Apply</span><br></a>
	

  

                    </div>
 
                    <div class="card1">

                        <img src="/images/passportRenew.png"
							class="images" alt="Comfortable Journeys">

                        <a href="/passportReissue"
							style="margin-bottom: 10px; margin-left: 20px; font-size: 25px; color: white; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;"><span
							style="font-weight: bold;">Passport Renewal</span><br></a>

                    </div>

                

                    

                

                    <div class="card1">

                        <img src="/images/v1.png" class="images"
							alt="Extensive Routes">

                       <a href="/applyVisa"
							style="margin-bottom: 10px; margin-left: 15px; font-size: 25px; color: white; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;"><span
							style="font-weight: bold;">VISA Apply</span></a>

                    </div>

                

                    <div class="card1">

                        <img src="/images/v2.png" class="images"
							alt="Modern Amenities">

                        <a href="/cancelVisa"
							style="margin-bottom: 10px; margin-left: 3px; font-size: 25px; color: white; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); letter-spacing: 2px;"><span
							style="font-weight: bold;">Cancel VISA</span></a>

                    </div>

                </div>
</div>
                </form>



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
