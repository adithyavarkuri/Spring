package annotationconfig;

import model.College;
import model.CollegeStudent;
import model.User;
import model.UserDetails;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAnnotationClass {

    public static void main(String[] args) {
        // Annotation based spring context- creates ioc controller and registers all annotation configurations
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        //Scans the provided path and will create beans.
        context.scan("model");
        context.refresh();


//        UserDetails user = (UserDetails) context.getBean("collegeBean");
//        college.test();

        UserDetails user  = (UserDetails) context.getBean(UserDetails.class);
        System.out.println(user.getName());
    }


}
