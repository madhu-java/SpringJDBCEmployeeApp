package com.madhu;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.madhu.dao.EmployeeDao;
import com.madhu.model.Employee;

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBoot02Application.class, args);
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		EmployeeDao empDao = context.getBean(EmployeeDao.class);
		List<Employee> employees = empDao.getEmployees();
		employees.forEach(e->System.out.println(e));
		
		int deleted = empDao.deleteEmployee(4);
		System.out.println(deleted>0?"deleted":"notDeleted");
		
		int updated= empDao.updateEmployee(20000,2);
		System.out.println(updated>0?"updated":"not updated");
		
		
		int created= empDao.addEmployee(new Employee(9,"john","hill",4000));
		System.out.println(created>0?"emp added":"emp not added");
		
		

	
	}

}
