package com.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private String productname;
	private String spec;
	private String unit;
	private String memo;
	private Set sells = new HashSet(0);
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productname) {
		this.productname = productname;
	}

	/** full constructor */
	public Product(String productname, String spec, String unit, String memo,
			Set sells, Set purchases) {
		this.productname = productname;
		this.spec = spec;
		this.unit = unit;
		this.memo = memo;
		this.sells = sells;
		this.purchases = purchases;
	}

	// Property accessors

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set getSells() {
		return this.sells;
	}

	public void setSells(Set sells) {
		this.sells = sells;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}