package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Student;
import com.main.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService stdservice;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return stdservice.save(student);
	}
	
	@GetMapping("/findBy/{id}")
	public Student fingById(@PathVariable("id") int sid) {
		return stdservice.findById(sid);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer sid) {
		return stdservice.deleteById(sid);
	}
	
	@PutMapping("/edit/{id}")
	public Student editById(@PathVariable("id") Integer sid,@RequestBody Student student) {
		student.setSid(sid);
		return stdservice.editById(sid,student);
	}
	
	@GetMapping ("/findall")
	public List<Student>  getAll() {
		return stdservice.getAll();
	}
	
	@PostMapping("/inputlist")
	public void inputlist(@RequestBody List<Student> student) {
		 stdservice.inputlist(student);
	}
	
	@GetMapping("/count")
	public void count() {
		stdservice.count();
	}
	
	@GetMapping("/exists/{id}")
	public void check(@PathVariable("id") Integer sid) {
		stdservice.check(sid);
		
	}
	
	
	
	
	

}
