<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>




<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:AdminMasterTag title="Admin">

	<jsp:attribute name="head"> 
	
	<style>
body {
	margin: 0;
	padding: 0;
	background-image: url('/images/wm2.png');
	background-size: cover;
	background-repeat: no-repeat;
}
<style>
.cards-container {
	margin-top:200px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: flex-start;
    margin: 20px;
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

.card1:hover {
	transform: translateY(-5px);
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.top {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 20px;
}

.bottom {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>
	
	
	
	
	</jsp:attribute>


	<jsp:attribute name="content">



<form>
    <div class="cards-container">
        <div class="top">
            <div class="card1">
                <a href="/applyPassport">Get Users Details</a>
            </div>
            <div class="card1">
                <a href="/passportReissue">Update Visa Cost</a>
            </div>
            <div class="card1">
                <a href="/passportReissue">Update Passport Cost</a>
            </div>
        </div>
        <div class="bottom">
            <div class="card1">
                <a href="/applyVisa">Update Visa Permit Years</a>
            </div>
            <div class="card1">
                <a href="/cancelVisa">Update Session Time</a>
            </div>
            <div class="card1">
                <a href="/cancelVisa">Set Notices</a>
            </div>
        </div>
    </div>
</form>













</jsp:attribute>





</m:AdminMasterTag>