package annotationconfig;

import model.College;
import model.CollegeStudent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClass {
    public static void main(String[] args) {

        // Annotation based spring context- creates ioc controller and registers all annotation configurations
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        //Scans the provided path and will create beans.
        context.scan("model");
        context.refresh();


        College college = (College) context.getBean("collegeBean");
        college.test();

        CollegeStudent student  = (CollegeStudent) context.getBean(CollegeStudent.class);
        student.test();

    }

}
