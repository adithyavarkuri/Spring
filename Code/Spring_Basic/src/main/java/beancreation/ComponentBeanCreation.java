package beancreation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentBeanCreation {
	static ApplicationContext appFactory = null;

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("beancreation");
		context.refresh();
		  User user = (User)context.getBean("userBean");
		  System.out.println(user.getuser());
	}

	
}
