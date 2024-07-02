package com.aynavil.festivehall.DTO;


public class PropertiesDTO {

    private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PropertiesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PropertiesDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

 
}
