package com.idtracks.gauges.dto;

public class UserDTO {

	private String uid;
	private String userName;
	private String password;
	private String email;
	private String cnfpassword;
	private String openId;
	private String fullName;
	private boolean userFindByEmail;
	private boolean accept;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnfpassword() {
		return cnfpassword;
	}
	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public boolean isUserFindByEmail() {
		return userFindByEmail;
	}
	public void setUserFindByEmail(boolean userFindByEmail) {
		this.userFindByEmail = userFindByEmail;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
	
}
