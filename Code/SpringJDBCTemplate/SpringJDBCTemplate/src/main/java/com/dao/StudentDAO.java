package com.dao;

import java.util.List;

import javax.sql.DataSource;

import com.entity.Student;

public interface StudentDAO {
	
	// Used to initialize database resources
    // ie. connection
    public void setDataSource(DataSource ds);
 
    // Used to list down all the records
    // from the Student table
    public List<Student> listStudents();

}
