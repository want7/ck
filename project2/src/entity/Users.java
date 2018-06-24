package entity;

import java.io.Serializable;

public class Users implements Serializable{
	private String username;
	private String emailaddress;
	private String password;
	private String confirmpassword;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}
}
