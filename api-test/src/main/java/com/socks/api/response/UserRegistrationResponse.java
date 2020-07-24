package com.socks.api.response;

import com.google.gson.annotations.SerializedName;

public class UserRegistrationResponse {

	@SerializedName("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}