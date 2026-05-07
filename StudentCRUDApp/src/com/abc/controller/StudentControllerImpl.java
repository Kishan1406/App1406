package com.abc.controller;

import com.abc.dao.IStudentDao;
import com.abc.factory.StudentDaoFactory;
import com.abc.factory.StudentServiceFactory;
import com.abc.pojo.Student;
import com.abc.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public String save(Student student) {
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.save(student);
		
	}

	@Override
	public Student getById(Integer id) {
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.getById(id);
	}

	@Override
	public String updateById(Student student) {
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer id) {
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.deleteById(id);
	}

}
