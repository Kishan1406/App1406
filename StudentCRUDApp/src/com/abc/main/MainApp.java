package com.abc.main;

import java.util.Scanner;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentControllerFactory;
import com.abc.pojo.Student;

public class MainApp {
	
	public static void main(String[] args) {
		Scanner scanner=null;
		String name,age,address, id=null;
		IStudentController studentController=null;
		String status=null;
		Student stdRecord=null;
		
		while(true) {
			System.out.println("WELCOME TO STUDENT DATABASE APPLICATION");
			System.out.println("1.CREATE");
			System.out.println("2.READ");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			System.out.print("Enter your choice of operation::");
			scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			
			switch(option) {
			case 1: 
				// Collecting to the input
				System.out.print("Enter the name:");
				name = scanner.next();
				System.out.print("Enter the age:");
				age = scanner.next();
				System.out.print("Enter the address:");
				address = scanner.next();
				
				//Sending the data to the controller using POJO
				Student student = new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));
				student.setSaddress(address);
				
				//Pure Abstraction (Hiding the internal logic exposing the service name)
				studentController = StudentControllerFactory.getController();
				status = studentController.save(student);
				System.out.println(status);
				break;
			case 2:
				//Collecting the input
				System.out.print("Enter the student id:");
				id = scanner.next();
				//Pure Abstraction (Hiding the internal logic exposing the service name)
				studentController = StudentControllerFactory.getController();
				stdRecord = studentController.getById(Integer.parseInt(id));
				
				if (stdRecord!=null) {
					System.out.println(stdRecord);
				}else {
					System.out.println("Student record not found for the given id:"+id);
				}
				
				break;
			case 3:
				//Collecting the input
				System.out.print("Enter the student id:");
				id = scanner.next();
				//Pure Abstraction (Hiding the internal logic exposing the service name)
				studentController = StudentControllerFactory.getController();
				stdRecord = studentController.getById(Integer.parseInt(id));
				if (stdRecord!=null) {
					System.out.print("OldName is: "+stdRecord.getSname()+"  Enter the newName:");
					String newName = scanner.next();
					System.out.print("CurrentAge is: "+stdRecord.getSage()+"  Enter the newAge:");
					String newAge = scanner.next();
					System.out.print("CurrentAddress is: "+stdRecord.getSaddress()+" Enter the newAddress:");
					String newAddress = scanner.next();
					
					// Sending the updated POJO details to the Controller
					Student newStudent = new Student();
					//
					
					
					// Setting the SID to the POJO Object
					newStudent.setSid(stdRecord.getSid());
					// Performing the validation based on the user input for name
					if (newName.equals("") || newName==null) {
						newStudent.setSname(stdRecord.getSname());
						
					}else {
						newStudent.setSname(newName);
					}
					
					// Performing the validation based on the user input for age
					if (newAge.equals("") || newAge==null) {
						newStudent.setSage(stdRecord.getSage());
						
					}else {
						newStudent.setSage(Integer.parseInt(newAge));
					}
					
					// Performing the validation based on the user input for name
					if (newAddress.equals("") || newAddress==null) {
						newStudent.setSaddress(stdRecord.getSaddress());
						
					}else {
						newStudent.setSaddress(newAddress);
					}
					System.out.println(newStudent);
					status = studentController.updateById(newStudent);
					System.out.println(status);
					
				} else {
					System.out.println("Record not found for the updation: "+id);
				}
				break;
			case 4:
				System.out.print("Enter the student id:");
				id = scanner.next();
				//Pure Abstraction (Hiding the internal logic exposing the service name)
				studentController = StudentControllerFactory.getController();
				 status = studentController.deleteById(Integer.parseInt(id));
				 System.out.println(status);
				
				break;
			default:
				System.out.println("Thanks for using the application..");
				System.exit(0);
			}
		}
	}

}
