package dataStructs;

import java.util.ArrayList;

public class userStruct {
	private String UserName;
	private String UserPass;
	private Integer UserType;
	public userStruct(String name,String pass,Integer type){
		this.UserName = name;
		this.UserPass = pass;
		this.UserType = type;
	}
	
	public String getUserPass(){
		return UserPass;
	}
	
	public String getUserName(){
		return UserName;
	}
	
	public Integer getUserType(){
		return UserType;
	}
}

