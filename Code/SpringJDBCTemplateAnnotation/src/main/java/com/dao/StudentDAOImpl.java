package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.entity.Student;
import com.util.StudentMapper;

@Component
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;   
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
  

	public List<Student> listStudents()
    {
        // Custom SQL query
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplateObject.query(
            SQL, new StudentMapper());
 
        return students;
    }
	
	public int update(Student student) {
        String sqlQuery = "UPDATE student SET name=? WHERE id=?";
        return jdbcTemplateObject.update(sqlQuery, student.getName(), student.getId());
    }
	
	public Student getDetail(final String name) { 
        final String SQL = "select * from student where name = ? "; 
        List <Student> details = jdbcTemplateObject.query( 
           SQL, new PreparedStatementSetter() { 
               
           public void setValues(PreparedStatement preparedStatement) throws SQLException { 
              preparedStatement.setString(1, name); 
           } 
        }, 
           new StudentMapper()); 
        return details.get(0); 
     } 
	
	 public void insertStudentInfo(Student student) {
	        String sqlQuery = "INSERT INTO student VALUES(:id, :name, :department)";
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("id", student.getId());
	        map.put("name", student.getName());
	        map.put("department", student.getDepartment());
	        namedParameterJdbcTemplate.execute(sqlQuery, map, new PreparedStatementCallback() {
	        	public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
	                return ps.executeUpdate();
	            }
	        });
	         
	    }
	 
	 
	 public List<Student> getAllStudentDetails() {
         
	        // Implementation of ResultSetExtractor interface
	        return jdbcTemplateObject.query("SELECT * FROM student", new ResultSetExtractor<List<Student>>() {
	             
	            // extractData() is ResultSetExtractor 
	            // interface's method
	            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
	                List<Student> studentDetailList = new ArrayList<Student>();
	                while(rs.next()) {
	                    Student student = new Student();
	                    // 1, 2 and 3 are the indices of the data present
	                    // in the database respectively 
	                    student.setId(rs.getInt(1));
	                    student.setName(rs.getString(2));
	                    student.setDepartment(rs.getString(3));
	                    studentDetailList.add(student);
	                }
	                return studentDetailList;
	            }
	             
	        });
	    }
	 
	 
	 public void sampleExamples() {
		 
		 int result = jdbcTemplateObject.queryForObject(
				    "SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
		 
		 result =  jdbcTemplateObject.update(
			      "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", 1, "Bill", "Gates", "USA");
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
		 namedParameterJdbcTemplate.queryForObject(
		   "SELECT FIRST_NAME FROM EMPLOYEE WHERE ID = :id", namedParameters, String.class);
		 
		
	 }
	 
	 
	 public int addStudent(Student std) {
		    Map<String, Object> parameters = new HashMap<String, Object>();
		    parameters.put("ID", std.getId());
		    parameters.put("NAME", std.getName());
		    parameters.put("Department", std.getDepartment());
		  
		    return simpleJdbcInsert.execute(parameters);
		}
	 
	 
	 public Student getStudenUsingSimpleJdbcCall(int id) {
		 simpleJdbcCall.withProcedureName("READ_EMPLOYEE");
		    SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		    Map<String, Object> out = simpleJdbcCall.execute(in);

		    Student std = new Student();
		    std.setName((String) out.get("NAME"));
		    std.setDepartment((String) out.get("Department"));

		    return std;
		}
	 
	 
	 public int[] batchUpdateUsingJdbcTemplate(List<Student> students) {
		    return jdbcTemplateObject.batchUpdate("INSERT INTO Student VALUES (?, ?, ?, ?)",
		        new BatchPreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement ps, int i) throws SQLException {
		                ps.setInt(1, students.get(i).getId());
		                ps.setString(2, students.get(i).getDepartment());
		                ps.setString(3, students.get(i).getName());
		            }
		            @Override
		            public int getBatchSize() {
		                return 50;
		            }
		        });
		}

}
