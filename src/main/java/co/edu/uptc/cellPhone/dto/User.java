package co.edu.uptc.cellPhone.dto;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	
	public User() {
		super();
	}
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + "]";
	}

}
