package com.dao;

import java.util.List;

import javax.sql.DataSource;

import com.entity.Student;

public interface StudentDAO {
	

    public List<Student> listStudents();
    public int update(Student student);
    public Student getDetail(final String name);
    public void insertStudentInfo(Student student);
    public List<Student> getAllStudentDetails();

}
