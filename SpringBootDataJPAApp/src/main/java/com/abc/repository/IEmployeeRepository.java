package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
