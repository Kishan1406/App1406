package com.abc.controller;

import com.abc.pojo.Student;

public interface IStudentController {
	
	public String save(Student student);
	
	public Student getById(Integer id);
	
	public String updateById(Student student);
	
	public String deleteById(Integer id);
	

}
