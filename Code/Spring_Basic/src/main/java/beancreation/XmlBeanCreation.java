package beancreation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;

public class XmlBeanCreation {
	
	static ApplicationContext appFactory = null;

	public static void main(String[] args) {
		  appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		  primitiveType();
		 
	}

	public static void primitiveType() {
		System.out.println("----primitive inejction-----");
		Employee emp1 = (Employee) appFactory.getBean("emp1");
		emp1.show();

	
	}

}
