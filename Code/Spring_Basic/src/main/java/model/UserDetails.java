package model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDetails {


    @Bean
    public User userBean(){
        return new User();
    }

    public String getName(){
        return "UserName";
    }
}
