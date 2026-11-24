package com.assignment.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializationApp {
	public static void main(String[] args) {
		
		Employee[] employees = {
			    new Employee(101, "Alice", "HR", 50000),
			    new Employee(102, "Bob", "IT", 65000),
			    new Employee(103, "Carol", "Finance", 72000),
			    new Employee(104, "David", "Sales", 48000),
			    new Employee(105, "Eva", "IT", 80000)
			};
		
		// Step 3: SAVE - turn the 5 employee objects into bytes and store them in employees.dat
		
		try {
			FileOutputStream fos = new FileOutputStream("employees.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employees);
			oos.close();
			System.out.println("EMployees saved to file");
			
			
		} catch (IOException e) {
			System.out.println("Could not write to the file");
		}
		
		
		// Step 4: LOAD - read the bytes from employees.dat and rebuild them into Employee objects, then print each one
		try {
			FileInputStream fis = new FileInputStream("employees.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee[] loaded = (Employee[]) ois.readObject();
			ois.close();
			
			for (Employee e : loaded) {
				System.out.println(e);
		}
			} 
		
		catch (IOException e) {
			System.out.println("Could not read file");
			
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
			
			System.out.println("Employee class not found");
		}
		
		
		}
	
	}

