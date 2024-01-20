<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>




<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:masterAfterLogin title="HomeAfterLogin">



 <div id="MastermyModal" class="Mastermodal">
  <div class="Mastermodal-content">
      <p id="MastermodalMessage"></p>
      <div class="Mastermodal-buttons">
           <a href="/Logout" class="Masterok-button">Home</a>
      </div>
  </div>
</div>
</m:masterAfterLogin>