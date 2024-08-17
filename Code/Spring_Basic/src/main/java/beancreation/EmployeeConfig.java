package beancreation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public Employee employeeBean() {
		return new Employee();
	}

}
