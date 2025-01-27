package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.StudentEntityRestAPI;
import com.student.service.StudentService;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/insertdata")
	public String insertData(@RequestBody StudentEntityRestAPI s) {
		String msg =service.insertData(s);
		return msg;
	}
	
	@DeleteMapping("/deletedata/{studId}")
	public String deleteData(@PathVariable int studId) {
		String msg =service.deleteData(studId);
		return msg;
	}
	
	@PutMapping("/updatedata/{studId}")
	public String updateData(@RequestBody StudentEntityRestAPI s ,@PathVariable int studId) {
		String msg = service.updateData(s, studId);
		return msg;
	}
	
	@GetMapping("/singledata")
	public StudentEntityRestAPI getSingleRecord(@RequestParam int studId) {
		StudentEntityRestAPI s = service.getSingleRecord(studId);
		return s;
	}
	@GetMapping("/alldata")
	public List<StudentEntityRestAPI> getAllRecord() {
		List<StudentEntityRestAPI> s = service.getAllRecord();
		return s;
	}
}
