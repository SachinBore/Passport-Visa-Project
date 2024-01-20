<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="title" rtexprvalue="true" required="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="content" fragment="true"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/styles/MasterBeforeLogin.css">

<meta charset="ISO-8859-1">
<title>MasterBeforeLogin</title>



</head>
<body>

	<div class="navdiv">

		<div class="navlogodiv">
			<a  href="/home"><b>VisaWave</b></a>
		</div>

		<div class="navlinksdiv">
			<a href="/home">Home</a> <a href="/aboutus">About Us</a> <a href="ServicesInfo">Services</a>
			<a href="/contactus">Contact Us</a> <a href="/notices">Notices</a>
		</div>

	</div>

	
	<jsp:invoke fragment="head"></jsp:invoke>
	<div class="centered-div">
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
