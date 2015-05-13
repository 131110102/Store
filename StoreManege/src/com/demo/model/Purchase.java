package com.demo.model;

import java.util.Date;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */

public class Purchase implements java.io.Serializable {

	// Fields

	private Integer orderno;
	private Supplier supplier;
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
	public Purchase(Integer orderno, Supplier supplier, Product product) {
		this.orderno = orderno;
		this.supplier = supplier;
		this.product = product;
	}

	/** full constructor */
	public Purchase(Integer orderno, Supplier supplier, Product product,
			Float quantity, Double unitprice, Date orderdate, String memo) {
		this.orderno = orderno;
		this.supplier = supplier;
		this.product = product;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.orderdate = orderdate;
		this.memo = memo;
	}

	// Property accessors

	public Integer getOrderno() {
		return this.orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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