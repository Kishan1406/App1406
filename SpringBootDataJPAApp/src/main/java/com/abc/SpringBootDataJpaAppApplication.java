package com.abc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.abc.model.Employee;
import com.abc.service.EmployeeMgmtService;

@SpringBootApplication
public class SpringBootDataJpaAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootDataJpaAppApplication.class, args);
		
		System.out.println(applicationContext.getClass().getName());
		
		EmployeeMgmtService service = applicationContext.getBean("empservice", EmployeeMgmtService.class);
		
		Employee employee = new Employee();
		
		
		/*Create Operation
		 * employee.setEname("Kishan"); employee.setEage(26);
		 * employee.setEaddress("BNG"); service.save(employee);
		 */
		
		/*Read Operation
		 *  service.findById(1); */
		
		/*Find All
		 * List<Employee> employees = service.findAll();
		 * employees.forEach(System.out::println);
		 */
		
		/*Updation no code is required same code of create need to set id first
		 * employee.setEid(5); employee.setEname("Kishan P"); employee.setEage(26);
		 * employee.setEaddress("BNG"); service.save(employee);
		 */
		/* Delete operation
		 * service.deleteById(4); */
		
		/* Query
		 * repo.deleteAll()
		 * Query generation time
		 * Hibernate: select e1_0.eid,e1_0.eaddress,e1_0.eage,e1_0.ename from employee e1_0
Hibernate: delete from employee where eid=?
Hibernate: delete from employee where eid=?
Hibernate: delete from employee where eid=?
		 * service.deleteAll(); */
		
		
		/*Query
		 * repo.deleteAllInBatch();
		System.out.println("Delete All the record in the database");
		 * Hibernate: delete e1_0 from employee e1_0 Delete All the record in the
		 * database 
		 * service.deleteAll();
		 */
		
		
		applicationContext.close();
	}

}
