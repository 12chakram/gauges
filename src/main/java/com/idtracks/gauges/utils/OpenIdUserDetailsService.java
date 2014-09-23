package com.idtracks.gauges.utils;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.idtracks.gauges.security.UserDetails;

public class OpenIdUserDetailsService implements UserDetailsService {
	
    public UserDetails loadUserByUsername(String openIdIdentifier) {    	    	    	
     UserDetails userDetails =new UserDetails();
    	userDetails.setUserName(openIdIdentifier);    	
        return userDetails;
    }
}