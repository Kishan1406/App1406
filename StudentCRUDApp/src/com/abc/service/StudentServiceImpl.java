package com.abc.service;

import com.abc.dao.IStudentDao;
import com.abc.factory.StudentDaoFactory;
import com.abc.factory.StudentServiceFactory;
import com.abc.pojo.Student;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String save(Student student) {
		IStudentDao studentDao = StudentDaoFactory.getDao();
		return studentDao.save(student);
	}

	@Override
	public Student getById(Integer id) {
		 IStudentDao studentDao = StudentDaoFactory.getDao();
		 return studentDao.getById(id);
		
	}

	@Override
	public String updateById(Student student) {
		IStudentDao studentDao = StudentDaoFactory.getDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer id) {
		IStudentDao studentDao = StudentDaoFactory.getDao();
		return studentDao.deleteById(id);
	}

}
