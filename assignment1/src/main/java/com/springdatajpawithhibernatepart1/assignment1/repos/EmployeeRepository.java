package com.springdatajpawithhibernatepart1.assignment1.repos;

import com.springdatajpawithhibernatepart1.assignment1.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameStartingWith(String name);

    List<Employee> findByAgeBetween(int age1, int age2);
}
