package autowire;

public class AutowiringB {
	
	AutowiringA  byNameobj; 
	
	public AutowiringB() {
		System.out.println("B create");
	}
	
	AutowiringB(AutowiringA byNameobj){
		this.byNameobj = byNameobj;
	}

	public AutowiringA getByNameobj() {
		return byNameobj;
	}

	public void setByNameobj(AutowiringA byNameobj) {
		this.byNameobj = byNameobj;
	}

	void print(){System.out.println("hello B");}  
	public void display(){  
	    print();  
	    if(byNameobj == null)
	    	System.out.println("No autowire so obj a is not injected");
	    else
	    	byNameobj.print(); 
	}  
}
