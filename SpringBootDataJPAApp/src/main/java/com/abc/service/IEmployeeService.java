package com.abc.service;

import java.util.List;

import com.abc.model.Employee;

public interface IEmployeeService {
	public void save(Employee e);
	
	public void findById(Integer eid);
	
	public List<Employee>findAll();

	public void deleteById(Integer eid);
	
	public void deleteAll();
	
	
}
