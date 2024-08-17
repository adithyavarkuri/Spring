package autowire;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class Autowiring {
	
	static ApplicationContext appFactory = null;

	public static void main(String[] args) {
		  appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
		  noAutowire();
		  byName();
		  byType();
		  byConstructor();
	
	}
	
	public static void noAutowire() {
		System.out.println("No Autowire");
		AutowiringB a2 = (AutowiringB) appFactory.getBean("noAutoWire");
		a2.display();
	
	}
	
	public static void byName() {
		System.out.println("Autowire by name");
		//Byname
		AutowiringB b = (AutowiringB) appFactory.getBean("autowireb");
		b.display();
	}
	
	public static void byType() {
		System.out.println("by Type");
		//by Type
		AutowiringB b1 = (AutowiringB) appFactory.getBean("autowireb1");
		b1.display();
	}
	
	public static void byConstructor() {
		System.out.println("by Constructor");
		//by Type
		AutowiringB b1 = (AutowiringB) appFactory.getBean("autowireConstb");
		b1.display();
	}

}
