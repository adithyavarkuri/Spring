package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.Student;

import utili.StudentMapper;

public class StudentDAOImpl {
	
	
    private JdbcTemplate jdbcTemplateObject;
    
    public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public List<Student> listStudents()
    {
        // Custom SQL query
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplateObject.query(
            SQL, new StudentMapper());
 
        return students;
    }

}
