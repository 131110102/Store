package com.demo.model;

import java.util.Date;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */

public class Purchase implements java.io.Serializable {

	// Fields

	private String orderno;
	private Customer customer;
	private Product product;
	private Float quantity;
	private Double unitprice;
	private Date orderdate;
	private String memo;

	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(String orderno, Customer customer, Product product) {
		this.orderno = orderno;
		this.customer = customer;
		this.product = product;
	}

	/** full constructor */
	public Purchase(String orderno, Customer customer, Product product,
			Float quantity, Double unitprice, Date orderdate, String memo) {
		this.orderno = orderno;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.orderdate = orderdate;
		this.memo = memo;
	}

	// Property accessors

	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}