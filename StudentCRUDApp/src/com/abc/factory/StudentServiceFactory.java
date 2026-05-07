package com.abc.factory;

import com.abc.service.IStudentService;
import com.abc.service.StudentServiceImpl;

//FACTORY DESIGN PATTEN CODE
public class StudentServiceFactory {
	
	private static IStudentService studentService;

	static {
		 studentService= new StudentServiceImpl();
	}
	
	public static IStudentService getService() {
		return studentService;
	}

}
