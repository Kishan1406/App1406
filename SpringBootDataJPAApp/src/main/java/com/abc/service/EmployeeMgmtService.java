package com.abc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.abc.SpringBootDataJpaAppApplication;
import com.abc.model.Employee;
import com.abc.repository.IEmployeeRepository;

@Component("empservice")
public class EmployeeMgmtService implements IEmployeeService {

    private final SpringBootDataJpaAppApplication springBootDataJpaAppApplication;

	@Autowired
	private IEmployeeRepository repo;

    EmployeeMgmtService(SpringBootDataJpaAppApplication springBootDataJpaAppApplication) {
        this.springBootDataJpaAppApplication = springBootDataJpaAppApplication;
    }
	@Override
	public void save(Employee e) {
		System.out.println("Implementation class is::" +repo.getClass().getName());
		Employee employee = repo.save(e);
		System.out.println(employee);
		
	}
	@Override
	public void findById(Integer eid) {
		Optional<Employee> emp = repo.findById(eid);
		if (emp.isPresent()) {
			Employee employee = emp.get();
			System.out.println(employee);
		} else {
			System.out.println("No record found for the given id::"+eid);
		}
	}
	@Override
	public List<Employee> findAll() {
		List<Employee> employees = repo.findAll();
		return employees;
	}
	@Override
	public void deleteById(Integer eid) {
		try {
			repo.deleteById(eid);
			System.out.println("Record deleted sucessfully");
			
		} catch (Exception e) {
			System.out.println("Record not found for the deleteion");
		}
		
	}
	@Override
	public void deleteAll() {
		repo.deleteAllInBatch();
		System.out.println("Delete All the record in the database");
		
	}
	

}
