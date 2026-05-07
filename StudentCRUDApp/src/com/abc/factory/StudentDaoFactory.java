package com.abc.factory;

import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoImpl;

//FACTORY DESIGN PATTEN CODE
public class StudentDaoFactory {
	
	private static IStudentDao studentDao;

	static {
		 studentDao = new StudentDaoImpl();
	}
	
	public static IStudentDao getDao() {
		return studentDao;
	}

}
