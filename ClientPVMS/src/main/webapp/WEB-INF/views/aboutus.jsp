<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>About Us - Visa and Passport Management Application</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	/*    background-image: url('/images/wm2.png'); */
	/* background-color: #; */
}

.header {
	padding-down: 50px;
	text-align: center;
	padding: 20px;
}

.contact-info {
	margin-top: 2px;
	border-top: 1px solid #ddd;
	padding-top: 20px;
	color: black;
	text-align: center;
	padding: 20px;
}

.container {
	max-width: 1000px;
	font-size: 14px;
	margin: 0 auto;
	padding: 20px;
	line-height: 1.6;
	margin-top: -50px;
}

.mission {
	font-size: 15px;
	margin-bottom: 20px;
}

.features {
	margin-bottom: 20px;
}

.features h2 {
	font-size: 15px;
}

.features li {
	margin-bottom: 10px;
}

.why-choose {
	margin-bottom: 20px;
	/*   text-align: center; */
}

.why-choose h2 {
	margin-bottom: 10px;
	font-size: 15px;
}

.why-choose li {
	margin-bottom: 5px;
}

.contact-info {
	margin-top: 30px;
	border-top: 1px solid #ddd;
	padding-top: 30px;
	text-align: center;
}

.contact-info h2 {
	font-size: 24px;
	margin-bottom: 15px;
	color: #333;
}

.contact-list {
	list-style: none;
	padding-left: 0;
}

.contact-list li {
	margin-bottom: 15px;
	color: #666;
}

.contact-list li strong {
	color: #333;
}
/* Responsive Adjustments */
@media screen and (max-width: 768px) {
	nav ul {
		flex-direction: column;
		align-items: center;
	}
	nav ul li {
		margin: 10px 0;
	}
}

.about-us-section {
	padding: 100px 0;
	text-align: center;
	opacity: 0; /* Initial opacity set to 0 */
	animation: fadeInUp 1s forwards; /* Apply the fadeInUp animation */
}

@
keyframes fadeInUp {from { opacity:0;
	transform: translateY(20px); /* Slide content up slightly */
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
.button {
	text-align: center;
	margin-top: 20px; /* Adjust this value as needed */
}

.button input[type="button"] {
	color: #fff;
	font-size: 18px;
	outline: none;
	border: none;
	padding: 8px 16px;
	border-radius: 6px;
	background: #0398fc;
	cursor: pointer;
	transition: all 0.3s ease;
}

.button input[type="button"]:hover {
	background: white;
	color: #0398fc;
	border: 1px solid #0398fc;
}

a {
	color: #007bff; /* Change link color to blue */
	text-decoration: none; /* Remove default underline */
}

/* Apply styles on hover */
a:hover {
	text-decoration: underline; /* Underline on hover */
}

/* Apply styles on click */
a:active {
	background-color: #f8f8f8; /* Add background color on click */
}
</style>
</head>
<body>
	<div class="header">
		<h1>About Us</h1>
	</div>
	<div class="container">
		<div class="mission">
			<p>
				Welcome to <span style="font-weight: bold;">VisaWave</span>, your
				trusted partner in simplifying and streamlining the visa and
				passport management process. We understand that navigating the
				complexities of visa and passport requirements can be a daunting
				task, whether you are a traveler seeking hassle-free documentation
				or a corporation managing international assignments.
			</p>
		</div>
		<div class="features">
			<h2>What We Offer</h2>
			<ul>
				<li><b>Visa Application Management:</b> Say goodbye to long
					queues and confusing paperwork.</li>
				<li><b>Passport Renewals and Update:</b> Keep your passport
					up-to-date without the stress.</li>
				<li><b>Traveler Profiles:</b> Store your travel and identity
					information securely in one place.</li>
				<li><b>Corporate Solutions:</b> For businesses with global
					operations, managing employee travel and expatriate assignments can
					be complex.</li>
			</ul>
		</div>
		<div class="why-choose">
			<h2>Why Choose Us</h2>
			<ul>
				<li><b>Expertise:</b> Our team includes experienced experts in
					immigration, travel, and technology.</li>
				<li><b>User-Friendly Interface:</b> Our app has an easy-to-use
					design that helps you step by step..</li>
				<li><b>Security:</b> Your privacy and security are of the
					utmost importance to us.</li>
				<li><b>Customer Support:</b> Need assistance? Our dedicated
					customer support team is here to help.</li>
			</ul>
		</div>

		<p>
			At <span style="font-weight: bold;">VisaWave</span>,We really care
			about making visas and passports easy to handle. Come join us as we
			change how people and groups deal with travel documents for other
			countries.
		</p>
		<div>
			<p>
				<b>If you have any questions, please check our <a href="/FAQs">FAQs</a>
					page for answers.
				</b>
			</p>
		</div>
		<div class="button">

			<a href="${referer}"> <input type="button" value="Back">

			</a>

		</div>
	</div>

	<div class="contact-info">
		<h2>Contact Us</h2>
		<ul class="contact-list">
			<li><strong>Phone:</strong> 123-456-7890</li>
			<li><strong>Email:</strong> abc@visaservices.com</li>
		</ul>
	</div>
</body>
</html>