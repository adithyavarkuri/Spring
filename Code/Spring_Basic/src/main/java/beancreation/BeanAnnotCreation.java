package beancreation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAnnotCreation {
	
static ApplicationContext appFactory = null;

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("beancreation");
		context.refresh();
		Employee employee = (Employee)context.getBean("employeeBean");
		  System.out.println(employee.getName());
	}

}
