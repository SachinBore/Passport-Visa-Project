	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

 

<m:masterAfterLogin title="">

 

 

    <jsp:attribute name="head">

    

<link rel="stylesheet"  href="/styles/applyPassport.css">

<!-- Add these links to the <head> section of your HTML or JSP file -->

 

 

 

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

    margin-left:335px;

}

.inline-label {

        display: inline-block;

        width: 150px;

        vertical-align: top; /* Adjust vertical alignment if needed */

    }

 

    .input-field {

        /* Adjust width to leave space for the label */

    }

 

.ok-button:hover {

    background-color: #0056b3;

}

/*  @media screen and (max-width: 768px) {

        .field-row {

            flex-direction: column;  

        }  */

.field-row {

        display: flex;

        align-items: center;

        margin-bottom: 10px;

    }

 

    /* Style for field name */

    .field-name {

        width: 150px;

        /* font-weight: bold; */

    }

 

    /* Style for input field */

    .input-field {

       /*  flex: 1;

         margin-left: 10px; */

          /*   border: 2px solid #ccc; */

   /*  border-radius: 10px; */

    width: 200px;

    height: 45px;

  /*    padding: 10px;*/

    font-size: 15px;

     transition: transform 0.3s ease, box-shadow 0.3s ease

         

    }

    

    #pin{

        margin-left:30px;

    }

</style>

 

<style>

    .highlight {

        background-color: yellow;

        /* You can add more styles here, if needed */

    }

</style>

 

<script

    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

 

    

    <script>

    

     $(document).ready(function() {

        

        var message = "${message}";

        var messageArray = message.split(",");
        
        
        if (messageArray.length === 3) {
        
        	var formattedMessage = "Dear User,<br>" +
	        "<strong>Your New Passport Id :</strong> " + messageArray[0] + "<br>" +
	        "<strong>New Expiry Date :</strong> " + messageArray[2] + "<br>" +
	        "<strong>Cost :</strong> " + messageArray[1];

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

            modalMessage.css("white-space", "pre-line");

            modal.css("display", "block");

            

            okButton.click(function() {

                modal.css("display", "none");

            });

        }

        

        

        $("#city").append("<option value=''>select</option>");

        $("#state").append("<option value='''>select</option>");

        

        $.ajax({

            type:'GET',

            url:"http://localhost:9000/getAllStates",

            dataType:"JSON",

            contentType : "application/json;charset=utf-8",

            async : false,

            success: function(data) {

                

                for (var i = 0; i < data.length; i++) {

                    $("#state").append("<option value='" + data[i].stateName + "'>"+ data[i].stateName+ "</option>");

                }

            },

            error:function(x,err) {

                

                var modal = $("#myModal");

                var modalMessage = $("#modalMessage");

                var okButton = $("#okButton");

                

                modalMessage.text("The server returned an error. Please contact the administrator for more information");

 

                modal.css("display", "block");

                

                okButton.click(function() {

                    modal.css("display", "none");

                });

                

            }

        }); // end of ajax

        

        $("#state").change(function() {

            var state = $("#state").val();

            

            $.ajax({

                type:'GET',

                url:"http://localhost:9000/getAllCitiesByState/"+state,

                dataType:"JSON",

                contentType : "application/json;charset=utf-8",

                async : false,

                success: function(data) {

                    

                    $("#city").empty();

                    $("#city").append("<option value=-1>select</option>");

                    

                    for (var i = 0; i < data.length; i++) {

                        $("#city").append("<option value='" + data[i] + "'>"+ data[i]+ "</option>");

                    }

                },

                error:function(x,err) {

                    var modal = $("#myModal");

                    var modalMessage = $("#modalMessage");

                    var okButton = $("#okButton");

                    

                    modalMessage.text("The server returned an error. Please contact the administrator for more information");

                    modal.css("display", "block");

                    

                    okButton.click(function() {

                        modal.css("display", "none");

                    });

                }

            }) // end of ajax

        }); // end of change

        

        

    }); // end of ready

     

    </script>

</jsp:attribute>

 

 

    <jsp:attribute name="content">

    <body>

<div class="big-container">

<div class="form-container">

<div class="form-content">

    

    <f:form action="PassportCheck" method="post"  style="background-color: rgba(255, 255, 255, 0.7);"
							modelAttribute="passport" class="container form-group">
    <!-- <h1 style="margin-bottom: 10px; margin-left: 30px;">Passport Application</h1> -->
    <h1 style="margin-bottom: 10px; margin-left: 20px; font-size: 36px; color: #05386B; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); ">
    <span style="font-weight: bold;">Passport Application</span><br>
</h1>
    
    <div class="field-row">
        <div class="field-name">Country</div>
        <div class="input-field">
            <f:input path="country" readonly="true" />
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">State</div>
        <div class="input-field">
            <f:select path="state" required="true"></f:select>
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">City</div>
        <div class="input-field">
            <f:select path="city" required="true"></f:select>
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">pin number</div>
        <div class="input-field" id="pin">
            <f:input type="number" path="pin" required="true" />
        </div>
        <div>
            <f:errors path="pin" class="f-errors" />
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">Type of Service</div>
        <div style="margin-left:90px;">
        <div class="input-field">
            <f:radiobutton path="typeOfService" value="Normal" required="true" />Normal
        
            <f:radiobutton path="typeOfService" value="Tatkal" /> Tatkal
        </div>
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">Booklet Type</div>
        <div style="margin-left:90px;">
        <div class="input-field">
            <f:radiobutton path="bookletType" value="30Pages"
										required="true" />30 Pages
            <f:radiobutton path="bookletType" value="60Pages" /> 60 Pages
        </div>
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">Issue Date</div>
        <div class="input-field">
            <f:input path="issueDate" type="date" readonly="true"></f:input>
        </div>
        <div>
            <f:errors path="issueDate" class="f-errors" />
        </div>
    </div>
    
    <div class="field-row">
        <div class="field-name">UserId</div>
        <div class="input-field">
            <f:input path="userId.userId" readonly="true" required="true" />
        </div>
    </div>
    
    <div>
        <input type="submit">
    </div>
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

    </body>

</jsp:attribute>
</m:masterAfterLogin>
