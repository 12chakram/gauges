package com.idtracks.gauges.domain;

import java.io.InputStream;
import java.io.Serializable;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="idtracksusers")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uid;
	private String userName;
	private String password;
	private String email;
	private String cnfpassword;
	private String openId;
	private String fullName;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	
	private InputStream userprofileimg;
	private String fileName;
	private String fileLocation;
	public byte[] bytes;
	
	public User() {
	       super();
	  }
	  
	  @PersistenceConstructor
	  public User(String uid,String userName,String password, String email,String openId,String fullName,String firstName,String lastName,String gender, String dob) {
	    super();
	    this.uid = uid;
	    this.userName = userName;
	    this.password = password;
	    this.email = email;
	    this.openId =openId;
	    this.fullName = fullName;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.gender = gender;
	    this.dob =dob;
	  }
	 
	  public User(String uid,String userName,String password, String email,String openId,String fullName,String firstName,String lastName,String gender, String dob,String cnfpassword) {
	    super();
	    this.uid = uid;
	    this.userName = userName;
	    this.password = password;
	    this.email = email;
	    this.openId =openId;
	    this.fullName = fullName;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.gender = gender;
	    this.dob =dob;
	  }
	
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	public InputStream getUserprofileimg() {
		return userprofileimg;
	}

	public void setUserprofileimg(InputStream userprofileimg) {
		this.userprofileimg = userprofileimg;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	  public String toString() {
	    return "User [uid=" + uid + ", userName=" + userName + ", password="
	        + password+",email="+email+",openId="+openId+",fullName="+fullName+"]";
	  } 
}
