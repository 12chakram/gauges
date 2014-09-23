package com.idtracks.gauges.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idtracks.gauges.domain.User;
import com.idtracks.gauges.service.UserService;

/**
 * Handles and retrieves person request
 * 
 * @author Krams at {@link http://krams915@blogspot.com}
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="userService")
	private UserService userService;
	
	HttpSession session;
    
    /**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/common", method = RequestMethod.GET)
    public String getCommonPage(Model model,HttpServletRequest request) {
    	String result = "";
    	String page = "";
    	logger.debug("Received request to show common page");
    	OpenIDAuthenticationToken token = (OpenIDAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
    	List<OpenIDAttribute> attributes = token.getAttributes();    	
    	final String openId = SecurityContextHolder.getContext().getAuthentication().getName();
    	
    	 String email = "";
    	 String fullName = "";
    	 String firstName = "";
    	 String lastName = "";
    	 
    	if(openId.contains("yahoo")){
    		 email = attributes.get(0).getValues().get(0);
        	 fullName = attributes.get(1).getValues().get(0);
    	}else if (openId.contains("google")){
    		 email = attributes.get(0).getValues().get(0);
        	 firstName = attributes.get(1).getValues().get(0);
        	 lastName = attributes.get(2).getValues().get(0);
    	}
    	
    	User user =userService.findUserByOpenId(openId);    	
    	session = request.getSession(true);
		if(user!=null && !StringUtils.isBlank(openId)){
				user.setEmail(email);
				user.setFullName(firstName);
				user.setLastName(lastName);
				user.setFullName(fullName);
				userService.updateUser(user);
			
      }else{
			user = new User();
			user.setEmail(email);
	    	user.setFirstName(firstName);
	    	user.setLastName(lastName);
	    	user.setOpenId(openId);
	    	result = userService.addUser(user);
	    	page = "dashboard";
	    	if(result.equalsIgnoreCase("duplicateEmail")){
	    		model.addAttribute("emailWarningMsg", true);
	    		user = new User();
	    		user.setEmail(email);
	    		model.addAttribute("userAttribute",user);
	    		page = "signup";
	    	}
		  }
			session.setAttribute("haveCurrentLocation", true);
		  	model.addAttribute("showMap", true);
			model.addAttribute("isDefault", true);
			return page;
		
   }
    
    /**
     * Handles and retrieves the admin JSP page that only admins can see
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
    	logger.debug("Received request to show admin page");
    
    	// Do your work here. Whatever you like
    	// i.e call a custom service to do your business
    	// Prepare a model to be used by the JSP page
    	
    	// This will resolve to /WEB-INF/jsp/adminpage.jsp
    	return "adminpage";
	}
}
