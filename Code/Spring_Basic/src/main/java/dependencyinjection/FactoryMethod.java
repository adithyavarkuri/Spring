package dependencyinjection;

import model.Student;
import model.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethod {

    public static void main(String[] args) {
        ApplicationContext appFactory =  new ClassPathXmlApplicationContext("applicationContext.xml");

        UserInfo userInfoBean=(UserInfo)appFactory.getBean("userInfo");
        System.out.println(userInfoBean);

    }
}
