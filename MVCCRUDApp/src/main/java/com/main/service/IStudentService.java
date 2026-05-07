package com.main.service;

import java.util.List;

import com.main.entity.Student;

public interface IStudentService {
	
	public Student save(Student student);
	
	public Student findById(Integer sid);

	public String deleteById(Integer sid);

	public Student editById(Integer sid, Student student);

	public java.util.List<Student> getAll();

	public void inputlist(List<Student> student);

	public void count();

	public void check(Integer sid);

	

	

	

	

	

	

	
	
	

	
	
	
	

}
