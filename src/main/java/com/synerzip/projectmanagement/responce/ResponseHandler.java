package com.synerzip.projectmanagement.responce;

import com.google.gson.Gson;

public class ResponseHandler {

	Gson gson = new Gson();

	public String getErrorResponce() {
		String error = "{'message':'record not found','error_code':'404'}";
		return gson.toJson(error);
	}

	public String getAllErrorResponce() {
		String error = "{'message':'record empty','error_code':'101'}";
		return gson.toJson(error);
	}

	public String postErrorResponce() {
		String error = "{'message':'record already exist','error_code':'302'}";
		return gson.toJson(error);
	}

	public String deleteErrorResponce() {
		String error = "{'message':'record already deleted','error_code':'400'}";
		return gson.toJson(error);
	}

	public String deleteAllErrorResponce() {
		String error = "{'message':'nothing to delete','error_code':'400'}";
		return gson.toJson(error);
	}

	public String putErrorResponce() {
		String error = "{'message':'record not found','error_code':'304'}";
		return gson.toJson(error);
	}
	
	public String getPaginateError() {
		String error = "{'message':'value must be positive','error_code':'101'}";
		return gson.toJson(error);
	}
}
