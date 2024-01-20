package com.techwave.client.models.restconnect;;

public class visa_urls {
	public static final String APPLY_VISA="http://localhost:9000/applyVisa";
	
	public static final String CANCEL_VISA="http://localhost:9000/cancelVisa/{vid}";
	
	public static final String GET_VISA_BY_ID="http://localhost:9000/getVisaById/{vid}";
	
	public static final String GET_ALL_VISAS="http://localhost:9000/getAllVisas";
	
	public static final String GET_VISA_BY_USER_ID="http://localhost:9000/getVisaByUserId/{uid}";
	
	public static final String GET_ALL_VISAS_BY_STATUS= "http://localhost:9000/getAllVisasByStatus/{status}";
	
	public static final String GET_USER_VISA_BY_ID_AND_STATUS= "http://localhost:9000/getUserVisaByIdAndStatus/{uid}/{status}";

}
