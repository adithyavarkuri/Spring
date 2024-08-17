package dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import model.Address;
import model.Employee;
import model.Question;

public class ConstructorInjection {
	
	static ApplicationContext appFactory = null;

	public static void main(String[] args) {
		  appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		  primitiveType();
		  dependentObj();
		  collectionInjection(); 
		  listDepObj();
		  mapInjection(); 
		  mapdepobjInjection();
		  inheritingbean();
	}

	public static void primitiveType() {
		System.out.println("----primitive inejction-----");
		Employee emp1 = (Employee) appFactory.getBean("emp1");
		emp1.show();

		Employee emp2 = (Employee) appFactory.getBean("emp2");
		emp2.show();

		Employee emp3 = (Employee) appFactory.getBean("emp3");
		emp3.show();
		
		Employee emp4 = (Employee) appFactory.getBean("emp4");
		emp4.show();
	}

	public static void dependentObj() {
		System.out.println("---dependent obj injection-----");
		Address add1 = (Address) appFactory.getBean("add1");
		System.out.println(add1.toString());

		Employee emp1 = (Employee) appFactory.getBean("emp5");
		emp1.show();
	}

	public static void collectionInjection() {
		System.out.println("---collectionInjection--");

		Question ques1 = (Question) appFactory.getBean("ques1");
		ques1.displayInfo();
	}

	public static void listDepObj() {
		System.out.println("---ListDepObj----");
		Question ques2 = (Question) appFactory.getBean("ques2");
		ques2.displayInfoobj();
	}

	public static void mapInjection() {
		System.out.println("-----Map injection---");
		Question ques3 = (Question) appFactory.getBean("ques3");
		ques3.displayInfoMap();
	}

	public static void mapdepobjInjection() {
		System.out.println("-------mapdepobjInjection-----");

		Question ques4 = (Question) appFactory.getBean("ques4");
		ques4.displayInfoMapoj();
	}
	
	public static void inheritingbean() {
System.out.println("------inheritingbean---");
		Employee emp7 = (Employee) appFactory.getBean("emp7");
		emp7.show();
	}

}
