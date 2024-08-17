package app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import model.Student;



public class App {
	public static void main(String[] args) {
		
	
	    //BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");

		//XML beanfactory is depreciated 
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	    ApplicationContext appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      
	    Student studentBean=(Student)beanFactory.getBean("student");  
	    System.out.println(studentBean);
	    
	    Student studentApp=(Student)appFactory.getBean("student");  
	    System.out.println(studentApp);
	     
	   
	}
}
