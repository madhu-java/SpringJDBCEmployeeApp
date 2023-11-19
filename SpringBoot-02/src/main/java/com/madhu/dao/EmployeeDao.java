package com.madhu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhu.model.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao {
	
	private static final String SQL_QUERY = "select eid,ename,eaddr,esal from employee";
	private static final String SQL_DELETE = "delete from employee where eid=?";
	private static final String SQL_UPDATE = "update employee set esal=? where eid=?";
	private static final String SQL_INSERT = "insert into employee values(?,?,?,?)";

	public EmployeeDao() {
		System.out.println("EmployeeDAO object created...");
	}
	@Autowired
private DataSource dataSource;
private	List<Employee> empList ;
	
	@Override
	public List<Employee> getEmployees() {
		System.out.println(dataSource.getClass().getName());
		empList = new ArrayList<>();
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			
			while(resultSet.next()) {
				Employee e = new Employee();
				e.setEid(resultSet.getInt(1));
				e.setEname(resultSet.getString(2));
				e.setEaddr(resultSet.getString(3));
				e.setEsal(resultSet.getInt(4));
				empList.add(e);
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return empList;
	}
    public int deleteEmployee(int id) {
    	 int executeUpdate=0;
    	try {
			Connection connection = dataSource.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQL_DELETE);
			prepareStatement.setInt(1, id); 
			executeUpdate = prepareStatement.executeUpdate();
			  //return executeUpdate;
    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executeUpdate;
    }
    
    public int updateEmployee(int sal,int id) {
    	int update=0;
    	try {
			Connection connection = dataSource.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQL_UPDATE);
			prepareStatement.setInt(1, sal);
			prepareStatement.setInt(2, id);
			 update = prepareStatement.executeUpdate();
    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return update;
    }
   public int addEmployee(Employee e) {
	   Connection connection;
	   int inserted=0;
	try {
		connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(SQL_INSERT);
		   prepareStatement.setInt(1,e.getEid());
		   prepareStatement.setString(2,e.getEname());
		   prepareStatement.setString(3,e.getEaddr());
		   prepareStatement.setInt(4,e.getEsal());
		   
		    inserted = prepareStatement.executeUpdate();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   
	   return inserted;
   }
}

