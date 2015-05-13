package com.demo.model;

import java.util.Date;

/**
 * Sell entity. @author MyEclipse Persistence Tools
 */

public class Sell implements java.io.Serializable {

	// Fields

	private Integer sellno;
	private Product product;
	private Customer customer;
	private Float quantity;
	private Double unitprice;
	private Date orderdate;
	private String memo;

	// Constructors

	/** default constructor */
	public Sell() {
	}

	/** minimal constructor */
	public Sell(Integer sellno, Product product, Customer customer) {
		this.sellno = sellno;
		this.product = product;
		this.customer = customer;
	}

	/** full constructor */
	public Sell(Integer sellno, Product product, Customer customer,
			Float quantity, Double unitprice, Date orderdate, String memo) {
		this.sellno = sellno;
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.orderdate = orderdate;
		this.memo = memo;
	}

	// Property accessors

	public Integer getSellno() {
		return this.sellno;
	}

	public void setSellno(Integer sellno) {
		this.sellno = sellno;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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