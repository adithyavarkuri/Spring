package model;

import java.util.HashMap;
import java.util.Map;

public class Address {
	private String city;
	private String state;
	private String country;

	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Address() {
		
	}
	public String toString() {
		return city + " " + state + " " + country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public static void main(String[] args) {
		Map<String, String> a = new HashMap<String, String>();
		a.put("a", "");
		a.put("b", " ");
		System.out.println(a.get("a"));		
		System.out.println(a.get("b"));		
		System.out.println(a.get("c"));		
		
		if(a.get("a")!=null) {
			System.out.println("not null");
		}
	}
	

}