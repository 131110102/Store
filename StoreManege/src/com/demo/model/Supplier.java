package com.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private String companyname;
	private String address;
	private String city;
	private String citynum;
	private String phone;
	private String fax;
	private String memo;
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(String companyname) {
		this.companyname = companyname;
	}

	/** full constructor */
	public Supplier(String companyname, String address, String city,
			String citynum, String phone, String fax, String memo, Set purchases) {
		this.companyname = companyname;
		this.address = address;
		this.city = city;
		this.citynum = citynum;
		this.phone = phone;
		this.fax = fax;
		this.memo = memo;
		this.purchases = purchases;
	}

	// Property accessors

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}