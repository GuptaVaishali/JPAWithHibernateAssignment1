package com.springdatajpawithhibernatepart1.assignment1;

import com.springdatajpawithhibernatepart1.assignment1.entities.Employee;
import com.springdatajpawithhibernatepart1.assignment1.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class Assignment1ApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}


	/* Perform Create Operation on Entity using Spring Data JPA */
	@Test
	public void testCreateEmployee(){
		Employee employee = new Employee();
		employee.setAge(26);
		employee.setName("Veena");
		employee.setLocation("UP");
		repository.save(employee);
	}


	/* Perform Update Operation on Entity using Spring Data JPA */
	@Test
	public void testUpdateEmployee(){
		Employee employee = repository.findById(1l).get();
		employee.setName("Vaishali Gupta");
		employee.setAge(23);
		employee.setLocation("Faridabad,Haryana");
		repository.save(employee);
	}


	/* Perform Delete Operation on Entity using Spring Data JPA */
	@Test
	public void testDeleteEmployee(){
		Employee employee = repository.findById(2l).get();
		repository.delete(employee);
	}


	/* Perform Read Operation on Entity using Spring Data JPA */
	@Test
	public void testReadEmployees(){
		Employee employee = repository.findById(1l).get();
		assertEquals("Faridabad,Haryana",employee.getLocation());
		System.out.println("Name " + employee.getName());
		System.out.println("Age = " + employee.getAge());
		System.out.println("Location = " + employee.getLocation());
	}


	/* Get the total count of the number of Employees */
	@Test
	public void testCountEmployees(){
		System.out.println("Total no of employees = " + repository.count());
	}


	/* Implement Pagination and Sorting on the bases of Employee Age */
	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable = PageRequest.of(0,3, Sort.Direction.ASC,"age");
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
	}


	/* Create and use finder to find Employee by Name */
	@Test
	public void testFindEmployeeByName(){
		List<Employee> employeeList = repository.findByName("Vaishali Gupta");
		employeeList.forEach(employee -> System.out.println(employee));
	}


	/* Create and use finder to find Employees starting with V character */
	@Test
	public void testFindEmployeesStartingWithVChar(){
		List<Employee> employeeList = repository.findByNameStartingWith("V");
		employeeList.forEach(employee -> System.out.println(employee));
	}


	/* Create and use finder to find Employees Between the age of 28 to 32 */
	@Test
	public void testFindEmployeesBetweenAge28And32(){
		List<Employee> employeeList = repository.findByAgeBetween(28,32);
		employeeList.forEach(employee -> System.out.println(employee));
	}


}
