package com.synerzip.projectmanagement.responce;

import com.google.gson.Gson;

public class ResponseHandler {

	public String getErrorResponce(){
		String error="{'message':'record not found','error_code':'404'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;
	}
	
	public String getAllErrorResponce(){
		String error="{'message':'record empty','error_code':'101'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;
	}
	
	public String postErrorResponce(){
		String error="{'message':'record already exist','error_code':'302'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;
	}
	
	public String deleteErrorResponce(){
		String error="{'message':'record already deleted','error_code':'400'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;
	}
	
	public String deleteAllErrorResponce(){
		String error="{'message':'nothing to delete','error_code':'400'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;		
	}
	
	public String putErrorResponce(){
		String error="{'message':'record already updated','error_code':'304'}";
		Gson gson =new Gson();
		String jsonError=gson.toJson(error);
		return jsonError;
	}
}
