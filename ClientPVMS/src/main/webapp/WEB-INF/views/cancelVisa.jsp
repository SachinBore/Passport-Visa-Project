<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

 

<m:masterAfterLogin title="">

<jsp:attribute name="head">

 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/cancelVisa.css">

 

 

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

 

.ok-button:hover {

    background-color: #0056b3;

}

 

.inline-label {

        display: inline-block;

        width: 150px;

        vertical-align: top; /* Adjust vertical alignment if needed */

    }

 

    .input-field {

        /* Adjust width to leave space for the label */

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

 

</style>

 

<script

    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

 

<script>

     $(document).ready(function() {

    	 
        var message = "${message}";

 

        if (message) {

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

        

        <!-- 1.after selecting any dropdown other than default we need to fetch the corresponding values, write a ajax code for it-->

        <!-- 2.after clicking submit then display the message that is coming from the server -->

        <!-- 3.after clicking OK on the given message then redirect user to home page-->

 		

        var dropdown = $("#visaId");

        dropdown.change(function() {

        

            var selectedValue = $(this).val();

            
			
            if (selectedValue !== "") {

                alert("in the select if");

                $.ajax({

                    type:"Get",

                    url:"http://localhost:9000/getVisaById/"+selectedValue,

                    

                    dataType:"json",

                    async:true,

                    contentType:"application/json;charset=utf-8",

                    success:function(data)

                    {
                 
                        $("#userId").val(data.userId.userId);

                        $("#passportId").val(data.passportId.passportId);

                        $("#issueDate").val(data.dateOfIssue);

                        $("#country").val(data.country);

                    },

                    error:function(x,error)

                    {
                    	/* alert("in error");
                    
						alert(x);
						alert(error); */
                        //alert("The server returned an error. Please contact the administrator for more information.");

                    }

                }); // end of ajax

            }

        }); // end of dropdown

        

        

        $("#btnClick").click(function(){

             event.preventDefault();

            var visaId = $("#visaId").val();

            

          

            

            

             $.ajax({

                type:'Put',

                url:"http://localhost:9000/cancelVisa/"+visaId,

                dataType:"text",

                contentType:"application/json;charset=utf-8",

                async:false,

                success:function(data)

                {

                    var modal = $("#myModal");

                    var modalMessage = $("#modalMessage");

                    var okButton = $("#okButton");

                    modalMessage.text(data);

                    modal.css("display", "block");

 

                    // Close the modal and navigate to the controller when the OK button is clicked

                    okButton.click(function() {

                        modal.css("display", "none");

                        // Navigate to the controller URL

                    });

                },

                error:function(x,err)

                {

                    //alert("The server returned an error. Please contact the administrator for more information.");

                }

            });

            

            

        });

        

        

        

    }); // end of jquery

</script>

</jsp:attribute>

<jsp:attribute name="content">

<body>

 

 

 

    <form method="post" class="container form-group" style="background-color: rgba(255, 255, 255, 0.7);margin-top:40px;">

<h1 style="margin-bottom: 10px; margin-left: 90px; font-size: 36px; color: #05386B; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); ">
    <span style="font-weight: bold;">Cancel VISA</span><br>
</h1>
        <table>

 

            <tr>

                <td>Choose VisaId</td>

                <td  class="input-field"><select id="visaId" required>

 

                        <option value="" selected>Select an option</option>
						
                        <c:forEach items="${vdlist}" var="list">

                            <option value="${list.visaId}">${list.visaId}</option>

                        </c:forEach>

                </select></td>

            </tr>

 

            <tr>

                <td>User Id</td>

                <td><input type="text" id="userId" readonly></td>

            </tr>

 

            <tr>

                <td>Passport Id</td>

                <td><input type="text" id="passportId" readonly></td>

            </tr>

 

            <tr>

                <td>Visa Issue date</td>

                <td><input type="date" id="issueDate" readonly></td>

            </tr>

 

            <tr>

                <td>Visa Applied Country</td>

                <td><input type="text" id="country" readonly></td>

            </tr>

 

            <tr>

                <td><input type="submit" value="Cancel Visa" id="btnClick"></td>

            </tr>

 

        </table>

 

        <div id="myModal" class="modal">

    <div class="modal-content">

        <p id="modalMessage"></p>

        <div class="modal-buttons">

            <a href="/services" class="ok-button">services</a>

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
 

 

</body>

</jsp:attribute>

</m:masterAfterLogin>