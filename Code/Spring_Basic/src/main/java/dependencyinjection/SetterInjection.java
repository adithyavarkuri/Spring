package dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import model.Question;


public class SetterInjection {
	
	static ApplicationContext appFactory = null;

	public static void main(String[] args) {
		  appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		
		primitive();
		dependentObj();
		listDepObj();
		listInjection();
		mapInjection();
		mapdepobjInjection();
	}

	public static void primitive() {
		System.out.println("-primitive---");
		Employee emp1 = (Employee) appFactory.getBean("emps1");
		emp1.show();

		
	}

	public static void dependentObj() {
		System.out.println("--dependentObj-----");
		Employee emp1 = (Employee) appFactory.getBean("emps2");
		emp1.show();
	}
	
	public static void listInjection() {
		System.out.println("---listInjection--");
		Question q1 = (Question) appFactory.getBean("quess1");
		q1.displayInfo();
	}
	
	public static void listDepObj() {
		System.out.println("-----listDepObj-----");
		Question q1 = (Question) appFactory.getBean("quess2");
		q1.displayInfoobj();
	}
	
	public static void mapInjection() {
		System.out.println("-mapInjection---");
		Question q1 = (Question) appFactory.getBean("quess3");
		q1.displayInfoMap();
	}
	

	public static void mapdepobjInjection() {
		System.out.println("---mapdepobjInjection--");
		Question q1 = (Question) appFactory.getBean("quess4");
		q1.displayInfoMapoj();
	}

}
