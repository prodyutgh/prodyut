package com.ecommercef.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@Controller
public class BaseController {
	
	public User loggedInUser;
	
	@Autowired
	private UserService userService;
	
	protected String getBaseURL(HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	
	protected String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("BaseController -> getPrincipal() : " + SecurityContextHolder.getContext().getAuthentication().getName());
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        if(!userName.equals("anonymousUser")){
        	this.loggedInUser = userService.getUserByEmail(userName);
        	userName = this.loggedInUser.getFirst_name() + " " + this.loggedInUser.getLast_name();
        }
        return userName;
    }
}
