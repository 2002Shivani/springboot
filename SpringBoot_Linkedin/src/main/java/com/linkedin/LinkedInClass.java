package com.linkedin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linkedin.com")
public class LinkedInClass {

	@PostMapping("/feed")
	public String feedMethod() {
		return "Feed Page";
	}
	
	@GetMapping("/job")
	public String jobMethod() {
		return "Job Page";
	}
	
	@PutMapping("/message")
	public String messageMethod() {
		return "Message Page";
	}
	
	@DeleteMapping("/network")
	public String networkMethod() {
		return "Network Page";
	}
	
	@PatchMapping("/notification")
	public String notificationMethod() {
		return "Notification Page";
	}
}
