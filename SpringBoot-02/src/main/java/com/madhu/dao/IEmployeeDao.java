package com.madhu.dao;

import java.util.List;

import com.madhu.model.Employee;

public interface IEmployeeDao {
	List<Employee>  getEmployees();
	int deleteEmployee(int id);
	int updateEmployee(int sal,int id);
	int addEmployee(Employee e);
	

}
