package com.idtracks.gauges.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String email;
	
	private String name;
	
	public Collection<GrantedAuthority> getAuthorities() {
		Collection grantedAuthorities = new HashSet<String>();
	    grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
	    return grantedAuthorities;		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return "";
	}

	public String getUsername() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
