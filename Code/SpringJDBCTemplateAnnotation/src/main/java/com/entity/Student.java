package com.entity;

public class Student {

	 private int id;
	    private String name;
	    private String department;
	     
	    // no args constructor
	    public Student(){}
	     
	    // parameterized constructor
	    public Student(int id, String name, String department) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.department = department;
	    }
	 
	    // getters and setters method
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
	    public String getDepartment() {
	        return department;
	    }
	    public void setDepartment(String department) {
	        this.department = department;
	    }
	     
	    // toString() method
	    @Override
	    public String toString() {
	        return "Student [id=" + id + ", name=" + name + ", department=" + department + "]";
	    }  
}
