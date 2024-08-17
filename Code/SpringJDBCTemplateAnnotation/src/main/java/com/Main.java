package com;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.JDBCConfig;
import com.dao.StudentDAO;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
    	 //ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      
        
        // Spring check the blueprint for studentDao bean 
        // from application-context.xml file and return it
        StudentDAO studentDao = (StudentDAO)context.getBean(StudentDAO.class);
        
        Student st = new Student();
        st.setId(1);
        st.setName("varkuri");
        
        int res = studentDao.update(st);
        System.out.println(res);
        
        Student st1 = new Student();
        st1.setId(4);
        st1.setName("varkuri4");
        
        studentDao.insertStudentInfo(st1);
         
        // This will return a boolean value as 1 or 0
        List<Student> students = studentDao.listStudents();
        System.out.println(students);
        
        Student student = studentDao.getDetail("varkuri");
        System.out.println(student);
        
        List<Student> students1 = studentDao.listStudents();
        System.out.println(students1);
        

    }
}
