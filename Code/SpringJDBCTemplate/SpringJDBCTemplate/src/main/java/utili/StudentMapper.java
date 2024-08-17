package utili;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student  = new Student();
		student.setId(rs.getInt("Id"));
		student.setDepartment(rs.getString("department"));
		student.setName(rs.getString("name"));
		return student;
	}

}
