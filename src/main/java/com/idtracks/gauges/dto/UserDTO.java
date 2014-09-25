package com.idtracks.gauges.dto;

public class UserDTO {

	private String uid;
	private String userName;
	private String secpassword;
	private String email;
	private String cnfpassword;
	private String openId;
	private String fullName;
	private boolean userFindByEmail;
	private boolean accept;
	private String loginpwd;
	
	
	
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
	
	public String getSecpassword() {
		return secpassword;
	}
	public void setSecpassword(String secpassword) {
		this.secpassword = secpassword;
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
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	
}
