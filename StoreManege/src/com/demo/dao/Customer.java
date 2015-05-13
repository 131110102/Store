package com.demo.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String companyname;
	private String city;
	private String citynum;
	private String fax;
	private String address;
	private String phone;
	private Set sells = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String companyname) {
		this.companyname = companyname;
	}

	/** full constructor */
	public Customer(String companyname, String city, String citynum,
			String fax, String address, String phone, Set sells) {
		this.companyname = companyname;
		this.city = city;
		this.citynum = citynum;
		this.fax = fax;
		this.address = address;
		this.phone = phone;
		this.sells = sells;
	}

	// Property accessors

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitynum() {
		return this.citynum;
	}

	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getSells() {
		return this.sells;
	}

	public void setSells(Set sells) {
		this.sells = sells;
	}

}