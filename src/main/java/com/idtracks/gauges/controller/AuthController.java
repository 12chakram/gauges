/**
 * 
 */
package com.idtracks.gauges.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.Signal;

import com.idtracks.gauges.domain.User;
import com.idtracks.gauges.dto.UserDTO;
import com.idtracks.gauges.service.UserService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

/**
 * @author vayyala
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	protected static Logger logger = Logger.getLogger("controller");
	
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String signIn(@RequestParam (value="error", required=false) boolean error, ModelMap model){
		logger.debug("requested for login page");
		model.addAttribute("userAttribute", new UserDTO());
		if (error){
			model.put("error", "Ypu have entered an invalid username or password");
		}else{
			model.put("error","");
		}
		return "signin";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signUp(@RequestParam (value="error", required=false) boolean error, ModelMap model){
		logger.debug("requested for login page");
		model.addAttribute("userAttribute", new UserDTO());
		if (error){
			model.put("error", "Ypu have entered an invalid username or password");
		}else{
			model.put("error","");
		}
		return "signup";
	}
	
	@RequestMapping(value="/signupProcess", method=RequestMethod.POST)
	public ModelAndView doSignUp(@ModelAttribute("userAttribute") UserDTO userdto, HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView model =null;
		User signupUser = new User();
		
		signupUser.setEmail(userdto.getEmail());
		signupUser.setUserName(userdto.getUserName());
		signupUser.setPassword(userdto.getPassword());
		
		  String result = userService.addUser(signupUser);
		
			if(result.equalsIgnoreCase("sucess")){
				model = new  ModelAndView("dashboard");
				signupUser =userService.getUser(signupUser.getUserName(),signupUser.getPassword());
				model.addObject("signupUser", signupUser);
				return model;
			}else{
				model = new  ModelAndView("signup");
				return model;
			}
		
	}
	
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView loginProcess (@ModelAttribute ("userAttribute") UserDTO user, HttpServletRequest request){
		
		ModelAndView model =null;
    	User loggedInUser = userService.getUser(user.getUserName(),user.getPassword());
    	
    	if(loggedInUser!=null){
    		model = new  ModelAndView("dashboard");
    	}else{
    		model = new  ModelAndView("/");
    	}
    	return model;
	}
}



