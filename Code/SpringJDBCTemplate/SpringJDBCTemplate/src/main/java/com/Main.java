package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dao.StudentDAOImpl;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
    	
    	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
    	 ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      
        
        // Spring check the blueprint for studentDao bean 
        // from application-context.xml file and return it
        StudentDAOImpl studentDao = (StudentDAOImpl)context.getBean("studentdao");
         
        // This will return a boolean value as 1 or 0
        List<Student> students = studentDao.listStudents();
        System.out.println(students);
        

    }
}
