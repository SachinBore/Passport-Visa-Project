<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>ContactUs</title>
    <link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/styles/contactus.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="content">
      <div class="left-side">
        <div class="address details">
          <i class="fas fa-map-marker-alt"></i>
          <div class="topic">Address</div>
          <div class="text-one">qwerty</div>
          <div class="text-two">Z hub city</div>
        </div>
        <div class="phone details">
          <i class="fas fa-phone-alt"></i>
          <div class="topic">Phone</div>
          <div class="text-one">1236767889</div>
          <div class="text-two">184302321</div>
        </div>
        <div class="email details">
          <i class="fas fa-envelope"></i>
          <div class="topic">Email</div>
          <div class="text-one">abc@gmail.com</div>
          <div class="text-two">xyz@gmail.com</div>
        </div>
      </div>
      <div class="right-side">
        <div class="topic-text">ContactUs</div>
        <p>If you have any work from us or any types of queries related to our application, you can send us message from here. It is our pleasure to help you.</p>
      <form action="#">
        <div class="input-box">
          <input type="text" placeholder="Enter your name">
        </div>
        <div class="input-box">
          <input type="text" placeholder="Enter your email">
        </div>
        <div class="input-box message-box">
          <textarea rows="" cols="" placeholder="Enter your queries"></textarea>
        </div>
        
        <div class="button">
          <input type="button" value="Send Now" >
        </div>
        <div class="button">

        <a href="${referer}">

  <input type="button" value="Back">

</a>

</div>
      </form>
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
</body>
</html>