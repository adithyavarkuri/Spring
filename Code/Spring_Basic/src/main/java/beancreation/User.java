package beancreation;

import org.springframework.stereotype.Component;

@Component("userBean")
public class User {
	
	

	public String getuser() {
		return "User A";
	}
}