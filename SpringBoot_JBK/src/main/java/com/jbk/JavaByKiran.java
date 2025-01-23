package com.jbk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thekiranacadmey.com")
public class JavaByKiran {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		return "Home Page";
	}
	
	@RequestMapping(value = "/course",method = RequestMethod.POST)
	public String coursePage() {
		return "Course Page";
	}
	
	@RequestMapping(value = "/learn",method = RequestMethod.PUT)
	public String learnPage() {
		return "Learn Page";
	}
	@RequestMapping(value = "/about",method = RequestMethod.DELETE)
	public String aboutUsPage() {
		return "About Us Page";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.PATCH)
	public String registerPage() {
		return "Register Page";
	}
	
}
