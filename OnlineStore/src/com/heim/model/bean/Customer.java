package com.heim.model.bean;
/**
 * 
 * @author Heim
 *
 */
public class Customer {
	
	private Integer id;
	private String password;
	private String name;
	private String phone;
	private String address;
	private Boolean isAdmin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Customer(String password, String name, String phone, String address, Boolean isAdmin) {
		super();
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.isAdmin = isAdmin;
	}
	public Customer(){}

}
