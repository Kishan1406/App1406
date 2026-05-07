package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Student;
import com.main.repository.IStudentRepository;


@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository repo;
	@Override
	public Student save(Student student) {
		return repo.save(student);
	}
	@Override
	public Student findById(Integer sid) {
		return repo.findById(sid).get();
		
	}
	@Override
	public String deleteById(Integer sid) {
		repo.deleteById(sid);
		return "Record deleted for the given id::"+sid;
	}
	@Override
	public Student editById(Integer sid, Student student) {
		Student stdData = repo.findById(sid).get();
		stdData.setSname(student.getSname());
		stdData.setSage(student.getSage());
		stdData.setSaddress(student.getSaddress());
		Student saveStd = repo.save(stdData);
		return saveStd;
	}
	@Override
	public List<Student> getAll() {
		
		return repo.findAll();
	}
	@Override
	public void inputlist(List<Student> student) {
		
		for (Student list : student) {
			System.out.println("ID: "+list.getSid());
			System.out.println("NAME: "+list.getSname());
			System.out.println("AGE: "+list.getSage());
			System.out.println("ADDRESS:"+list.getSaddress());
			
		}
		repo.saveAll(student);
	}
	@Override
	public void count() {
		long count = repo.count();
		System.out.println("The number of record present in the database::"+count);
		
	}
	@Override
	public void check(Integer sid) {
		boolean existsById = repo.existsById(sid);
		if (existsById ==true) {
			System.out.println("Record found for the given student id::"+sid);
		}
		else {
			System.out.println("Record not found for the given student id::"+sid);
		}
	}
	
	
	
	
	
	
	
	
	

}
