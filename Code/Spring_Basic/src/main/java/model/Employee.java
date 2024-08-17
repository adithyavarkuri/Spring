package model;

public class Employee {
	private int id;
	private String name;
	private String email;
	private Address address;
	private String  salary;

	public Employee() {
		System.out.println("def cons");
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee(int id, String name,String email) {
		this.id = id;
		this.name = name;
		this.email =email;
	}
	
	public Employee(int id, Address address) {
		this.id = id;
		this.address = address;
	}

	public void show() {
		System.out.println("ID = " + id + " and name = " + name + " and email = "+ email);
		if(address!=null) {
			System.out.println(address.toString());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public  String get() {
		return "hello";
	}
	
	
	
	

}
