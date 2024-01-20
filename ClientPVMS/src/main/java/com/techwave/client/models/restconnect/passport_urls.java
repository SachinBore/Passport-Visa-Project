package com.techwave.client.models.restconnect;

public class passport_urls {
	public static final String APPLY_PASSPORT = "http://localhost:9000/applyPassport";
	public static final String REISSUE_PASSPORT = "http://localhost:9000/reissuePassport";
	public static final String GET_ALL_PASSPORTS = "http://localhost:9000/getAllPassports";
	public static final String GET_PASSPORT_BY_PASSPORT_ID = "http://localhost:9000/getByPassportId/{pid}";
	public static final String GET_PASSPORT_BY_USER_ID = "http://localhost:9000/getPassportByUserId/{uid}";
	public static final String GET_ALL_PASSPORT_BY_STATUS = "http://localhost:9000/getAllPassportByStatus/{status}";
	public static final String GET_USER_PASSPORT_BY_ID_AND_STATUS = "http://localhost:9000/getUserPassportStatus/{uid}/{status}";

}
