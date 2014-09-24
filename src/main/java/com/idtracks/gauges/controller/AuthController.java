/**
 * 
 */
package com.idtracks.gauges.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.idtracks.gauges.dto.UserDTO;

/**
 * @author vayyala
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
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
}



